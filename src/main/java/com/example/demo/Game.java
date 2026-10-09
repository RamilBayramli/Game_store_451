package com.example.demo;
import com.example.demo.Studio;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity(name = "games" )
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String genre;
    private double price;
    @ManyToOne
    @JoinColumn(name = "games")
    private Studio studio;

    public Game(Long id, String title, Double price, Studio studio) {
        this.id = id;
        this.title  = title;
        this.genre = genre;
        this.price = price;
        this.studio = studio;
    }
}
