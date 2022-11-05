package agh.isc.opp;
import static java.lang.System.out;
public class World {
    public static void main(String[] args){
        Animal animal1 = new Animal();
        OptionsParser check_arr = new OptionsParser();
        MoveDirection[] directions = check_arr.parser(args);

        for(int i = 0; i<directions.length; i++){
            animal1.move(directions[i]);
        }

        out.println(animal1.toString());
    }
}
