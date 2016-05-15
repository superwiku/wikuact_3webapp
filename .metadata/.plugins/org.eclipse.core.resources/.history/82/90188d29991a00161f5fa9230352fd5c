package org.meruvian.yama.webapi.service.product;

import java.math.BigDecimal;

import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.meruvian.yama.bussiness.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wordnik.swagger.annotations.Api;

@Path("/api/products")
@Api("/product")
@Produces(MediaType.APPLICATION_JSON)
public interface ProductService {
	@GET
	@Path("/{id}")
	Product getProductById(@PathParam("id")  String id);
	
	@GET
	@Path("/barcode")
	Product getProductByBarcode(@QueryParam("barcode")  String barcode);
	
	@GET
	Page<Product> findProductByName(@QueryParam("name") @DefaultValue("") String name, Pageable pageable);
	
	@GET
	@Path("/nameprice")
	Page<Product> findProductByNameAndPrice(@QueryParam("name") @DefaultValue("") String name,@QueryParam("price") @DefaultValue("") BigDecimal price, Pageable pageable);
	
	@POST
	Product saveProduct(Product product);
	
	@PUT
	@Path("/{id}")
	Product updateProduct(Product product);
	
	@DELETE
	@Path("/{id}")
	void deleteProduct(@PathParam("Id")  String Id);

}
