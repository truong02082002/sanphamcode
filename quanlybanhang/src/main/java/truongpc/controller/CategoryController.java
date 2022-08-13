package truongpc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import truongpc.entity.Category;
import truongpc.repo.CategoryRepo;

@Controller
@RequestMapping("/category")
public class CategoryController {
	@Autowired
	CategoryRepo categoryRepo;
	
	@GetMapping("/create")
	public String create1() {
		
		return"category/create";
	}
	@PostMapping("/create")
	public String create2(@ModelAttribute Category category) {
		categoryRepo.save(category);
		return"redirect:/category/search";
	}
	
	@GetMapping("/search")
	public String search(Model model) {
		model.addAttribute("categoryList", categoryRepo.findAll());
		return"category/search";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		categoryRepo.deleteById(id);
		return"redirect:/category/search";
	}
	
	@GetMapping("/edit")
	public String edit1(Model model, @RequestParam("id") int id) {
		model.addAttribute("category", categoryRepo.findById(id).orElse(null));
		return"category/edit";
	}
	@PostMapping("/edit")
	public String edit2(@ModelAttribute Category category) {
		Category category2 = categoryRepo.findById(category.getId()).orElse(null);
		category2.setName(category.getName());
		categoryRepo.save(category2);
		return"redirect:/category/search";
	}
		
	
}
