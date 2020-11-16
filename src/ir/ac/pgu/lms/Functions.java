package ir.ac.pgu.lms;

import ir.ac.pgu.lms.dataStructures.LinkedList;
import ir.ac.pgu.lms.dataStructures.TwoSidedLinkedList;
import ir.ac.pgu.lms.domain.NodeTwoSided;

import java.util.Random;

public class Functions {

    public static LinkedList singlySidedSeedData(int n, int bound) {
        LinkedList linkedList = new LinkedList(true);


        Random random = new Random();

        for (int i = 0; i < n; i++) {
            linkedList.insert(random.nextInt(bound));
        }

        return linkedList;
    }

    public static TwoSidedLinkedList DoubleSidedSeedData(int n, int bound) {
        TwoSidedLinkedList twoSidedLinkedList = new TwoSidedLinkedList(true);

        Random random = new Random();

        for (int i = 0; i < n; i++) {
            twoSidedLinkedList.insert(random.nextInt(bound));
        }

        return twoSidedLinkedList;
    }

    public static TwoSidedLinkedList commonNodes(TwoSidedLinkedList first, TwoSidedLinkedList second) {

        TwoSidedLinkedList finalList = new TwoSidedLinkedList(true);

        NodeTwoSided firstPTR = first.getHead();
        NodeTwoSided secondPTR = second.getHead();

        if (first.getSize() == 0 || second.getSize() == 0) {
            System.out.println("One of lists are empty");
            return null;
        }

        while (firstPTR != null) {
            while (secondPTR != null) {
                if (firstPTR.getData() == secondPTR.getData())
                    finalList.insert(firstPTR.getData());
                secondPTR = secondPTR.getNext();
            }
            firstPTR = firstPTR.getNext();
        }
        return finalList;
    }

    public static TwoSidedLinkedList commonNodesRec(TwoSidedLinkedList first, TwoSidedLinkedList second) {

        TwoSidedLinkedList finalList = new TwoSidedLinkedList(true);

        NodeTwoSided firstPTR = first.getHead();
        NodeTwoSided secondPTR = second.getHead();

        if (first.getSize() == 0 || second.getSize() == 0) {
            System.out.println("One of lists are empty");
            return null;
        }

        commonNodesRecOuter(firstPTR, secondPTR, finalList);
        return finalList;
    }

    public static void commonNodesRecOuter(NodeTwoSided firstPTR, NodeTwoSided secondPTR, TwoSidedLinkedList finalList) {
        if (firstPTR != null) {
            commonNodesRecInner(firstPTR, secondPTR, finalList);
            commonNodesRecOuter(firstPTR.getNext(), secondPTR, finalList);
        }
    }

    public static void commonNodesRecInner(NodeTwoSided firstPTR, NodeTwoSided secondPTR, TwoSidedLinkedList finalList) {
        if (secondPTR != null) {
            if (firstPTR.getData() == secondPTR.getData())
                finalList.insert(firstPTR.getData());
            commonNodesRecInner(firstPTR, secondPTR.getNext(), finalList);
        }
    }
}
