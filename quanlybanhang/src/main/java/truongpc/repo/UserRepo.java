package truongpc.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import truongpc.entity.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
