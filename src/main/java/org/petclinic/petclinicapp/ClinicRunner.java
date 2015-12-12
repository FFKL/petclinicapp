package org.petclinic.petclinicapp;

import org.petclinic.petclinicapp.Exceptions.IDException;
import org.petclinic.petclinicapp.Exceptions.PetTypeException;
import org.petclinic.petclinicapp.Exceptions.WrongInputException;
import org.petclinic.petclinicapp.Pets.Cat;
import org.petclinic.petclinicapp.Pets.Pet;

import java.io.IOException;

/**
 * Работа клиники.
 */
public class ClinicRunner {



    public static void main(String[] args) throws IOException {
        ClinicTerminal terminal = new ClinicTerminal();
        Client c = new Client(22, "Ivan", new Cat("Hren"));
        Client g = new Client(22, "Ivan", new Cat("Hren"));

        try {
            terminal.myClinic.addClient(1, "Vasiliy Pupkin", "Dog", "Racks");
            terminal.myClinic.addClient(2, "Julia Korosteleva", "Cat", "Pushok");
            terminal.myClinic.addClient(3, "Dmitriy Pupkin", "Cat", "Hren");
        } catch (WrongInputException e) {
            e.printStackTrace();
        } catch (IDException e) {
            e.printStackTrace();
        } catch (PetTypeException e) {
            e.printStackTrace();
        }
        terminal.mainMenu();
    }
}
