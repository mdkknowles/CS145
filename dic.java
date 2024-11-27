import java.util.Scanner;

class Node {
    int key;
    String firstName, lastName, address, city, state, postal, email, phone;
    Node left, right;

    public Node(int key, String firstName, String lastName, String address, String city, String state,
                String postal, String email, String phone) {
        this.key = key;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.postal = postal;
        this.email = email;
        this.phone = phone;
        this.left = null;
        this.right = null;
    }

    @Override
    public String toString() {
        return "ID: " + key + "\nName: " + firstName + " " + lastName + "\nAddress: " + address + ", " + city + ", " +
               state + " " + postal + "\nEmail: " + email + "\nPhone: " + phone;
    }
}

class BinarySearchTree {
    private Node root;
    private int size;

    public BinarySearchTree() {
        this.root = null;
        this.size = 0;
    }

    public void add(int key, String firstName, String lastName, String address, String city, String state,
                    String postal, String email, String phone) {
        root = addRecursive(root, key, firstName, lastName, address, city, state, postal, email, phone);
        size++;
    }

    private Node addRecursive(Node current, int key, String firstName, String lastName, String address, String city,
                              String state, String postal, String email, String phone) {
        if (current == null) {
            return new Node(key, firstName, lastName, address, city, state, postal, email, phone);
        }
        if (key < current.key) {
            current.left = addRecursive(current.left, key, firstName, lastName, address, city, state, postal, email, phone);
        } else if (key > current.key) {
            current.right = addRecursive(current.right, key, firstName, lastName, address, city, state, postal, email, phone);
        }
        return current;
    }

    public Node search(int key) {
        return searchRecursive(root, key);
    }

    private Node searchRecursive(Node current, int key) {
        if (current == null || current.key == key) {
            return current;
        }
        if (key < current.key) {
            return searchRecursive(current.left, key);
        }
        return searchRecursive(current.right, key);
    }

    public void delete(int key) {
        root = deleteRecursive(root, key);
    }

    private Node deleteRecursive(Node current, int key) {
        if (current == null) {
            return null;
        }
        if (key < current.key) {
            current.left = deleteRecursive(current.left, key);
        } else if (key > current.key) {
            current.right = deleteRecursive(current.right, key);
        } else {
            if (current.left == null) return current.right;
            if (current.right == null) return current.left;

            Node smallestValue = findMin(current.right);
            current.key = smallestValue.key;
            current.firstName = smallestValue.firstName;
            current.lastName = smallestValue.lastName;
            current.address = smallestValue.address;
            current.city = smallestValue.city;
            current.state = smallestValue.state;
            current.postal = smallestValue.postal;
            current.email = smallestValue.email;
            current.phone = smallestValue.phone;

            current.right = deleteRecursive(current.right, smallestValue.key);
        }
        return current;
    }

    private Node findMin(Node current) {
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public int size() {
        return size;
    }
}

public class Dictionary {
    public static void main(String[] args) {
        final int NUM_OF_INTENTS = 6;
        Scanner sc = new Scanner(System.in);
        int userIntent = 0;
        BinarySearchTree bst = new BinarySearchTree();

        while (userIntent != NUM_OF_INTENTS) {
            printIntroduction();
            userIntent = getUserIntent(sc);
            switch (userIntent) {
                case 1:
                    addEntry(sc, bst);
                    break;
                case 2:
                    deleteEntry(sc, bst);
                    break;
                case 3:
                    modifyEntry(sc, bst);
                    break;
                case 4:
                    lookupEntry(sc, bst);
                    break;
                case 5:
                    numberOfEntries(bst);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid input. Try again.");
                    break;
            }
        }    
    }
    private static void printIntroduction() {
        System.out.println("Select one of the following options:");
        System.out.println("1: Add an entry.");
        System.out.println("2: Delete an entry.");
        System.out.println("3: Modify an entry.");
        System.out.println("4: Lookup an entry.");
        System.out.println("5: List total number of entries.");
        System.out.println("6: Exit.");
    }

    private static int getUserIntent(Scanner sc) {
        System.out.print("Your choice: ");
        while (!sc.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            sc.next();
        }
        return sc.nextInt();
    }

    private static void addEntry(Scanner sc, BinarySearchTree bst) {
        System.out.print("Entry ID: ");
        int key = sc.nextInt();
        sc.nextLine();
        System.out.print("First name: ");
        String firstName = sc.nextLine();
        System.out.print("Last name: ");
        String lastName = sc.nextLine();
        System.out.print("Address: ");
        String address = sc.nextLine();
        System.out.print("City: ");
        String city = sc.nextLine();
        System.out.print("State: ");
        String state = sc.nextLine();
        System.out.print("Postal/zip code: ");
        String postal = sc.nextLine();
        System.out.print("Email address: ");
        String email = sc.nextLine();
        System.out.print("Phone number: ");
        String phone = sc.nextLine();

        bst.add(key, firstName, lastName, address, city, state, postal, email, phone);
        System.out.println("Entry added successfully.");
    }

    private static void deleteEntry(Scanner sc, BinarySearchTree bst) {
        System.out.print("Entry ID to delete: ");
        int entryID = sc.nextInt();
        Node entry = bst.search(entryID);
        if (entry == null) {
            System.out.println("Entry not found.");
        } else {
            bst.delete(entryID);
            System.out.println("Entry deleted successfully.");
        }
    }

    private static void modifyEntry(Scanner sc, BinarySearchTree bst) {
        System.out.print("Entry ID to modify: ");
        int entryID = sc.nextInt();
        sc.nextLine();
        Node entry = bst.search(entryID);
        if (entry == null) {
            System.out.println("Entry not found.");
            return;
        }
        System.out.println("Current entry: \n" + entry);
        System.out.print("New first name: ");
        entry.firstName = sc.nextLine();
        System.out.print("New last name: ");
        entry.lastName = sc.nextLine();
        System.out.print("New address: ");
        entry.address = sc.nextLine();
        System.out.print("New city: ");
        entry.city = sc.nextLine();
        System.out.print("New state: ");
        entry.state = sc.nextLine();
        System.out.print("New postal/zip code: ");
        entry.postal = sc.nextLine();
        System.out.print("New email: ");
        entry.email = sc.nextLine();
        System.out.print("New phone: ");
        entry.phone = sc.nextLine();
        System.out.println("Entry modified successfully.");
    }

    private static void lookupEntry(Scanner sc, BinarySearchTree bst) {
        System.out.print("Entry ID to lookup: ");
        int entryID = sc.nextInt();
        Node entry = bst.search(entryID);
        if (entry == null) {
            System.out.println("Entry not found.");
        } else {
            System.out.println("Entry details: \n" + entry);
        }
    }

    private static void numberOfEntries(BinarySearchTree bst) {
        System.out.println("Total number of entries: " + bst.size());
    }
}
