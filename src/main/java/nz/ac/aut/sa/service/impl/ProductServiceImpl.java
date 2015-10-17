package nz.ac.aut.sa.service.impl;

import java.util.List;

import nz.ac.aut.sa.dao.ProductDao;
import nz.ac.aut.sa.dao.impl.ProductDaoImpl;
import nz.ac.aut.sa.service.ProductService;
import nz.ac.aut.sa.services.domain.impl.ProductImpl;


public class ProductServiceImpl implements ProductService{
	private ProductDao productDao=new ProductDaoImpl();

	public void addProduct(ProductImpl product) {
		productDao.save(product);
	}

	public void updateProduct(ProductImpl product) {
		productDao.update(product);
	}

	public ProductImpl getProduct(int id) {
		return productDao.get(ProductImpl.class, id);
	}

	public void deleteProduct(int id) {
		productDao.delete(ProductImpl.class, id);
	}

	public List<ProductImpl> getProducts() {
		return productDao.findAll(ProductImpl.class);
	}
	
	

}
