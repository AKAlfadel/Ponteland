package choreotype;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Database {
    private Connection dbConnection;

    public void openConnection() {
        try {
            Class.forName("org.sqlite.JDBC");
            dbConnection = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\thema\\Desktop\\SOFTWARE ENGINEERING PRACTICE\\ASSIGN2\\ProjectDB.db");
        } catch (ClassNotFoundException | SQLException e) {
        }
    }

    public void closeConnection() {
        try {
            if (dbConnection != null) {
                dbConnection.close();
            }
        } catch (SQLException e) {
        }
    }

    public void createTables() {
    String createUserTable = "CREATE TABLE IF NOT EXISTS users (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "username TEXT NOT NULL," +
            "password TEXT NOT NULL," +
            "role TEXT NOT NULL" +
            ");";
    
    String createChoreTable = "CREATE TABLE IF NOT EXISTS chores (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT," +
            "name TEXT NOT NULL," +
            "description TEXT NOT NULL," +
            "in_use BOOLEAN NOT NULL," +
            "assigned_to INTEGER," +
            "completed BOOLEAN NOT NULL" +
            ");";
    
    // Add more table creation queries for other entities, if necessary
    
    executeUpdate(createUserTable);
    executeUpdate(createChoreTable);
}

    // ... (other methods)

    // Method for executing a query and returning a ResultSet
    public ResultSet executeQuery(String sql) {
        try {
            Statement stmt = dbConnection.createStatement();
            return stmt.executeQuery(sql);
        } catch (SQLException e) {
            return null;
        }
    }

    // Method for executing an update and returning the number of affected rows
    public int executeUpdate(String sql) {
        try {
            Statement stmt = dbConnection.createStatement();
            return stmt.executeUpdate(sql);
        } catch (SQLException e) {
            return 0;
        }
    }

    // Method for loading users from the database
    public List<User> loadUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (ResultSet rs = executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String role = rs.getString("role");
                users.add(new User(id, username, password, role));
            }
        } catch (SQLException e) {
        }
        return users;
    }

    // Method for saving a list of users to the database
    public void saveUsers(List<User> users) {
        for (User user : users) {
            // Update the user in the database
            updateUser(user);
        }
    }

    // Method for loading chores from the database
    public List<Chore> loadChores() {
        List<Chore> chores = new ArrayList<>();
        String sql = "SELECT * FROM chores";
        try (ResultSet rs = executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                boolean inUse = rs.getBoolean("in_use");
                int assignedTo = rs.getInt("assigned_to");
                boolean completed = rs.getBoolean("completed");
                chores.add(new Chore(id, name, description, inUse, assignedTo, completed));
            }
        } catch (SQLException e) {
        }
        return chores;
    }

    // Method for saving a list of chores to the database
    public void saveChores(List<Chore> chores) {
        for (Chore chore : chores) {
            // Update the chore in the database
            updateChore(chore);
        }
    }
    
    

    // ... (other methods)

    private void updateUser() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void updateChore() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}