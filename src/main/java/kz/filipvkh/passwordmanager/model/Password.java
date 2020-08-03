package kz.filipvkh.passwordmanager.model;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "PASSWORDS")
public class Password {

    @Id
    @GeneratedValue
    private Long id;
    private String resource;
    @ElementCollection
    private Set<String> tags;
    private String value;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getResource() {
        return resource;
    }
    public void setResource(String resource) {
        this.resource = resource;
    }

    public Set<String> getTags() {
        return tags;
    }
    public void setTags(Set<String> tags) {
        this.tags = tags;
    }

    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Password)) return false;
        Password password = (Password) o;
        return Objects.equals(id, password.id) &&
                Objects.equals(resource, password.resource) &&
                Objects.equals(tags, password.tags) &&
                Objects.equals(value, password.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, resource, tags, value);
    }
}
