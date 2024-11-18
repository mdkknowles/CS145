public class Node {
    int key; // Unique key for the node
    String firstName, lastName, address, email, phone;
    Node left, right; // Left and right child pointers

    // Constructor to initialize a new Node
    public Node(int key, String firstName, String lastName, String address, String email, String phone) {
        this.key = key;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.left = this.right = null;
    }

    // Setters for updating fields
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setAddress(String address) { this.address = address; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }

    // String representation of the Node
    @Override
    public String toString() {
        return "Key: " + key + "\n" +
                "First Name: " + firstName + "\n" +
                "Last Name: " + lastName + "\n" +
                "Address: " + address + "\n" +
                "Email: " + email + "\n" +
                "Phone: " + phone + "\n";
    }
}
