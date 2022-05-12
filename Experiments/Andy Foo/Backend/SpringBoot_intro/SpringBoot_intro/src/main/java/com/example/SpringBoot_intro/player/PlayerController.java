package com.example.SpringBoot_intro.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path="api/v1/player")
public class PlayerController {

    @Autowired
    private final PlayerService playerService;

    public PlayerController (PlayerService playerService){
        this.playerService = playerService;
    }

    @PostMapping
    public void addPlayer(@RequestBody Player player){
        playerService.addPlayer(player);
    }

    @GetMapping
    public List<Player> getAllPLayers(){
        return playerService.returnPlayers();
    }

    @GetMapping(path = "{id}")
    public Player getPlayerViaID(@PathVariable("id") UUID id){
        return playerService.getPlayerViaID(id)
                .orElse(null);
    }

    @DeleteMapping(path = "{id}")
    public void deletePLayerViaID(@PathVariable("id") UUID id){
        playerService.deletePlayerViaID(id);
    }

    @PutMapping(path = "{id}")
    public void updatePlayerViaID(@PathVariable("id") UUID id, @RequestBody Player playerToUpdate ){
        playerService.updatePlayerViaID(id, playerToUpdate);
    }
}
