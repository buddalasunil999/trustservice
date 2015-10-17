package nz.ac.aut.sa.service;

import java.util.Collection;
import java.util.List;

import nz.ac.aut.sa.services.domain.impl.Buyer;


public interface BuyerService {
	public void addBuyer(Buyer buyer);
	public Buyer getBuyer(int id);
	public List<Buyer> getBuyers();
	public void updateBuyer(Buyer buyer);
	public void deleteBuyer(int id);
	public List<Buyer> getFriends(Collection<Integer> friendsList);
}
