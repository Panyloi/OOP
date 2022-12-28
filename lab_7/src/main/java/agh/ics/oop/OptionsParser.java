package agh.ics.oop;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OptionsParser {
    public static MoveDirection[] parse (String args[]){

        List<MoveDirection> newDirections = new ArrayList<>();
        for (String direct : args) {
            switch (direct) {
                case "f", "forward" -> newDirections.add(MoveDirection.FORWARD);
                case "b", "backward" -> newDirections.add(MoveDirection.BACKWARD);
                case "r", "right" -> newDirections.add(MoveDirection.RIGHT);
                case "l", "left" -> newDirections.add(MoveDirection.LEFT);
                default -> throw new IllegalArgumentException(direct + " is not legal move specification");
            }
        }
        MoveDirection[] newDirectionsArray = new MoveDirection[newDirections.size()];
        newDirections.toArray(newDirectionsArray);
        return newDirectionsArray;
    }
}
