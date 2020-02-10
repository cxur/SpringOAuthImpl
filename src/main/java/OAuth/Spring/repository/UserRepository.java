package OAuth.Spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import OAuth.Spring.model.User;


@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByEmailAddress(String emailAddress);

}
