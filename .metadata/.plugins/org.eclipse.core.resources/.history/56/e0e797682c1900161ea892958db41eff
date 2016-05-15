package org.meruvian.yama.webapi.service.product;

import java.math.BigDecimal;

import javax.inject.Inject;

import org.meruvian.yama.bussiness.entity.Product;
import org.meruvian.yama.bussiness.entity.ProductRepository;
import org.meruvian.yama.core.LogInformation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
public class RestProductService implements ProductService{
	@Inject
	private ProductRepository productrepository;
	
	@Override
	public Page<Product> findProductByName(String name, Pageable pageable) {
		return productrepository.findByName(name,LogInformation.ACTIVE,pageable);
	}
	
	@Override
	public Page<Product> findProductByNameAndPrice(String name, BigDecimal price, Pageable pageable){
		return productrepository.findByNameAndPrice(name, price, LogInformation.ACTIVE, pageable);
	}
	
	@Override
	public Product getProductByBarcode(String barcode) {
		return productrepository.getByBarcode(barcode);
	}
	
	@Override
	@Transactional
	public Product updateProduct(Product product) {
		Product awal = getProductByBarcode(product.getBarcode());
		if (awal != null) {
			awal.setName(product.getName());
			awal.setPrice(product.getPrice());
			}		
		return awal;
	}
	
	@Override
	@Transactional
	public Product saveProduct(Product product){
		return productrepository.save(product);
	}
	
	@Override
	@Transactional
	public void deleteProduct(String id) {
		productrepository.delete(id);
	}

	
}
