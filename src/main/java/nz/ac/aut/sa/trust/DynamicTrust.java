package nz.ac.aut.sa.trust;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Collection;

import nz.ac.aut.sa.services.domain.impl.Buyer;
import nz.ac.aut.sa.services.domain.impl.ProductImpl;
import nz.ac.aut.sa.services.domain.impl.Seller;


public class DynamicTrust {
	public static double getFriendsTrust(Collection<Buyer> friends, ProductImpl product) {
		double trust = 0;
		int counter = 0;
		for (Buyer friend : friends) {
			if (friend.getRatings().get(product.getId()) != null
					&& friend.getRatings().get(product.getId()) != Double.NaN) {
				trust += friend.getRatings().get(product.getId());
				counter++;
			}
		}
		if (counter == 0) {
			return -1;
		}
		trust /= counter;
		return BigDecimal.valueOf(trust).setScale(3, RoundingMode.HALF_UP).doubleValue();
	}

	public static double getSellerPenalty(Seller seller) {
		return BigDecimal
				.valueOf((double) (seller.getNumAnomalousTransactions()) / ((double) seller.getNumTransactions()))
				.setScale(3, RoundingMode.HALF_UP).doubleValue();
	}
	
	public static double getDynamicTrust(double friendsTrust, double staticRating,double penatly){
		boolean noFriends = false;
		if (friendsTrust == -1) {
			friendsTrust = 0;
			noFriends = true;
		}
		double finalRating = BigDecimal.valueOf(((staticRating + friendsTrust) / (noFriends ? 1 : 2)) - penatly)
				.setScale(3, RoundingMode.HALF_UP).doubleValue();
		return finalRating;
	}
}
