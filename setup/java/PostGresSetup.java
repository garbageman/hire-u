import java.sql.*;
import org.postgresql.*;
import java.util.Map;
import java.util.HashMap;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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

  public static Connection getConnection() {
    Connection connection = null;
    try {
        connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hireu","hireu", "dev");
    } catch (SQLException e) {
        System.out.println("Connection Failed! Check output console");
        e.printStackTrace();
        return null;
    }

    if (connection != null) {
        return connection;
    } else {
        System.out.println("Failed to make connection!");
        return null;
    }
  }

  public static void createTable(String tableName, Map<String,String> attributes) {
    /* Create a connection with the local postgres instance */
    Connection connection = getConnection();
    Statement stmt = null;

    System.out.println("Dropping table " + tableName);

    String drop_table = "drop table " + tableName;

    try {
        stmt = connection.createStatement();
        stmt.execute(drop_table);
        stmt.close();
    } catch (SQLException e ) {
        System.out.println(e);
    }

    System.out.println("Creating table " + tableName);

    /* Create the sql statement to execute based on the parameters */
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

  public static void fillTable(String file, String tableName) {
    try (BufferedReader br = new BufferedReader(new FileReader(new File(file)))) {
      String line;
      line = br.readLine();
      if (line == null) {
        System.out.println("File is empty");
        return;
      }

      /* Line is not null, parse it */
      String attributes = line;

      while ((line = br.readLine()) != null) {
        saveRow(tableName, attributes, line.split(", "));
      }
    } catch (FileNotFoundException f) {
			System.out.println("CSV file was not found please specify a correct path");

			return;
		} catch (IOException i) {
			System.out.println("Error reading from the csv file");

			return;
		}

  }

  public static void saveRow(String tableName, String attributes, String[] values) {
     Connection connection = getConnection();

     /* Create the sql statement to execute based on the parameters */
     Statement stmt = null;

     String v = "";
     for (int i = 0; i < values.length; i++) {
       v = v + "\'" + values[i] + "\', ";
     }

     String insert = "insert into " + tableName +
                     " ( " + attributes +
                     " ) values ( " +
                     v.substring(0,v.length() - 2) + " );";

      System.out.println("Statement: " + insert);

      try {
          stmt = connection.createStatement();
          stmt.execute(insert);
          stmt.close();
      } catch (SQLException e ) {
          System.out.println(e);
      }
  }

  public static void main(String[] argv) {
        System.out.println("Setting up the HireU database");

        /* Initial test table setup */
        HashMap<String,String> testAttributes = new HashMap<String,String>();
        testAttributes.put("campus", "varchar(255)");
        testAttributes.put("name", "varchar(255)");
        testAttributes.put("location", "varchar(255)");

        createTable("department",testAttributes);

        /* Fill the table from file */
        fillTable("/CMSC/HireU/webapp/setup/files/departments.csv", "department");

  }

}
