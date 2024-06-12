package DeliveryRoutingSystem.java;

import java.util.AbstractList;

public class OrderList<E> extends AbstractList<E> {
    private Object[] orders;
    private int size;
    
    @SuppressWarnings("unchecked")
    public OrderList() {
        this.orders = new Object[10];
        this.size = 0;
    }

    @Override
    public boolean add(E order) {
        if (size == orders.length) {
        	incCapacity();
        }
        orders[size++] = order;
        return true;
    }

    @SuppressWarnings("unchecked")
	@Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return (E) orders[index];
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        @SuppressWarnings("unchecked")
		E remOrder = (E) orders[index];
        System.arraycopy(orders, index + 1, orders, index, size - index - 1);
        orders[--size] = null;
        return remOrder;
    }

    @Override
    public int size() {
        return size;
    }

    private void incCapacity() {
        int newCapacity = orders.length * 2;
        Object[] newOrders = new Object[newCapacity];
        System.arraycopy(orders, 0, newOrders, 0, size);
        orders = newOrders;
    }
}
