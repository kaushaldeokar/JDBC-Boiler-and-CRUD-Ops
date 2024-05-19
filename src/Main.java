import java.sql.*;


public class Main {

    // final - makes string variable immutable / cannot be overridden
    private static final String Url= "jdbc:mysql://localhost:3306/jdbc_crud";

    //
    private static final String username= "root";

    //
    private static final String password= "Kd123@123";


    public static void main(String[] args) {

        try{
            // Load and register the MySQL driver
            Class.forName("com.mysql.cj.jdbc.Driver");

        }catch (ClassNotFoundException e){
            System.out.println("ERROR1** : "+e.getMessage());
        }

        try {
            //create Connections via Connection Interface
            Connection connection = DriverManager.getConnection(Url,username,password);
            //use Statement Interface and execute method of Connection interface
            Statement statement  = connection.createStatement();
            // now we have to perform Crud Operation using this statement interface only
            String query = "select * from Students";
            //when ever we are retriving data extecute Qurey else Update Query
            // To hold the table Result Set Interface helps in
            ResultSet  resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("ID : "+id);
                System.out.println("Name : "+name);
            }

        }catch (SQLException e){
            System.out.println("ERROR2** : "+e.getMessage());
        }

    }
}