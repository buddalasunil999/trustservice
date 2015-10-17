package nz.ac.aut.sa.service.impl;

import java.util.List;

import nz.ac.aut.sa.dao.SellerDao;
import nz.ac.aut.sa.dao.impl.SellerDaoImpl;
import nz.ac.aut.sa.service.SellerService;
import nz.ac.aut.sa.services.domain.impl.Seller;


public class SellerServiceImpl implements SellerService{
	private SellerDao sellerDao = new SellerDaoImpl();

	public void addSeller(Seller seller) {
		sellerDao.save(seller);
	}

	public Seller getSeller(int id) {
		return sellerDao.get(Seller.class, id);
	}
	
	public void deleteSeller(int id){
		sellerDao.delete(Seller.class, id);
	}
	
	public void updateSeller(Seller seller){
		sellerDao.update(seller);
	}

	public List<Seller> getSellers() {
		return sellerDao.findAll(Seller.class);
	}

}
