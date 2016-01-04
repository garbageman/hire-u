import java.sql.*;
import org.postgresql.*;
import java.util.Map;
import java.util.HashMap;

/**
 * This class will set up all of the necessary tables in the local
 * postgres instance.
 * Before running this program, the developer must create a hireu user in
 * the local postgres instance and create a hireu database
 * @author damien
 */

public class PostGresSetup {

  /**
   * This method will create a table in the hireu database
   * The map supplied should be attribute name -> type
   * @param tableName
   * @param attributes
   */

  public static void createTable(String tableName, Map<String,String> attributes) {
    /* Create a connection with the local postgres instance */
    Connection connection = null;
    try {
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hireu","hireu", "production");
    } catch (SQLException e) {
        System.out.println("Connection Failed! Check output console");
        e.printStackTrace();
        return;
    }

    if (connection != null) {
        System.out.println("Connected to database, creating tables");
    } else {
        System.out.println("Failed to make connection!");
        return;
    }

    System.out.println("Creating table " + tableName);

    /* Create the sql statement to execute based on the parameters */
    Statement stmt = null;
    String create_table = "create table " + tableName + " ( ";

    /* Generate create statement based on map */
    for (String s : attributes.keySet()) {
      create_table = create_table + s + " " + attributes.get(s) + ", ";
    }

    /* Add on the final part of the create statement and get rid of last comma */
    create_table = create_table.substring(0, create_table.length() - 2) + " );";

    /* Sanity check for statement to be executed */
    System.out.println("Statement: " + create_table);

    /* Run the statement to create the table */
    try {
        stmt = connection.createStatement();
        stmt.execute(create_table);
        stmt.close();
    } catch (SQLException e ) {
        System.out.println(e);
    }

    System.out.println("Successfully created table " + tableName);

  }

  public static void main(String[] argv) {
        System.out.println("Setting up the HireU database");

        /* Initial test table setup */
        HashMap<String,String> testAttributes = new HashMap<String,String>();
        testAttributes.put("Val1", "int");
        testAttributes.put("Val2", "varchar(255)");
        testAttributes.put("Val3", "int");

        createTable("test",testAttributes);
  }

}
