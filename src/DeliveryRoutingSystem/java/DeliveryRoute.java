package DeliveryRoutingSystem.java;

import java.util.AbstractSequentialList;
import java.util.LinkedList;

public class DeliveryRoute<E> extends AbstractSequentialList<E> {
    private LinkedList<E> route;

    public DeliveryRoute() {
        this.route = new LinkedList<>();
    }

    @Override
    public void add(int index, E element) {
        route.add(index, element);
    }

    @Override
    public E remove(int index) {
        return route.remove(index);
    }

    @Override
    public int size() {
        return route.size();
    }

    @Override
    public java.util.ListIterator<E> listIterator(int index) {
        return route.listIterator(index);
    }
}
