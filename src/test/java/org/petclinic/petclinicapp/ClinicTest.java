package org.petclinic.petclinicapp;

import org.junit.Test;
import org.petclinic.petclinicapp.Pets.Cat;
import org.petclinic.petclinicapp.Pets.Dog;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ClinicTest {

    @Test
    public void testFindClientsByPetName() throws Exception {
        Clinic myClinic = new Clinic();
        Client first = new Client(1, "Vasiliy", new Dog("Dog"));
        Client second = new Client(2, "Vasiliy", new Cat("Cat"));
        Client third = new Client(3, "Dmitriy", new Cat("Vaska"));
        List<Client> clients = new ArrayList<Client>();
        clients.add(second);

        myClinic.addClient(first);
        myClinic.addClient(second);
        myClinic.addClient(third);

        assertEquals(clients, myClinic.findClientsByPetName("Cat"));
    }

    @Test
    public void testFindByClientName() throws Exception {
        Clinic myClinic = new Clinic();
        Client first = new Client(1, "Vasiliy", new Dog("Dog"));
        Client second = new Client(2, "Vasiliy", new Cat("Cat"));
        Client third = new Client(3, "Dmitriy", new Cat("Vaska"));
        List<Client> clients = new ArrayList<Client>();
        clients.add(first);
        clients.add(second);

        myClinic.addClient(first);
        myClinic.addClient(second);
        myClinic.addClient(third);
        assertEquals(clients, myClinic.findByClientName("Vasiliy"));
    }
}