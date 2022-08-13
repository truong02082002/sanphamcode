package truongpc.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import truongpc.entity.Bill;

public interface BillRepo extends JpaRepository<Bill, Integer> {

}
