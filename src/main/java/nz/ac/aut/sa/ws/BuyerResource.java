package nz.ac.aut.sa.ws;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nz.ac.aut.sa.service.BuyerService;
import nz.ac.aut.sa.service.ProductService;
import nz.ac.aut.sa.service.SellerService;
import nz.ac.aut.sa.service.ServiceFactory;
import nz.ac.aut.sa.services.domain.impl.Buyer;
import nz.ac.aut.sa.services.domain.impl.ProductImpl;
import nz.ac.aut.sa.trust.DynamicTrust;

@Path("/buyers")
public class BuyerResource {
	private BuyerService buyerService = ServiceFactory.getBuyerService();
	private ProductService productService = ServiceFactory.getProductService();
	
	@GET
	@Path("/{buyerId}/{productId}")
	public double getFriendsRating(@PathParam("buyerId") int buyerId,@PathParam("productId") int productId){
		Buyer buyer = buyerService.getBuyer(buyerId);
		if(buyer == null){
			return -1;
		}
		Collection<Buyer> friends = buyerService.getFriends(buyer.getFriendsId());
		ProductImpl product = productService.getProduct(productId);
		if(product == null){
			return -1;
		}
		return DynamicTrust.getFriendsTrust(friends, product);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Buyer> getBuyers(){
		return buyerService.getBuyers();
	}
}
