package piuwave.dsmovie.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_movie")
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String title;
	private Double score;
	private Integer count;
	private String image;
	
	
	//aqui na linha 32 usamos o "Set" que eh uma colecao de scores (nao usaremos uma lista assim nao teremos o risco
	//de alguma repeticao de filmes - quando temos tabelas de muitos para muitos)	
	//aqui criamos dentro da tabela Movies, uma referencia para todo o conjunto de avaliacoes dos filmes
	//usamos o "HashSet" pois ela eh uma interface por isso temos que instanciar uma classe que implementarah uma classe.
	
	@OneToMany(mappedBy = "id.movie")  //aqui no "id.Movie" temos o "id" que vem da classe Score.java(linha 12) e o "Movie" que vem da clase ScorePK (linha 19) 
	private Set<Score> scores = new HashSet<>();
	
	public Movie() {
	}

	public Movie(Long id, String title, Double score, Integer count, String image) {
		this.id = id;
		this.title = title;
		this.score = score;
		this.count = count;
		this.image = image;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Set<Score> getScores() {
		return scores;
	}
}
