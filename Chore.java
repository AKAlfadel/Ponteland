package choreotype;



public class Chore {
    private int id;
    private String name;
    private String description;
    private boolean inUse;
    private int assignedTo;
    private boolean completed;

    public Chore(int id, String name, String description, boolean inUse, int assignedTo, boolean completed) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.inUse = inUse;
        this.assignedTo = assignedTo;
        this.completed = completed;
    }

    // Getters and setters for the attributes

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isInUse() {
        return inUse;
    }

    public void setInUse(boolean inUse) {
        this.inUse = inUse;
    }

    public int getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(int assignedTo) {
        this.assignedTo = assignedTo;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    //Methods for Chore.java
    
    // createChore()
    public static Chore createChore(String name, String description, boolean inUse, int assignedTo, boolean completed) {
        // Use your Database class to insert a new chore into the database
        // and retrieve the generated id for the new chore
        Database db = new Database();
        db.openConnection();
        int id = db.insertChore(name, description, inUse, assignedTo, completed);
        db.closeConnection();

        return new Chore(id, name, description, inUse, assignedTo, completed);
    }

    // updateChore()
    public void updateChore() {
        // Use your Database class to update the chore record in the database
        Database db = new Database();
        db.openConnection();
        db.updateChore(this);
        db.closeConnection();
    }

    // deleteChore()
    public void deleteChore() {
        // Use your Database class to delete the chore record from the database
        Database db = new Database();
        db.openConnection();
        db.deleteChore(this);
        db.closeConnection();
    }

    // assignChore()
    public void assignChore(int userId) {
        this.setAssignedTo(userId);
        // Use your Database class to update the assignedTo field for the chore record in the database
        Database db = new Database();
        db.openConnection();
        db.updateChoreAssignedTo(this, userId);
        db.closeConnection();
    }

    // markAsComplete()
    public void markAsComplete() {
        this.setCompleted(true);
        // Use your Database class to update the completed field for the chore record in the database
        Database db = new Database();
        db.openConnection();
        db.updateChoreCompleted(this);
        db.closeConnection();
    }
}