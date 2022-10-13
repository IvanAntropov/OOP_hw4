package Console;

import java.util.Scanner;

public class ReadConsole {
    String text1 = "\nsuccess\n\n";
    String text2 = "\nNothing to read\n";

    public ReadConsole() {
    }

    public String read(){
        Scanner in = new Scanner(System.in);
        String ConsoleString = "";
        boolean check = true;
        while(check) {
            if (in.hasNextLine()) {
                ConsoleString = in.nextLine();
                check = false;
                System.out.printf(text1);
            } else {
                System.out.println(text2);
            }
        }
        in.close();
        return ConsoleString;
    }

}