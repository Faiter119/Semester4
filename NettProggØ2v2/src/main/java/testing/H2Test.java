package testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class H2Test {

    public static void main(String[] a) throws Exception {
        Class.forName("org.h2.Driver");
        Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");

        //conn.createStatement().execute("drop table Users");
        //conn.createStatement().execute("Create table if not EXISTS Users(accountNr INTEGER PRIMARY KEY ,balance DOUBLE , ownerName VARCHAR )");

        //conn.createStatement().execute("insert into Users VALUEs (101, 1, 'Olav Reppe Husby');");


        ResultSet resultSet = conn.createStatement().executeQuery("select * from USERs ;");

        ResultSetMetaData metaData = resultSet.getMetaData();

        while (resultSet.next()){

            System.out.println(resultSet.getInt("accountNr")+" - "+resultSet.getDouble("balance")+" - "+resultSet.getString("ownerName"));

        }

        conn.close();
    }
}