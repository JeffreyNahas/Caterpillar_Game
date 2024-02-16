package Caterpillar_Game;

import java.util.NoSuchElementException;

public class MyStack<E> {
    private MyDoublyLinkedList<E> list;
    public MyStack(){
        list= new MyDoublyLinkedList<>();

    }
    public boolean push(E element){
        return list.addLast(element);
    }
    public E pop(){
        if (list.isEmpty()){
            throw new NoSuchElementException("The stack is empty");
        }
        return list.removeLast();
    }
    public E peek(){
        if (list.isEmpty()){
            throw new NoSuchElementException("The stack is empty");
        }
        return list.peekLast();
    }
    public boolean isEmpty(){
        return list.isEmpty();
    }
    public void clear(){
        list.clear();
    }
    public int getSize(){
        return list.getSize();
    }
}
