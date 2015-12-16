package org.petclinic.petclinicapp.EmulationUsers;

import org.petclinic.petclinicapp.Clinic;
import org.petclinic.petclinicapp.Exceptions.IDException;
import org.petclinic.petclinicapp.Exceptions.PetTypeException;
import org.petclinic.petclinicapp.Exceptions.WrongInputException;

public class Administrator extends Thread {
    private RandomParameters random = new RandomParameters();
    private Clinic myClinic;

    public Administrator(Clinic myClinic) {
        this.myClinic = myClinic;
    }

    public synchronized void addUser() {
        try {
            this.myClinic.addClient(random.getRandomNum(), random.getClientName(), random.getPetType(), random.getPetName());
        } catch (WrongInputException e) {
            e.getMessage();
        } catch (IDException e) {
            e.getMessage();
        } catch (PetTypeException e) {
            e.getMessage();
        }
    }

    public synchronized void removeUser() {
        try {
            this.myClinic.removeClient(random.getRandomNum());
        } catch (IDException e) {
            e.getMessage();
        }
    }

    public synchronized void removePet() {
        try {
            this.myClinic.removePet(random.getRandomNum());
        } catch (IDException e) {
            e.getMessage();
        }
    }

    @Override
    public void run() {
        super.run();
    }
}
