//The provided code defines a Citizen class in Java
// that represents a person with personal details.
public class Citizen {
    private String id; // User ID
    private String nationalId; // NPR number
    private String name;
    private String phone;
    private String email;
    private String dateOfBirth;
    private String address;
    private String photoPath; // e.g., "photos/citizen1.jpg"
//Constructor: Initializes all fields when a Citizen object is created.
    public Citizen(String id, String nationalId, String name, String phone, String email, String dateOfBirth, String address, String photoPath) {
        this.id = id;
        this.nationalId = nationalId;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
        this.photoPath = photoPath;
    }

    // Getters: Public methods to access private fields securely.
    public String getId() { return id; }
    public String getNationalId() { return nationalId; }
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }
    public String getDateOfBirth() { return dateOfBirth; }
    public String getAddress() { return address; }
    public String getPhotoPath() { return photoPath; }
    //toString() method: Provides a custom string representation of the object.
    //By overriding toString(), we return a readable, meaningful summary of the object
    // in this case, key fields like id, nationalId, name, phone, and email
    @Override//several alternative ways to implement the toString() method in
    // Java without changing its meaning or functionality.
    // Here are the most common and clean approaches:StringBuilder,
    //using StringJoiner,Objects.toString().
    // or Using Lombok(Add the @ToString annotation to auto-generate)
    public String toString() {
        return "Citizen{" +
                "id='" + id + '\'' +
                ", nationalId='" + nationalId + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}