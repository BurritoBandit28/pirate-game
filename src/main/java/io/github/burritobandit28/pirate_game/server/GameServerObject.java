package io.github.burritobandit28.pirate_game.server;

import java.util.ArrayList;

public class GameServerObject {

    private int roomCode;

    // list of all connected players
    private ArrayList<Player> Playerlist = new ArrayList<>();

    public GameServerObject() {
        // does nothing rn
    }

    public GameServerObject(int roomCode) {
        this.roomCode = roomCode;
    }


    // the game loop / actions to be taken every game loop
    public void loop() {
        //System.out.println(this.roomCode); -this line was for a quick little test
    }

    // probably never going to be needed
    public void onPlayerJoin(Player player) {
        Playerlist.add(player);
    }

    // getter method for the player list
    public ArrayList<Player> getPlayerlist() {
        return this.Playerlist;
    }

    // again, probably gonna be useless but a room code setter function
    public void setRoomCode(int i) {
        this.roomCode = i;
    }

    // roomcode getter method
    public int getRoomCode() {
        return this.roomCode;
    }



}
