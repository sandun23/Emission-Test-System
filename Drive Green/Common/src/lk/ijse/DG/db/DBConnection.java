package lk.ijse.DG.db;


import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static DBConnection dbConnection;
    private Connection  connection;

    public DBConnection() throws SQLException, IOException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        FileReader fileReader=new FileReader("D:\\IJSE\\2nd Sem Final Project\\Drive Green\\Common\\src\\lk\\ijse\\DG\\db\\dbc.properties");
        Properties properties=new Properties();
        properties.load(fileReader);
        String ip=properties.getProperty("ip");
        String port=properties.getProperty("port");
        String user=properties.getProperty("user");
        String password=properties.getProperty("password");
        String db=properties.getProperty("db");
        String jdbcUrl = "jdbc:mysql://" + ip + ":" + port + "/" + db;

        connection= DriverManager.getConnection(jdbcUrl,user,password);
    }

    public static DBConnection getInstance() throws SQLException, IOException, ClassNotFoundException {
        if (dbConnection==null){
            dbConnection=new DBConnection();
        }
        return dbConnection;
    }
    public Connection getConnection(){
        return connection;
    }
}

