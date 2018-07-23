import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Jdbs2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int id = getCorrectNumber(scanner, "Iveskite ID");

        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/kcs", "root", "");


        } catch (SQLException e) {
            System.out.println("Ivyko prisijungimo klaida" + e);
        }


        if (connection != null) {
            System.out.println("ivyko prisijungimas");
            try {
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM Students WHERE ID =" +id);
                resultSet.next();
                System.out.println(resultSet.getString("name") +" " + resultSet.getString("email"));



            } catch (SQLException e) {
                e.printStackTrace();
            }

        }



        }


    public static int getCorrectNumber(Scanner sc, String message) {
        int result;
        while (true) {

            System.out.println(message);
            try {
                result = sc.nextInt();
                sc.nextLine();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Nepavyko pakartokit");
                sc.nextLine();

            }

        }
        return result;
    }
}
