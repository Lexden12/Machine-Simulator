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
