package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine{
    private final List<MoveDirection> moves;
    private final IWorldMap map;
    private final List<Animal> animals;

    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] positions){
        this.moves = List.of(moves);
        this.map = map;
        this.animals = new ArrayList<>();

        for(Vector2d position: positions){
            Animal newAnimal = new Animal(this.map, position);
            int i = 0;
            if (this.map.place(newAnimal)) {
                animals.add(newAnimal);
            }

        }
    }
    public String getFrame(){
        return this.map.toString();
    }

    @Override
    public void run(){
//        RandomGenerator.getSeed();
        for(int i = 0; i < moves.size(); i++){
            animals.get(i % animals.size()).move(moves.get(i));
            System.out.println(String.format("Animal %d, move: %s", i % animals.size(), moves.get(i).toString()));
            System.out.println(map.toString());
        }
    }


}
