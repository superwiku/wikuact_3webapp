package org.meruvian.yama.webapi.service.purchasedetail;

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

import org.meruvian.yama.bussiness.entity.PurchaseDetail;

@Path("/T_PURCHASE_DETAIL")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface PurchaseDetailService {
	
	@GET
	@Path("/{id}")
	PurchaseDetail getPurchaseDetailById(@PathParam("id")  long id);
	
	
	@POST
	@OPTIONS
	PurchaseDetail savePurchaseDetail(PurchaseDetail purchasedetail);
	
	@PUT
	@Path("/{id}")
	PurchaseDetail updatePurchaseDetail(@PathParam("id")  long id, PurchaseDetail purchasedetail);
	
	@DELETE
	@Path("/{id}")
	void deletePurchaseDetail(@PathParam("id")  long id);

}
