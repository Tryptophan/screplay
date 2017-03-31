package model;

import java.util.Arrays;

/**
 * Stores the type of the action, what it performs the action on, and the time they were performed
 */
public class Action {
    private Type type;
    private String[] params;
    private int seconds;

    public Action(final Type type, final String[] params, final int seconds) {
        this.type = type;
        this.params = params;
        this.seconds = seconds;
    }

    public Type getType() {
        return type;
    }

    public String[] getParams() {
        return params;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setParams(String[] params) {
        this.params = params;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Params: %s, Executed at: %s", type, Arrays.toString(params), seconds);
    }

    public enum Type {
        BUILD,
        TRAIN;

        public static Type of(String string) {
            switch (string) {
                case "Build":
                    return BUILD;
                case "Train":
                    return TRAIN;
                default:
                    return null;
            }
        }
    }
}
