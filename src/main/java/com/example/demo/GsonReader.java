package com.example.demo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class GsonReader {

public static void main(String[] args) throws IOException {
    // TODO Auto-generated method stub  
    BufferedReader reader = null;

    try{
        reader = new BufferedReader(new FileReader("D://Java//correct_offer.json"));
        Gson gson = new GsonBuilder().create();
        String results = gson.fromJson(reader, String.class);

        
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(reader != null){
                try{
                    reader.close();
                }catch(Exception e){
                    e.printStackTrace();
                }

            }
        }
}
}
