package model.parser;

import hu.belicza.andras.bwhf.control.BinRepParser;
import hu.belicza.andras.bwhf.model.PlayerActions;
import hu.belicza.andras.bwhf.model.ReplayHeader;
import model.Action;
import model.Map;
import model.Player;
import model.Replay;

import java.awt.*;
import java.io.File;
import java.util.ArrayList;

import static hu.belicza.andras.bwhf.model.ReplayHeader.convertFramesToSeconds;
import static sun.audio.AudioPlayer.player;

public class ReplayParser {
    public static Replay parseReplay(String filename) {

        // Grab the info from the replay file and parse it out into an object

        File file = new File(filename);
        hu.belicza.andras.bwhf.model.Replay replay = BinRepParser.parseReplay(file, true, false, true, false);

        String name = file.getName();
        Player[] players = new Player[12];
        Map map = new Map();
        String version = replay.replayHeader.guessVersionFromDate();

        // Populate player models
        PlayerActions[] pas = replay.replayActions.players;
        for (int i = 0; i < pas.length; i++) {
            PlayerActions pa = pas[i];
            Player player = new Player();
            player.setName(pa.playerName);
            player.setRace(Player.Race.of(ReplayHeader.RACE_NAMES[replay.replayHeader.playerRaces[i]]));
            // todo: get color
            player.setColor(Color.GREEN);

            hu.belicza.andras.bwhf.model.Action[] playerActions = pa.actions;
            Action[] actions = new Action[playerActions.length];
            // Get actions for player
            for (int j = 0; j < playerActions.length; j++) {

                hu.belicza.andras.bwhf.model.Action a = playerActions[j];
                // Good god, this uses magic to get the name, if this is not called, name is not set
                a.toString(player.getName(), true);

                // Get time in seconds
                int seconds = convertFramesToSeconds(a.iteration);
                // todo: Get the actionable entities and put them into a params array
                actions[j] = new Action(a.name, a.parameters.split(","), seconds);
            }

            player.setActions(actions);
            players[i] = player;
        }

        return new Replay(name, players, map, version);
    }
}
