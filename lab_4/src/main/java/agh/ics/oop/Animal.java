package agh.ics.oop;

public class Animal {
    private IWorldMap map;
    private MapDirection orientation;
    private Vector2d position ;

    public Animal() {
        this(new RectangularMap(5, 5));
    }
    public Animal(IWorldMap map) {
//        this.map = map;
        this(map, new Vector2d(2, 2));
    }

    public Animal(IWorldMap map, Vector2d initialPosition) {
        this.map = map;
        this.position = initialPosition;
        this.orientation = MapDirection.NORTH;
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

        if (map.canMoveTo(newPosition)){
            this.position = newPosition;
        }
    }
}


