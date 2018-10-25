package com.bjanczak.service;

import com.bjanczak.model.Movie;
import com.bjanczak.repository.MovieRepository;
import com.bjanczak.service.interfaces.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public List<Movie> showMovieList() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovie(int id) {
        return movieRepository.getOne(id);
    }

    @Override
    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(Movie movie) {
        movieRepository.delete(movie);
    }
}


