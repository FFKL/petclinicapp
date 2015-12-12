package org.petclinic.petclinicapp.Roll;

public class ArrayRoll<T> implements Roll {
    private int sizeArray = 0;
    private Object[] mass = new Object[sizeArray];
    private ArrayRollController controller = new ArrayRollController();

    @Override
    public void add(Object newElem) {
        mass = controller.incrementArray(mass);
        mass[mass.length - 1] = newElem;
    }

    @Override
    public void add(int position, Object newElem) {
        mass = controller.incrementFromPosititon(position, mass);
        mass[position] = newElem;

    }

    @Override
    public void remove(int position) {
        mass = controller.decrementFromPosition(position, mass);
    }

    @Override
    public Object get(int position) {
       return mass[position];
    }

    @Override
    public void clear() {
        for (Object o : mass)
            mass = controller.decrementFromPosition(0, mass);
    }

    @Override
    public int size() {
        int size = 0;
        for (Object o : mass)
            ++size;
        return size;
    }
}
