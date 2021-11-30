import java.sql.*;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    static String pathToDB;
    static Connection conn;


    public static void main(String[] args) throws SQLException {
         createTables();
       //  dropTables();
       // insertColor();
       selectAllColors();


    }
// CREATE COLOR
    public static void insertColor() throws SQLException {
        connect();

        System.out.println("Write a color and press enter:");
        Scanner sc = new Scanner(System.in);
        String color = sc.next().trim().toUpperCase(Locale.ROOT);
        System.out.println("What is the level you like this color (from 1 to 5):");
        int grade = sc.nextInt();
        System.out.println("What is your name, please?");
        String person = sc.next().trim().toUpperCase(Locale.ROOT);

        String sql = "INSERT INTO color (name, grade) VALUES (?,?)";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        String sql2 = "INSERT INTO record (person_name, color_id) VALUES (?,(SELECT color_id FROM color WHERE color_id = (SELECT MAX(color_id) FROM color)))";
        PreparedStatement preparedStatement2 = conn.prepareStatement(sql2);

        preparedStatement.setString(1,color);
        preparedStatement.setInt(2,grade);
        preparedStatement2.setString(1,person);

        int done = preparedStatement.executeUpdate();
        if(done == 1) {
            System.out.println("Your value has been saved to DB");
        }else{
            System.out.println("Unsuccessful action");
        }
        conn.close();
    }

// SELECT ALL
    public static void selectAllColors() throws SQLException {
        connect();
        String sql = "SELECT * FROM color";

        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.execute();

        ResultSet result = preparedStatement.getResultSet();

        while (result.next()) {
            System.out.println(result.getInt(1) + " color: " + result.getString("name") + " is graded: " + result.getInt(3));
        }
        result.close();
        preparedStatement.close();
        conn.close();


    }

// CREATING TABLES
    public static void createTables() throws SQLException {
        connect();
        String sql = "CREATE TABLE IF NOT EXISTS color (color_id INTEGER PRIMARY KEY,\n" +
                "                name TEXT NOT NULL,\n" +
                "                grade INTEGER NOT NULL)";
        String sql2 = "CREATE TABLE IF NOT EXISTS record(\n" +
                "                record_id INTEGER PRIMARY KEY,\n" +
                "                person_name TEXT NOT NULL,\n" +
                "                color_id INTEGER,\n" +
                "                FOREIGN KEY (color_id)\n" +
                "                REFERENCES color (color_id)\n" +
                "                ON DELETE CASCADE\n" +
                "                ON UPDATE CASCADE\n" +
                "        )";

        Statement statement = conn.createStatement();
        statement.addBatch(sql);
        statement.addBatch(sql2);
        statement.executeBatch();
        statement.close();
        conn.close();
    }

// DROPPING TABLES
    public static void dropTables() throws SQLException {
        connect();
        String sql = "DROP TABLE IF EXISTS color";
        String sql2 = "DROP TABLE IF EXISTS record";
        Statement statement = conn.createStatement();
        statement.addBatch(sql);
        statement.addBatch(sql2);
        statement.executeBatch();
        statement.close();
        conn.close();
    }

// CREATING CONNECTION
    public static void connect() {
        pathToDB = "seven.db";
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:"+pathToDB);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
