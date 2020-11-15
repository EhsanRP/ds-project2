package ir.ac.pgu.lms;

import ir.ac.pgu.lms.dataStructures.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(false);

        linkedList.insertRec(3);
        linkedList.insertRec(10);
        linkedList.insertRec(2);
        linkedList.insertRec(5);
        linkedList.insertRec(6);
        linkedList.insertRec(4);
        linkedList.insertRec(9);
        linkedList.insertRec(8);
        linkedList.insertRec(7);
        linkedList.insertRec(1);

        linkedList.printList();

    }
}
