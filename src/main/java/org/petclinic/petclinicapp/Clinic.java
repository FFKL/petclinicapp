package org.petclinic.petclinicapp;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс описывает клинику.
 */
public class Clinic {
    private final List<Client> clients;
    /**
     * Конструктор
     */
    public Clinic() {
        this.clients = new ArrayList<Client>();
    }
    /**
     * Добавление клиента
     * @param client Клиент
     */
    public void  addClient(final Client client) {
        this.clients.add(client);
    }

    /**
     * Нахождение клиента по имени питомца
     * @param petName имя клиента
     * @return List клиентов с заданным именем
     */
    public List<Client> findClientsByPetName(final String petName){
        List<Client> clientsWithCurrentPet = new ArrayList<Client>();
        for (Client c : clients) {
            String name = c.getPet().getName();
            if (name.equals(petName))
                clientsWithCurrentPet.add(c);
        }
        return clientsWithCurrentPet;
    }
    /**
     * Нахождение клиента по собственному имени
     * @param clientName имя клиента
     * @return List клиентов с заданным именем
     */
    public List<Client> findByClientName(final String clientName){
        List<Client> clientsWithCurrentName = new ArrayList<Client>();
        for (Client c : clients) {
            if (c.getClientName().equals(clientName))
                clientsWithCurrentName.add(c);
        }
        return clientsWithCurrentName;
    }
    /**
     * Изменение имени клиента
     * @param id ID клиента
     * @param clientName имя клиента
     */
    public void changeClientName(int id, String clientName){
        for (Client c : clients) {
            if (c.getId() == id){
                c.setClientName(clientName);
                break;
            }
        }
    }
    /**
     * Изменение имени питомца
     * @param id ID клиента
     * @param petName имя питомца
     */
    public void changePetName(int id, String petName){
        for (Client c : clients) {
            if (c.getId() == id){
                c.getPet().setName(petName);
                break;
            }
        }
    }
    /**
     * Удаление клиента
     * @param id ID клиента
     */
    public void removeClient(int id){
        for (int i = 0; i < clients.size(); i++){
            if (clients.get(i).getId() == id){
                clients.remove(i);
                break;
            }
        }
    }
    /**
     * Удаление питомца
     * @param id ID килента
     */
    public void removePet(int id){
        for (int i = 0; i < clients.size(); i++){
            if (clients.get(i).getId() == id){
                clients.get(i).removePet();
                break;
            }
        }
    }

    public void table() {
        for (Client c : clients) {
            System.out.println("ID: " + c.getId() + "Client Name: " + c.getClientName() + "Pet: " + c.getPet().getName());
        }
    }
}
