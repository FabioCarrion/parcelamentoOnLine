package bethaCode.javaspringideaparcelamentoonLine;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager{

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://ec2-44-196-68-164.compute-1.amazonaws.com:5432/d96lj43ae85kli";
        Connection conn = DriverManager.getConnection(url, "ndfynhwaxijqcj", "5d252a890415017eee5677daed92af706a33d661394e0844bc9fcb6d9b42c8f4");
        return conn;
    }

}