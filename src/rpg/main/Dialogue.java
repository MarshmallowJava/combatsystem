package rpg.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Dialogue {

    private static final BufferedReader ENTERDETECTOR = new BufferedReader(new InputStreamReader(System.in));

    public static void print(String... messages){
        print(false, messages);
    }

    public static void print(boolean instant, String... messages){
        for(String message : messages){
            System.out.print(message);

            if(!instant)
                nod();
        }
    }
    public static void nextLine(){
        System.out.println();
    }

    private static void nod(){
        input(null, ".*");
    }

    public static String input(String message, String regex){
        if(message != null)
            System.out.print(message);

        while(true){
            try {
                String data = ENTERDETECTOR.readLine();
                if(data.matches(regex)){
                    return data;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }    
        }
    }
}
