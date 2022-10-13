package Classes;

public class Milk{
    private final String name;
    private final int count;
    private final String unit;
    private final int volume;
    protected String perFat;
    protected String shelfLife;

    public Milk(String name, int count, String unit, int volume,Double fat, String life) {
        this.name = name;
        this.count = count;
        this.unit = unit;

        this.volume = volume;

        this.perFat = fat + " %";
        this.shelfLife = life;
    }

    public String ToString(){
        String goodString;
        goodString = String.format(    "\nИмя: %s\n" +
                "Кол-во: %d %s\n" +
                "Объем: %d мл\n"+
                "Жирность: %s\n"+
                "Годен до: %s\n",name,count,unit,volume, perFat,shelfLife);

        return goodString;
    }
}