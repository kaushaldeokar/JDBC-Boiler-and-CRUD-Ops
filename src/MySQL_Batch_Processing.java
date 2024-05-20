import java.sql.*;
import java.util.Scanner;

public class MySQL_Batch_Processing {

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

            // now we have to perform Crud Operation using this statement interface only

            //***Batch Processing***//

            //USING NORMAL STATEMENTS//
            Statement statement = connection.createStatement();
            Scanner scan = new Scanner(System.in);

            while(true){
                String name = scan.nextLine();
                int age = scan.nextInt();
                double marks = scan.nextDouble();
                System.out.println("Want to enter more data (0/1) : ");
                int choice =scan.nextInt();

                String query = String.format("INSERT into Students (name , age , marks) Values ('%s',%d,%f)",name,age , marks);
                statement.addBatch(query);

                if(choice==0)break;

            }
            //***will result in return of array ***//
            // will result in boolean array particular row is added or not //
            int[]  rows_added = statement.executeBatch();

            boolean check_if_all_rows_added = true;
            for ( int i=0 ;i<rows_added.length;i++){
                if(rows_added[i]==0){
                    check_if_all_rows_added = false;
                    System.out.println(i+1 + " data not added");
                }
            }

            if(check_if_all_rows_added == true){
                System.out.println(" data added Succesfully");
            }






        } catch (SQLException e) {
            System.out.println("ERROR2** : " + e.getMessage());
        }

    }

}
