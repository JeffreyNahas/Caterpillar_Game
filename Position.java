package Caterpillar_Game;

public class Position {
    private int xcoord;
    private int ycoord;
    public Position(int xcoord, int ycoord){
        this.xcoord= xcoord;
        this.ycoord= ycoord;
    }
    public Position(Position position){
        this.xcoord = position.xcoord;
        this.ycoord= position.ycoord;

    }
    public void reset(int xcoord, int ycoord){
        this.xcoord= xcoord;
        this.ycoord= ycoord;
    }
    public void reset(Position position){
        this.xcoord= position.xcoord;
        this.ycoord= position.ycoord;
    }
    public int getDistance( Position position2){
        return(Math.abs(xcoord- position2.xcoord) + Math.abs(ycoord- position2.ycoord));
    }
    public int getX(){
       return this.xcoord ;
    }
    public int getY(){
        return this.ycoord ;
    }
    public void moveWest(){
        this.xcoord--;
    }
    public void moveEast(){
        this.xcoord++;
    }
    public void moveNorth(){
        this.ycoord--;
    }
    public void moveSouth(){
        this.ycoord++;
    }
    public boolean equals(Object object){
        if (object instanceof Position){
            if (((Position) object).xcoord == xcoord ||((Position) object).ycoord == ycoord){
                return true;
            }
            return false;
        }
        return false;
    }


}
