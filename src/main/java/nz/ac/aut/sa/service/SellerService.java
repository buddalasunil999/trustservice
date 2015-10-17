package nz.ac.aut.sa.service;

import java.util.List;

import nz.ac.aut.sa.services.domain.impl.Seller;


public interface SellerService {
	public void addSeller(Seller seller);
	public void updateSeller(Seller seller);
	public Seller getSeller(int id);
	public void deleteSeller(int id);
	public List<Seller> getSellers();
}
