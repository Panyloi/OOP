package agh.isc.oop;
import agh.ics.oop.Direction;

import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
        out.println("Start");
        Direction[] directions = new Direction[args.length];
        for(int i = 0; i< args.length; i++){
            switch (args[i]) {
                case "f":
                    directions[i] = Direction.FORWARD;
                    break;
                case "b":
                    directions[i] = Direction.BACKWARD;
                    break;
                case "r":
                    directions[i] = Direction.RIGHT;
                    break;
                case "l":
                    directions[i] = Direction.LEFT;
                    break;
            }
        }
        run(directions);
        out.println("Stop");
    }

    public static void run(Direction[] directions){
        for (int i=0; i< directions.length; i++)
        {
            switch (directions[i]) {
                case FORWARD:
                    out.println("Zwierzak idzie do przodu");
                    break;
                case BACKWARD:
                    out.println("Zwierzak idzie do tyłu");
                    break;
                case RIGHT:
                    out.println("Zwierzak skręca w prawo");
                    break;
                case LEFT:
                    out.println("Zwierzak skęca w lewo");
                    break;
            }
        }
    }
}
