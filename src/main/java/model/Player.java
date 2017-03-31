package model;

import java.awt.*;

public class Player {

    private String name;
    private Race race;
    private Action[] actions;
    private Color color;
    private int apm;

    public Player(String name, Race race, Action[] actions, Color color, int apm) {
        this.name = name;
        this.race = race;
        this.actions = actions;
        this.color = color;
        this.apm = apm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Action[] getActions() {
        return actions;
    }

    public void setActions(Action[] actions) {
        this.actions = actions;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getApm() {
        return apm;
    }

    public void setApm(int apm) {
        this.apm = apm;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Race: %s, Color: %s, APM: %s", name, race.name, color, apm);
    }

    public enum Race {
        TERRAN("Terran"),
        ZERG("Zerg"),
        PROTOSS("Protoss");

        private final String name;

        Race(String name) {
            this.name = name;
        }

        public static Race of(String string) {
            switch (string) {
                case "Terran":
                    return TERRAN;
                case "Zerg":
                    return ZERG;
                case "Protoss":
                    return PROTOSS;
                default:
                    return null;
            }
        }

        public String getName() {
            return name;
        }
    }
}
