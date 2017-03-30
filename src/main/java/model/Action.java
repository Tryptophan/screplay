package model;

import java.util.Arrays;

/**
 * Stores the name of the action, what it performs the action on, and the time they were performed
 */
public class Action {
    private String name;
    // todo: refactor out to object that can hold details on param
    private String[] params;
    private int seconds;

    public Action(final String name, final String[] params, final int seconds) {
        this.name = name;
        this.params = params;
        this.seconds = seconds;
    }

    public String getName() {
        return name;
    }

    public String[] getParams() {
        return params;
    }

    public int getSeconds() {
        return seconds;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParams(String[] params) {
        this.params = params;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Params: %s, Executed at: %s", name, Arrays.toString(params), seconds);
    }
}
