package ir.ac.pgu.lms.domain;

public class NodeOneSided {

    private int data;
    private NodeOneSided next;

    public NodeOneSided(int data, NodeOneSided next) {
        this.data = data;
        this.next = next;
    }

    public NodeOneSided(int data) {
        this.data = data;
        this.next = null;
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
