package assignment2;
import java.util.NoSuchElementException;
public class MyQueue<E>{
    private MyDoublyLinkedList list;
    public MyQueue(){
        list= new MyDoublyLinkedList<>();
    }
    public boolean enqueue(E element){
        return list.addLast(element);
    }
    public E dequeue(){
        if(list.isEmpty()){
            throw new NoSuchElementException("The queue is empty");
        }
        return (E) list.removeFirst();
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
    public void clear(){
        list.clear();
    }
    public boolean equals(Object object){
        if (object instanceof MyQueue){
            MyQueue newObject= (MyQueue) object;
            list.equals(object);
        }
        return true;

    }
}
