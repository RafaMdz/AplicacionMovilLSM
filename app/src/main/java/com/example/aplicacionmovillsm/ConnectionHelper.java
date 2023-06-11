package com.example.aplicacionmovillsm;

import android.os.StrictMode;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


public class ConnectionHelper {

    public Connection connectionClass(){
        Connection cnn=null;
        try{
            StrictMode.ThreadPolicy politica = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(politica);

            Class.forName("org.gjt.mm.mysql.Driver").newInstance();
            //remotemysql.com:
            cnn = DriverManager.getConnection("jdbc:mysql://20.110.160.147:3306/AppDB","admin","password");


        }catch(Exception e){

        }
        return cnn;
    }
}
