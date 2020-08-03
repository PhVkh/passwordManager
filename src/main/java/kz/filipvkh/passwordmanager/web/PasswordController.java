package kz.filipvkh.passwordmanager.web;

import kz.filipvkh.passwordmanager.model.Password;
import kz.filipvkh.passwordmanager.service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PasswordController {

    @Autowired
    private PasswordService passwordService;

    @GetMapping("/password")
    public ResponseEntity<String> getPasswords(@RequestParam String tag) {
        return new ResponseEntity<>(passwordService.resolveTag(tag), HttpStatus.OK);
    }

    @PostMapping("/password")
    public ResponseEntity<String> saveNewPassword(@RequestBody Password password) {
        passwordService.save(password);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
