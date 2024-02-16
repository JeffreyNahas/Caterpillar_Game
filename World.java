package assignment2;

public class World {
    private Caterpillar caterpillar;
    private Position food_pos;
    private Region map_2D;
    private ActionQueue list_actions;
    private TargetQueue list_food;
    private GameState curr_state;

    public World(TargetQueue list_food, ActionQueue list_actions){
        caterpillar= new Caterpillar();
        food_pos=list_food.dequeue();
        map_2D= new Region(0,0,15,15);
        this.list_actions= list_actions ;
        this.list_food= list_food;
        curr_state= GameState.MOVE;
    }
    public void step() {
        if (list_actions.isEmpty()) {
            curr_state=GameState.NO_MORE_ACTION;
        }
        if (curr_state != GameState.MOVE && curr_state != GameState.EAT) {
            return;
        }
        Position head= new Position(caterpillar.getHead());
        Direction dir=list_actions.dequeue();
        if (dir==Direction.NORTH){
            head.moveNorth();
        }else if (dir==Direction.SOUTH){
            head.moveSouth();
        }else if (dir==Direction.WEST){
            head.moveWest();
        }else if (dir==Direction.EAST){
            head.moveEast();
        }
        Position nextHead = new Position(head);
        if (!(map_2D.contains(nextHead))){
            curr_state=GameState.WALL_COLLISION;
        }else if (caterpillar.selfCollision(nextHead)){
            curr_state=GameState.SELF_COLLISION;
        }else if (list_food.isEmpty() && food_pos==null){
            curr_state=GameState.DONE;
        }else if (nextHead.getX()== food_pos.getX() && nextHead.getY()==food_pos.getY()){
            //foodList.dequeue();
            caterpillar.eat(nextHead);
            curr_state=GameState.EAT;
        }else{
            curr_state=GameState.MOVE;
            caterpillar.move(nextHead);
        }

    }
    public GameState getState() {
        return this.curr_state;
    }
    public Caterpillar getCaterpillar(){
        return this.caterpillar;
    }
    public Position getFood(){
        return food_pos;
    }
    public boolean isRunning(){
        if (getState()==GameState.MOVE || getState()==GameState.EAT ){
            return true;
        }
        return false;
    }
}

