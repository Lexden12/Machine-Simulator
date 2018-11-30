/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package turing.machine;

/**
 *
 * @author Alex "Lexden" Schendel
 */
public class Tape {
    private DoublyLinkedListElement<Character> head;
    
    public Tape(String in){
        char[] chars = in.toCharArray();
        head = new DoublyLinkedListElement<>(chars[0]);
        DoublyLinkedListElement prev = head;
        for(int i = 1; i < chars.length; i++){
            DoublyLinkedListElement e = new DoublyLinkedListElement<>(chars[i]);
            prev.setNext(e);
            e.setPrevious(prev);
            prev = e;
        }
        
    }

    public DoublyLinkedListElement<Character> getHead() {
        return head;
    }
    
    public DoublyLinkedListElement<Character> moveLeft(){
        if(head.getPrevious() == null){
            DoublyLinkedListElement e = new DoublyLinkedListElement<>('_');
            head.setPrevious(e);
            e.setNext(head);
        }
        head = head.getPrevious();
        return head;
    }
    
    public DoublyLinkedListElement<Character> moveRight(){
        if(head.getNext() == null){
            DoublyLinkedListElement e = new DoublyLinkedListElement<>('_');
            head.setNext(e);
            e.setPrevious(head);
        }
        head = head.getNext();
        return head;
    }
    
    public void writeCharacter(char c){
        head.setElement(c);
    }
    
    @Override
    public String toString(){
        DoublyLinkedListElement<Character> start = head;
        DoublyLinkedListElement<Character> prev = start.getPrevious();
        while(prev != null){
            start = prev;
            prev = start.getPrevious();
        }
        String s = "";
        while(start != null){
            s = s.concat(start.getElement() + ", ");
            start = start.getNext();
        }
        return s;
    }
}
