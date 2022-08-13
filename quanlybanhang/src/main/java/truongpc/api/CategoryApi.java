package truongpc.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import truongpc.entity.Category;
import truongpc.repo.CategoryRepo;


@RestController
@RequestMapping("/api")
public class CategoryApi {
	@Autowired
	private CategoryRepo categoryRepo;

	@GetMapping("/category/search")
	public List<Category> search() {
		List<Category> categories = categoryRepo.findAll();
		return categories;
	}

	@PostMapping("/category/add")
	public void add(@RequestBody Category category) {
		categoryRepo.save(category);
	}

	@PutMapping("/category/update")
	public void update(@RequestBody Category category) {
		categoryRepo.save(category);
	}
	
	@DeleteMapping("/category/delete/{id}")
	public void delete(@PathVariable(name = "id") int id) {
		categoryRepo.deleteById(id);
	}

}
