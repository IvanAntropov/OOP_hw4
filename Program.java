import Actions.JsonReader;
import Actions.JsonWriter;
import Classes.Bread;
import Classes.Cat;
import Classes.Milk;
import Console.ReadConsole;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        String path = "JsonData\\file.json";
        ReadConsole console = new ReadConsole();

        JsonWriter jsonWriter = new JsonWriter(path);

        String string = "Hi world";
        Integer digit = 5;
        Cat cat1 = new Cat(5,6,"Blue","Barsik","Dvoroviu","No","Brown","29.03.2001");
        Milk milk1 = new Milk("Irbitscoe",5,"ML",5,0.2,"14.10.2001");
        Bread bread1 = new Bread("Xleb",5,"Кг","29.03.1978","Xoroshiu");

//        jsonWriter.writeJson(string,true); //true ля дозаписи, false для перезаписи
//        jsonWriter.writeJson(digit,true);
//        jsonWriter.writeJson(cat1,true);
//        jsonWriter.writeJson(bread1,true);
//        jsonWriter.writeJson(milk1,true); //Не распознает так, что пишет как хочет

        JsonReader jsonReader = new JsonReader(path);
        ArrayList a = new ArrayList();
//        jsonReader.showJson(); // Показывает json
        jsonReader.JsonShowByName(console.read().toLowerCase()); //Показывает элемент по имени класса

    }
}