package com.example.SpringBoot_intro.player;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PlayerDao {

    int insertPlayer(UUID id, Player pLayer  );

    default int insertPlayer(Player player){
        UUID id = UUID.randomUUID();
        return insertPlayer(id, player);
    }

    List<Player> returnAllPlayers();

    Optional<Player> selectPlayerViaID(UUID id);

    int deletePlayerViaID(UUID id);

    int updatePlayerViaID(UUID id, Player player);

}
