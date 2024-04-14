package jdbc;
import java.sql.*;

public class JDBCPostreSQL {
    public static void main(String[] args) {
        /*
         import package-> load driver-> register driver-> create connection-> create statement-> execute statement-> close
        */

        try{
            Class.forName("org.postgresql.Driver"); //otional to load driver, it automatically loads driver

            final String url = "jdbc:postgresql://localhost:5432/Student";
            final String username = "postgres";
            final String password = "0000";
            String sql = "insert into student values (?,?,?,?)";
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("connection established successfully");

            /*
            final String query = "select * from student";
              Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            resultSet.next(); //points at first row
            System.out.println(resultSet.getString("name"));

            to print more rows
            while(resultSet.next()){
                System.out.println(resultSet.getString("name" or columnno));
                resultSet.getString("name" or columnno) if column holds string
                resultSet.getInt("name" or columnno) if column holds int ...as so on
                //other print statements here
            }
            */
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,4); //setInt for datatype of column, (column number, value)
            statement.setString(2, "Chandan");
            statement.setInt(3,8981);
            statement.setString(4,"E");
            
            statement.execute();
            connection.close();


           
        }catch(Exception e){
            System.out.println("this is error "+e);
        }
    }
}
