package org.meruvian.yama.webapi.service.salesdetail;

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

import org.meruvian.yama.bussiness.entity.SalesDetail;

@Path("/T_SALES")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public interface SalesDetailService {
	
	@GET
	@Path("/{id}")
	SalesDetail getSalesDetailById(@PathParam("id")  long id);
	
	
	@POST
	@OPTIONS
	SalesDetail saveSalesDetail(SalesDetail salesdetail);
	
	@PUT
	@Path("/{id}")
	SalesDetail updateSalesDetail(@PathParam("id")  long id, SalesDetail salesdetail);
	
	@DELETE
	@Path("/{id}")
	void deleteSalesDetail(@PathParam("id")  long id);

}
