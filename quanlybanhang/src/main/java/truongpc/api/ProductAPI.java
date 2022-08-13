package truongpc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import truongpc.entity.Product;
import truongpc.repo.CategoryRepo;
import truongpc.repo.ProductRepo;

@RestController
@RequestMapping("/api")
public class ProductAPI {
	@Autowired
	private ProductRepo productRepo;
	@Autowired 
	private CategoryRepo categoryRepo;
	
	@GetMapping("/product/search")
	private List<Product> search(){
		List<Product> products = productRepo.findAll();
		return products;
	}
	@PostMapping("/product/add")
	private void add(@RequestBody Product product) {
		
		productRepo.save(product);
	}
	@PutMapping("/product/update")
	private void update(@RequestBody Product product) {
		productRepo.save(product);
	}
	@DeleteMapping("/product/delete/{id}")
	private void delete(@PathVariable(name="id") int id) {
		productRepo.deleteById(id);
	}
}
