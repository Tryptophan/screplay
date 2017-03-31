package hu.belicza.andras.bwhf.model;

import model.Map;

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
     * Map tile data: width x height elements.
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

    public static Map.Location[] getLocationArrayFromList(List<short[]> list) {
        Map.Location[] locations = new Map.Location[list.size()];

        for (int i = 0; i < locations.length; i++) {

            short[] loc = (short[]) list.toArray()[i];
            locations[i] = new Map.Location((int) loc[0], (int) loc[1]);
        }

        return locations;
    }

    public static Map.Location[] getLocationArrayFromIntList(List<int[]> list) {
        Map.Location[] locations = new Map.Location[list.size()];

        for (int i = 0; i < locations.length; i++) {

            int[] loc = (int[]) list.toArray()[i];
            locations[i] = new Map.Location(loc[0], loc[1]);
        }

        return locations;
    }
}
