package org.petclinic.petclinicapp;

import org.petclinic.petclinicapp.Pets.Cat;
import org.petclinic.petclinicapp.Pets.Dog;
import org.petclinic.petclinicapp.Pets.Pet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Работа клиники.
 */
public class ClinicRunner {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException, InterruptedException {
        Clinic myClinic = new Clinic();

        myClinic.addClient(new Client(1,"Vasiliy Pupkin", new Dog("Racks")));
        myClinic.addClient(new Client(2,"Julia Korosteleva", new Cat("Pushok")));
        myClinic.addClient(new Client(3,"Dmitriy Pupkin", new Cat("Hren")));

        while (true) {
            System.out.println("Вас приветствует Клиника для животных! Выберите действие (1 - Добавление; 2 - Поиск; 3 - Редактирование; 4 - Удаление; 5 - Показать всех клиентов");
            try {
                int action = Integer.parseInt(reader.readLine());
                switch (action) {
                    case 1:
                        add(myClinic);
                        break;
                    case 2:
                        search(myClinic);
                        break;
                    case 3:
                        edit(myClinic);
                        break;
                    case 4:
                        delete(myClinic);
                        break;
                    case 5:
                        myClinic.table();
                        break;
                    default:
                        System.out.println("Введите корректную команду");
                        break;
                }
            }
            catch (NumberFormatException e) {
                Thread.sleep(20); //задержка добавлена для того, чтобы цикл не срабатывал несколько раз после остановки процесса
                System.out.println("Введите цифру!");
            }
        }
    }

    private static String wrongInput(String inputString) throws IOException {
        String outputString = inputString;
        while (true) {
            if (outputString.matches("\\D+")) {
                break;
            } else {
                System.out.println("Ввод содержит цифры. Введите корректное имя (Пример: Василий)");
                outputString = reader.readLine();
            }
        }
        return outputString;
    }

    private static void add(Clinic myClinic) throws IOException {
        int id;
        String clientName;
        String petName;
        System.out.println("Введите ID клиента");
        id = Integer.parseInt(reader.readLine());
        System.out.println("Введите имя клиента");
        clientName = reader.readLine();
        ClinicRunner.wrongInput(clientName);
        System.out.println("Введите имя питомца");
        petName = reader.readLine();
        ClinicRunner.wrongInput(petName);
        System.out.println("Кот/Собака");
        Pet pet;
        while (true) {
            String petType = reader.readLine();
            if (petType.equals("Кот")) {
                pet = new Cat(petName);
                break;
            } else if (petType.equals("Собака")) {
                pet = new Dog(petName);
                break;
            } else {
                System.out.println("Введите корректный тип питомца: Кот/Собака");
            }
        }
        myClinic.addClient(new Client(id, clientName, pet));
        System.out.println("Клиент добавлен!");
    }

    private static void search(Clinic myClinic) throws IOException {
        System.out.println("Поиск. (Введите цифру) Искать по: 1 - имени питомца, 2 - имени клиента");
        String clientName;
        String petName;
        while (true) {
            try {
                int num = Integer.parseInt(reader.readLine());

                if (num == 1) {
                    System.out.println("Введите имя питомца");
                    petName = reader.readLine();
                    ClinicRunner.wrongInput(petName);
                    System.out.println("Найдено: " + myClinic.findClientsByPetName(petName));
                    break;
                } else if (num == 2) {
                    System.out.println("Введите имя клиента");
                    clientName = reader.readLine();
                    ClinicRunner.wrongInput(clientName);
                    System.out.println("Найдено: " +  myClinic.findByClientName(clientName));
                    break;
                } else {
                    System.out.println("Введите корректную команду");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Введите цифру!");
            }
        }
    }

    private static void edit(Clinic myClinic) throws IOException {
        System.out.println("Редактирование. (Введите цифру) Редактировать: 1 - имя питомца, 2 - имя клиента");
        while (true) {
            try {
                int numSearch = Integer.parseInt(reader.readLine());
                if (numSearch == 1) {
                    System.out.println("Введите ID клиента");
                    int idSearch = Integer.parseInt(reader.readLine());
                    System.out.println("Введите новое имя питомца");
                    String petNameSearch = reader.readLine();
                    myClinic.changePetName(idSearch, petNameSearch);
                    System.out.println("Имя питомца изменено");
                    break;
                } else if (numSearch == 2) {
                    System.out.println("Введите ID клиента");
                    int idSearch = Integer.parseInt(reader.readLine());
                    System.out.println("Введите новое имя клиента");
                    String petNameSearch = reader.readLine();
                    myClinic.changeClientName(idSearch, petNameSearch);
                    System.out.println("Имя клиента изменено");
                    break;
                } else {
                    System.out.println("Введите корректную команду");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Введите цифру");
            }
        }
    }

    private static void delete(Clinic myClinic) throws IOException {
        try {
            System.out.println("Удаление. (Введите цифру) Удалить: 1 - питомца, 2 - клиента");
            while (true) {
                int numSearch = Integer.parseInt(reader.readLine());
                if (numSearch == 1) {
                    System.out.println("Введите ID клиента");
                    myClinic.removePet(Integer.parseInt(reader.readLine()));
                    System.out.println("Питомец удален");
                    break;
                } else if (numSearch == 2) {
                    System.out.println("Введите ID клиента");
                    myClinic.removeClient(Integer.parseInt(reader.readLine()));
                    System.out.println("Клиент удален");
                    break;
                } else {
                    System.out.println("Введите корректную команду");
                }
            }
        }
        catch (NumberFormatException e) {
            System.out.println("Введите цифру");
        }

    }



}
