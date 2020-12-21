/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.HttpClient;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author BOT
 */
public class LoginManager {

    public LoginManager() {
    }
    
    
    public static int login(String username, String pass) throws MalformedURLException, IOException{
        
        JsonObject test = new JsonObject();
        
        test.addProperty("username", username);
        test.addProperty("pass", username);
        
        
        System.out.println(test);
        int job = 0;
        
        
        String data = HttpClient.excutePost("http://localhost:4000/api/login",test.toString(), "application/json");
        System.out.println(data);
        JsonObject json = new JsonParser().parse(data).getAsJsonObject();
        
//        for (JsonElement a : arr) {
//            System.out.println(a.getAsJsonObject().get("job").toString());
            job = Integer.parseInt(json.getAsJsonObject().get("job").toString());
//        }
        return job;
    }
    public static void main(String[] args) {
        try {
            int job = login("admin","admin");
            System.out.println(job);
        } catch (IOException ex) {
            Logger.getLogger(LoginManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
