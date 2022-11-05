package agh.isc.opp;


import java.util.Arrays;

public class OptionsParser {
    public MoveDirection[] parser (String args[]){

        MoveDirection[] directions = new MoveDirection[args.length];
        for(int i = 0; i< args.length; i++){
            switch (args[i]) {
                case "b", "backward":
                    directions[i] = MoveDirection.BACKWARD;
                    break;
                case "f", "forward":
                    directions[i] = MoveDirection.FORWARD;
                    break;
                case "r", "right":
                    directions[i] = MoveDirection.RIGHT;
                    break;
                case "l", "left":
                    directions[i] = MoveDirection.LEFT;
                    break;
                default:
                    directions = Arrays.copyOf(directions, directions.length - 1);
            }
        }
        return directions;
    }
}
