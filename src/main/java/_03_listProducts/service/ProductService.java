package _03_listProducts.service;

import java.util.List;

import _03_listProducts.model.ProductBean;

public interface ProductService {
	// 計算販售的商品總共有幾頁
	int getTotalPages();
	
	// 查詢某一頁的商品資料
	List<ProductBean> getPageProds();

	int getPageNo();

	void setPageNo(int pageNo);

	int getRecordsPerPage();

	void setRecordsPerPage(int recordsPerPage);

	// 計算紀錄總筆數
	long getRecordCounts();

	ProductBean getProd(int prodId);
	
	// 修改一筆商品資料
	int updateProd(ProductBean bean, long sizeInBytes) ;

	// 修改一筆記錄
	int updateBook(ProductBean bean) ;

	// 依bookID來查詢單筆記錄
	ProductBean queryProd(int prodId);

	// 依bookID來刪除單筆記錄
	int deleteProd(int no);

	// 新增一筆記錄
	int saveProd(ProductBean bean);
	
	// 取出所有的類型
	List<String> getProdType();
}
