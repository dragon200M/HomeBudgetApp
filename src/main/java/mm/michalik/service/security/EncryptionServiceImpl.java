package mm.michalik.service.security;

import org.jasypt.util.password.StrongPasswordEncryptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by maciej on 01.09.16.
 */
@Service
public class EncryptionServiceImpl implements EncryptionService{


  private StrongPasswordEncryptor strongPasswordEncryptor;

    @Autowired
    public void setStrongPasswordEncryptor(StrongPasswordEncryptor strongPasswordEncryptor) {
        this.strongPasswordEncryptor = strongPasswordEncryptor;
    }

    @Override
    public String encryptString(String input) {
        return strongPasswordEncryptor.encryptPassword(input);}

    @Override
    public boolean checkPassword(String plainPassword, String encryptedPassword) {
        return strongPasswordEncryptor.checkPassword(plainPassword,encryptedPassword);
    }
}
