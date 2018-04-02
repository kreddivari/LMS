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

import com.zen.smi.bo.RoleBO;
import com.zen.smi.bo.UserBO;
import com.zen.smi.dao.entities.Roles;
import com.zen.smi.dao.entities.Users;
import com.zen.smi.dao.entities.UsersRoles;
import com.zen.smi.dao.exception.GenericDAOException;
import com.zen.smi.exception.BusinessException;
import com.zen.smi.exception.UserException;
import com.zen.smi.generic.utils.BeanCopyUtil;
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
    
    
    public static String encrypt(String plainText, SecretKey secretKey,Cipher cipher)
			throws Exception {
		byte[] plainTextByte = plainText.getBytes();
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		byte[] encryptedByte = cipher.doFinal(plainTextByte);
		Base64.Encoder encoder = Base64.getEncoder();
		String encryptedText = encoder.encodeToString(encryptedByte);
		return encryptedText;
	}

	public static String decrypt(String encryptedText, SecretKey secretKey,Cipher cipher)
			throws Exception {
		Base64.Decoder decoder = Base64.getDecoder();
		byte[] encryptedTextByte = decoder.decode(encryptedText);
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		byte[] decryptedByte = cipher.doFinal(encryptedTextByte);
		String decryptedText = new String(decryptedByte);
		return decryptedText;
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
				KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
				keyGenerator.init(128);
				SecretKey secretKey = keyGenerator.generateKey();
				Cipher cipher = Cipher.getInstance("AES");
				users.setPassword(userBO.getPassword());
				System.out.println("encrypted password:################"+users.getPassword());
			} catch (Exception e) {
				
				  throw new BusinessException(e);
			}
			getUserDAO().createUser(users);
			result= "success";
		} catch (GenericDAOException e) {
			result= "failed";
               throw new BusinessException(e);
			
		}
		LOGGER.debug("Ends getUserByUserName....");
		
		return result;
	}
	
	
}
