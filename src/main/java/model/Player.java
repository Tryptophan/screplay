package model;

import java.awt.*;
import java.util.Arrays;

public class Player {

    public enum Race {
        TERRAN("Terran"),
        ZERG("Zerg"),
        PROTOSS("Protoss");

        private final String name;
        Race(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
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
    }

    private String name;
    private Race race;
    private Action[] actions;
    private Color color;

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

    @Override
    public String toString() {
        return String.format("Name: %s, Race: %s, Color: %s", name, race.name, color);
    }
}
