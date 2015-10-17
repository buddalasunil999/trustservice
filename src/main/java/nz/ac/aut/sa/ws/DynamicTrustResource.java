package nz.ac.aut.sa.ws;

import java.util.Collection;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import nz.ac.aut.sa.service.BuyerService;
import nz.ac.aut.sa.service.ProductService;
import nz.ac.aut.sa.service.SellerService;
import nz.ac.aut.sa.service.ServiceFactory;
import nz.ac.aut.sa.services.domain.impl.Buyer;
import nz.ac.aut.sa.services.domain.impl.ProductImpl;
import nz.ac.aut.sa.services.domain.impl.Seller;
import nz.ac.aut.sa.trust.DynamicTrust;

@Path("/dynamictrust")
public class DynamicTrustResource {
	private BuyerService buyerService = ServiceFactory.getBuyerService();
	private ProductService productService = ServiceFactory.getProductService();
	private SellerService sellerService = ServiceFactory.getSellerService();

	@GET
	@Path("/{buyerId}/{productId}/{sellerId}")
	public double getFriendsRating(@PathParam("buyerId") int buyerId, @PathParam("productId") int productId,
			@PathParam("sellerId") int sellerId) {
		Buyer buyer = buyerService.getBuyer(buyerId);
		if (buyer == null) {
			return -1;
		}
		Collection<Buyer> friends = buyerService.getFriends(buyer.getFriendsId());
		ProductImpl product = productService.getProduct(productId);
		if (product == null) {
			return -1;
		}
		Seller seller = sellerService.getSeller(sellerId);
		if(seller == null){
			return -1;
		}
		double satic = product.getRating();
		double friendsTrust = DynamicTrust.getFriendsTrust(friends, product);
		double anomalous = DynamicTrust.getSellerPenalty(seller);
		return DynamicTrust.getDynamicTrust(friendsTrust, satic, anomalous);
	}

}
