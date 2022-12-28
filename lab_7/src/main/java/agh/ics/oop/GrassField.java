package agh.ics.oop;

import java.util.HashMap;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.lang.Math;

public class GrassField extends AbstractWorldMap {
    final private int amountOfGrass;
//    final private List<Grass> grasses;
//    final private List<Animal> animals;
    public GrassField(int n){
        this.amountOfGrass = n;
        grasses = new HashMap<>();
        animals = new HashMap<>();
//        RandomGenerator.setSeed(0x259B7F73);

        int limit = (int) Math.sqrt(n * 10);
        int i = 0;
        while (i < n){
            int x = RandomGenerator.randint(0,limit);
            int y = RandomGenerator.randint(0,limit);
            Vector2d checkVector = new Vector2d(x, y);
            if (!this.isOccupied(checkVector)){
                grasses.put(checkVector, new Grass(checkVector));
                this.mapBoundary.addPosition(checkVector);
                i ++;
            }
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position){
        Object object = this.objectAt(position);
        return object == null || object instanceof Grass;
    }

//    public Vector2d upperRight(){
//        Vector2d high = new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE);
//        for(Animal animal : animals.values()){
//            Vector2d pos = animal.getPosition();
//            high = high.upperRight(pos);
//        }
//
//        for (Grass grass : grasses.values()){
//            Vector2d pos = grass.getPosition();
//            high = high.upperRight(pos);
//        }
//        return new Vector2d(high.x, high.y);
//    }
//    public  Vector2d lowerLeft(){
//        Vector2d low = new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);
//
//        for(Animal animal : animals.values()){
//            Vector2d pos = animal.getPosition();
//            low = low.lowerLeft(pos);
//        }
//
//        for (Grass grass : grasses.values()){
//            Vector2d pos = grass.getPosition();
//            low = low.lowerLeft(pos);
//        }
//        return new Vector2d(low.x, low.y);
//    }
//    @Override
//    public boolean place(Animal animal){
//        if (!isOccupied(animal.getPosition())){
//            animals.add(animal);
//            return true;
//        }
//        else{
//            Object object = objectAt(animal.getPosition());
//            if (object instanceof Grass){
//                for (Grass grass : grasses){
//                    if (grass.getPosition().x == animal.getPosition().x && grass.getPosition().y == animal.getPosition().y) {
//                        grasses.remove(grass);
//                        break;
//                    }
//                }
//                animals.add(animal);
//                return true;
//            }
//        }
//        return false;
//    }

//    @Override
//    public boolean isOccupied(Vector2d position){
//        for (Grass grass: grasses){
//            if (grass.getPosition().equals(position)) return true;
//        }
//
//        for (Animal animal: animals){
//            if (animal.getPosition().equals(position)) return true;
//        }
//        return false;
//    }

    @Override
    public boolean isOccupied(Vector2d position){
        if ( super.isOccupied(position)) {
//            System.out.println("Ok grass" );
            return true;
        }
        for (Grass grass: grasses.values()){
            if (grass.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position){

        if (animals.containsKey(position)){
            return animals.get(position);
        }

        if (grasses.containsKey(position)){
            return grasses.get(position);
        }

        return null;
    }

    public String toString() {
        MapVisualizer visualizer = new MapVisualizer(this);
        Vector2d[] bounds = this.mapBoundary.getBounds();
        return visualizer.draw(bounds[0], bounds[1]);
    }
//    public Object objectAt(Vector2d position){
//
//        for (Animal animal : animals){
//            if (animal.getPosition().equals(position)) return animal;
//        }
//        for (Grass grass : grasses){
//            if (grass.getPosition().equals(position)) return grass;
//        }
//
//        return null;
//    }

//    public String toString(){
//        MapVisualizer visualizer = new MapVisualizer(this);
//
//        Vector2d high = new Vector2d(Integer.MIN_VALUE,Integer.MIN_VALUE);
//        Vector2d low = new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);
//
//        for(Animal animal : this.animals){
//            Vector2d pos = animal.getPosition();
//            high = high.upperRight(pos);
//            low = low.lowerLeft(pos);
//        }
//
//        for (Grass grass : this.grasses){
//            Vector2d pos = grass.getPosition();
//            high = high.upperRight(pos);
//            low = low.lowerLeft(pos);
//        }
//        return visualizer.draw(new Vector2d(low.x, low.y), new Vector2d(high.x, high.y));
//    }
}
