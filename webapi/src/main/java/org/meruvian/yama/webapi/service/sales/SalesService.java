package org.meruvian.yama.webapi.service.sales;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.meruvian.yama.bussiness.entity.Sales;


public interface SalesService {
	
	@GET
	@Path("/{id}")
	Sales getSalesById(@PathParam("id")  long id);
	
	
	@POST
	@OPTIONS
	Sales saveSales(Sales sales);
	
	@PUT
	@Path("/{id}")
	Sales updateSales(@PathParam("id")  long id, Sales sales);
	
	@DELETE
	@Path("/{id}")
	void deleteSales(@PathParam("id")  long id);

}
