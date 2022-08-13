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

import truongpc.entity.User;
import truongpc.repo.UserRepo;

@RestController
@RequestMapping("/api")
public class UserAPI {
	@Autowired
	UserRepo userRepo;

	@GetMapping("/user/search")
	public List<User> search(){
		List<User> users = userRepo.findAll();
		return users;
	}
	
	@PostMapping("/user/add")
	public void add(@RequestBody User user) {
		userRepo.save(user);
	}
	
	@PutMapping("/user/update")
	public void update(@RequestBody User user) {
		userRepo.save(user);
	}
	@DeleteMapping("/user/delete/{id}")
	public void delete(@PathVariable(name="id") int id) {
		userRepo.deleteById(id);
	}
}
