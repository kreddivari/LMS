package com.zen.smi.service.helper;

import static com.zen.smi.generic.utils.SmiConstants.USER_PROPERTIES;
import org.apache.log4j.Logger;
import com.zen.smi.bo.UserBO;
import com.zen.smi.dao.entities.Users;
import com.zen.smi.generic.utils.BeanCopyUtil;
public final class UserHelper extends BeanCopyUtil {

	/**
	 * Logger for StaffHelper class.
	 */
	private static final Logger LOGGER = Logger.getLogger(UserHelper .class);

	/**
	 * Instance of StaffHelper.
	 */
	private static UserHelper  instance;

	/**
	 * Private constructor
	 */
	private UserHelper() {

	}
	
	/**
	 * Converts Staff entity to StaffBO object
	 * @param Staff staff
	 * @return StaffBO
	 */
	public UserBO convertUserEntityToBO(Users user) {
		LOGGER.debug("Starts convertUserEntityToBO...");
		UserBO userBO = new UserBO();
    	BeanCopyUtil.copyBeanProperties(user, userBO, USER_PROPERTIES);
		LOGGER.debug("Ends convertUserEntityToBO...");
		return userBO;
	}
	/**
	 * Singleton instance of StaffHelper.
	 *
	 * @return instance StaffHelper
	 */
	public static UserHelper getInstance() {
		if (instance == null) {
			instance = new UserHelper();
		}
		return instance;
	}

}
