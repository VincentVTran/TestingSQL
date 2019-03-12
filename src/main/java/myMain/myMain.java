package myMain;

import java.sql.*;

public class myMain {
    static Connection connection;
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/test";
        String username = "root";
        String password = "";

        connection = DriverManager.getConnection(url, username, password);
        System.out.println("Worked");
        Statement invoke = connection.createStatement();


        //Insert data
        invoke.executeUpdate("INSERT INTO students VALUE (6, 'Filber', 'CS');");

        //Grab data and stores into result set
        ResultSet rs = invoke.executeQuery("SELECT name FROM students;");
        while(rs.next()){
            System.out.println(rs.getString(1));
        }

        //Closing
        rs.close();
        invoke.close();
        connection.close();
    }
}
