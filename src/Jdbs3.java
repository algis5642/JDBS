import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Jdbs3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("iveskite nauja varda!");
        String Name1 = scanner.nextLine();
        System.out.println("iveskite nauja pavarde!");
        String Surname1 = scanner.nextLine();
        System.out.println("Iveskite Telefona");
        String phone = scanner.nextLine();
        System.out.println("emailas");
        String email = scanner.nextLine();
        int id = getCorrectNumber(scanner, "Iveskite ID Kuri norite atnaujinti");

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
                int resultSet = statement.executeUpdate("UPDATE Students SET NAME = '"+Name1+"', Surname= '"+Surname1+"', " +
                                 "phone='" +phone+"', email='" + email+"' where id=" +id);

                ResultSet resultSet1 = statement.executeQuery("SELECT * FROM Students where id ="+ id);
                resultSet1.next();
                System.out.println(resultSet1.getString("name") + " " + resultSet1.getString("surname") + " " + );


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
