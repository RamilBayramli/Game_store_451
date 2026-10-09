package com.example.demo;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/games")
public class GameController {
    private GameService service;
    public GameController(GameService service) {
        this.service = service;
    }

    @PostMapping
    public Game add(@RequestBody Game game) {
        return service.save(game);
    }

    @GetMapping
    public List<Game> getAll() {
        return service.getAll();
    }

    @GetMapping("/id")
    public Game get(@PathVariable Long id) {
        return service.getOne(id);
    }

    @PutMapping("/id")
    public Game update(@PathVariable Long id, @RequestBody Game game) {
        return service.update(id, game);
    }

    @DeleteMapping("/id")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/search/title")
    public List<Game> byTitle(@RequestParam String title) {
        return service.byTitle(title);
    }

    @GetMapping("/search/genre")

    public List<Game> byGenre(@RequestParam String genre) {
        return service.byGenre(genre);
    }
    @GetMapping("/search/price/greater")

    public List<Game> expensive(@RequestParam Double price) {
        return service.expensive(price);
    }
    @GetMapping("/search/price/less")
    public List<Game> cheap(@RequestParam Double price) {
        return service.cheap(price);
    }

    @GetMapping("/search/title/contains")
    public List<Game> search(@RequestParam String title) {

        return service.search(title);
    }
    @GetMapping("/search/studio/id")
    public List<Game> byStudio(@PathVariable Long id) {
        return service.byStudio(id);
    }
}
