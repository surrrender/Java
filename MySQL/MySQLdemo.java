package MySQL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLdemo {
    // JDBC URL, username, and password of MySQL server
    //协议+数据库的服务器号+监听的端口号+数据库名称
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/mydemo";
    private static final String USER = "root";
    private static final String PASSWORD = "szll987612345";

    public static void main(String[] args) {

        // Step 1: Establishing a connection
        //注意DriverManager这类就是我们导入到项目的那个jar包所包含的，这个包使得我们可以建立起于数据库之间的联系
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USER, PASSWORD)) {
            System.out.println("Connected to the database");

            String headOftable ="DESCRIBE my_table";
            // Step 2: Creating a PreparedStatement
            String sqlQuery = "SELECT * FROM my_table";
            //只有Statement对象才能被执行，因此写好的查询字符串要交给Statement对象来执行
            Statement statement = connection.createStatement();
//            ResultSet resultSet1 = statement.executeQuery(headOftable);
//            ArrayList<String> columns = new ArrayList<String>();
//            while(resultSet1.next()) {
//                columns.add(resultSet1.getString(1));
//            }
//            System.out.printf("")
            ResultSet resultSet = statement.executeQuery(sqlQuery);
            int columnCount = resultSet.getMetaData().getColumnCount();

            for(int i =1;i<=columnCount;i++){
                System.out.printf("%-12s",resultSet.getMetaData().getColumnName(i));
            }
            System.out.println();
            for(int i=1;i<=columnCount;i++){
                System.out.print("----------");
            }
            System.out.println();
            while(resultSet.next()){
                 int studentId = resultSet.getInt("id");
                 String studentName = resultSet.getString("name");
                 int studentAge = resultSet.getInt("age");
                 System.out.printf("%-10d%-10s%-10d",studentId,studentName,studentAge);
                 System.out.println();
            }
            //            try (PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery)) {
//                // Setting a parameter for the SQL query
//                int minimumAge = 20;
//                preparedStatement.setInt(1, minimumAge);
//
//                // Step 3: Executing the query
//                try (ResultSet resultSet = preparedStatement.executeQuery()) {
//                    // Step 4: Processing the results
//                    while (resultSet.next()) {
//                        int studentId = resultSet.getInt("student_id");
//                        String studentName = resultSet.getString("name");
//                        int studentAge = resultSet.getInt("age");
//
//                        System.out.println("Student ID: " + studentId + ", Name: " + studentName + ", Age: " + studentAge);
//                    }
//                }
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
