
import java.sql.*;

public class JdbcExample {
    public static void main(String[] args) {

        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kcs", "root", "");
        } catch (SQLException e) {
            System.out.println("Ivyko klaida "+ e);
        }

        if (connection !=null);
        {
            System.out.println("Prisijungeme!");
            try {
                Statement statement = connection.createStatement();

               ResultSet resultSet = statement.executeQuery("select  * from students");

               while (resultSet.next()){
                   System.out.println(resultSet.getString("Name" ) + " " + resultSet.getString("Surname") + " " + resultSet.getString("Phone")+ " " + resultSet.getString("email"));
               }


            } catch (SQLException e) {
                e.printStackTrace();
            }
        }





    }










}
