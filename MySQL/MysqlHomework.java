package MySQL;

import java.sql.*;
import java.util.Scanner;

public class MysqlHomework {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/bookstore";
    private static final String USER = "root";

    public static void main(String[] args) {
        System.out.println("请输入密码");
        String PASSWORD = new Scanner(System.in).next();

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
            System.out.println("Connected to the database");

            String sqlAdd = "INSERT INTO my_table (store_name,Sales,Date)values(?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlAdd);
            preparedStatement.setString(1, "Los Angeles");
            preparedStatement.setInt(2, 1500);
            preparedStatement.setDate(3, Date.valueOf("1999-01-09"));
            preparedStatement.addBatch();

            preparedStatement.setString(1, "San Diego");
            preparedStatement.setInt(2, 250);
            preparedStatement.setDate(3, Date.valueOf("1999-01-07"));
            preparedStatement.addBatch();

            preparedStatement.setString(1, "Los Angeles");
            preparedStatement.setInt(2, 300);
            preparedStatement.setDate(3, Date.valueOf("1999-01-08"));
            preparedStatement.addBatch();

            preparedStatement.setString(1, "Boston");
            preparedStatement.setInt(2, 700);
            preparedStatement.setDate(3, Date.valueOf("1999-01-08"));
            preparedStatement.addBatch();
            preparedStatement.executeBatch();
            String sqlQuery = "SELECT * FROM my_table";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            int columns = resultSet.getMetaData().getColumnCount();
            for (int i = 1; i <= columns; i++) {
                System.out.printf("%-12s", resultSet.getMetaData().getColumnName(i));
            }
            System.out.println();
            for (int i = 1; i <= columns; i++) {
                System.out.print("------------");
            }
            System.out.println();
            while (resultSet.next()) {
                String bookstore = resultSet.getString("store_name");
                int scale = resultSet.getInt("Sales");
                String date = resultSet.getString("Date");
                System.out.printf("%-12s%-12d%-12s", bookstore, scale, date);
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
