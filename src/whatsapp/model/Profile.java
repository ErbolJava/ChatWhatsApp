package whatsapp.model;

import whatsapp.enums.Status;

import java.util.ArrayList;
import java.util.List;

public class Profile {
private Long id;
private String name;
private String phoneNumber;
private String password;
private String image;
private Status status;
private List<Profile> contacts = new ArrayList<>();
private List<String>messages = new ArrayList<>();

    public Profile(Long id, String name, String phoneNumber, String password, String image, Status status, List<Profile> contacts) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.image = image;
        this.status = status;
        this. contacts = contacts;
    }

    public Profile() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<Profile> getContacts() {
        return contacts;
    }

    public void setContacts(List<Profile> contacts) {
        this.contacts = contacts;
    }

    @Override
    public String toString() {
            return "Profile" +
                    " id = " + id +
                    " name='" + name + '\'' +
                    " phoneNumber='" + phoneNumber + '\'' +
                    " password='" + password + '\'' +
                    " image='" + image + '\'' +
                    " status='" + status +
                    " contacts='" + contacts;

    }
}
