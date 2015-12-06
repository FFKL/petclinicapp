package org.petclinic.petclinicapp;

import org.junit.Test;
import org.petclinic.petclinicapp.Exceptions.WrongInputException;
import org.petclinic.petclinicapp.Pets.Cat;
import org.petclinic.petclinicapp.Pets.Dog;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ClinicTest {

    Clinic myClinic = new Clinic();
    Client first = new Client(1, "Vasiliy", new Dog("Dog"));
    Client second = new Client(2, "Vasiliy", new Cat("Cat"));
    Client third = new Client(3, "Dmitriy", new Cat("Vaska"));

    @Test
    public void testFindClientsByPetName() throws Exception {
        List<Client> clients = new ArrayList<Client>();
        clients.add(second);

        myClinic.addClient(first);
        myClinic.addClient(second);
        myClinic.addClient(third);

        assertEquals(clients, myClinic.findClientsByPetName("Cat"));
    }

    @Test
    public void testFindByClientName() throws Exception {
        List<Client> clients = new ArrayList<Client>();
        clients.add(first);
        clients.add(second);

        myClinic.addClient(first);
        myClinic.addClient(second);
        myClinic.addClient(third);
        assertEquals(clients, myClinic.findByClientName("Vasiliy"));
    }

    @Test(expected = WrongInputException.class)
    public void testAddClient() throws WrongInputException {
        Clinic myClinic = new Clinic();
        Client first = new Client(1, "Vasiliy55", new Dog("Dog"));
        myClinic.addClient(first);
    }

    @Test(expected = WrongInputException.class)
    public void testFindClientsByPetName1() throws WrongInputException {
        myClinic.findClientsByPetName("132Pushok");
    }

    @Test(expected = WrongInputException.class)
    public void testFindByClientNameEx() throws WrongInputException {
        myClinic.findByClientName("123Vasiliy");
    }

    @Test(expected = WrongInputException.class)
    public void testChangeClientNameEx() throws WrongInputException {
        myClinic.changeClientName(2, "123Vasiliy");
    }

    @Test(expected = WrongInputException.class)
    public void testChangePetName() throws WrongInputException {
        myClinic.changePetName(3, "Pushok32");
    }
}