package com.example.ChelseaAssignment3.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Movies")

public class Movies {
    public void setMovieID(int movieID) {
        this.movieID = movieID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRelease_year() {
        return release_year;
    }

    public void setRelease_year(String release_year) {
        this.release_year = release_year;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public Movies (int movieID, String name,String release_year, String rating, String genre, String description){
        this.movieID =movieID;
        this.name=name;
        this.release_year=release_year;
        this.rating=rating;
        this.genre=genre;
        this.description=description;

    }

    @Id
    int movieID;
    @Column
    String name;
    @Column
    String release_year;
    @Column
    String rating;
    @Column
    String genre;
    @Column
    String description;

    public int getMovieID() {
        return movieID;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "movieID=" + movieID +
                ", name='" + name + '\'' +
                ", release_year" + release_year + '\'' +
                ", rating" + rating + '\'' +
                ", genre" + genre + '\'' +
                ", description" + description + '\'' +
                '}';


    }


}
