package com.bjanczak.model;

import javax.persistence.*;

@Entity
@Table(name = "ticket")

public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "showing", nullable = false)
    private Showing showing;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_last_name")
    private String userLastName;

    @Column(name = "seat")
    private int seat;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Showing getShowing() {
        return showing;
    }

    public void setShowing(Showing showing) {
        this.showing = showing;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public int getSeat() {
        return seat;
    }

    public void setSeat(int seat) {
        this.seat = seat;
    }

    @Override
    public String toString() {
        return "Showing{" +
                "id=" + id +
                ", showing=" + showing +
                ", userName='" + userName + '\'' +
                ", userLastName='" + userLastName + '\'' +
                ", seats=" + seat +
                '}';
    }
}

