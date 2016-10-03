package mm.michalik.service.security;

/**
 * Created by maciej on 01.09.16.
 */
public interface EncryptionService {
    String encryptString(String input);
    boolean checkPassword(String plainPassword, String encryptedPassword);
}
