package com.learningMicroservices2.springBootCourse2.entities;

import java.util.Objects;

public class Movie {
    private Long id;
    private Integer publicationYear;
    private String category;
    private String name;
    private String description;

    public Movie(){

    }

    public Movie(Long id, Integer publicationDate, String category, String name, String description){
        this.id = id;
        this.publicationYear = publicationDate;
        this.category = category;
        this.name = name;
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Movie movie = (Movie) o;
        return id.equals(movie.id) && publicationYear.equals(movie.publicationYear) && category.equals(movie.category) && name.equals(movie.name) && Objects.equals(description, movie.description);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + publicationYear.hashCode();
        result = 31 * result + category.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + Objects.hashCode(description);
        return result;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", publicationYear=" + publicationYear +
                ", category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
