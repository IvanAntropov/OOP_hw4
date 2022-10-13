package Actions;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class JsonReader {
    private String path;
    static Map<String,String> jsonData = new HashMap<>();
    static String mainJsonStr = "";
    public JsonReader(String path) {
        this.path = path;
    }

    public void JsonShowByName(String nameClass){
        JsonRead();
        if(jsonData.containsKey(nameClass)){
            System.out.println(nameClass + ":\n" +jsonData.get(nameClass));
        }else{
            System.out.println("===Nothing===");
        }
    }

    public void showJson(){
        JsonRead();
        System.out.println(mainJsonStr);
    }

    private void JsonRead(){
        String jsonStr = "";
        ArrayList<Character> readerList = new ArrayList<>();
        readerList = read();
        int i = 0;
        String help1 = "" + readerList.get(i);
        while(i <= readerList.size()){
            if(help1.contains("{")){
                i = JsonReadForClasses(readerList,i);
            }else if(help1.contains("\"")){
                i++;
                help1 = "" + readerList.get(i);
                String helper = "";
                mainJsonStr += "\n\nString:\n";
                while(!help1.contains("\"")){
                    mainJsonStr += ""+readerList.get(i);
                    helper += "" + readerList.get(i);
                    i++;
                    help1 = "" + readerList.get(i);
                }
                jsonData.put("string",helper);
            }else if(checker(help1)){
                String digits = "";
                while(checker(help1)){
                    digits = ""+readerList.get(i);
                    i++;
                    help1 = ""+readerList.get(i);
                }
                mainJsonStr += "\n\nInteger:\n" + digits;
                jsonData.put("integer",digits);
            }
            i++;
            if(i<readerList.size()){
                help1 = ""+readerList.get(i);
            }
        }
        mainJsonStr = mainJsonStr.replaceAll(";","");
    }

    private boolean checker(String string){
        int intValue;
        try {
            intValue = Integer.parseInt(string);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private int JsonReadForClasses(ArrayList<Character> list,int i){
        String jsonStr2 = "";
        String[] arr = new String[2];
        Boolean check = true;
        String help1 = "" + list.get(i);
        while (!help1.contains("[") && check){
            jsonStr2 += list.get(i);
            i++;
            help1 = "" + list.get(i);
            if(help1.contains("}")){
                jsonStr2 += "}";
                mainJsonStr += "Noname:\n" + jsonStr2 +"\n";
                jsonData.put("noname",jsonStr2);
                check = false;
            }
        }
        if (!check){
            return i;
        }
        jsonStr2 = jsonStr2.replaceAll(":", "");
        jsonStr2 = jsonStr2.replaceAll("\"", "");
        jsonStr2 = jsonStr2.replaceAll("}", "");
        jsonStr2 = jsonStr2.replaceAll(" ", "");
        jsonStr2 = jsonStr2.replaceAll("\\{", "");
        jsonStr2 = jsonStr2.replaceAll("\n", "");
        arr[0]=jsonStr2.toLowerCase();
        mainJsonStr += "\n\n" + jsonStr2 + ": ";
        jsonStr2 = "";
        i++;
        String help2 = "" + list.get(i);
        while (!help2.contains("]")){
            jsonStr2 += list.get(i);
            i++;
            help2 = "" + list.get(i);
        }
        jsonStr2 = jsonStr2.replaceAll(";", "");
        jsonStr2 = jsonStr2.replaceAll("\"", "");
        jsonStr2 = jsonStr2.replaceAll("}", "");
        jsonStr2 = jsonStr2.replaceAll("\\{", "");
        arr[1]=jsonStr2;
        mainJsonStr += jsonStr2 + ";\n";
        jsonData.put(arr[0],arr[1]);
        return i;
    }

    private ArrayList<Character> read(){
        ArrayList<Character> readerList = new ArrayList<Character>();
            try(FileReader reader = new FileReader(path))
            {
                int c;
                while((c=reader.read())!=-1){
                    readerList.add((char) c);
                }
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
            return readerList;
    }

}
