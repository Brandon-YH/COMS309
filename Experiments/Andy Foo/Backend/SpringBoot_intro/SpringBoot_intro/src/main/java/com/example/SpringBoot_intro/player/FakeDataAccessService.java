package com.example.SpringBoot_intro.player;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakeDataAccessService implements  PlayerDao{

    private static List<Player> DB = new ArrayList<>();

    @Override
    public int insertPlayer(UUID id, Player player) {
        DB.add(new Player(id, player.getPlayerName(),player.getLevel(),player.getEmail()));
        return 1;
    }

    public List<Player> returnAllPlayers(){
        return DB;
    }

    @Override
    public Optional<Player> selectPlayerViaID(UUID id) {

        return  DB.stream()
                .filter(person -> person.getId().equals(id))
                .findFirst();

    }

    @Override
    public int deletePlayerViaID(UUID id) {
        Optional<Player> playerUnknown = selectPlayerViaID(id);
        if(playerUnknown.isEmpty()){
            return 0;
        }

        DB.remove(playerUnknown.get());
        return 1;
    }

    @Override
    public int updatePlayerViaID(UUID id, Player player) {
        Optional<Player> playerUnknown = selectPlayerViaID(id);
        if(playerUnknown.isPresent()){
            int indexToUpdate = DB.indexOf(playerUnknown.get());
            DB.set(indexToUpdate, new Player(id, player.getPlayerName(), player.getLevel(), player.getEmail()));
            return 1;
        }
        return 0;
    }

}
