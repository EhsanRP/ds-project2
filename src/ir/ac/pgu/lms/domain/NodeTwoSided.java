package ir.ac.pgu.lms.domain;

public class NodeTwoSided {
    private int data;
    private NodeOneSided next;
    private NodeOneSided previous;

    public NodeTwoSided(int data, NodeOneSided next, NodeOneSided previous) {
        this.data = data;
        this.next = next;
        this.previous = previous;
    }

    public NodeTwoSided(int data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    public boolean hasNext() {
        return getNext() != null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public NodeOneSided getNext() {
        return next;
    }

    public void setNext(NodeOneSided next) {
        this.next = next;
    }
}
