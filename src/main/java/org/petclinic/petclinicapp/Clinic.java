package org.petclinic.petclinicapp;

import org.petclinic.petclinicapp.Exceptions.WrongInputException;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс описывает клинику.
 */
public class Clinic {
    private final List<Client> clients;

    String CONTAINS_NO_NUMBERS_REGEXP = "\\D+";
    String WRONG_INPUT_EXCEPTION_MESSAGE = "Ввод содержит цифры. Введите корректное имя (Пример: Василий)";
    /**
     * Конструктор
     */
    public Clinic() {
        this.clients = new ArrayList<Client>();
    }
    /**
     * Добавление клиента
     * @param client Клиент
     * @throws WrongInputException, если имя клиента или имя питомца содержат цифры
     */
    public void  addClient(final Client client) throws WrongInputException {
        if (!client.getClientName().matches(CONTAINS_NO_NUMBERS_REGEXP) || !client.getPet().getName().matches(CONTAINS_NO_NUMBERS_REGEXP)) {
            throw new WrongInputException(WRONG_INPUT_EXCEPTION_MESSAGE);
        }
        else {
            this.clients.add(client);
        }
    }

    /**
     * Нахождение клиента по имени питомца
     * @param petName имя клиента
     * @return List клиентов с заданным именем
     * @throws WrongInputException, если имя питомца содержит цифры
     */
    public List<Client> findClientsByPetName(final String petName) throws WrongInputException {
        if (!petName.matches(CONTAINS_NO_NUMBERS_REGEXP)) {
            throw new WrongInputException(WRONG_INPUT_EXCEPTION_MESSAGE);
        }
        else {
                List<Client> clientsWithCurrentPet = new ArrayList<Client>();
                for (Client c : clients) {
                    String name = c.getPet().getName();
                    if (name.equals(petName))
                        clientsWithCurrentPet.add(c);
                }
            return clientsWithCurrentPet;
        }
    }
    /**
     * Нахождение клиента по собственному имени
     * @param clientName имя клиента
     * @return List клиентов с заданным именем
     * @throws WrongInputException, если имя клиента содержит цифры
     */
    public List<Client> findByClientName(final String clientName) throws WrongInputException {
        if (!clientName.matches(CONTAINS_NO_NUMBERS_REGEXP)) {
            throw new WrongInputException(WRONG_INPUT_EXCEPTION_MESSAGE);
        }
        else {
            List<Client> clientsWithCurrentName = new ArrayList<Client>();
            for (Client c : clients) {
                if (c.getClientName().equals(clientName))
                    clientsWithCurrentName.add(c);
            }
            return clientsWithCurrentName;
        }
    }
    /**
     * Изменение имени клиента
     * @param id ID клиента
     * @param clientName имя клиента
     * @throws WrongInputException, если имя клиента содержит цифры
     */
    public void changeClientName(int id, String clientName) throws WrongInputException {
        if (!clientName.matches(CONTAINS_NO_NUMBERS_REGEXP)) {
            throw new WrongInputException(WRONG_INPUT_EXCEPTION_MESSAGE);
        }
        else {
            for (Client c : clients) {
                if (c.getId() == id){
                    c.setClientName(clientName);
                    break;
                }
            }
        }
    }
    /**
     * Изменение имени питомца
     * @param id ID клиента
     * @param petName имя питомца
     * @throws WrongInputException, если имя питомца содержит цифры
     */
    public void changePetName(int id, String petName) throws WrongInputException {
        if (!petName.matches(CONTAINS_NO_NUMBERS_REGEXP)) {
            throw new WrongInputException(WRONG_INPUT_EXCEPTION_MESSAGE);
        }
        else {
            for (Client c : clients) {
                if (c.getId() == id){
                    c.getPet().setName(petName);
                    break;
                }
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

    /**
     * Вывод списка клиентов клиники на экран
     * В случае отсутствия питомца вместо имени питомца выводит строку "!Питомец отсутствует!"
     */
    public void clientList() {
        for (Client c : clients) {
            String petName;
            if (c.getPet() == null)
                petName = "!Питомец отсутствует!";
            else
                petName = "; Имя питомца: " +  c.getPet().getName();
            System.out.println("ID клиента: " + c.getId() + "; Имя клиента: " + c.getClientName() + petName);
        }
    }
}
