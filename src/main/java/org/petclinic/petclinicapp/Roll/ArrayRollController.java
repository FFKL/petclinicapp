package org.petclinic.petclinicapp.Roll;

class ArrayRollController {
    Object[] incrementArray(Object[] mass) {
        int sizeArray = mass.length + 1;
        Object[] newMass = new Object[sizeArray];
        for (int i = 0; i < mass.length; i++)
            newMass[i] = mass[i];
        return newMass;
    }

    Object[] incrementFromPosititon(int position, Object[] mass) {
        Object[] newMass = new Object[mass.length + 1];
        for (int i = 0; i < position; i++)
            newMass[i] = mass[i];
        for (int i = position; i < mass.length; i++)
            newMass[i + 1] = mass[i];
        return newMass;
    }

    Object[] decrementFromPosition(int position, Object[] mass) { //2
        Object[] newMass = new Object[mass.length - 1]; //length 3
        for (int i = 0; i < position; i++) //0 1 2 3
            newMass[i] = mass[i]; //0 1
        for (int i = position; i < mass.length - 1; i++)
            newMass[i] = mass[i + 1]; //3
        return newMass;
    }
}
