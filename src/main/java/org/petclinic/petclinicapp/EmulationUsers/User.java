package org.petclinic.petclinicapp.EmulationUsers;

import org.petclinic.petclinicapp.Clinic;
import org.petclinic.petclinicapp.Exceptions.IDException;
import org.petclinic.petclinicapp.Exceptions.WrongInputException;

public class User extends Thread {
    private static RandomParameters random = new RandomParameters();
    private static Clinic myClinic;

    public User(Clinic myClinic) {
        this.myClinic = myClinic;
    }

    public static synchronized void searchUser() {
        try {
            myClinic.findByClientName(random.getClientName());
        } catch (WrongInputException e) {
            e.getMessage();
        }
    }

    public static synchronized void editPetName() {
        try {
            myClinic.changePetName(random.getRandomNum(), random.getPetName());
        } catch (WrongInputException e) {
            e.getMessage();
        } catch (IDException e) {
            e.getMessage();
        }
    }

    @Override
    public void run() {
        super.run();
    }
}
