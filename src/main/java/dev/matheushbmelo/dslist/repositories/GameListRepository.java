package dev.matheushbmelo.dslist.repositories;

import dev.matheushbmelo.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GameListRepository extends JpaRepository<GameList, Long> {
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE tb_belonging SET position = :newPosition\n" +
            "WHERE game_list_id = :listId AND game_id = :gameId")
    void updateBelonging(Long listId, Long gameId, int newPosition);
}
