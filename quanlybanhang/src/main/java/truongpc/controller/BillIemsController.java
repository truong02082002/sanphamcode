package truongpc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import truongpc.entity.BillItems;
import truongpc.repo.BillItemsRepo;
import truongpc.repo.BillRepo;
import truongpc.repo.ProductRepo;

@Controller
@RequestMapping("/billitems")
public class BillIemsController {
	@Autowired
	BillItemsRepo billItemsRepo;
	@Autowired
	BillRepo billRepo;
	@Autowired
	ProductRepo productRepo;
	
	@GetMapping("/create")
	public String create(Model model,@RequestParam("id")int id) {
		model.addAttribute("billList", billRepo.findAll());
		model.addAttribute("productList", productRepo.findAll());
		model.addAttribute("id",id);
		return"billitems/create";
	}
	@PostMapping("/create")
	public String create(@ModelAttribute BillItems billItems) {
		billItemsRepo.save(billItems);
		return"redirect:/billitems/search";
	}
	
	@GetMapping("/search")
	public String search(Model model) {
		model.addAttribute("billitemsList", billItemsRepo.findAll());
		return"billitems/search";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		billItemsRepo.deleteById(id);
		return"redirect:/billitems/search";
	}
	
	@GetMapping("/edit")
	public String edit(@RequestParam("id") int id, Model model) {
		model.addAttribute("billitems", billItemsRepo.findById(id).orElse(null));
		model.addAttribute("bill", billRepo.findAll());
		model.addAttribute("product", productRepo.findAll());
		return"billitems/edit";
	}
	@PostMapping("/edit")
	public String edit(@ModelAttribute BillItems billItems) {
		billItemsRepo.save(billItems);
		return"redirect:/billitems/search";
	}
}
