package com.bjanczak;

import com.bjanczak.model.Movie;
import com.bjanczak.service.interfaces.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
class MovieController {

	private final Logger log = LoggerFactory.getLogger(MovieController.class);
	@Autowired
	private MovieService movieService;

	@GetMapping("/movies")
	public List<Movie> movies() {
		return movieService.showMovieList();
	}

	@GetMapping("/movie/{id}")
	ResponseEntity<?> getMovie(@PathVariable Integer id) {
		Optional<Movie> movie = Optional.of(movieService.getMovie(id));
		return movie.map(response -> ResponseEntity.ok().body(response))
				.orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
	}

	@PostMapping("/movie")
	ResponseEntity<Movie> createMovie(@Valid @RequestBody Movie movie) throws URISyntaxException {
		log.info("Request to create movie: {}", movie);
		movieService.addMovie(movie);
		return ResponseEntity.created(new URI("/api/movie/" + movie.getId()))
				.body(movie);
	}

	@PutMapping("/movie/{id}")
	ResponseEntity<Movie> updateMovie(@PathVariable Integer id, @Valid @RequestBody Movie movie) {
		movie.setId(id);
		log.info("Request to update movie: {}", movie);
		movieService.addMovie(movie);
		return ResponseEntity.ok().body(movie);
	}
}