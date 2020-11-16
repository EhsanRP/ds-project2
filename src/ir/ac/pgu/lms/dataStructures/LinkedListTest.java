package ir.ac.pgu.lms.dataStructures;

import ir.ac.pgu.lms.domain.NodeOneSided;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListTest {

    LinkedList linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new LinkedList(true);

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
    }

    @Test
    void getTail() {
        Assertions.assertEquals(linkedList.indexOf(linkedList.getSize()-1), linkedList.getTail());
    }

    @Test
    void insertFirst() {
        linkedList.insertFirst(0);
        Assertions.assertEquals(0, linkedList.getHead().getData());
    }

    @Test
    void search() {
        Assertions.assertEquals(5, linkedList.search(5).getData());
    }

    @Test
    void insertAfter() {
        linkedList.insertAfter(10,linkedList.search(5));
        Assertions.assertEquals(linkedList.search(5).getNext().getData(), 10);
    }

    @Test
    void deleteNode() {
        NodeOneSided node = linkedList.indexOf(5);
        linkedList.deleteNode(node);
        Assertions.assertNotEquals(linkedList.indexOf(5),node);
    }

    @Test
    void deleteFirst() {
        NodeOneSided node = linkedList.indexOf(0);
        linkedList.deleteFirst();
        Assertions.assertNotEquals(node,linkedList.getHead());
        Assertions.assertEquals(node.getNext(),linkedList.getHead());
    }

    @Test
    void deleteLast() {
        NodeOneSided node = linkedList.indexOf(linkedList.getSize()-1);
        NodeOneSided newTail = linkedList.indexOf(linkedList.getSize()-2);
        linkedList.deleteLast();
        Assertions.assertEquals(9,linkedList.getSize());
        Assertions.assertEquals(linkedList.getTail(),newTail);
    }

    @Test
    void getHead() {
        Assertions.assertEquals(linkedList.indexOf(0), linkedList.getHead());
    }

    @Test
    void isEmpty() {
        Assertions.assertFalse(linkedList.isEmpty());
        LinkedList linkedList = new LinkedList(false);
        Assertions.assertTrue(linkedList.isEmpty());
    }

    @Test
    void getSize() {
        Assertions.assertEquals(10, linkedList.getSize());
    }


    @Test
    void isPresent() {
        Assertions.assertTrue(linkedList.isPresent(linkedList.getSize() - 1));
    }

    @Test
    void indexOf() {
        Assertions.assertNotNull(linkedList.indexOf(9));
        Assertions.assertNull(linkedList.indexOf(10));
    }

    @Test
    void deleteIndexOf() {

        linkedList.printList();
        Assertions.assertNotNull(linkedList.indexOf(5));
        NodeOneSided node = linkedList.indexOf(5);
        Assertions.assertEquals(node, linkedList.indexOf(4).getNext());
        linkedList.deleteIndexOf(5);
        Assertions.assertEquals(9, linkedList.getSize());
        System.out.println();
        linkedList.printList();
        Assertions.assertEquals(7, linkedList.indexOf(4).getNext().getData());
    }
}