package moviedatabase;
import java.sql.*;

public class MovieDatabase {

    public static void main(String[] args) throws Exception{
        getAllMovieDetails();
        getMoviesByActorName("Leonardo DiCaprio");
    }
    
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/moviedatabase";
            String user = "root";
            String password = "Sep@2001";
            Connection con = DriverManager.getConnection(url, user, password);
            return con;
        } catch(Exception e) {
            return null;
        }
    }
    
    public static void getAllMovieDetails() {
        try {
            Connection con = getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from movies");
            while(rs.next()) {
                System.out.println("------------------------------");
                System.out.println("Movie: "+rs.getString(1)+"\nActor: "+rs.getString(2)+"\nActress: "+rs.getString(3)+"\nRelease Date: "+rs.getString(4)+"\nDirector: "+rs.getString(5));
            }
        } catch(Exception e) {
            System.err.println("Error occured");
        }
    }
    
    public static void getMoviesByActorName(String actor_name) {
        try {
            Connection con = getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from movies where actor='"+actor_name+"'");
            while(rs.next()) {
                System.out.println("------------------------------");
                System.out.println("Movie: "+rs.getString(1)+"\nActor: "+rs.getString(2)+"\nActress: "+rs.getString(3)+"\nRelease Date: "+rs.getString(4)+"\nDirector: "+rs.getString(5));
            }
        } catch(Exception e) {
            System.err.println("Error occured");
        }
    }
}
