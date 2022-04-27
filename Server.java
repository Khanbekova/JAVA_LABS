/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labjava1;

import java.io.*;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Елена
 */
public class Server{
    
    public static void main(String[] args){
      try (ServerSocket server= new ServerSocket(8000)){
          System.out.println("Сервер запущен");
          
          while(true){
          try(Socket socket = server.accept();
               BufferedWriter writer = new BufferedWriter( new OutputStreamWriter(socket.getOutputStream()));
                  BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))
          ){
            double result = 0.0 ;
            String[] values;
            
            String request = reader.readLine();
            values = request.split(" "); 
              
            System.out.println("Запрос:" + values[0] + values[1] + values[2]);
              
              IntegralThread[] myThread = new IntegralThread[2];
                
                for (int i = 0; i < 2; i++) {
                    myThread[i] = new IntegralThread(values[0], values[1], values[2]);
                    myThread[i].start();
                }
                   
            try {
                for(int i = 0; i < 2; i++){
                    myThread[i].join();
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(labjava1UI.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            for(int i = 0; i < 2; i++){
                result += myThread[i].getResult();
                }
            System.out.println("Ответ:" + result);
            String buf = Double.toString(result);
            writer.write(buf);
            writer.newLine();
            writer.flush();
          }catch(NullPointerException e){e.printStackTrace();}}
          
      }catch(IOException e){throw new RuntimeException(e);}
    
     
    }



}
