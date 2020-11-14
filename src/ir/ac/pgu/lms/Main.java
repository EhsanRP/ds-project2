package ir.ac.pgu.lms;

import ir.ac.pgu.lms.dataStructures.LinkedList;
import ir.ac.pgu.lms.domain.NodeOneSided;

public class Main {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(false);

        linkedList.insert(3);
        linkedList.insert(10);
        linkedList.insert(2);
        linkedList.insert(5);
        linkedList.insert(6);
        linkedList.insert(4);
        linkedList.insert(9);
        linkedList.insert(8);
        linkedList.insert(7);
        linkedList.insert(1);

        linkedList.printList();

        //linkedList.recurSelectionSort(linkedList.getHead());


    }
}
