package Classes;

import Interfaces.ICanBeJson;

public class Bread implements ICanBeJson {
    private String name;
    private int count;
    private String unit;
    private String shelfLife;
    protected String typeOfFlour;
    public Bread(String name, int count, String unit, String date, String typeOfFlour){
        this.name = name;
        this.count = count;
        this.unit = unit;

        this.shelfLife = date;

        this.typeOfFlour = typeOfFlour;
    }

    public void getInfo() {
        String goodString;
        goodString = String.format("\nИмя: %s\n" +
                "Кол-во: %d %s\n" +
                "Годен до: %s\n"+
                "Тип муки: %s\n",name,count,unit,shelfLife,typeOfFlour);
        System.out.println(goodString);
    }

    @Override
    public String toJson() {
        String JsonString;
        JsonString = String.format("{\n\"Bread\": [\n{\n\"Имя\": \"%s\",\n" +
                "\"Кол-во\": %d \"%s\",\n" +
                "\"Годен до\": \"%s\",\n"+
                "\"Тип муки\": \"%s\"\n}\n]\n}",name,count,unit,shelfLife,typeOfFlour);
        return JsonString;
    }

    @Override
    public String toString() {
        String JsonString = String.format("{\n\"Bread\": [\n{\n\"Имя\": \"%s\",\n" +
                "\"Кол-во %s\": %d,\n" +
                "\"Годен до\": \"%s\",\n"+
                "\"Тип муки\": \"%s\"\n}\n]\n}\n",name,unit,count,shelfLife,typeOfFlour);
        return JsonString;
    }
}