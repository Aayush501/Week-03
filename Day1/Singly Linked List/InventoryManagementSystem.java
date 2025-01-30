// definition of ItemNode class
class ItemNode {
    // declaring the attributes of this class
    private String itemName, itemID;
    private int quantity;
    private float price;
    ItemNode next;

    // created a non-parameterized constructor
    ItemNode() {}

    // created a parameterized constructor to initialize the object
    ItemNode(String itemName, String itemID, int quantity, float price) {
        this.itemName = itemName;
        this.itemID = itemID;
        this.quantity = quantity;
        this.price = price;
    }

    // created getter methods to maintain encapsulation and data security
    public String getItemID(){
        return this.itemID;
    }

    public String getItemName(){
        return this.itemName;
    }

    public float getPrice(){
        return this.price;
    }

    public int getQuantity(){
        return this.quantity;
    }

    public void setQuantity(int quantity){
        this.quantity = quantity;
    }
}




// definition of Item class
class Item {
    // declaring the attributes of this class
    ItemNode head; // head of the linked list
    static int totalItems=0;

    // defining the behaviour of this class

    // created a parameterized constructor to initialize a linked list of Items
    Item(String itemName, String itemID, int quantity, float price) {
        head = new ItemNode(itemName, itemID, quantity, price);
        totalItems++;
    }


    // created a method to display all Item records
    public void displayAllRecords() {
        ItemNode item = head;
        while (item != null) {
            System.out.println("Name of the item: " + item.getItemName() + "\nItem ID: " + item.getItemID() + "\nquantity: " + item.getQuantity() + "\nprice: " + item.getPrice() + "\n");
            item = item.next;
        }
    }



    // created a method addNewItem to add a new Item at the end of the list
    public void addItem(String itemName, String itemID, int quantity, float price) {
        addItem(itemName, itemID, quantity, price, totalItems+1);
    }



    // created a method to add a record at any position of the list including the beginning and end position
    public void addItem(String itemName, String itemID, int quantity, float price, int position) {
        if (position == 1) { // if user wants to add a record at the beginning
            ItemNode newItem = new ItemNode(itemName, itemID, quantity, price);
            newItem.next = head;
            head = newItem;
            totalItems++;
            return;
        }

        // if the inserting position is not the beginning
        ItemNode item1 = head;
        ItemNode item2 = null;

        // created an integer variable to iterate through the list till we reach to the position
        int i=1;
        while (i<position) { // after this loop we have to insert the new record between item1 and item2 nodes
            if (item1 == null){ // means item2 is already at the last position
                System.out.println("Invalid insert position!!");
                return;
            }
            item2 = item1;
            item1 = item1.next;
            i++;
        }

        // initializing a new item record
        ItemNode newItem = new ItemNode(itemName, itemID, quantity, price);

        // inserting the new record between item1 and item2
        newItem.next = item1;
        item2.next = newItem;
        totalItems++;
    }



    // created a method to search a record by itemID or itemName
    public void searchItem(String itemNameOrID) {
        // iterator for the list
        ItemNode item = head;

        while (item != null) { // with this loop item1 will reach to the position that is required
            if (item.getItemName().equals(itemNameOrID) || item.getItemID().equals(itemNameOrID)) {
                System.out.println("Details of the item:\nName: " + item.getItemName() + "\nItem ID: " + item.getItemID() + "\nquantity: " + item.getQuantity() + "\nprice: " + item.getPrice() + "\n");
                return;
            }
            item = item.next;
        }

        System.out.println("This item does not exist.");
    }



    // created a method to delete a record by itemID
    public void deleteByItemID(String itemID) {
        // iterators for the list
        ItemNode item1 = head;
        ItemNode item2 = null;

        while (item1 != null) { // with this loop item1 will reach to the position that is needed to be deleted
            if (item1.getItemID().equals(itemID)) {
                item2.next = item1.next;
                totalItems--;
                return;
            }
            item2 = item1;
            item1 = item1.next;
        }

        System.out.println("This item does not exist.");
    }


    // created a method to update the quantity of an Item by itemID
    public void updateQuantity(String itemID, int quantity) {
        // iterator for the list
        ItemNode item1 = head;

        while (item1 != null) { // with this loop item1 will reach to the position that is required
            if (item1.getItemID().equals(itemID)) {
                item1.setQuantity(quantity);
                return;
            }
            item1 = item1.next;
        }

        System.out.println("This item does not exist.");
    }

