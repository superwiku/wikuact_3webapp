package org.meruvian.yama.webapi.service.product;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.meruvian.yama.bussiness.entity.Product;

@Path("api/pos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface ProductService {
	

	@GET
	@Path("/{id}")
	
	Product getProductById(@PathParam("id")  long id);
	
	@GET
	List<Product> findProductByName(@QueryParam("name") @DefaultValue("") String name);
	
	@POST
	@OPTIONS
	Product saveProduct(Product product);
	
	@PUT
	@Path("/{id}")
	Product updateProduct(@PathParam("id")  long id, Product product);
	
	@DELETE
	@Path("/{id}")
	void deleteProduct(@PathParam("id")  long id);

}
