package model.parser;

import hu.belicza.andras.bwhf.control.BinRepParser;
import hu.belicza.andras.bwhf.model.MapData;
import hu.belicza.andras.bwhf.model.PlayerActions;
import hu.belicza.andras.bwhf.model.ReplayHeader;
import model.Action;
import model.GameMap;
import model.Player;
import model.Replay;

import java.awt.*;
import java.io.File;

import static hu.belicza.andras.bwhf.model.ReplayHeader.convertFramesToSeconds;

public class ReplayParser {

    static Color getColorFromString(String string) {
        switch (string) {
            case "red":
                return Color.RED;
            case "blue":
                return Color.BLUE;
            case "teal":
                return new Color(0, 128, 128);
            case "purple":
                return new Color(128, 0, 128);
            case "orange":
                return Color.ORANGE;
            case "brown":
                return new Color(165, 42, 42);
            case "yellow":
                return Color.YELLOW;
            case "green":
                return Color.GREEN;
            case "pale yellow":
                return new Color(255, 255, 120);
            case "tan":
                return new Color(210, 180, 140);
            case "aqua":
                return new Color(127, 255, 212);
            case "pale green":
                return new Color(152, 251, 152);
            case "blueish gray":
                return new Color(156, 156, 168);
            case "cyan":
                return Color.CYAN;
            case "white":
            default:
                return Color.WHITE;
        }
    }

    public static Replay parseReplay(String filename) {

        // Grab the info from the replay file and parse it out into an object

        File file = new File(filename);
        hu.belicza.andras.bwhf.model.Replay replay = BinRepParser.parseReplay(file, true, true, true, true);

        String name = file.getName();
        Player[] players = new Player[12];

        String version = replay.replayHeader.guessVersionFromDate();

        // Populate player models
        PlayerActions[] pas = replay.replayActions.players;
        for (int i = 0; i < pas.length; i++) {
            PlayerActions pa = pas[i];
            String playerName = pa.playerName;
            int apm = replay.replayHeader.getPlayerApm(i);
            Player.Race playerRace = Player.Race.of(ReplayHeader.RACE_NAMES[replay.replayHeader.playerRaces[i]]);
            Color playerColor = getColorFromString(ReplayHeader.IN_GAME_COLOR_NAMES[replay.replayHeader.playerColors[i]]);
            hu.belicza.andras.bwhf.model.Action[] playerActions = pa.actions;
            Action[] actions = new Action[playerActions.length];
            // Get actions for player
            for (int j = 0; j < playerActions.length; j++) {

                hu.belicza.andras.bwhf.model.Action a = playerActions[j];
                // Good god, this uses magic to get the name, if this is not called, name is not set
                //noinspection ResultOfMethodCallIgnored
                a.toString(pa.playerName, true);

                // Get time in seconds
                int seconds = convertFramesToSeconds(a.iteration);
                System.out.println(a.name);
                actions[j] = new Action(Action.Type.of(a.name), a.parameters.split(","), seconds);
            }

            players[i] = new Player(playerName, playerRace, actions, playerColor, apm);
        }

        int width = replay.mapData.tiles[0];
        int height = replay.mapData.tiles[1];

        // Get locations of objects on the gameMap
        GameMap.Location[] minerals = MapData.getLocationArrayFromList(width / 8, height / 8, replay.mapData.mineralFieldList);
        GameMap.Location[] geysers = MapData.getLocationArrayFromList(width / 8, height / 8, replay.mapData.geyserList);
        GameMap.Location[] starts = MapData.getLocationArrayFromIntList(width / 8, height / 8, replay.mapData.startLocationList);

        GameMap gameMap = new GameMap(replay.replayHeader.mapName, width, height, replay.mapData.tileSet, geysers, minerals, starts);

        return new Replay(name, players, gameMap, version);
    }
}
