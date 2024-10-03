package com.movieflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieflix.repository.MovieRepository;
import com.movieflix.entities.Movie;

@Service
public class MovieServiceImplementation implements MovieService{
	@Autowired
	MovieRepository movrepo;

	public MovieServiceImplementation(MovieRepository movrepo) {
		super();
		this.movrepo = movrepo;
	}

	@Override
	public String addMovie(Movie mov) {
		movrepo.save(mov);
		return "movie is added";
	}

	@Override
	public List<Movie> viewMovie() {
		List<Movie> movieList =movrepo.findAll();
		return movieList;
	}

}

