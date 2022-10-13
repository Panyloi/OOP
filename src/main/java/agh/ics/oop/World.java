package agh.isc.oop;
import static java.lang.System.out;

public class World {
    public static void main(String[] args) {
//        out.println("System wystartował!");
        out.println("Start");
        run(args);
        out.println("Stop");
//        out.println("System zakończył zadanie!");
    }

    public static void run(String[] args){
//        out.println("Zwierzak idzie do przodu!");
        for (int i=0; i<args.length; i++)
        {
//            out.print(args[i] + ",");
            switch (args[i]) {
                case "f":
                    out.println("Zwierzak idzie do przodu");
                    break;
                case "b":
                    out.println("Zwierzak idzie do tyłu");
                    break;
                case "r":
                    out.println("Zwierzak skręca w prawo");
                    break;
                case "l":
                    out.println("Zwierzak skęca w lewo");
                    break;
                default:
                    break;
            }
        }
//        for (int i=0; i<args.length-1; i++)
//        {
//            out.print(args[i] + ",");
//        }
//        out.println( args[args.length - 1] );
    }
}
