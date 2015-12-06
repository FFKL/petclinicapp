package org.petclinic.petclinicapp.Pets;

public class Cat implements Pet {

    private String name;
    /**
     * Конструктор
     */
    public Cat(final String name){
        this.name = name;
    }
    /**
     * Получение имени питомца
     */
    @Override
    public String getName() {
        return this.name;
    }
    /**
     * Добавление имени питомца
     * @param name Имя питомца
     */
    @Override
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Звук, издаваемый питомцем
     */
    @Override
    public void makeSound() {
        System.out.println("Meov-Meov");
    }
}
