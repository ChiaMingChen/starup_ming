package _01_register.service;

import _01_register.model.UserBean;
import _05_orderProcess.model.OrderBean;

public interface UserService {
	boolean idExists(String id);
	int saveUser(UserBean ub);
	void updateUnpaidOrderAmount(OrderBean ob);
	UserBean queryUser(String id);
	UserBean getUser(int nId);
	boolean nicknameExists(String nickname);
	UserBean getUser2(String account);
}
