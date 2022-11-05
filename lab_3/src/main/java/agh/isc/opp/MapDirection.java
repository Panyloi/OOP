package agh.isc.opp;

import java.util.Map;

public enum MapDirection {
    NORTH,
    SOUTH,
    WEST,
    EAST,
    ERROR;

    public String toString(){
        switch (this){
            case EAST: return "wschód";
            case WEST: return "zachód";
            case NORTH: return "północ";
            case SOUTH: return "południe";
            default: return "Kierunek nieznany!";
        }
    }

    public MapDirection next(){
        switch (this){
            case NORTH: return EAST;
            case EAST: return SOUTH;
            case SOUTH: return WEST;
            case WEST: return NORTH;
            default: return ERROR;
        }
    }

    public MapDirection previous(){
        switch (this){
            case NORTH: return WEST;
            case WEST: return SOUTH;
            case SOUTH: return EAST;
            case EAST: return NORTH;
            default: return ERROR;
        }
    }

    public Vector2d toUnitVector(){
        switch (this){
            case NORTH: return new Vector2d(0, 1);
            case EAST: return new Vector2d(1, 0);
            case SOUTH: return new Vector2d(0, -1);
            case WEST: return new Vector2d(-1, 0);
            default: return new Vector2d(0,0);
        }
    }
}
