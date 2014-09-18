package se.radley.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.radley.domain.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>, UserRepositoryCustom {

	public User findByEmail(String email);
}
