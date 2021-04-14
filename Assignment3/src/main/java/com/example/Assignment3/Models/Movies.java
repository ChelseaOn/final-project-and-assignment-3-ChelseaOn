package com.example.Assignment3.Models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Movies")
public class Movies {
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
