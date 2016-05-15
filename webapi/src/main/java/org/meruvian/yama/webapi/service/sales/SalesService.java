package org.meruvian.yama.webapi.service.sales;

import java.util.Date;

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

import org.meruvian.yama.bussiness.entity.Purchase;
import org.meruvian.yama.bussiness.entity.Sales;
import org.meruvian.yama.bussiness.entity.SalesDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wordnik.swagger.annotations.Api;

@Path("/api/saless")
@Api("/sales")
@Produces(MediaType.APPLICATION_JSON)
public interface SalesService {
	
	@GET
	@Path("/{id}")
	Sales getSalesById(@PathParam("id")  String id);
	
	@GET
	@Path("/salesdate")
	Page<Sales> findSalesBySalesdate(@QueryParam("salesdate") @DefaultValue("new Date()") Date salesdatemin, @QueryParam("salesdate") @DefaultValue("new Date()") Date salesdatemax, Pageable pageable);
	
	@GET
	@Path("/{sales_id}")
	Page<SalesDetail> findSalesDetailBySales(@PathParam("sales_id") String id, Pageable pageable);
	
	@GET
	Page<Sales> findSalesByTotalsales(@QueryParam("totalsales") @DefaultValue("0") Double totalpurchasemin, @QueryParam("totalsales") @DefaultValue("0") Double totalpurchasemax, Pageable pageable);
	
	@POST
	Sales saveSales(Sales sales);
	
	@PUT
	@Path("/{id}")
	Sales updateSales(@PathParam("id")  String id, Sales sales);
	
	@DELETE
	@Path("/{id}")
	void deleteSales(@PathParam("id")  String id);

}
