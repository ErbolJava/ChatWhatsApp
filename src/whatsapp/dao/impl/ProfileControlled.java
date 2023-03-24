package whatsapp.dao.impl;

import whatsapp.customException.MyExc;
import whatsapp.dao.ProfileControl;
import whatsapp.enums.Status;
import whatsapp.model.Profile;

import java.util.*;

public class ProfileControlled implements ProfileControl {

    @Override
    public List<Profile> createAccount(List<Profile> profiles) {
        try {
            Profile profile = new Profile();
            System.out.print("Enter your username: ");
            String inputName = new Scanner(System.in).next();

            if (profiles.stream().anyMatch(p -> p.getName().equals(inputName))) {
                throw new MyExc("This username already exists");
            }
            String inputPhoneNumber;
            do {
                System.out.print("Phone number (start with 0): ");
                inputPhoneNumber = new Scanner(System.in).next();
            } while (!inputPhoneNumber.startsWith("0"));

            System.out.print("Password (at least 7 characters): ");
            String inputPassword = new Scanner(System.in).next();

            if (inputPassword.length() < 7) {
                throw new MyExc("Password must be at least 7 characters long");
            }
            profile.setName(inputName);
            profile.setId((long) (profiles.size() + 1));
            profile.setPassword(inputPassword);
            profile.setPhoneNumber(inputPhoneNumber);
            profile.setStatus(Status.HELLO_I_USE_WHATSAPP);
            profiles.add(profile);

            return profiles;
        } catch (MyExc e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Profile signIn(List<Profile> profiles) {
        System.out.print("name: ");
        String inputName = new Scanner(System.in).next();
        System.out.print("password: ");
        String inputPassword = new Scanner(System.in).next();


        Optional<Profile> matchedProfile = profiles.stream()
                .filter(profile -> profile.getName().equals(inputName) && profile.getPassword().equals(inputPassword))
                .findAny();

        return matchedProfile.orElse(null);
    }

    @Override
    public List<Status> allStatuses(List<Profile> profiles) {
        return new ArrayList<>(Arrays.asList(Status.values()));
    }

    @Override
    public Profile changeProfilePhoto(List<Profile> profiles) {
        try {
            System.out.print("name: ");
            String inputName = new Scanner(System.in).next();
            System.out.print("password: ");
            String inputPassword = new Scanner(System.in).next();
            Optional<Profile> changePhotoOfProfile = profiles.stream()
                    .filter(profile -> profile.getName().equals(inputName) && profile.getPassword().equals(inputPassword))
                    .findAny();
            if (changePhotoOfProfile.isPresent()) {
                System.out.print("Put new image: ");
                String newImage = new Scanner(System.in).next();
                changePhotoOfProfile.get().setImage(newImage);
                return changePhotoOfProfile.get();
            } else {
                throw new MyExc("Something went wrong");
            }
        } catch (MyExc e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public Profile changeStatus(List<Profile> profiles) {
        try {
            System.out.print("name: ");
            String inputName = new Scanner(System.in).next();
            System.out.print("password");
            String inputPassword = new Scanner(System.in).next();
            Optional<Profile> changeStatus = profiles.stream()
                    .filter(profile -> profile.getName().equals(inputName) && profile.getPassword().equals(inputPassword))
                    .findAny();
            if (changeStatus.isPresent()) {
                System.out.println("Put new status: ");
                System.out.println("[1] " + Status.AT_HOME + " [2] " + Status.AT_WORK + " [3]" + Status.AT_PEAKSOFT + " [4]" + Status.ONLINE);
                String inputStatus = new Scanner(System.in).next();
                switch (inputStatus) {
                    case "1" -> changeStatus.get().setStatus(Status.AT_HOME);
                    case "2" -> changeStatus.get().setStatus(Status.AT_WORK);
                    case "3" -> changeStatus.get().setStatus(Status.AT_PEAKSOFT);
                    case "4" -> changeStatus.get().setStatus(Status.ONLINE);
                    default -> {
                        break;
                    }
                }
                changeStatus.get().setStatus(Status.valueOf(inputStatus));
                return changeStatus.get();
            } else {
                throw new MyExc("Something went wrong with Status");
            }
        } catch (MyExc e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public String addContact(List<Profile> profiles) {
        boolean looping = true;
        boolean loop = false;
        try {
            System.out.print("verify name: ");
            String verifyName = new Scanner(System.in).nextLine();
            System.out.print("verify password: ");
            String verifyPassword = new Scanner(System.in).nextLine();

            for (Profile p : profiles) {
                if (p.getName().equals(verifyName) && p.getPassword().equals(verifyPassword)) {
                    System.out.print("name of your friend: ");
                    String inputFrName = new Scanner(System.in).next();
                    System.out.print("phone number of your friend: ");
                    String inputFrPhoneNumber = new Scanner(System.in).next();
                    for (Profile profile : p.getContacts()) {
                        profile.setName(inputFrName);
                        profile.setPhoneNumber(inputFrPhoneNumber);
                        p.getContacts().add(profile);
                        profile.getContacts().add(p);
                        profiles.add(profile);
                        System.out.println("Successfully added");
                    }
                } else {
                    loop = false;
                }
            }
            if (loop) {
                throw new MyExc("This person did not do registration");
            }
        } catch (MyExc e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public List<String> sendingMessage(List<Profile> profiles) {
        System.out.println("");
        String input = new Scanner(System.in).next();
        return null;
    }

    @Override
    public List<String> removingAcc(List<Profile> profiles) {
        try {
            System.out.print("name: ");
            String inputName = new Scanner(System.in).next();
            System.out.print("password");
            String inputPassword = new Scanner(System.in).next();
            Optional<Profile> removingAcc = profiles.stream()
                    .filter(profile -> profile.getName().equals(inputName) && profile.getPassword().equals(inputPassword))
                    .findAny();
            if (removingAcc.isPresent()) {
                profiles.remove(removingAcc.get());
                System.out.println("Profile removed successfully!");
            } else {
                throw new MyExc("Profile not found!");
            }
        } catch (MyExc e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
