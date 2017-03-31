package hu.belicza.andras.bwhf.model;

import model.GameMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Class modeling some data about the map.
 *
 * @author Belicza Andras
 */
public class MapData {

    /**
     * Defines the tile set of the map.
     */
    public short tileSet = -1;

    /**
     * GameMap tile data: width x height elements.
     */
    public short[] tiles;

    /**
     * Mineral positions on the map, {x,y} pixel coordinates.
     */
    public List<short[]> mineralFieldList = new ArrayList<short[]>();

    /**
     * Vespene geyser positions on the map, {x,y} pixel coordinates.
     */
    public List<short[]> geyserList = new ArrayList<short[]>();

    /**
     * Start locations on the map, {owner,x,y} pixel coordinates.
     */
    public List<int[]> startLocationList = new ArrayList<int[]>();

    public static GameMap.Location[] getLocationArrayFromList(int width, int height, List<short[]> list) {
        GameMap.Location[] locations = new GameMap.Location[list.size()];

        for (int i = 0; i < locations.length; i++) {

            short[] loc = (short[]) list.toArray()[i];
            locations[i] = new GameMap.Location(scaledPosition(loc[0], width), scaledPosition(loc[1], height));
        }

        return locations;
    }

    public static GameMap.Location[] getLocationArrayFromIntList(int width, int height, List<int[]> list) {
        GameMap.Location[] locations = new GameMap.Location[list.size()];

        for (int i = 0; i < locations.length; i++) {

            int[] loc = (int[]) list.toArray()[i];
            locations[i] = new GameMap.Location(scaledPosition(loc[0], width), scaledPosition(loc[1], height));
        }

        return locations;
    }

    private static int scaledPosition(int pos, int max) {
        return pos / max;
    }
}
