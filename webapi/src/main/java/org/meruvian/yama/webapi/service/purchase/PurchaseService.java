package org.meruvian.yama.webapi.service.purchase;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.meruvian.yama.bussiness.entity.Purchase;


@Path("api/pos")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface PurchaseService {
	
	@GET
	@Path("/{id}")
	Purchase getPurchaseById(@PathParam("id")  long id);
	
	
	@POST
	@OPTIONS
	Purchase savePurchase(Purchase purchase);
	
	@PUT
	@Path("/{id}")
	Purchase updatePurchase(@PathParam("id")  long id, Purchase purchase);
	
	@DELETE
	@Path("/{id}")
	void deletePurchase(@PathParam("id")  long id);
			
	
}
