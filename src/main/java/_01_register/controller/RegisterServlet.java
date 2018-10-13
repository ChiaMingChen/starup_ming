package _01_register.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import _00_init.util.GlobalService;
import _00_init.util.SystemUtils2018;
import _00_init.util.UserFileIO;
import _01_register.model.UserBean;
import _01_register.service.UserService;



@WebServlet("/register.do")
@MultipartConfig(location = "", fileSizeThreshold = 5 * 1024 * 1024, maxFileSize = 1024 * 1024
* 500, maxRequestSize = 1024 * 1024 * 500 * 5)
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%!^'\"]).{8,})";
	private Pattern pattern = null;
	private Matcher matcher = null;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
				throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		
		Map<String,String> errorMsg = new HashMap<String,String>(); 
		Map<String, String> oKMsg = new HashMap<String, String>();
		HttpSession session = request.getSession();
		request.setAttribute("MsgMap", errorMsg);
		session.setAttribute("MsgOK", oKMsg);		
		String account = "";  
		String password= "";
		String password2= "";
		String name= "";
		String nickname= "";	
		String gender= "";
		String birthday= "";
		String phone = "";
		String address = "";		
		String photoName= ""; //大頭照檔名
		String introduction= "";
		long sizeInBytes = 0;
		InputStream is = null;
		
		Collection<Part> parts = request.getParts();

		if (parts != null) { 
			for (Part p : parts) {
				String fldName = p.getName();
				String value = request.getParameter(fldName);
				
				if(p.getContentType() == null) {
					if (fldName.equalsIgnoreCase("account")) {
						account = value;
					}else if(fldName.equals("password")){
						password = value;	
					}else if(fldName.equals("password2")){
						password2= value;	
					}else if(fldName.equalsIgnoreCase("name")){
						name = value;
					}else if(fldName.equalsIgnoreCase("nickname")){
						nickname = value;
					}else if(fldName.equalsIgnoreCase("gender")){
						gender = value;
					}else if(fldName.equalsIgnoreCase("birthday")){
						birthday = value;	
					}else if(fldName.equalsIgnoreCase("phone")){
						phone = value;
					}else if(fldName.equalsIgnoreCase("address")){
							address = value;		
					}else if(fldName.equalsIgnoreCase("photoName")){
						photoName = value;	
					}else if(fldName.equalsIgnoreCase("introduction")){
						introduction = value;
					}
				}else {
						photoName = GlobalService.getFileName(p);
						photoName = GlobalService.adjustFileName(photoName, GlobalService.IMAGE_FILENAME_LENGTH);
						if (photoName != null && photoName.trim().length() > 0) {
							sizeInBytes = p.getSize();
							is = p.getInputStream();
						}else {
							
						}
				}
				}
	
			if (account == null || account.trim().length() == 0) {
				errorMsg.put("errorIDEmpty", "帳號未輸入");
			}else {
				session.setAttribute("account",account);
			}
			if (password == null || password.trim().length() == 0) {
				errorMsg.put("errorPasswordEmpty", "密碼未輸入");
			}
			if (password2 == null || password2.trim().length() == 0) {
				errorMsg.put("errorPassword2Empty", "密碼未輸入");
			}
			if (password.trim().length() > 0 && password2.trim().length() > 0) {
				if (!password.trim().equals(password2.trim())) {
					errorMsg.put("errorPassword2Empty", "密碼欄必須與確認欄一致");
					errorMsg.put("errorPasswordEmpty", "*");
				}
			}
			if (name == null || name.trim().length() == 0) {
				errorMsg.put("errorName", "姓名未輸入");
			}else {
				session.setAttribute("name", name);
			}
			if (nickname == null || name.trim().length() == 0) {
				errorMsg.put("errorNickname", "暱稱未輸入");
			}else {
				session.setAttribute("nickname", nickname);
			}
			if (gender == null ||gender.trim().length() == 0) {
				errorMsg.put("errorGender", "性別未輸入");
			}else {
				session.setAttribute("gender", gender);
			}
			if (birthday == null ||birthday.trim().length() == 0) {
				errorMsg.put("errorBirthday", "生日未輸入");
			}else {
				session.setAttribute("birthday", birthday);
			}
			if (phone == null ||phone.trim().length() == 0) {
				errorMsg.put("errorPhone", "電話未輸入");
			}else {
				session.setAttribute("phone", phone);
			}
			if (address == null ||address.trim().length() == 0) {
				errorMsg.put("errorAddress", "地址未輸入");
			}
			if (is == null) {
				errorMsg.put("errorPhoto", "頭像圖片未上傳");
			}else {
				session.setAttribute("address", address);
			}
		} else {
			errorMsg.put("errTitle", "此表單不是上傳檔案的表單");
		}
		if (errorMsg.isEmpty()) {
			pattern = Pattern.compile(PASSWORD_PATTERN);
			matcher = pattern.matcher(password);
			if (!matcher.matches()) {
				errorMsg.put("passwordError",
				"密碼至少含有一個大寫字母、小寫字母、數字與!@#$%!^'\\\"等四組資料組合而成，且長度不能小於八個字元");
			}
		}
			if (!errorMsg.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("_01_register/Register.jsp");
				rd.forward(request, response);
				return;
			}
			try {
				// UserService service = new UserServiceImpl();
				/*改spring啦*/
				ServletContext sc = getServletContext();
				WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(sc);
				UserService service = ctx.getBean(UserService.class);
				/**/
				if (service.idExists(account)) {
					errorMsg.put("errorIDDup", "此帳號已存在，請換新帳號");
				} else if(service.nicknameExists(nickname)) {
					errorMsg.put(" ", "此暱稱已存在，請換新暱稱");
				} else {
					password = GlobalService.getMD5Endocing(
					GlobalService.encryptString(password));
					
					Timestamp ts = new java.sql.Timestamp(System.currentTimeMillis());
					Blob blob = SystemUtils2018.fileToBlob(is, sizeInBytes);
					
					
					
					Date bir = java.sql.Date.valueOf(birthday);
					UserFileIO mfio = new UserFileIO("c:\\data\\introduction.txt");
					mfio.insertUser(introduction);
					Clob clob = SystemUtils2018.fileToClob("c:\\data\\introduction.txt");
					File introText = new File("c:\\data\\introduction.txt");// create file object
					
					UserBean mem = new UserBean(null, account,password,name,nickname,gender,bir,phone,address,blob,photoName,clob,ts,0);					
					int n = service.saveUser(mem);
					introText.delete();// call file method delete() to delete introduction in text file
					if (n == 1) {
						oKMsg.put("InsertOK", "<Font color='red'>輸入OK</Font>");
						response.sendRedirect("_01_register/RegisterSuccess.jsp");
						return;
					} else {
						errorMsg.put("errorIDDup", "新增此筆資料有誤(RegisterServlet)");
					}
				}
				if (!errorMsg.isEmpty()) {
					RequestDispatcher rd = request.getRequestDispatcher("_01_register/Register.jsp");
					rd.forward(request, response);
					return;
				}
			} catch (Exception e) {
				e.printStackTrace();
				errorMsg.put("errorIDDup", e.getMessage());
				RequestDispatcher rd = request.getRequestDispatcher("_01_register/Register.jsp");
				rd.forward(request, response);
			}
		}
		}

	


