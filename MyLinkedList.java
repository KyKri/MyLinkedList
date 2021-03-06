package mylinkedlist;

public class MyLinkedList<E> {
    /**
     * Node subclass of MyLinkedList that stores a pointer to another node and some
     * generic datatype E
     * 
     * @param <E> Generic datatype that indicates what the node's data property will
     *            store
     */
    class Node<E> {
        E data;
        Node<E> next;

        /**
         * Constructs a new node
         * 
         * @param obj Generic object that the node will store
         */
        public Node(E obj) {
            data = obj;
            next = null;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int currentSize;

    /**
     * MyLinkedList constructor
     */
    public MyLinkedList() {
        head = tail = null;
        currentSize = 0;
    }

    /**
     * Adds the specified object to the beginning of the linked list and increments
     * the currentSize by 1.
     * <p>
     * Time complexity analysis: O(1)
     * 
     * @param obj
     */
    public void addFirst(E obj) {
        Node<E> node = new Node<E>(obj);
        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head = node;
        }
        currentSize++;
    }

    /**
     * Adds the specified object to the end of the linked list and increments the
     * currentSize by 1. Time complexity analysis: O(1)
     * 
     * @param obj
     */
    public void addLast(E obj) {
        Node<E> node = new Node<E>(obj);

        if (head == null) {
            head = tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
        currentSize++;
    }

    /**
     * Removes the first element in the linked list and decrements the currentSize
     * by 1. Time complexity analysis: O(1)
     * 
     * @return The first element in the linked list, or null if the linked list is
     *         empty
     */
    public E removeFirst() {
        // make sure linked list isn't empty
        if (head == null) {
            return null;
        }

        // declare after head is checked for null so that temp can never be null
        E temp = head.data;

        // update the tail if last element is being remove
        if (head.next == null) {
            head = tail = null;
        } else {
            head = head.next;
        }
        currentSize--;
        return temp;
    }

    /**
     * Removes and returns the element at the end of the linked list if the list is
     * not empty. Otherwise returns null if the list is empty. Time complexity
     * analysis: O(n)
     * 
     * @return
     */
    public E removeLast() {
        // check for empty linked list
        if (head == null) {
            return null;
        }
        // we've already written code to handle single element removes, so re-use it
        if (head == tail) {
            return removeFirst();
        }

        Node<E> previous = null, current = head;

        // move down the list to the last element
        while (current != tail) {
            previous = current;
            current = current.next;
        }

        tail = previous;
        tail.next = null;
        currentSize--;
        return current.data;
    }

    /**
     * Removes and returns the specified element from the linked list if it is in
     * the linked list and decrements the current size by 1. Otherwise returns null
     * if the list is empty or element not in list. Time complexity analysis: O(n)
     * 
     * @param obj Element to remove
     * @return Specified element or null if the element is not in the linked list
     */
    public E remove(E obj) {
        Node<E> previous = null, current = head;

        while (current != null) {
            if (((Comparable<E>) current.data).compareTo(obj) == 0) {
                // Re-used code for single item and first item removal
                if (current == head) {
                    return removeFirst();
                }
                // Re-used code for returning last item
                if (current == tail) {
                    return removeLast();
                }
                previous.next = current.next;
                currentSize--;
                return current.data;
            }
            previous = current;
            current = current.next;
        }

        // Specified element was not found in the linked list
        return null;
    }

    /**
     * Returns true if the specified element is in the list. Returns false otherwise.
     * Time complexity analysis: O(n)
     * 
     * @param E Object to try to find
     * @return  Returns true if object is found, false otherwise
     */
    public boolean find(E obj) {
        Node<E> current = head;

        // Iterate down the list and look for the element
        while (current != null) {
            if (((Comparable<E>) current.data).compareTo(obj) == 0) {
                return true;
            }
            current = current.next;
        }

        // Specified element was not found in the linked list
        return false;
    }

    /**
     * Returns the first element in the list, or null if the list is empty.
     * Time complexity analysis: O(1)
     * 
     * @return  Returns first element, or null if list is empty.
     */
    public E peekFirst() {
        if (head == null) {
            return null;
        }
        return head.data;
    }

    /**
     * Returns the last element in the list, or null if the list is empty.
     * Time complexity analysis: O(1)
     * 
     * @return  Returns last element, or null if list is empty.
     */
    public E peekLast() {
        if (tail == null) {
            return null;
        }
        return tail.data;
    }

    /**
     * Returns the currentSize of the linked list. Time complexity analysis: O(1)
     * 
     * @return The currentSize
     */
    public int getCurrentSize() {
        return currentSize;
    }
}