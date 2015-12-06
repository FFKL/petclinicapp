package org.petclinic.petclinicapp;

import org.petclinic.petclinicapp.Exceptions.WrongInputException;
import org.petclinic.petclinicapp.Pets.Cat;
import org.petclinic.petclinicapp.Pets.Dog;

import java.io.IOException;

/**
 * Работа клиники.
 */
public class ClinicRunner {



    public static void main(String[] args) throws IOException, InterruptedException {
        ClinicTerminal terminal = new ClinicTerminal();

        try {
            terminal.myClinic.addClient(new Client(1, "Vasiliy Pupkin", new Dog("Racks")));
            terminal.myClinic.addClient(new Client(2, "Julia Korosteleva", new Cat("Pushok")));
            terminal.myClinic.addClient(new Client(3, "Dmitriy Pupkin", new Cat("Hren")));
        } catch (WrongInputException e) {
            e.printStackTrace();
        }
        terminal.mainMenu();
    }
}
