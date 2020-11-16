package ir.ac.pgu.lms;

import ir.ac.pgu.lms.dataStructures.LinkedList;
import ir.ac.pgu.lms.dataStructures.TwoSidedLinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList linkedList = Functions.singlySidedSeedData(30, 50);
        linkedList.printList();

        TwoSidedLinkedList first = Functions.DoubleSidedSeedData(10, 50);
        TwoSidedLinkedList second = Functions.DoubleSidedSeedData(10, 50);

        first.printList();
        System.out.println();
        second.printList();

        TwoSidedLinkedList finalList = Functions.commonNodes(first, second);

        System.out.println();
        finalList.printList();

        TwoSidedLinkedList finalListRec = Functions.commonNodesRec(first, second);

        System.out.println();
        finalListRec.printList();

    }
}
