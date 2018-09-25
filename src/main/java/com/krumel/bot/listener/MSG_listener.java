package com.krumel.bot.listener;



import java.sql.*;

public class MSG_listener{
    public static void main (String [] args ) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
       final String hostname = "www.heinz-lukas.de";
       final String user = "discord";
       final String dbname = "discord";
       final String password = "2FR12§!3=f";
       final String port = "3306";
        Connection conn = null;
        try {
            System.out.println("* Treiber laden");
            Class.forName("org.gjt.mm.mysql.Driver").newInstance();
        }
        catch (Exception e) {
            System.err.println("Unable to load driver.");
            e.printStackTrace();
        }
        try {
            System.out.println("* Verbindung aufbauen");
            String url = "jdbc:mysql://"+hostname+":"+port+"/"+dbname;
            conn = DriverManager.getConnection(url, user, password);

            System.out.println("* Datenbank-Verbindung beenden");
            conn.close();
        }
        catch (SQLException sqle) {
            System.out.println("SQLException: " + sqle.getMessage());
            System.out.println("SQLState: " + sqle.getSQLState());
            System.out.println("VendorError: " + sqle.getErrorCode());
            sqle.printStackTrace();
        }

    } // ende: public static void main(

    }