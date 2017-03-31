package model;

public class GameMap {
    private String name;
    private int width;
    private int height;
    // todo: reverse engineer this to make an enum for tilesets
    private int tileset;
    private Location[] vespeneGeyserLocations;
    private Location[] mineralFieldLocations;
    private Location[] startLocations;

    public GameMap(String name, int width, int height, int tileset, Location[] vespeneGeyserLocations, Location[] mineralFieldLocations, Location[] startLocations) {
        this.name = name;
        this.width = width;
        this.height = height;
        this.tileset = tileset;
        this.vespeneGeyserLocations = vespeneGeyserLocations;
        this.mineralFieldLocations = mineralFieldLocations;
        this.startLocations = startLocations;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getTileset() {
        return tileset;
    }

    public void setTileset(int tileset) {
        this.tileset = tileset;
    }

    public Location[] getVespeneGeyserLocations() {
        return vespeneGeyserLocations;
    }

    public void setVespeneGeyserLocations(Location[] vespeneGeyserLocations) {
        this.vespeneGeyserLocations = vespeneGeyserLocations;
    }

    public Location[] getMineralFieldLocations() {
        return mineralFieldLocations;
    }

    public void setMineralFieldLocations(Location[] mineralFieldLocations) {
        this.mineralFieldLocations = mineralFieldLocations;
    }

    public Location[] getStartLocations() {
        return startLocations;
    }

    public void setStartLocations(Location[] startLocations) {
        this.startLocations = startLocations;
    }

    @Override
    public String toString() {
        return String.format("Name: %s, Size: %s x %s, Tileset: %s", name, width, height, tileset);
    }

    public static class Location {
        private int x;
        private int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        @Override
        public String toString() {
            return String.format("(%s, %s)", x, y);
        }
    }
}
