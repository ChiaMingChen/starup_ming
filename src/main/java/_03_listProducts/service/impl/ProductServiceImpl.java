package _03_listProducts.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import _03_listProducts.model.ProductBean;
import _03_listProducts.repository.ProductDao;
import _03_listProducts.repository.Impl.ProductDaoImpl;
import _03_listProducts.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductDao dao;

	public ProductServiceImpl() {
		this.dao = new ProductDaoImpl();
	}

	@Override
	public int getTotalPages() {
		return dao.getTotalPages();
	}

	@Override
	public List<ProductBean> getPageProds() {
		return dao.getPageProds();
	}

	@Override
	public int getPageNo() {
		return dao.getPageNo();
	}

	@Override
	public void setPageNo(int pageNo) {
		dao.setPageNo(pageNo);
	}

	@Override
	public int getRecordsPerPage() {
		return dao.getRecordsPerPage();
	}

	@Override
	public void setRecordsPerPage(int recordsPerPage) {
		dao.setRecordsPerPage(recordsPerPage);
	}

	@Override
	public long getRecordCounts() {
		return dao.getRecordCounts();
	}

	@Override
	public ProductBean getProd(int prodId) {
		dao.setProdId(prodId);
		return dao.getProd();
	}

	@Override
	public int updateProd(ProductBean bean, long sizeInBytes) {
		return dao.updateProd(bean, sizeInBytes);
	}

	@Override
	public int updateBook(ProductBean bean) {
		return dao.updateProd(bean);
	}

	@Override
	public ProductBean queryProd(int prodId) {
		return dao.queryProd(prodId);
	}

	@Override
	public int deleteProd(int no) {
		return dao.deleteProd(no);
	}

	@Override
	public int saveProd(ProductBean bean) {
		return dao.saveProd(bean);
	}

	@Override
	public List<String> getProdType() {
		return dao.getProdType();
	}
}