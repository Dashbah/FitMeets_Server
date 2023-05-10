package fitmeets.event;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class UserIdValue {
    @Id
    @GeneratedValue
    private Long id;
    @JsonProperty("userId")
    private Long value;

    public UserIdValue(Long value) {
        this.value = value;
    }

    // getters and setters
}