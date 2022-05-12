package com.example.SpringBoot_intro.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlayerService {

    private final PlayerDao playerDao;

    @Autowired
    public PlayerService(@Qualifier("fakeDao") PlayerDao playerDao){
        this.playerDao = playerDao;
    }

    public int addPlayer(Player player){
        return playerDao.insertPlayer(player);
    }

    public List<Player> returnPlayers(){
        return playerDao.returnAllPlayers();
    }

    public Optional<Player> getPlayerViaID(UUID id){
        return playerDao.selectPlayerViaID(id);
    }

    public int deletePlayerViaID(UUID id){
        return playerDao.deletePlayerViaID(id);
    }

    public int updatePlayerViaID(UUID id, Player newPlayer){
        return playerDao.updatePlayerViaID(id,newPlayer);
    }
}
