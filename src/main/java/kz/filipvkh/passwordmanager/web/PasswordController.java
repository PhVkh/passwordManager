package kz.filipvkh.passwordmanager.web;

import kz.filipvkh.passwordmanager.model.Password;
import kz.filipvkh.passwordmanager.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
public class PasswordController {

    @Autowired
    private PasswordService passwordService;

    @PostMapping("/password")
    public ResponseEntity<String> getEncryptedPassword(@RequestBody String tag) {
        List<Password> passwords = passwordService.resolveTag(tag);
        if (passwords.isEmpty()) {
            return new ResponseEntity<>("no password found", HttpStatus.OK);
        } else if (passwords.size() == 1) {
            return new ResponseEntity<>(passwords.get(0).getValue(), HttpStatus.OK);
        } else {
            StringBuilder response = new StringBuilder();
            for (Password p : passwords) {
                response.append(p.getResource()).append(" ").append(p.getValue()).append("\n");
            }
            return new ResponseEntity<>(response.toString(), HttpStatus.OK);
        }
    }
}
