package model;

import java.util.Arrays;

public class Replay {

    private String name;
    private Player[] players;
    private GameMap gameMap;
    private String version;

    public Replay(String name, Player[] players, GameMap gameMap, String version) {
        this.name = name;
        this.players = players;
        this.gameMap = gameMap;
        this.version = version;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }

    public GameMap getGameMap() {
        return gameMap;
    }

    public void setGameMap(GameMap gameMap) {
        this.gameMap = gameMap;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Players: %s, GameMap: %s, Version: %s", name, Arrays.toString(players), gameMap, version);
    }
}
