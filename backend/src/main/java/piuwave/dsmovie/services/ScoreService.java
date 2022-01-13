package piuwave.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import piuwave.dsmovie.dto.MovieDTO;
import piuwave.dsmovie.dto.ScoreDTO;
import piuwave.dsmovie.entities.Movie;
import piuwave.dsmovie.entities.Score;
import piuwave.dsmovie.entities.User;
import piuwave.dsmovie.repositories.MovieRepository;
import piuwave.dsmovie.repositories.ScoreRepository;
import piuwave.dsmovie.repositories.UserRepository;

@Service
public class ScoreService {
	
	@Autowired
	private MovieRepository movieRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;

	@Transactional
	public MovieDTO saveScore(ScoreDTO dto) {
		
		User user = userRepository.findByEmail(dto.getEmail());
		if (user == null) {
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);
		}
		
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		
		score = scoreRepository.saveAndFlush(score);
		
		double sum = 0.0;
		for (Score s : movie.getScores()) {  //aqui pegamos a lista de scores de cada filme
			sum = sum + s.getValue();
		}
		
		double avg = sum / movie.getScores().size(); // o metodo ".size" pega o tamanho da colecao de notas
		
		movie.setScore(avg);
		movie.setCount(movie.getScores().size()); // aqui o metodo ".size" pega o tamanho dos usuarios que deram uma nota ao filme
		
		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);
		
	}
}
