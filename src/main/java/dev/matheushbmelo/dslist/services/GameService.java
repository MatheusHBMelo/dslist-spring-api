package dev.matheushbmelo.dslist.services;

import dev.matheushbmelo.dslist.dtos.GameDto;
import dev.matheushbmelo.dslist.dtos.GameMinDto;
import dev.matheushbmelo.dslist.repositories.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    private final GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public List<GameMinDto> findAll() {
        return gameRepository.findAll().stream().map(GameMinDto::new).toList();
    }

    public GameDto findById(Long id) {
        return gameRepository.findById(id).map(GameDto::new).orElseThrow(() -> new RuntimeException("Game not found"));
    }
}
