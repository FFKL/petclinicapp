package org.petclinic.petclinicapp.EmulationUsers;

import java.util.Random;

public class RandomParameters {
    Random random = new Random();
    String[] clientName = new String[] {"Василий", "Юлия", "Дмитрий", "Юрий", "Михаил"};
    String[] petName = new String[] {"Рыжик", "Барбос", "Пушок"};
    String[] petType = new String[] {"Cat", "Dog"};

    public String getClientName() {
        return randomString(this.clientName);
    }

    public String getPetName() {
        return randomString(this.petName);
    }

    public String getPetType() {
        return randomString(this.petType);
    }

    public int getRandomNum() {
        return random.nextInt(6);
    }

    private String randomString(String[] mas) {
        return mas[random.nextInt(mas.length - 1)];
    }
}
