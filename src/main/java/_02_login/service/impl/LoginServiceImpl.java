package _02_login.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import _01_register.dao.UserDao;
import _01_register.model.UserBean;
import _02_login.service.LoginService;

// 登入時系統必須執行的checkIDPassword()功能交由 MemberDao來完成 

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	UserDao  dao ;
	public LoginServiceImpl() {
		//this.dao = new UserDaoImpl_Jdbc();  //交給IOC控管
	}
	// 檢查帳號與密碼是否與某位已登入會員的帳號密碼完全相同。
	public UserBean processLogin(String account, String password) {
		UserBean ub = checkIDPassword(account, password);
		//updateLoginStatus(userId);
		return ub;
	}
	
	public UserBean checkIDPassword(String account, String password) {
		UserBean ub = dao.checkIDPassword(account, password);
		return ub;
	}
}
