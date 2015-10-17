package nz.ac.aut.sa.service;

import java.util.List;

import nz.ac.aut.sa.services.domain.impl.ProductImpl;


public interface ProductService {
	public void addProduct(ProductImpl product);
	public void updateProduct(ProductImpl product);
	public ProductImpl getProduct(int id);
	public void deleteProduct(int id);
	public List<ProductImpl> getProducts();
}
