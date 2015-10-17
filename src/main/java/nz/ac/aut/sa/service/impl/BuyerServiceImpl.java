package nz.ac.aut.sa.service.impl;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import nz.ac.aut.sa.dao.BuyerDao;
import nz.ac.aut.sa.dao.impl.BuyerDaoImpl;
import nz.ac.aut.sa.service.BuyerService;
import nz.ac.aut.sa.services.domain.impl.Buyer;


public class BuyerServiceImpl implements BuyerService{
	private BuyerDao buyerDao = new BuyerDaoImpl();

	public void addBuyer(Buyer buyer) {
		this.buyerDao.save(buyer);
	}

	public Buyer getBuyer(int id) {
		return this.buyerDao.get(Buyer.class, id);
	}
	
	public List<Buyer> getBuyers(){
		return this.buyerDao.findAll(Buyer.class);
	}

	public void updateBuyer(Buyer buyer) {
		this.buyerDao.update(buyer);
	}

	public void deleteBuyer(int id) {
		this.buyerDao.delete(Buyer.class, id);
	}
	
	public List<Buyer> getFriends(Collection<Integer> friendsList){
		List<Buyer> friends = new LinkedList<Buyer>();
		for(Integer id : friendsList){
			friends.add(getBuyer(id));
		}
		return friends;
	}

}
