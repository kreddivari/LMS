package com.zen.smi.service.impl;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.apache.log4j.Logger;

import com.zen.smi.bo.UserBO;
import com.zen.smi.dao.entities.Roles;
import com.zen.smi.dao.entities.Users;
import com.zen.smi.dao.entities.UsersRoles;
import com.zen.smi.dao.exception.GenericDAOException;
import com.zen.smi.exception.BusinessException;
import com.zen.smi.exception.UserException;
import com.zen.smi.service.UserService;
import com.zen.smi.service.helper.UserHelper;

public class UserServiceImpl extends BaseService implements UserService {
	
	/**
	 * Logger for StaffServiceImpl class.
	 */
	private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class);

    /**
	 * {@inheritDoc}
	 */
	public UserBO getUserByUserName(String userName) throws UserException {		
		LOGGER.debug("Starts getUserByUserName....");
		UserBO userBO = null;
		try {
			Users users = getUserDAO().getUserByUserName(userName);
			if(users != null)
			{
				userBO = UserHelper.getInstance().convertUserEntityToBO(users);
				try {
					KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
					keyGenerator.init(128);
					SecretKey secretKey = keyGenerator.generateKey();
					Cipher cipher = Cipher.getInstance("AES");
					userBO.setPassword(userBO.getPassword());
					System.out.println("decrypted password:################"+userBO.getPassword());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (GenericDAOException e) {
			e.printStackTrace();			
		}
		LOGGER.debug("Ends getUserByUserName....");		
		return userBO;
	}
	   private String encrypt(String password) {
	    	 String encryptedPasswd = null;
	    	 try {
	             MessageDigest md = MessageDigest.getInstance("MD5");
	             md.update(password.getBytes()); 
	          	 byte[] output = md.digest();
	          	encryptedPasswd = bytesToHex(output);
	          } catch (Exception e) {
	             e.printStackTrace();
	          }
	    	 return encryptedPasswd;
	    }
	    private String bytesToHex(byte[] b) {
	        char hexDigit[] = {'0', '1', '2', '3', '4', '5', '6', '7',
	                           '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
	        StringBuffer buf = new StringBuffer();
	        for (int j=0; j<b.length; j++) {
	           buf.append(hexDigit[(b[j] >> 4) & 0x0f]);
	           buf.append(hexDigit[b[j] & 0x0f]);
	        }
	        return buf.toString();
	     }
	
    public UserBO authenticate(String userName, String password) throws UserException {
		
		LOGGER.debug("Starts authenticate....");
		UserBO userBO = null;
		try {
			Users users = getUserDAO().authenticate(userName, password);
			if(users != null)
			{				
			List<UsersRoles> userRolesList = getUsersRolesDAO().getUserRoles(users.getUserId());
			Set<UsersRoles> userRoles = new HashSet<UsersRoles>(userRolesList);
			users.setUsersRoleses(userRoles);
			for(UsersRoles userRole:userRoles)
			{
				Roles role = getRolesDAO().getRoles(userRole.getUserRoleId());
				userRole.setRoles(role);
			}			
				userBO = UserHelper.getInstance().convertUserEntityToBO(users);
			}else{
				return userBO;
			}
		} catch (GenericDAOException e) {
			e.printStackTrace();
		}
		LOGGER.debug("Ends authenticate....");		
		return userBO;
	}
   
	public String createUser(UserBO userBO) throws BusinessException {

		LOGGER.debug("Starts getUserByUserName....");
		String result=null;
		try {
			Users users = new Users();
			if(userBO.getUserId()!=null){				
				users.setUserId(userBO.getUserId());	
			}
			users.setUserName(userBO.getUserName());
			users.setEmail(userBO.getEmail());
			users.setFirstName(userBO.getFirstName());
			users.setLastName(userBO.getLastName());
			users.setMobile(userBO.getMobile());
			try {
				
				users.setPassword(encrypt(userBO.getPassword()));
				System.out.println("encrypted password:################"+users.getPassword());
			} catch (Exception e) {				
			   throw new BusinessException(e);
			}
			getUserDAO().createUser(users);
			UsersRoles userRole=new UsersRoles();
			Roles role=getRolesDAO().findById(2);
			userRole.setRoles(role);
			userRole.setUsers(users);
			getUsersRolesDAO().save(userRole);
			result= "success";
		} catch (GenericDAOException e) {
			result= "failed";
            throw new BusinessException(e);			
		}
		LOGGER.debug("Ends getUserByUserName....");		
		return result;
	}	
}
