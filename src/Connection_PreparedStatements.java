import java.sql.*;

public class Connection_PreparedStatements {

    // final - makes string variable immutable / cannot be overridden
    private static final String Url = "jdbc:mysql://localhost:3306/jdbc_crud";

    //
    private static final String username = "root";

    //
    private static final String password = "Kd123@123";


    public static void main(String[] args) {

        try {
            // Load and register the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

        } catch (ClassNotFoundException e) {
            System.out.println("ERROR1** : " + e.getMessage());
        }

        try {
            //create Connections via Connection Interface
            Connection connection = DriverManager.getConnection(Url, username, password);
            //use Statement Interface and execute method of Connection interface
            Statement statement = connection.createStatement();
            // now we have to perform Crud Operation using this statement interface only
            // **PREPARED STATEMENTS ** //
            String Query = "INSERT INTO Students(name , age , marks) VALUES(?,?,?)";
            PreparedStatement preparedQuery = connection.prepareStatement(Query);
            preparedQuery.setString(1,"KD");
            preparedQuery.setInt(2,25);
            preparedQuery.setDouble(3,99.5);

            int rows_added = preparedQuery.executeUpdate();

            if(rows_added>0){
                System.out.println("Added Successfully");
            }else System.out.println("FAILED");




        } catch (SQLException e) {
            System.out.println("ERROR2** : " + e.getMessage());
        }

    }
}
