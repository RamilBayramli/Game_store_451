package com.example.demo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    List<Game> findByTitle(String title);
    List<Game> findByGenre(String genre);
    List<Game> findByPriceGreaterThan(Double price);
    List<Game> findByPriceLessThan(Double price);
    List<Game> findByTitleContainingIgnoreCase(String title);
    List<Game> findByStudioId(Long id);
}