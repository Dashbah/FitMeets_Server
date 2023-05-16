package fitmeets.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "_user")
public class User implements UserDetails {
    @Id
    @GeneratedValue
    private Long id;
    private String firstname;
    private String lastname;
    private String email;

    @JsonIgnore
    private String password;

    private String city;
    private String description;
    private Integer age;

    @Enumerated(EnumType.STRING)
    private Sex sex;
    @Enumerated(EnumType.STRING)
    private Role role;

    @OneToMany(cascade = CascadeType.ALL)
    private List<SportType> sportTypes;

    @OneToMany(cascade = CascadeType.ALL)
    private List<EventsValue> events;

//    public User(String firstname, String lastname, String email, String city,
//                String description, Integer age, Sex sex, Role role,
//                List<SportType> sportTypes, List<EventsValue> events) {
//        // this.id = id;
//        this.firstname = firstname;
//        this.lastname = lastname;
//        this.email = email;
//        this.city = city;
//        this.description = description;
//        this.age = age;
//        this.sex = sex;
//        this.role = role;
//        this.sportTypes = sportTypes;
//        this.events = events;
//    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
    // private List<SportType> favSports;
    // private File photo;
}
