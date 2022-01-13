package piuwave.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import piuwave.dsmovie.entities.Score;
import piuwave.dsmovie.entities.ScorePK;

public interface ScoreRepository extends JpaRepository<Score, ScorePK>{
	
}
