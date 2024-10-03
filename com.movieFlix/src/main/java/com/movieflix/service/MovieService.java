package com.movieflix.service;

import java.util.List;

import com.movieflix.entities.Movie;

public interface MovieService {
	
	public String addMovie(Movie mov);
	
	public List<Movie> viewMovie();
	
	

}
