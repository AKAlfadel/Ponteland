package choreotype;

import java.util.ArrayList;
import java.util.List;

public class ChoreManager {
    private List<Chore> choresList;
    private List<User> usersList;
    private Database database;

    public ChoreManager() {
        database = new Database();
        database.openConnection();
        database.createTables();
        usersList = database.loadUsers();
        choresList = database.loadChores();
    }

    public List<Chore> getChoresList() {
        return choresList;
    }

    public List<User> getUsersList() {
        return usersList;
    }

      public void addChore(Chore chore) {
        choresList.add(chore);
        database.saveChore(chore);
    }

    public void updateChore(Chore chore) {
        chore.updateChore();
    }

    public void deleteChore(Chore chore) {
        choresList.remove(chore);
        chore.deleteChore();
    }

    public void addUser(User user) {
        usersList.add(user);
        database.saveUser(user);
    }

    public void updateUser(User user) {
        user.updateUser();
    }

    public void deleteUser(User user) {
        usersList.remove(user);
        user.deleteUser();
    }

    public void closeDatabaseConnection() {
        database.closeConnection();
    }
}

