package fitmeets.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
public class UserSubscriberIdValue {
    @Id
    @GeneratedValue
    private Long id;
    @JsonProperty("eventId")
    private Long value;

    public UserSubscriberIdValue(Long value) {
        this.value = value;
    }
}