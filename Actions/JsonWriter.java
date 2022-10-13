package Actions;

import Interfaces.ICanBeJson;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.Writer;

/**
 * При постройке требует путь
 *
 * Те что знает запишет в нужной форме
 * Остальным соболезнуем
 */
public class JsonWriter {

    private String path;

    public JsonWriter(String path) {
        this.path = path;
    }

    /**
     * True дописать
     *
     * False переписать
     */
    public <E> void writeJson(E data,boolean check){

            if(check){
                try {
                    PrintWriter output = new PrintWriter(new FileWriter(path, true));
                    write(output,data);
                }catch(Exception e)
                {
                    e.getStackTrace();
                }

            }else{
                try {
                    Writer output = new FileWriter(path);
                    write(output,data);
                }catch(Exception e)
                {
                    e.getStackTrace();
                }
            }
    }

    private <E1 extends Writer,E2> void write(E1 output,E2 data){
        try{
            if(data instanceof ICanBeJson){
                output.write(data.toString() + "\n"); // Можно ли использовать нестандартные методы для даты?
            } else                                        // Например data.toJson(), то как я хотел
            if (data instanceof String) {
                output.write("\"" + data + "\"\n");
            } else if (data instanceof Integer) {
                output.write( data.toString() +"\n");
            }else{
                output.write("{\"" + data + "\"}\n");
            }
            output.close();
        }
        catch(Exception e)
        {
            e.getStackTrace();
        }

    }

}