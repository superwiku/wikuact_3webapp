package org.meruvian.yama.webapi.service.product;

import java.util.List;

import javax.inject.Inject;

import org.meruvian.yama.bussiness.entity.Product;
import org.meruvian.yama.bussiness.entity.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(readOnly = true)
public class RestProductService implements ProductService{
	@Inject
	private ProductRepository productrepository;
	
	@Override
	public List<Product> findProductByName(String name) {
		return productrepository.findByName(name);
	}
	
	@Override
	public Product getProductById(long id) {
		return productrepository.findById(id);
	}
	
	@Override
	@Transactional
	public Product updateProduct(long id, Product product) {
		Product awal = getProductById(product.getId());
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
	public void deleteProduct(long id) {
		productrepository.delete(id);
	}

}
