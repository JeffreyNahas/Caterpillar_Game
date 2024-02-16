package assignment2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyDoublyLinkedList<E> extends MyLinkedList<E> {

    private DNode head;
    private DNode tail;

    public boolean add(E element) {
        DNode newNode = new DNode();
        if (isEmpty()) {
            head= newNode;
        }else{
            tail.next = newNode;
        }
        newNode.element = element;
        newNode.prev= tail;
        tail= newNode;
        size += 1;
        return true;
    }

    public E remove() {
        if (size == 0)
            throw new NoSuchElementException("The List is Empty");
        else if (size == 1) {
            E element = tail.element;
            head = null;
            tail.element = null;
            tail = null;
            size = 0;
            return element;
        } else {
            E element = tail.element;
            tail = tail.prev;
            tail.next.element = null;
            tail.next.prev = null;
            tail.next = null;
            size-= 1;
            return element;
        }
    }
    public boolean addFirst(E element){
        DNode newNode = new DNode();
        boolean operation= false;
        if (isEmpty()) {
            tail= newNode;
        }else{
            head.prev = newNode;
        }
        newNode.element= element;
        newNode.next= head;
        head= newNode;
        size += 1;
        return true;


    }
    public boolean addLast(E element) {
        return add(element);
    }
    public E removeFirst(){
        if(isEmpty()){
            throw new NoSuchElementException("The list is empty");
        }
        E element= head.element;
        if (head!= tail){
            head= head.next;
            head.prev = null;
        }else{
            head= null;
            tail= null;
        }
        size-= 1;
        return element;
    }
    public E removeLast(){
        if(isEmpty()) {
            throw new NoSuchElementException("The list is empty");
        }
        E element= tail.element;
        if (head!= tail){
            tail= tail.prev;
            tail.next = null;
        }else{
            head= null;
            tail= null;
        }
        size-= 1;
        return element;
    }
    public E peekFirst(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return head.element;
    }
    public E peekLast(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return tail.element;
    }
    public void clear(){
        head = null;
        tail = null;
        size= 0;
    }
    public boolean equals(Object object){
        if (!(object instanceof MyDoublyLinkedList)){
           return false;
        }
        MyDoublyLinkedList newObject= (MyDoublyLinkedList) object;
        if (size!= newObject.size){
            return false;
        }
        Iterator <E> iterator1= iterator();
        Iterator <E> iterator2= newObject.iterator();
        while (iterator1.hasNext()){
            if (!iterator1.next().equals(iterator2.next())){
                return false;
            }

        }
        return true;
    }

    public Iterator<E> iterator() {
        return new DLLIterator();
    }
        private class DNode {
        private E element;
        private DNode next;
        private DNode prev;
    }

    private class DLLIterator implements Iterator<E> {
        DNode curr;

        public DLLIterator() {
            this.curr = head;
        }

        public boolean hasNext() {
            return this.curr != null;
        }

        public E next() {
            if (!this.hasNext())
                throw new NoSuchElementException();

            E element = this.curr.element;
            this.curr = this.curr.next;
            return element;
        }
    }
}