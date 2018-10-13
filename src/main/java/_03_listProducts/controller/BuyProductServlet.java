package _03_listProducts.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import _00_init.util.SystemUtils2018;
import _03_listProducts.model.OrderItem;

@WebServlet("/_03_listProducts/BuyProduct.do")
public class BuyProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// 只要舊的Session物件，如果找不到，不要建立新的Session物件，直接傳回 null
		HttpSession session = request.getSession(false);
		if (session == null) {
			// 如果傳回值為null，表示找不到舊的Session物件，請瀏覽器對首頁發出請求
			response.sendRedirect(getServletContext().getContextPath() + "/index.jsp");
			return;
		}

//				// 取出存放在session物件內的ShoppingCart物件
//				ShoppingCart cart = (ShoppingCart)session.getAttribute("ShoppingCart");
//				// 如果找不到ShoppingCart物件
//				if (cart == null) {
//					// 就新建ShoppingCart物件
//					cart = new ShoppingCart();
//					// 並將此新建ShoppingCart的物件放到session物件內，成為它的屬性物件
//					session.setAttribute("ShoppingCart", cart);   
//				}
		String prodName = request.getParameter("prodName");
		String prodType = request.getParameter("prodType");
		String prodIntro = request.getParameter("prodIntro");
		String pageNo = request.getParameter("pageNo");
		String idStr = request.getParameter("prod_id");
		String priceStr = request.getParameter("price");
		if (pageNo == null) {
			pageNo = "1";
		}

		Integer prod_id = 0;
		Integer prodPrice = 0;
		long sizeInBytes = 0;

		
		try {
			// 進行資料型態的轉換
			prod_id = Integer.parseInt(idStr.trim());
			prodPrice =Integer.parseInt(priceStr.trim());
		} catch (NumberFormatException e) {
			throw new ServletException(e);
		}
		//InputStream is = null; 
		//Blob prodImg = SystemUtils2018.fileToBlob(is, sizeInBytes);
				//將訂單資料封裝到OrderItem物件內
		 //OrderItem oi = new OrderItem(prod_id, prodName, prodType, prodImg, prodPrice,prodIntro);
		 //將OrderItem物件內加入ShoppingCart的物件內
		 //cart.addToCart(prod_id, oi);
		RequestDispatcher rd = request.getRequestDispatcher("/_03_listBooks/DisplayPageProducts?pageNo=" + pageNo);
		rd.forward(request, response);
	}

}