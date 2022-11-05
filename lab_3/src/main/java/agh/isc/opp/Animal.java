package agh.isc.opp;

public class Animal {
    private Vector2d position = new Vector2d(2, 2);
    private MapDirection orientation = MapDirection.NORTH;

    public String toString(){
        String position_str, orientation_str;
        position_str = ("pozycja: (" + this.position.x + "," + this.position.y + ") , orientacja: ");
        orientation_str = orientation.toString();
        return (position_str + orientation_str);
    }

    public boolean isAt(Vector2d position){
        if ( (this.position.x == position.x)  & (this.position.y == position.y)) return true;
        else return false;
    }

    public void move(MoveDirection direction){
//        int x1 = this.position.x;
//        int y1 = this.position.y;
        switch (direction){
            case RIGHT:
                this.orientation = this.orientation.next();
                break;

            case LEFT:
                this.orientation = this.orientation.previous();
                break;

            case FORWARD:
                switch (orientation){
                    case NORTH:
                        if (this.position.y < 4) this.position = new Vector2d(this.position.x, this.position.y + 1);
                        break;
                    case EAST:
                        if (this.position.x < 4) this.position = new Vector2d(this.position.x+ 1, this.position.y);
                        break;
                    case SOUTH:
                        if (this.position.y > 0) this.position = new Vector2d(this.position.x, this.position.y - 1);
                        break;
                    case WEST:
                        if (this.position.x > 0) this.position = new Vector2d(this.position.x - 1, this.position.y);
                        break;
                }
                break;

            case BACKWARD:
                switch (orientation){
                    case NORTH:
                        if (this.position.y > 0) this.position = new Vector2d(this.position.x, this.position.y - 1);
                        break;
                    case EAST:
                        if (this.position.x > 0) this.position = new Vector2d(this.position.x - 1, this.position.y);
                        break;
                    case SOUTH:
                        if (this.position.y < 4) this.position = new Vector2d(this.position.x, this.position.y + 1);
                        break;
                    case WEST:
                        if (this.position.x < 4) this.position = new Vector2d(this.position.x + 1, this.position.y);
                        break;
                }
                break;
        }

    }
}
