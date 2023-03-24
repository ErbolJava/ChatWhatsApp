import whatsapp.customException.MyExc;
import whatsapp.model.Profile;
import whatsapp.service.implemented.ProfileServed;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws MyExc {
        List<Profile>profiles = new ArrayList<>();
        while(true) {
        try{
        ProfileServed profileServed = new ProfileServed();
        Scanner scanner = new Scanner(System.in);

            System.out.println("""
                    
                    1 - SIGH UP | 2 - ALL STATUSES | 3 - SIGN IN | 4 - CHANGE PHOTO
                    5 - CHANGE STATUS OF PROFILE | 6 - ADDING CONTACT TO WHATSAPP
                                7 - SEND MESSAGE | 8 - REMOVE WHATSAPP""");
            switch (scanner.nextInt()) {
                case 1 -> System.out.println(profileServed.createAccount(profiles));
                case 2 -> System.out.println(profileServed.allStatuses(profiles));
                case 3 -> System.out.println(profileServed.signIn(profiles));
                case 4 -> System.out.println(profileServed.changeProfilePhoto(profiles));
                case 5 -> System.out.println(profileServed.changeStatus(profiles));
                case 6 -> System.out.println(profileServed.addContact(profiles));
                case 7 -> System.out.println(profileServed.sendingMessage(profiles));
                case 8 -> System.out.println(profileServed.removingWhatsApp(profiles));
                default -> throw new MyExc("There are only 8 functions");
            }
        }catch (MyExc e){
            System.out.println(e.getMessage());
        }
        }
    }
}