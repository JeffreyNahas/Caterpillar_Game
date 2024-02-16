package Caterpillar_Game;

public class Caterpillar extends MyDoublyLinkedList <Position> {
    public Caterpillar(){
        Position pos_initial = new Position(7,7);
        add(pos_initial);
    }
    public Position getHead(){
        return peekFirst();
    }

    public void eat(Position position){
        Position head = this.getHead();
        if (Math.abs(position.getX() - head.getX()) + Math.abs(position.getY() - head.getY()) != 1){
            throw new IllegalArgumentException("the input position is not orthogonally adjacent to the current head position");
        }else{
            addFirst(position);
        }
    }

    public void move(Position position){
        Position head = this.getHead();
        if(Math.abs(position.getX() - head.getX()) + Math.abs(position.getY() - head.getY()) != 1){
            throw new IllegalArgumentException("It is not adjacent to the current head position");
        }
        this.addFirst(position);
        this.removeLast();
    }

    public boolean selfCollision(Position pos){
        for (int i=0; i<getSize(); i++){
            Position pos2=peekFirst();
            removeFirst();
            if (pos2.getX()==pos.getX() && pos2.getY()==pos.getY()){
                return true;
            }
            addLast(pos2);
        }
        return false;
    }
}



