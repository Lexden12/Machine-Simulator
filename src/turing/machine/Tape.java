/*
 * Copyright (C) 2018 Alex "Lexden" Schendel <lexden.s@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
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
            if(start == head)
                s = s.concat("|"+start.getElement() + "|, ");
            else
                s = s.concat(start.getElement() + ", ");
            start = start.getNext();
        }
        return s;
    }
}
