package agh.ics.oop;
import java.util.Objects;

public class Vector2d {
    public final int x;
    public final int y;

    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString(){
        String result;
        result = ("(" + Integer.toString(this.x) + "," + Integer.toString(this.y) + ")");
        return result;
    }

    public boolean precedes(Vector2d other){
        if ((this.x <= other.x) && (this.y <= other.y)){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean follows(Vector2d other){
        if((this.x >= other.x) && (this.y >= other.y)){
            return true;
        }
        else{
            return false;
        }
    }

    public Vector2d add(Vector2d other){
        Vector2d newVector = new Vector2d(this.x + other.x, this.y + other.y);
        return newVector;
    }

    public Vector2d subtract(Vector2d other){
        Vector2d newVector = new Vector2d(this.x - other.x, this.y - other.y);
        return newVector;
    }

    public Vector2d upperRight(Vector2d other){
        int x1;
        int y1;

        if (this.x >= other.x){
            x1 = this.x;
        }
        else{
            x1 = other.x;
        }

        if (this.y >= other.y){
            y1 = this.y;
        }
        else{
            y1 = other.y;
        }

        return new Vector2d(x1, y1);
    }

    public Vector2d lowerLeft(Vector2d other){
        int x1;
        int y1;

        if (this.x <= other.x){
            x1 = this.x;
        }
        else{
            x1 = other.x;
        }

        if (this.y <= other.y){
            y1 = this.y;
        }
        else{
            y1 = other.y;
        }

        return new Vector2d(x1, y1);
    }

    public Vector2d opposite(){
        return new Vector2d(this.x * (-1), this.y * (-1));
    }
    @Override
    public boolean equals(Object other){
        if(this == other) return true;
        if (other == null) return false;
        if (this.getClass() != other.getClass()) return false;

        Vector2d vector = (Vector2d) other;
        return (this.x == vector.x) & (this.y == vector.y);
    }
    @Override
    public int hashCode(){
        return Objects.hash(this.x, this.y);
    }

    public static void main(String[] args){
        MapDirection v = MapDirection.EAST;
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
    }
}
