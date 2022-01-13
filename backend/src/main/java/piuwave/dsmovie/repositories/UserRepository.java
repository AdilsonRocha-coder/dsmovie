package piuwave.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import piuwave.dsmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail(String email);
}
