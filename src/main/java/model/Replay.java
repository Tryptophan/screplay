package model;

import java.util.Arrays;

public class Replay {

    private String name;
    private Player[] players;
    private Map map;
    private String version;

    public Replay(String name, Player[] players, Map map, String version) {
        this.name = name;
        this.players = players;
        this.map = map;
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

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Players: %s, Map: %s, Version: %s", name, Arrays.toString(players), map, version);
    }
}
