package truongpc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import truongpc.entity.User;
import truongpc.repo.UserRepo;

@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	UserRepo userRepo;
	
	@GetMapping("/create")
	public String create1() {
		
		return"user/create";
	}
	@PostMapping("/create")
	public String create2(@ModelAttribute User user) {
		userRepo.save(user);
		return"redirect:/user/search";
	}
	
	@GetMapping("/search")
	public String search(Model model) {
		model.addAttribute("userList", userRepo.findAll());
		return"user/search";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		userRepo.deleteById(id);
		return"redirect:/user/search";
	}
	
	@GetMapping("/edit")
	public String edit1(Model model, @RequestParam("id") int id) {
		model.addAttribute("user", userRepo.findById(id).orElse(null));
		return"user/edit";
	}
	
	@PostMapping("/edit")
	public String edit2(@ModelAttribute User user) {
		userRepo.save(user);
		return"redirect:/user/search";
	}
}
