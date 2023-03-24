package whatsapp.service;

import whatsapp.enums.Status;
import whatsapp.model.Profile;

import java.util.List;

public interface ProfileServe {
    List<Profile> createAccount(List<Profile>profiles);
    Profile signIn(List<Profile>profiles);
    List<Status> allStatuses(List<Profile>profiles);
    Profile changeProfilePhoto(List<Profile>profiles);
    Profile changeStatus(List<Profile>profiles);
    String addContact(List<Profile>profiles);
    List<String> sendingMessage(List<Profile>profiles);
    List<String>removingWhatsApp(List<Profile>profiles);
}
