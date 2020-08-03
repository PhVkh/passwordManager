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

    public List<Password> resolveTag(String tag) {
        return passwordRepository.findAllByTags(tag);
    }
}
