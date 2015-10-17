package nz.ac.aut.sa.ws;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import nz.ac.aut.sa.service.ProductService;
import nz.ac.aut.sa.service.ServiceFactory;
import nz.ac.aut.sa.services.domain.impl.ProductImpl;

@Path("/products")
public class ProductResource {
	private ProductService productService = ServiceFactory.getProductService();
	
	@GET
	@Path("/{productId}")
	public double getProductRating(@PathParam("productId") int productId){
		ProductImpl product = productService.getProduct(productId);
		if(product == null){
			return -1;
		}
		return product.getRating();
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<ProductImpl> getProducts(){
		return productService.getProducts();
	}
}
