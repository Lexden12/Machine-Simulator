/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package turing.machine;

/**
 *
 * @author Alex "Lexden" Schendel
 * @param <E> element to be stored in the linked list
 */
public class DoublyLinkedListElement<E> {
    private E element;
    private DoublyLinkedListElement<E> next, previous;

    public DoublyLinkedListElement(E element) {
        this.element = element;
    }

    public E getElement() {
        return element;
    }

    public DoublyLinkedListElement<E> getNext() {
        return next;
    }

    public DoublyLinkedListElement<E> getPrevious() {
        return previous;
    }

    public void setElement(E element) {
        this.element = element;
    }

    public void setNext(DoublyLinkedListElement<E> next) {
        this.next = next;
    }

    public void setPrevious(DoublyLinkedListElement<E> previous) {
        this.previous = previous;
    }
}
