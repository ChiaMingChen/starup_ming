package _02_login.service;

import _01_register.model.UserBean;
// 定義進行登入時系統必須執行的功能
public interface LoginService {
	public UserBean checkIDPassword(String account, String password) ;
}
