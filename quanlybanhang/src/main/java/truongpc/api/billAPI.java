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

import truongpc.entity.Bill;
import truongpc.entity.User;
import truongpc.repo.BillRepo;
import truongpc.repo.UserRepo;

@RestController
@RequestMapping("/api")
public class billAPI {
	@Autowired 
	BillRepo billRepo;
	@Autowired
	UserRepo userRepo;
	
	@GetMapping("/bill/search")
	public List<Bill> search(){
		List<Bill> bills = billRepo.findAll();
		return bills;
	}
	
	@PostMapping("/bill/add")
	public void add(@RequestBody Bill bill) {
		billRepo.save(bill);
	}
	
	@PutMapping("/bill/update")
	public void update(@RequestBody Bill bill) {
		billRepo.save(bill);
	}
	
	@DeleteMapping("/bill/delete/{id}")
	public void delete(@PathVariable(name="id") int id) {
		billRepo.deleteById(id);
	}
}
