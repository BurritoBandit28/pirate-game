package io.github.burritobandit28.pirate_game;

import io.github.burritobandit28.pirate_game.server.GameServerObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static final Logger LOGGER = LoggerFactory.getLogger("Server");

    private static ArrayList<GameServerObject> _GAMES = new ArrayList<>();


    // the loops for the server, I separated them for readability and in case we ever want to add more stuff
    private static void doServerLoop() {

        for (GameServerObject game : _GAMES) {
            game.loop();
        }

    }


    // loop for the ENTIRE game
    private static void doGameLoop() {
        // check player join packets
        // handle packet, connect them to a server
        doServerLoop();
    }

    // creates a game and returns its room code
    public static int createGameServer() {

        // generate room code between 0 and 99999
        Random random = new Random();
        int i = random.nextInt(99999);

        // create object
        GameServerObject gameServerObject = new GameServerObject(i);

        // append to list of running games
        _GAMES.add(gameServerObject);
        LOGGER.info("Room opened with code %s".formatted(i));
        return i;
    }

    private static void serverStartup() {
        LOGGER.info("Starting up...");

        // any startup things

        LOGGER.info("Start up complete!");
    }

    public static void main(String[] args) {

        // run start up operations
        serverStartup();

        //createGameServer(); -using for a little test earlier

        // while loop is temporary solution TODO, make it good
        while (true) {

            // run game loop for every game as long as the list isn't empty
            if (!(_GAMES.size() < 1)) {
                doGameLoop();
            }

        }
    }
}
