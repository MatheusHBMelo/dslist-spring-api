package dev.matheushbmelo.dslist.controller;

import dev.matheushbmelo.dslist.dtos.GameListDto;
import dev.matheushbmelo.dslist.dtos.GameMinDto;
import dev.matheushbmelo.dslist.services.GameListService;
import dev.matheushbmelo.dslist.services.GameService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/lists")
public class GameListController {
    private final GameListService gameListService;
    private final GameService gameService;

    public GameListController(GameListService gameListService, GameService gameService) {
        this.gameListService = gameListService;
        this.gameService = gameService;
    }

    @GetMapping
    public ResponseEntity<List<GameListDto>> findAll() {
        return ResponseEntity.ok(gameListService.findAll());
    }

    @GetMapping(path = "/{listId}/games")
    public ResponseEntity<List<GameMinDto>> findByList(@PathVariable(value = "listId") Long listId) {
        return ResponseEntity.ok(gameService.findByList(listId));
    }

}
