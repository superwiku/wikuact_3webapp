package org.meruvian.yama.webapi.service.sales;

import java.util.Date;

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

import org.meruvian.yama.bussiness.entity.Sales;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/api/saless")
@Api("/saless")
@Produces(MediaType.APPLICATION_JSON)

public interface SalesService {
	
	@GET
	@Path("/{id}")
	@ApiOperation(httpMethod = "GET", value = "Get Sales By Id", response = Sales.class)
	Sales getSalesById(@PathParam("id")  String id);
	
	@GET
	@ApiOperation(httpMethod = "GET", value = "Find Sales By Totalsales", response = Sales.class, responseContainer = "Page")
	Page<Sales> findSalesByTotalsales(@QueryParam("totalsales") @DefaultValue("0") Double totalsales , Pageable pageable);
	
	@GET
	@Path("/salesdate")
	@ApiOperation(httpMethod = "GET", value = "Find Sales By Salesdate", response = Sales.class, responseContainer = "Page")
	Page<Sales> findSalesBySalesdate(@QueryParam("salesdate") @DefaultValue("new Date()") Date salesdatemin, @QueryParam("salesdate") @DefaultValue("new Date()") Date salesdatemax, Pageable pageable);
	
	@GET
	@Path("/totalsales")
	@ApiOperation(httpMethod = "GET", value = "Find Sales By Totalsales", response = Sales.class, responseContainer = "Page")
	Page<Sales> findSalesByTotalsales(@QueryParam("totalsales") @DefaultValue("0") Double totalsalesmin, @QueryParam("totalsales") @DefaultValue("0") Double totalsalesmax, Pageable pageable);
	
	@POST
	@ApiOperation(httpMethod = "POST", value = "Post Sales", response = Sales.class)	
	Sales saveSales(Sales sales);
	
	@PUT
	@Path("/{id}")
	@ApiOperation(httpMethod = "PUT", value = "Put Sales By Id", response = Sales.class)
	Sales updateSales(Sales sales);
	
	@DELETE
	@Path("/{id}")
	@ApiOperation(httpMethod = "DELETE", value = "Delete Sales By Id")
	void deleteSales(@PathParam("id")  String id);

}
