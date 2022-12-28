package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class Animal {
    private IWorldMap map;
    private MapDirection orientation;
    private Vector2d position ;
    private List<IPositionChangeObserver> observers;

    public Animal() {
        this(new RectangularMap(5, 5));
    }
    public Animal(IWorldMap map) {
//        this.map = map;
        this(map, new Vector2d(2, 2));
        this.observers = new ArrayList<>();
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.position = initialPosition;
        this.orientation = MapDirection.NORTH;
        this.observers = new ArrayList<>();
    }

    public String toString() {
        return switch (this.orientation) {
            case NORTH -> "N";
            case EAST -> "E";
            case SOUTH -> "S";
            case WEST -> "W";
        };
    }

    public boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }

    public Vector2d getPosition(){
        return this.position;
    }

    public MapDirection getOrientation(){
        return this.orientation;
    }

    public void move(MoveDirection direction) {

        Vector2d newPosition = position;

        switch (direction) {
            case RIGHT -> this.orientation = this.orientation.next();
            case LEFT -> this.orientation = this.orientation.previous();
            case FORWARD -> newPosition = this.position.add(orientation.toUnitVector());
            case BACKWARD -> newPosition = this.position.subtract(orientation.toUnitVector());
        }

        if (this.map.canMoveTo(newPosition)){
            this.positionChanged(newPosition);
            this.position = newPosition;

        }
    }

    public void addObserver(IPositionChangeObserver observer){
        observers.add(observer);

    }
    public void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }

    public void positionChanged(Vector2d newPosition){
        for(IPositionChangeObserver observer : observers){
            observer.positionChanged(getPosition(), newPosition);
        }
    }
}


