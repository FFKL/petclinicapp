package org.petclinic.petclinicapp.Terminal;

import org.petclinic.petclinicapp.Clinic;
import org.petclinic.petclinicapp.Exceptions.IDException;
import org.petclinic.petclinicapp.Exceptions.PetTypeException;
import org.petclinic.petclinicapp.Exceptions.WrongInputException;

import java.io.BufferedReader;
import java.io.IOException;



public class TerminalAdd {

    BufferedReader reader;
    Clinic myClinic;

    public TerminalAdd(BufferedReader reader, Clinic myClinic) throws IOException {
        this.reader = reader;
        this.myClinic = myClinic;
    }

    private final String ENTER_ID = "Введите ID клиента";
    private final String ENTER_CLIENT_NAME = "Введите имя клиента";
    private final String ENTER_PET_NAME = "Введите имя питомца";
    private final String ENTER_PET_TYPE = "Введите тип питомца: Cat/Dog";
    private final String CLIENT_ADDED = "Клиент добавлен!";

    int id;
    String clientName;
    String petType;
    String petName;

    public void start() throws IOException {
        this.id = Integer.parseInt(io(ENTER_ID));
        this.clientName = io(ENTER_CLIENT_NAME);
        this.petType = io(ENTER_PET_TYPE);
        this.petName = io(ENTER_PET_NAME);
        endOfAdd(myClinic);

    }

    private String io(String enter) throws IOException {
        System.out.println(enter);
        return reader.readLine();
    }

    private void endOfAdd(Clinic myClinic) {
        try {
            myClinic.addClient(this.id, this.clientName, this.petType, this.petName);
            System.out.println(CLIENT_ADDED);
        } catch (IDException e) {
            System.out.println(e.getMessage());
        } catch (WrongInputException e) {
            System.out.println(e.getMessage());
        } catch (PetTypeException e) {
            System.out.println(e.getMessage());
        }
    }
}
