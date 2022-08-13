package truongpc.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import truongpc.entity.Product;
import truongpc.repo.CategoryRepo;
import truongpc.repo.ProductRepo;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	ProductRepo productRepo;
	@Autowired
	CategoryRepo categoryRepo;
	
	@GetMapping("/create")
	public String create1(Model model) {
		model.addAttribute("categoryList", categoryRepo.findAll());
		return"product/create";
	}
	@PostMapping("/create")
	public String create(@ModelAttribute Product product,
			@RequestParam(name = "file", required = false) MultipartFile file) {
		if (file != null && file.getSize() > 0) {
			// co luu lai file vao filder
			final String FOLDER =  "C:\\Users\\ADMIN\\eclipse-workspace\\quanlybanhang\\src\\main\\resources\\static\\image\\"; 

			String filename = file.getOriginalFilename();

			java.io.File outFile = new java.io.File(FOLDER + filename);
			try {
				file.transferTo(outFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			product.setImage(filename);
		}
			
		productRepo.save(product);
		return"redirect:/product/search";
	}

	@RequestMapping(value = "/download-file")
	public void download(HttpServletRequest request, HttpServletResponse response) {
		String filename = request.getParameter("image");
		String dataDirectory = "C:\\Users\\ADMIN\\eclipse-workspace\\quanlybanhang\\src\\main\\resources\\static\\image\\"; // sau image nho de \\ de luu trong folder image
		java.nio.file.Path file = Paths.get(dataDirectory, filename);
		if (Files.exists(file)) {
			response.setContentType("image/jpeg");
			try {
				Files.copy(file, response.getOutputStream());
				response.getOutputStream().flush();
			} catch (IOException ex) {
				ex.printStackTrace();
			}

		}
	}
	@GetMapping("/search")
	public String search(Model model) {
		model.addAttribute("productList", productRepo.findAll());
		return"product/search";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("id") int id) {
		productRepo.deleteById(id);
		return"redirect:/product/search";
	}
	
	@GetMapping("/edit")
	public String edit1(Model model, @RequestParam("id") int id) {
		model.addAttribute("product", productRepo.findById(id).orElse(null));
		model.addAttribute("categoryList", categoryRepo.findAll());
		return"product/edit";
	}
	@PostMapping("/edit")
	public String edit(@ModelAttribute Product product,@RequestParam(name = "file", required = false) MultipartFile file) {
		if (file != null && file.getSize() > 0) {
			// co luu lai file vao filder
			final String FOLDER =  "C:\\Users\\ADMIN\\eclipse-workspace\\quanlybanhang\\src\\main\\resources\\static\\image\\"; 

			String filename = file.getOriginalFilename();

			java.io.File outFile = new java.io.File(FOLDER + filename);
			try {
				file.transferTo(outFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
			product.setImage(filename);
		}
			
		productRepo.save(product);
		return"redirect:/product/search";
	}
}
