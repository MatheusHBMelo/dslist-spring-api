package dev.matheushbmelo.dslist.services;

import dev.matheushbmelo.dslist.dtos.GameListDto;
import dev.matheushbmelo.dslist.repositories.GameListRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    private final GameListRepository gameListRepository;

    public GameListService(GameListRepository gameListRepository) {
        this.gameListRepository = gameListRepository;
    }

    @Transactional(readOnly = true)
    public List<GameListDto> findAll() {
        return gameListRepository
                .findAll()
                .stream()
                .map(GameListDto::new).toList();
    }
}
