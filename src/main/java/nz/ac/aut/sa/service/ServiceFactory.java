package nz.ac.aut.sa.service;

import nz.ac.aut.sa.service.impl.BuyerServiceImpl;
import nz.ac.aut.sa.service.impl.ProductServiceImpl;
import nz.ac.aut.sa.service.impl.SellerServiceImpl;

public class ServiceFactory {
	private static BuyerService buyerService;
	private static SellerService sellerService;
	private static ProductService productService;
	
	public  static BuyerService getBuyerService(){
		if(buyerService == null){
			buyerService = new BuyerServiceImpl();
		}
		return buyerService;
	}
	
	public static SellerService getSellerService(){
		if(sellerService == null){
			sellerService = new SellerServiceImpl();
		}
		return sellerService;
	}
	
	public static ProductService getProductService(){
		if(productService == null){
			productService = new ProductServiceImpl();
		}
		return productService;
	}
}
