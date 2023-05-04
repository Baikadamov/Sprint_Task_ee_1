package kz.biltlab.narxoz.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DBConnection {
  private static Connection connection;


  static {
    String url = "jdbc:postgresql://localhost:5432/sprinttask2";
    String user = "postgres";
    String password = "12345";
    try {
      Class.forName("org.postgresql.Driver");
      connection = DriverManager.getConnection(url, user, password);

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static ArrayList<Items> getItems() {
    ArrayList<Items> items = new ArrayList<>();
    try {
      PreparedStatement statement = connection.prepareStatement(
          "SELECT * FROM Items ORDER by id asc"
      );

      ResultSet resultSet = statement.executeQuery();

      while (resultSet.next()) {
        Items item = new Items();
        item.setId(resultSet.getLong("id"));
        item.setName(resultSet.getString("name"));
        item.setDescription(resultSet.getString("description"));
        item.setPrice(resultSet.getDouble("price"));

        items.add(item);
      }
      statement.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return items;
  }

  public static void addItem(Items item) {
    try {
      PreparedStatement statement = connection.prepareStatement("INSERT INTO items (name,description,price) " +
          "VALUES (?,?,?)");
      statement.setString(1, item.getName());
      statement.setString(2, item.getDescription());
      statement.setDouble(3, item.getPrice());

      statement.executeUpdate();
      statement.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static Items getItem(int id) {
    Items item = null;
    try {
      PreparedStatement statement = connection.prepareStatement("" +
          "SELECT * from items WHERE id = ? LIMIT 1");
      statement.setInt(1, id);

      ResultSet resultSet = statement.executeQuery();

      if (resultSet.next()) {
        item = new Items();
        item.setId(resultSet.getLong("id"));
        item.setName(resultSet.getString("name"));
        item.setDescription(resultSet.getString("description"));
        item.setPrice(resultSet.getDouble("price"));

      }

      statement.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
    return item;
  }

  public static void updateItem(Items item) {
    try {
      PreparedStatement statement = connection.prepareStatement("" +
          "UPDATE items " +
          "SET name=?," +
          "description=?," +
          "price=?" +
          "WHERE id = ?");
      statement.setString(1, item.getName());
      statement.setString(2, item.getDescription());
      statement.setDouble(3, item.getPrice());
      statement.setDouble(4, item.getId());
      statement.executeUpdate();
      statement.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void deleteItem(int id) {
    try {
      PreparedStatement statement = connection.prepareStatement("" +
          "DELETE FROM items WHERE id = ?");
      statement.setInt(1, id);
      statement.executeUpdate();
      statement.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  public static Users getUser(String email){
    Users users = null;
    try {
      PreparedStatement statement = connection.prepareStatement(" "+ "SELECT * FROM users WHERE email = ?");
      statement.setString(1,email);
      ResultSet resultSet = statement.executeQuery();
      if(resultSet.next()){
        users = new Users();
        users.setId(resultSet.getLong("id"));
        users.setEmail(resultSet.getString("email"));
        users.setPassword(resultSet.getString("password"));
        users.setFullName(resultSet.getString("full_Name"));
      }
      statement.close();
    }catch (Exception e){
      e.printStackTrace();
    }
    return users;
  }

}
