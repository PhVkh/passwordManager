package kz.filipvkh.passwordmanager.service;

import kz.filipvkh.passwordmanager.model.Password;
import kz.filipvkh.passwordmanager.repository.PasswordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PasswordService {

    @Autowired
    private PasswordRepository passwordRepository;

    public String resolveTag(String tag) {
        List<Password> passwords = passwordRepository.findAllByTags(tag);

        if (passwords.isEmpty()) {
            return "no password found";
        } else if (passwords.size() == 1) {
            return passwords.get(0).getValue();
        } else {
            StringBuilder response = new StringBuilder();
            for (Password p : passwords) {
                response.append(p.getResource()).append(" ").append(p.getValue()).append("\n");
            }
            return response.toString();
        }
    }

    public void save(Password password) {
        passwordRepository.save(password);
    }
}
