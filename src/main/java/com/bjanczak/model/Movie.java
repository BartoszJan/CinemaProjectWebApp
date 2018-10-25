package com.bjanczak.model;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "movie")
@Proxy(lazy = false)
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE,
            mappedBy = "movie", orphanRemoval = true)
    @Column(name = "showings", nullable = false)
    private List<Showing> showings;

    @Column(name = "title")
    private String title;

    @Column(name = "year")
    private LocalDate year;

    @Column(name = "duration")
    private int duration;

    @Column(name = "director")
    private String director;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Showing> getShowings() {
        return showings;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", duration=" + duration +
                ", director='" + director + '\'' +
                '}';
    }
}
