package org.meruvian.yama.webapi.service.salesdetail;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.meruvian.yama.bussiness.entity.SalesDetail;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("api/salesdetails")
@Api("/salesdetails")
@Produces(MediaType.APPLICATION_JSON)
public interface SalesDetailService {
	
	@GET
	@Path("/{id}")
	@ApiOperation(httpMethod = "GET", value = "Get Sales By Id", response = SalesDetail.class)
	SalesDetail getSalesDetailById(@PathParam("id")  String id);
	
	
	@POST
	@ApiOperation(httpMethod = "POST", value = "Post Sales", response = SalesDetail.class)
	SalesDetail saveSalesDetail(SalesDetail salesdetail);
	
	@PUT
	@Path("/{id}")
	@ApiOperation(httpMethod = "PUT", value = "Put SalesDetail By Id", response = SalesDetail.class)
	SalesDetail updateSalesDetail(@PathParam("id")  String id, SalesDetail salesdetail);
	
	@DELETE
	@Path("/{id}")
	@ApiOperation(httpMethod = "DELETE", value = "Delete SalesDetail By Id")
	void deleteSalesDetail(@PathParam("id")  String id);

}
