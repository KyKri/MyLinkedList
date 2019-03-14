package mylinkedlist;

import mylinkedlist.MyLinkedList;

class LinkedListTester {
    
    public static void main (String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<Integer>();

        list.addLast(new Integer(1));
        System.out.println(list.getCurrentSize());
        list.removeFirst();

        System.out.println(list.getCurrentSize());
    }
}