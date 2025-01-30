import java.util.ArrayList;

// definition of UserNode class
class UserNode {
    // declaring the attributes of this class
    private String userID, name;
    private int age;
    private ArrayList<String> friends;
    UserNode next;

    // created a parameterized constructor to initialize the object
    UserNode(String userID, String name, int age) {
        this.userID = userID;
        this.name = name;
        this.age = age;
        this.friends = new ArrayList<>();
    }

    // created getter methods to maintain encapsulation and data security
    public String getName()     {   return this.name;   }

    public String getUserID()   {   return this.userID;  }

    public int getAge() {  return this.age;    }

    public ArrayList<String> getFriends() {   return this.friends;  }
}

// definition of User class
class User {
    // declaring the attributes of this class
    UserNode head; // head of the linked list
    static int totalUsers=0;
    
    // created a non parameterized constructor
    User() {}
    
    // created a parameterized constructor to initialize a linked list of Users
    User(String userID, String name, int age) {
        head = new UserNode(userID, name, age);
        totalUsers++;
    }

    // created a method to display all User records
    public void displayAllRecords() {
        UserNode user = head;
        while (user != null) {
            System.out.println("Name of the User: " + user.getName() + "\nUserID: " + user.getUserID() + "\nAge: " + user.getAge() + "\n");
            System.out.println("Number of friends of " + user.getName() + " is: " + user.getFriends().size());
            displayFriends(user.getUserID());
            user = user.next;
        }
    }

    // created a method addNewUser to add a new User at the end of the list
    public void addUser(String userID, String name, int age) {
        addUser(userID, name, age, totalUsers+1);
    }

    // created a method to add a record at any position of the list including the beginning and end position
    public void addUser(String userID, String name, int age, int position) {
        if (!checkId(userID)) { // if user already exists
            System.out.println("User with ID " + userID + " already exists.");
            return;
        }

        if (position == 1) { // if user wants to add a record at the beginning
            UserNode newUser = new UserNode(userID, name, age);
            newUser.next = head;
            head = newUser;
            totalUsers++;
            return;
        }

        // if the inserting position is not the beginning
        UserNode User1 = head;
        UserNode User2 = null;

        // created an integer variable to iterate through the list till we reach to the position
        int i=1; //2
        while (i<position) { // after this loop we have to insert the new record between User1 and User2 nodes
            if (User1 == null){ // means User2 is already at the last position  
                System.out.println("Invalid insert position!!");
                return;
            }
            User2 = User1;
            User1 = User1.next;
            i++;
        }

        // initializing a new User record
        UserNode newUser = new UserNode(userID, name, age);

        // inserting the new record between User1 and User2
        newUser.next = User1;
        User2.next = newUser;
        totalUsers++;
    }

    // created a method to check if id is available or not
    public boolean checkId(String id) {
        UserNode current = head;
        while (current != null) {
            if (current.getUserID().equals(id)) {
                return false;
            }
            current = current.next;
        }
        return true;
    }

    // created a method to search a record by name or user id
    public void searchUser(String userIDOrName) {
        // iterator for the list
        UserNode user = head;

        while (user != null) { // with this loop User1 will reach to the position that is required
            if (user.getUserID().equals(userIDOrName) || user.getName().equals(userIDOrName)) {
                System.out.println("Name of the User: " + user.getName() + "\nUserID: " + user.getUserID() + "\nAge: " + user.getAge() + "\n");
                System.out.println("Number of friends of " + user.getName() + " is: " + user.getFriends().size());
                displayFriends(user.getUserID());                return;
            }
            user = user.next;
        }
        System.out.println("user does not exist.");
    }

    // created a method to find the friend using the user id
    UserNode findFriend(String friendId) {
        UserNode current = head;
        while (current != null) {
            if (current.getUserID().equals(friendId)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }


    // created a method to add the connection between the two user
    void addConnection(String user1Id, String user2Id) {
        if (user1Id.equals(user2Id)) {
            System.out.println("A user cannot be friends with themselves.");
            return;
        }
        UserNode user1 = findFriend(user1Id);
        UserNode user2 = findFriend(user2Id);
        if (user1 == null) {
            System.out.println("User with ID " + user1Id + " not found.");
            return;
        }
        if (user2 == null) {
            System.out.println("User with ID " + user2Id + " not found.");
            return;
        }
        if (!(user1.getFriends().contains(user2Id))) {
            user1.getFriends().add(user2Id);
        }
        if (!(user2.getFriends().contains(user1Id))) {
            user2.getFriends().add(user1Id);
        }
    }

    // created a methods to remove the connections between users
    void removeConnection(String user1Id, String user2Id) {
        UserNode user1 = findFriend(user1Id);
        UserNode user2 = findFriend(user2Id);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        user1.getFriends().remove(user2Id);
        user2.getFriends().remove(user1Id);
        System.out.println("Connection removed between " + user1Id + " and " + user2Id);
    }

    // created a method to find mutual friends between two users
    void findMutualFriends(String user1Id, String user2Id) {
        UserNode user1 = findFriend(user1Id);
        UserNode user2 = findFriend(user2Id);
        if (user1 == null || user2 == null) {
            System.out.println("One or both users not found.");
            return;
        }

        System.out.println("Mutual friends between " + user1.getName() + " and " + user2.getName() + " are:");
        for (String friendId : user1.getFriends()) {
            if (user2.getFriends().contains(friendId)) {
                UserNode mutualFriend = findFriend(friendId);
                if (mutualFriend != null) {
                    System.out.println("- " + mutualFriend.getName() + " (ID: " + mutualFriend.getUserID() + ")");
                }
            }
        }
    }

    // Display the friendList of the user
    public void displayFriends(String userId) {
        UserNode user = findFriend(userId);
        if (user != null) {
            System.out.println("Friends of " + user.getName() + " (ID: " + user.getUserID() + "):");
            for (String friendId : user.getFriends()) {
                UserNode friend = findFriend(friendId);
                if (friend != null) {
                    System.out.println("- " + friend.getName() + " (ID: " + friend.getUserID() + ")");
                }
            }
        } else {
            System.out.println("User not found.");
        }
    }
}


// definition of SocialMediaFriendConnections class
public class SocialMediaFriendConnections {
    public static void main(String[] args) {
        User users = new User();

        // adding users in the list
        users.addUser("user1", "Person1", 21);
        users.addUser("user2", "Person2", 22);
        users.addUser("user3", "Person3", 23);
        users.addUser("user4", "Person4", 22);
        users.addUser("user5", "Person5", 21);

        // adding connections between users
        users.addConnection("user1", "user2");
        users.addConnection("user1", "user3");
        users.addConnection("user1", "user4");
        users.addConnection("user2", "user5");
        users.addConnection("user2", "user3");
        users.addConnection("user2", "user4");
        users.addConnection("user3", "user4");
        users.addConnection("user3", "user5");
        users.addConnection("user4", "user5");

        // displaying all records
        users.displayAllRecords();

        // finding mutual friends between two uses
        users.findMutualFriends("user1","user2");
        users.findMutualFriends("user3","user4");

        // trying to add connection between same user ids
        users.addConnection("user4", "user4");

        // removing connection between two users
        users.removeConnection("user3","user4");
        users.removeConnection("user4","user5");

        // displaying friends of a user
        users.displayFriends("user1");
        users.displayFriends("user2");
        users.displayFriends("user3");
        users.displayFriends("user4");
        users.displayFriends("user5");

        // searching a user by username and userid
        users.searchUser("user5");
        users.searchUser("Person5");

        // displaying all records once again
        users.displayAllRecords();
    }
}