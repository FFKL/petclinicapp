package org.petclinic.petclinicapp.Roll;

public interface Roll<T> {
    public void add (T newElem);
    public void add (int position, T newElem);
    public void remove (int position);
    public T get (int position);
    public void clear();
    public int size();
}
