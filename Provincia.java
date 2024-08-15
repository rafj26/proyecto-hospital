import java.sql.*;
import javax.swing.*;

public class Provincia
{

    String sql;
    ResultSet rs;

    public void cargar_cb(JComboBox<String> cb)
    {

        try
        {
             DB bd = new DB();
             sql = "select * from provincia";
             rs = bd.executeQuery(sql);
             while (rs.next())
             {
                 cb.addItem(rs.getString("descripcion"));
             }
             bd.cerrar();
        }
        catch(Exception e)
        {
            System.out.println("error provincia " + e.toString());
        }        
    }


}
