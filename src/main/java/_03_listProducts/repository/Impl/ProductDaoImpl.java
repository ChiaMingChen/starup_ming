package _03_listProducts.repository.Impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import _00_init.util.GlobalService;
import _03_listProducts.model.ProductBean;
import _03_listProducts.repository.ProductDao;

	@Repository
	public class ProductDaoImpl implements Serializable , ProductDao {

		private static final long serialVersionUID = 1L;
		private int prod_id = 0; 	// 查詢單筆商品會用到此代號
		private int pageNo = 0;		// 存放目前顯示之頁面的編號
		private int recordsPerPage = GlobalService.RECORDS_PER_PAGE; // 預設值：每頁三筆
		private int totalPages = -1;
//		DataSource ds = null;
		
		@Autowired
		SessionFactory factory;
		
		private String tagName = "";
		String selected = "";

		public ProductDaoImpl() {
			
		}
		
		// 計算販售的商品總共有幾頁	
		public int getTotalPages() {
			// 注意下一列敘述的每一個型態轉換
			totalPages = (int) (Math.ceil(getRecordCounts() / (double) recordsPerPage));

			return totalPages;
		}
		
		// 查詢某一頁的商品資料，執行本方法前，一定要先設定實例變數pageNo的初值
		@SuppressWarnings("unchecked")
		@Override
		public List<ProductBean> getPageProds() {
			List<ProductBean> list = new ArrayList<ProductBean>();
			// 由頁碼推算出該頁是由哪一筆紀錄開始(1 based)
			int startRecordNo = (pageNo - 1) * recordsPerPage + 1;
//			int endRecordNo = (pageNo) * recordsPerPage;

			Session session = factory.getCurrentSession();
			String hql = "FROM ProductBean ";
			
			list = session.createQuery(hql)
						 .setFirstResult(startRecordNo)
						 .setMaxResults(recordsPerPage)
						 .getResultList();
					
			return list;
		}

		@Override
		public int getPageNo() {
			return pageNo;
		}

		@Override
		public void setPageNo(int pageNo) {
			this.pageNo = pageNo;
		}
		@Override
		public int getRecordsPerPage() {
			return recordsPerPage;
		}
		@Override
		public void setRecordsPerPage(int recordsPerPage) {
			this.recordsPerPage = recordsPerPage;
		}

		@SuppressWarnings("unchecked")
		@Override
		public long getRecordCounts() {
			List<Long> list ;
			Long count = 0L; // 必須使用 long 型態
			Session session = factory.getCurrentSession();
			String hql = "SELECT count(*) FROM ProductBean ";
			
			list = session.createQuery(hql)					
						 .getResultList();
			if(list!=null) {
				count = list.get(0);
			}
			return count;
		}
		@Override
		public void setProdId(int prod_id) {
			this.prod_id = prod_id;
		}
		@Override
		public ProductBean getProd() {
			ProductBean bean = queryProd(this.prod_id);
			return bean;
		}

		// 修改一筆商品資料
		@Override
		public int updateProd(ProductBean bean, long sizeInBytes) {
			int n = 0;
			String hql = "UPDATE ProductBean SET " 
					+ " prodName = :prodName,  prodType = :prodType, prodImg = :prodImg, prodImgName = :prodImgName,"
					+ " prodStock = :prodStock, prodPrice = :prodPrice, prodCompany = :prodCompany, prodIntro= :prodIntro, "
					+ " productUpDate = :productUpDate WHERE prod_id = :prod_id";
			if (sizeInBytes == -1) { // 不修改圖片
				n = updateProd(bean);
				return n;
			}
			Session session = factory.getCurrentSession();
			n = session.createQuery(hql)
					.setParameter("prodName", bean.getProdName())
					.setParameter("prodType", bean.getProdType())
					.setParameter("prodImg", bean.getProdImg())
					.setParameter("prodImgName", bean.getProdImgName())
					.setParameter("prodStock", bean.getProdStock())
					.setParameter("prodPrice", bean.getProdPrice())
					.setParameter("prodCompany", bean.getProdCompany())
					.setParameter("prodIntro", bean.getProdIntro())
					.setParameter("productUpDate", bean.getProductUpDate())
//					.setParameter("productOutDate", bean.getProductOutDate())
					.executeUpdate();
		
			return n;
		}

		// 修改一筆商品資料，不改圖片
		@Override
		public int updateProd(ProductBean bean) {
			int n = 0;
			
			String hql = "UPDATE ProductBean SET " 
					+ " prodName=:prodName,  prodType=:prodType, "
					+ " prodStock=:prodStock, prodPrice=:prodPrice, prodCompany = :prodCompany, prodIntro= :prodIntro, "
					+ " productUpDate = :productUpDate WHERE prod_id = :prod_id";
			Session session = factory.getCurrentSession();
			n = session.createQuery(hql)
					.setParameter("prodName", bean.getProdName())
					.setParameter("prodType", bean.getProdType())
//					.setParameter("prodImg", bean.getProdImg())
//					.setParameter("prodImgName", bean.getProdImgName())
					.setParameter("prodStock", bean.getProdStock())
					.setParameter("prodPrice", bean.getProdPrice())
					.setParameter("prodCompany", bean.getProdCompany())
					.setParameter("prodIntro", bean.getProdIntro())
					.setParameter("productUpDate", bean.getProductUpDate())
//					.setParameter("productOutDate", bean.getProductOutDate())
					.executeUpdate();

			
			return n;
		}

		// 依prod_Id來查詢單筆記錄
		@Override
		public ProductBean queryProd(int prod_Id)  {
			ProductBean bean = null;
			Session session = factory.getCurrentSession();
			bean = session.get(ProductBean.class, prod_Id);
			return bean;
		}

		// 依prod_Id來刪除單筆記錄
		@Override
		public int deleteProd(int no) {
			int n = 0;
			ProductBean bean = new ProductBean();
			bean.setProd_id(no);
			Session session = factory.getCurrentSession();
			session.delete(bean);
			
			return ++n;
		}

		// 新增一筆記錄---
		@Override
		public int saveProd(ProductBean bean) {
			int n = 0;
			Session session = factory.getCurrentSession();
			session.save(bean);
			return ++n;
		}
		@Override
		@SuppressWarnings("unchecked")
		public List<String> getProdType() {
			String hql = "SELECT DISTINCT category FROM BookBean";
			List<String> list = new ArrayList<>();
			Session session = factory.getCurrentSession();
			list = session.createQuery(hql).getResultList();			   
			return list;
		}
		@Override
		public String getSelected() {
			return selected;
		}
		@Override
		public void setSelected(String selected) {
			this.selected = selected;
		}
		@Override
		public String getProdTypeTag() {
			String ans = "";
			List<String> list = getProdType();
			ans += "<SELECT name='prodType'>";
			for (String cate : list) {
				if (cate.equals(selected)) {
					ans += "<option value='" + cate + "' selected>" + cate + "</option>";
				} else {
					ans += "<option value='" + cate + "'>" + cate + "</option>";
				}
			}
			ans += "</SELECT>";
			return ans;
		}
		@Override
		public String getTagName() {
			return tagName;
		}
		@Override
		public void setTagName(String tagName) {
			this.tagName = tagName;
		}

	}

