package com.bjanczak.model;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "movie")
@Proxy(lazy = false)
@Data
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

    @Column(name = "description")
    private String description;

    @Column(name = "image_source")
    private String imageSource;

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
