package truongpc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import truongpc.entity.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
