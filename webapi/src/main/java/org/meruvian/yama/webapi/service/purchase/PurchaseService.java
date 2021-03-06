package org.meruvian.yama.webapi.service.purchase;

import java.util.Date;
import java.util.List;

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
import org.meruvian.yama.bussiness.entity.Purchase;
import org.meruvian.yama.bussiness.entity.PurchaseDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Path("/api/purchases")
@Api("/purchases")
@Produces(MediaType.APPLICATION_JSON)

public interface PurchaseService {
	
	@GET
	@Path("/{id}")
	@ApiOperation(httpMethod = "GET", value = "Get Purchase By Id", response = Purchase.class)
	Purchase getPurchaseById(@PathParam("id")  String id);
	
	@GET
	@Path("/purchasedate")
	@ApiOperation(httpMethod = "GET", value = "Find Purchase By Purchase Date", response = Purchase.class,
					responseContainer = "Page")
	Page<Purchase> findPurchaseByPurchasedate(@QueryParam("purchasedatemin") Date purchasedatemin, @QueryParam("purchasedatemax") Date purchasedatemax, Pageable pageable);
	
	@GET
	@ApiOperation(httpMethod = "GET", value = "Find Purchase By Total Purchase", response = Purchase.class,
					responseContainer = "Page")
	Page<Purchase> findPurchaseByTotalpurchase(@QueryParam("totalpurchasemin") Double totalpurchasemin, @QueryParam("totalpurchasemax") Double totalpurchasemax, Pageable pageable);
	
	@POST
	@ApiOperation(httpMethod = "POST", value = "Post Purchase", response = Purchase.class)
	Purchase savePurchase(List<PurchaseDetail> purchaseDetails);
	
	@PUT
	@Path("/{id}/put")
	@ApiOperation(httpMethod = "PUT", value = "Put Purchase By Id", response = Purchase.class)
	Purchase updatePurchase(Purchase purchase);
	
	@DELETE
	@Path("/{id}/delete")
	@ApiOperation(httpMethod = "DELETE", value = "Delete Purchase By Id")
	void deletePurchase(@PathParam("id")  String id);
	
	@GET
	@Path("/{id}/details") 
	@ApiOperation(httpMethod = "GET", value = "Get PurchaseDetail By Purchase", response = PurchaseDetail.class)
	Page<PurchaseDetail> getPurchaseDetailByPurchase(@PathParam("id") String id, Pageable pageable);
	
			
	
}
