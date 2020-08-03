package kz.filipvkh.passwordmanager.repository;

import kz.filipvkh.passwordmanager.model.Password;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PasswordRepository extends JpaRepository<Password, Long> {
    List<Password> findAllByTags(String tag);
}
