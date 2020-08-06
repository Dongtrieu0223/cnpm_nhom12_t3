package lol.work.stop.DB;

import java.sql.*;

public class ConnectionDB {
    private static Connection con;

    public static Statement connect() throws ClassNotFoundException, SQLException  {
        if (con==null||con.isClosed()) {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf-8", "root", "");
            return con.createStatement();
        } else {
            return con.createStatement();
        }

    }

    public static PreparedStatement getPreparedStatement(String query) throws ClassNotFoundException, SQLException  {
        if (con==null||con.isClosed()) {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user?useUnicode=true&characterEncoding=utf-8", "root", "");
            return con.prepareStatement (query);
        } else {
            return con.prepareStatement (query);
        }
    }

}
