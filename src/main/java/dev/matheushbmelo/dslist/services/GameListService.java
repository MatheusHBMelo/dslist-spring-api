package dev.matheushbmelo.dslist.services;

import dev.matheushbmelo.dslist.dtos.GameListDto;
import dev.matheushbmelo.dslist.projections.GameMinProjection;
import dev.matheushbmelo.dslist.repositories.GameListRepository;
import dev.matheushbmelo.dslist.repositories.GameRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    private final GameListRepository gameListRepository;
    private final GameRepository gameRepository;

    public GameListService(GameListRepository gameListRepository, GameRepository gameRepository) {
        this.gameListRepository = gameListRepository;
        this.gameRepository = gameRepository;
    }

    @Transactional(readOnly = true)
    public List<GameListDto> findAll() {
        return gameListRepository
                .findAll()
                .stream()
                .map(GameListDto::new).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationIndex, obj);

        int min = Math.min(sourceIndex, destinationIndex);
        int max = Math.max(sourceIndex, destinationIndex);

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelonging(listId, list.get(i).getId(), i);
        }

    }
}
