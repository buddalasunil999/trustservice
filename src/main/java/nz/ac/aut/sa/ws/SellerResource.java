package nz.ac.aut.sa.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nz.ac.aut.sa.service.SellerService;
import nz.ac.aut.sa.service.ServiceFactory;
import nz.ac.aut.sa.services.domain.impl.Seller;
import nz.ac.aut.sa.trust.DynamicTrust;

@Path("/sellers")
public class SellerResource {
	private SellerService sellerService = ServiceFactory.getSellerService();
	
	@GET
	@Path("/{sellerId}")
	public double getSellerPenalty(@PathParam("sellerId") int sellerId){
		Seller seller = sellerService.getSeller(sellerId);
		if(seller == null){
			return -1;
		}
		return DynamicTrust.getSellerPenalty(seller);
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Seller> getSellers(){
		return sellerService.getSellers();
	}
	
}
