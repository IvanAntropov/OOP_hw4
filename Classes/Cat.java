package Classes;

import Interfaces.ICanBeJson;

public class Cat implements ICanBeJson {
    private int height;
    private int weight;
    private String colorOfEyes;
    private String dateOfBirth;
    private String name;
    private String breed;
    private String vaccines;
    private String colorOfFur;

    public Cat(int height1, int weight1, String colorOfEyes1, String name1,
               String breed1, String vaccines1, String ColorOfFur1, String dateOfBirth1){
        this.height = height1;
        this.weight = weight1;
        this.colorOfEyes = colorOfEyes1;
        this.name = name1;
        this.breed = breed1;
        this.vaccines = vaccines1;
        this.colorOfFur = ColorOfFur1;
        this.dateOfBirth = dateOfBirth1;
    }

    public void showAffection() {
        System.out.println("Мурлыкает");
    }

    public void MakeSound() {
        System.out.println("Мяу");
    }

    public void GetInfo() {
        String info = String.format("Рост: %d м\n" +
                        "Вес: %d кг\n" +
                        "Цвет глаз: %s\n" +
                        "Имя: %s\n" +
                        "Порода: %s\n" +
                        "Привики: %s\n" +
                        "Цвет шерсти: %s\n" +
                        "Дата рождения: %s\n",
                height,weight,colorOfEyes,name,breed,vaccines,colorOfFur,dateOfBirth);
        System.out.printf(info);
    }

    @Override
    public String toJson() {
        String JsonString = String.format("{\n\"Cat\": [\n{\n\"Рост:\" %d \"м\"\n" +
                        "\"Вес\": %d \"кг\"\n" +
                        "\"Цвет глаз\": \"%s\"\n" +
                        "\"Имя\": \"%s\"\n" +
                        "\"Порода\": \"%s\"\n" +
                        "\"Привики\": \"%s\"\n" +
                        "\"Цвет шерсти\": \"%s\"\n" +
                        "\"Дата рождения\": \"%s\"\n\n}\n]\n}",
                height,weight,colorOfEyes,name,breed,vaccines,colorOfFur,dateOfBirth);
        return JsonString;
    }

    @Override
    public String toString() {
        String JsonString = String.format("{\n\"Cat\": [\n{\n\"Рост м\": %d ,\n" +
                        "\"Вес кг\": %d ,\n" +
                        "\"Цвет глаз\": \"%s\",\n" +
                        "\"Имя\": \"%s\",\n" +
                        "\"Порода\": \"%s\",\n" +
                        "\"Привики\": \"%s\",\n" +
                        "\"Цвет шерсти\": \"%s\",\n" +
                        "\"Дата рождения\": \"%s\"\n}\n]\n}\n",
                height,weight,colorOfEyes,name,breed,vaccines,colorOfFur,dateOfBirth);
        return JsonString;
    }
}