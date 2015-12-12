package org.petclinic.petclinicapp.Roll;

public class LinkedRoll<T> implements Roll {

    Node head = null;
    Node tail = null;
    int size = 0;

    @Override
    public void add(Object newElem) {
        Node marker;
        if (tail == null) {
            tail = new Node(head, newElem);
            head = tail;
        } else {
            marker = head;
            marker.link = new Node(null, newElem);
            head = marker.link;
        }
        ++size;
    }

    @Override
    public void add(int position, Object newElem) {

    }

    @Override
    public String toString() {
        Node node = tail;
        while (node != null) {
            System.out.print("|" + node.elem + "|");
            node = node.link;
        }
        return super.toString();
    }

    @Override
    public void remove(int position) {
        Node node = tail;
        if (position == 0)
            tail = node.link;
        else {
            for (int i = 1; i <= position; i++) {
                if (position == i) {
                    node.link = node.link.link;
                    if (position == --size)
                        head = node;
                }
                node = node.link;
            }
        }
        --size;
    }

    @Override
    public Object get(int position) {
        return null;
    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return size;
    }

    private class Node {
        Node link = null;
        Object elem;
        Node(Node link, Object elem) {
            this.link = link;
            this.elem = elem;
        }
    }
}
