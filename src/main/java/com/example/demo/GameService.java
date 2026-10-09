package com.example.demo;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class GameService {
    private GameRepository repository;
    public GameService(GameRepository repository) {
        this.repository = repository;
    }
    public Game save(Game game) {
        return repository.save(game);
    }
    public List<Game> getAll() {
        return repository.findAll();
    }
    public Game getOne(Long id) {
        return repository.findById(id).orElse(null);
    }
    public Game update(Long id, Game newGame) {
        Game game = repository.findById(id).orElse(null);
        if (game != null) {
            game.setTitle(newGame.getTitle());
            game.setGenre(newGame.getGenre());
            game.setPrice(newGame.getPrice());
            game.setStudio(newGame.getStudio());
            return repository.save(game);
        }
        return null;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
    public List<Game> byTitle(String title) {
        return repository.findByTitle(title);
    }
    public List<Game> byGenre(String genre) {
        return repository.findByGenre(genre);
    }
    public List<Game> expensive(Double price) {
        return repository.findByPriceGreaterThan(price);
    }
    public List<Game> cheap(Double price) {
        return repository.findByPriceLessThan(price);
    }
    public List<Game> search(String title) {
        return repository.findByTitleContainingIgnoreCase(title);
    }
    public List<Game> byStudio(Long id) {
        return repository.findByStudioId(id);
    }
}