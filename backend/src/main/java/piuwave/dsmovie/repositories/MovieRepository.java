package piuwave.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import piuwave.dsmovie.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long>{
	
}
