package truongpc.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import truongpc.entity.Bill;
import truongpc.entity.User;
import truongpc.repo.BillRepo;
import truongpc.repo.UserRepo;

@Controller
@RequestMapping("/bill")
public class BillController {
	@Autowired
	BillRepo billRepo;
	@Autowired
	UserRepo userRepo;
	
	@GetMapping("/create")
	public String create1(Model model) {
		model.addAttribute("userList", userRepo.findAll());
		return"bill/create";
	}
	@PostMapping("/create")
	public String create2(@ModelAttribute Bill bill,
			@RequestParam(name = "date") @DateTimeFormat(pattern = "YYYY-MM-dd") Date date) {
		bill.setByDate(date);
		billRepo.save(bill);
		return"redirect:/bill/search";
	}
	
	@GetMapping("/search")
	public String search(Model model) {
		model.addAttribute("billList", billRepo.findAll());
		return"bill/search";
	}
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		billRepo.deleteById(id);
		return"redirect:/bill/search";
	}
	
	@GetMapping("/edit")
	public String edit1(@RequestParam("id") int id, Model model) {
		model.addAttribute("bill", billRepo.findById(id).orElse(null));
		model.addAttribute("userList", userRepo.findAll());
		return"bill/edit";
	}
	@PostMapping("/edit")
	public String edit2(@ModelAttribute Bill bill,
			@RequestParam(name = "date") @DateTimeFormat(pattern = "YYYY-MM-dd") Date date) {
		bill.setByDate(date);
		billRepo.save(bill);
		return"redirect:/bill/search";
	}
}
