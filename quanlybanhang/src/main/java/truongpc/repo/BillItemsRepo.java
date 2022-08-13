package truongpc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import truongpc.entity.BillItems;

public interface BillItemsRepo extends JpaRepository<BillItems, Integer>{

}
