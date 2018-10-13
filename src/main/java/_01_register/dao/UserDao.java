package _01_register.dao;

import java.util.List;

import _01_register.model.UserBean;
import _05_orderProcess.model.OrderBean;


public interface UserDao {
		UserBean getUser(int pk);

		int saveUser(UserBean ub);
		
		boolean idExists(String account);
		
		boolean nicknameExists(String nickname);
		
		List<_01_register.model.UserBean> checkLogin(String account,String password);
		
		UserBean checkIDPassword(String account, String password);
		
		List<UserBean> getAllUsers();
		
		int deleteUser(int pk);

		int updateUser(UserBean ub);

		void updateUnpaidOrderAmount(OrderBean ob);

		UserBean queryUser(String id);

		UserBean getUser2(String account);
}
