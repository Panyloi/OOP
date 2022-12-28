package agh.ics.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimulationEngine implements IEngine, Runnable{
    private List<MoveDirection> moves;
    private IWorldMap map;
    private List<Animal> animals;
    private int stepNumber;
    private List<IStepObserver> observers;
    public SimulationEngine(AbstractWorldMap map, Vector2d[] positions) {
        this(new MoveDirection[] {}, map, positions);
    }
    public SimulationEngine(MoveDirection[] moves, IWorldMap map, Vector2d[] positions){
        this.moves = List.of(moves);
        this.map = map;
        this.animals = new ArrayList<>();
        this.observers = new ArrayList<>();
        this.stepNumber = 0;

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
            this.nextStep();
        }
    }
    public void nextStep() {
        if (stepNumber >= moves.size())
            return;
        animals.get(stepNumber % animals.size()).move(moves.get(stepNumber));

        System.out.println(String.format("Animal %d, move: %s", stepNumber % animals.size(), moves.get(stepNumber).toString()));
        System.out.println(map.toString());
        stepNumber++;

        for (var observer : observers)
            observer.onStep();
    }
    public void setDirections(MoveDirection[] directions) {
        this.moves = List.of(directions);
    }

    public void addObserver(IStepObserver observer) {
        observers.add(observer);
    }
}
