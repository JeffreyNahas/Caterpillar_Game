package assignment2;

public class Region {
    private int min_x;
    private int min_y;
    private int max_x;
    private int max_y;
    public Region(int min_x,int min_y, int max_x, int max_y){
        this.max_x = max_x;
        this.min_x = min_x;
        this.max_y = max_y;
        this.min_y = min_y;
    }
    public boolean contains (Position position){
        return(position.getX()>=min_x && position.getX()<= max_x && position.getY()>=min_y && position.getY()<=max_y);
    }
}
