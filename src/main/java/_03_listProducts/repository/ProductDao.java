package _03_listProducts.repository;

import java.util.List;

import _03_listProducts.model.ProductBean;

public interface ProductDao {

	int getTotalPages();

	List<ProductBean> getPageProds();

	int getPageNo();

	void setPageNo(int pageNo);

	int getRecordsPerPage();

	void setRecordsPerPage(int recordsPerPage);

	// 計算紀錄總筆數
	long getRecordCounts();

	void setProdId(int bookId);

	ProductBean getProd();

	int updateProd(ProductBean bean, long sizeInBytes) ;

	// 修改一筆記錄

	// 依bookID來查詢單筆記錄
	ProductBean queryProd(int bookID);

	// 依bookID來刪除單筆記錄
	int deleteProd(int no);

	// 新增一筆記錄
	int saveProd(ProductBean bean);

	List<String> getProdType();

	void setSelected(String selected);

	String getSelected();

	String getProdTypeTag();

	String getTagName();

	void setTagName(String tagName);

	int updateProd(ProductBean bean);

}