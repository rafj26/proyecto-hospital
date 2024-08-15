import java.sql.*;
 
public class DB {
    private Connection connection;
    private String url,pass,user;
    PreparedStatement pst;
    ResultSet rs;
    public DB() {
        url = "jdbc:mysql://localhost:3306/semestral";
        pass = "root";
        user = "root";
    }
 
    public void abrir(){
        try {
            connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }
    public ResultSet executeQuery(String sql){
        try{
         pst = connection.prepareStatement(sql);
         rs = pst.executeQuery();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return rs;
    }

    public void cerrar(){
        try{
        connection.close();
        if (rs != null) rs.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}