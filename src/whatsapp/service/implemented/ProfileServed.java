package whatsapp.service.implemented;

import whatsapp.dao.impl.ProfileControlled;
import whatsapp.enums.Status;
import whatsapp.model.Profile;
import whatsapp.service.ProfileServe;

import java.util.List;

public class ProfileServed implements ProfileServe {
    ProfileControlled profileControlled = new ProfileControlled();
    @Override
    public List<Profile> createAccount(List<Profile>profiles) {
        return profileControlled.createAccount(profiles);
    }

    @Override
    public Profile signIn(List<Profile>profiles) {
        return profileControlled.signIn(profiles);
    }

    @Override
    public List<Status> allStatuses(List<Profile>profiles) {
        return profileControlled.allStatuses(profiles);
    }

    @Override
    public Profile changeProfilePhoto(List<Profile>profiles) {
        return profileControlled.changeProfilePhoto(profiles);
    }

    @Override
    public Profile changeStatus(List<Profile>profiles) {
        return profileControlled.changeStatus(profiles);
    }

    @Override
    public String addContact(List<Profile>profiles) {
        return profileControlled.addContact(profiles);
    }

    @Override
    public List<String> sendingMessage(List<Profile>profiles) {
        return profileControlled.sendingMessage(profiles);
    }

    @Override
    public List<String> removingWhatsApp(List<Profile>profiles) {
        return profileControlled.removingAcc(profiles);
    }
}
