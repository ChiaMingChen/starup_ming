package _03_listProducts.model;

import java.sql.Blob;
import java.sql.Date;

public class OrderItem {
	Integer prod_id=0;
	String prodName;
	String prodType;
	Blob prodImg;
	Integer prodPrice = 0;
	String prodIntro;
	
	public OrderItem(Integer prod_id, String prodName, String prodType, Blob prodImg, Integer prodPrice,
			String prodIntro) {
		super();
		this.prod_id = prod_id;
		this.prodName = prodName;
		this.prodType = prodType;
		this.prodImg = prodImg;
		this.prodPrice = prodPrice;
		this.prodIntro = prodIntro;
	}

	public Integer getProd_id() {
		return prod_id;
	}

	public void setProd_id(Integer prod_id) {
		this.prod_id = prod_id;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public String getProdType() {
		return prodType;
	}

	public void setProdType(String prodType) {
		this.prodType = prodType;
	}

	public Blob getProdImg() {
		return prodImg;
	}

	public void setProdImg(Blob prodImg) {
		this.prodImg = prodImg;
	}

	public Integer getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(Integer prodPrice) {
		this.prodPrice = prodPrice;
	}

	public String getProdIntro() {
		return prodIntro;
	}

	public void setProdIntro(String prodIntro) {
		this.prodIntro = prodIntro;
	}

	@Override
	public String toString() {
		return "OrderItem [prodImg=" + prodImg + "]";
	}
	

}