    // created a method to calculate the total value of the inventory
    public void displayTotalInventoryValue() {
        // iterator for the list
        ItemNode item = head;

        // created a variable to store total value of inventory
        float total = 0;

        while (item != null) {
            System.out.println("Item Name: " + item.getItemName() + ", ID: " + item.getItemID() + "\nPrice: " + item.getPrice() + "Rs. Quantity: " + item.getQuantity() + "\nTotal Cost: " + (item.getQuantity() * item.getPrice()) + "\n");
            total += item.getQuantity() * item.getPrice();
            item = item.next;
        }

        System.out.println("Total Number of Items: " + Item.totalItems + "\nTotal cost of the inventory: " + total);
    }

    /*
        below is the code to sort the list based on Item Name or Price in ascending or descending order.
        The algorithm used for sorting is merge sort.
        Below methods are kept private to ensure data security.
    */

    // method for sorting the linked list
    public void sort(Item head, String  mergeWhat, String mergeHow) {
        head.head = mergeSort(head.head, mergeWhat, mergeHow);
    }

    // method to implement the sorting
    private ItemNode mergeSort(ItemNode head, String mergeWhat, String mergeHow) {

        if (head == null || head.next == null) {
            return head; // if the list is empty or has one element then it's already sorted
        }

        // splitting the list into two halves
        ItemNode middle = getMiddleItem(head);
        ItemNode nextOfMiddle = middle.next;
        middle.next = null; // breaking the list into two halves

        // recursively sorting both halves
        ItemNode left = mergeSort(head, mergeWhat, mergeHow);
        ItemNode right = mergeSort(nextOfMiddle, mergeWhat, mergeHow);

        // merging the sorted halves
        return merge(left, right, mergeWhat, mergeHow);
    }

    // created getMiddleItem function
    private ItemNode getMiddleItem(ItemNode head) {
        if (head == null) {
            return head;
        }

        ItemNode slow = head;
        ItemNode fast = head;

        // moving 'fast' by 2 steps and 'slow' by 1 step to find the middle
        while (fast.next != null && fast.next.next != null) { // after this loop the slow iterator will arrive to the middle node
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow; // returning the middle node
    }

    // created the merge function
    private ItemNode merge(ItemNode left, ItemNode right, String mergeWhat, String mergeHow) {
        // dummy node to simplify merging
        ItemNode dummy = new ItemNode();
        ItemNode tail = dummy;

        // created a boolean variable check to define the condition which is going to be evaluated to sort the list
        boolean check;
        if(mergeWhat.equals("Price")) {
            if(mergeHow.equals("Asc")) {
                check = left.getPrice() <= right.getPrice();
            } else {
                check = left.getPrice() >= right.getPrice();
            }
        } else {
            if(mergeHow.equals("Asc")) {
                check = left.getItemName().compareTo(right.getItemName()) <= 0;
            } else {
                check = left.getItemName().compareTo(right.getItemName()) >= 0;
            }
        }

        // merging the two lists by comparing their data
        while (left != null && right != null) {
            if (check) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }

        // adding any remaining nodes from either list
        if (left != null) {
            tail.next = left;
        }
        if (right != null) {
            tail.next = right;
        }

        return dummy.next; // returning the merged list
    }
}

// definition of InventoryManagementSystem class
public class InventoryManagementSystem {
    public static void main(String[] args) {
        // created a linked list of Items
        Item items = new Item("Item1", "1", 5, 150);

        // iteration to add new Items
        for (int i = 0; i < 4; i++) {
            items.addItem("Item" + (i+2), "" + (i+2), 5, (i%2==1)? 250 : 200);
        }

        // displaying details of all Items
        items.displayAllRecords();

        // adding new record at beginning of the list
        items.addItem("Item0", "0", 5, 300, 1);

        // adding new record at the end of the list
        items.addItem("Item6", "6", 5, 350, Item.totalItems+1);

        // searching an Item by itemID
        items.searchItem("3");

        // searching an Item by itemName
        items.searchItem("Item5");

        // deleting a Item record by itemID
        items.deleteByItemID("5");

        // updating the quantity of a Item by itemID
        items.updateQuantity("2", 10);

        // providing the wrong input inside a function
        items.addItem("Item7","7", 10, 400, Item.totalItems+2);

        // displaying total cost of inventory
        items.displayTotalInventoryValue();

        // arranging items into ascending order of price
        items.sort(items, "Price","Asc");

        // displaying details of all Items
        items.displayAllRecords();

        // arranging items into descending order of price
        items.sort(items, "Price","Desc");

        // displaying details of all Items
        items.displayAllRecords();

        // arranging items into ascending order of Name
        items.sort(items, "Name","Asc");

        // displaying details of all Items
        items.displayAllRecords();

        // arranging items into descending order of Name
        items.sort(items, "Name","Desc");

        // displaying details of all Items
        items.displayAllRecords();
    }
}