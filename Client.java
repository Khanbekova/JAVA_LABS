/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labjava1;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 *
 * @author Елена
 */
public class Client {
    
    String result;
        public String getRes(){
        return result;
    }
       
    public void client(String low, String high, String step){
        
        try(Socket socket = new Socket("192.168.56.1", 8000);
        BufferedWriter writer = new BufferedWriter( new OutputStreamWriter(socket.getOutputStream()));
                  BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))        
        ){
            
            System.out.println("Соеденение с сервером");
           
            String request = low + " " + high + " " + step;
            System.out.println("Запрос:" + request);
            writer.write(request);
            writer.newLine();
            writer.flush();
            
            result = reader.readLine();
            System.out.println("Ответ:" + result);
        }catch(Exception e){e.printStackTrace();}
    }


}
