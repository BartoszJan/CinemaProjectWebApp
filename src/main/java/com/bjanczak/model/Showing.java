package com.bjanczak.model;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "showing")
public class Showing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "movie", nullable=false)
    private Movie movie;

    @Column(name = "showing_date_time")
    private LocalDateTime showingDateTime;

    @Column(name = "room_number")
    private int roomNumber;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.REMOVE,
            mappedBy = "showing", orphanRemoval = true)
    @Column(name = "tickets", nullable = false)
    private List<Ticket> tickets;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public LocalDateTime getShowingDateTime() {
        return showingDateTime;
    }

    public void setShowingDateTime(LocalDateTime showingDateTime) {
        this.showingDateTime = showingDateTime;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "Showing{" +
                "id=" + id +
                ", movie=" + movie +
                ", showingDateTime=" + showingDateTime +
                ", roomNumber=" + roomNumber +
                '}';
    }
}
