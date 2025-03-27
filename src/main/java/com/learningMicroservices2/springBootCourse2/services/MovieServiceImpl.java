package com.learningMicroservices2.springBootCourse2.services;

import com.learningMicroservices2.springBootCourse2.entities.Employee;
import com.learningMicroservices2.springBootCourse2.entities.Movie;

import java.util.ArrayList;
import java.util.List;

public class MovieServiceImpl implements IMovieService{

    private List<Movie> movies = new ArrayList<>();

    @Override
    public void getMovies(){
        System.out.println("MOVIES LIST");
        movies.forEach(System.out::println);

    }

    @Override
    public  void addMovie(Movie movie){
        movies.add(movie);
        System.out.println("MOVIE ADDED SUCCESSFULLY");
    }



}
