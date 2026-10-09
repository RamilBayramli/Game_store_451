package com.example.demo;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class StudioService {
    private StudioRepository repository;
    public StudioService(StudioRepository repository) {
        this.repository = repository;
    }
    public Studio save(Studio studio) {
        return repository.save(studio);
    }
    public List<Studio> getAll() {
        return repository.findAll();
    }
}
