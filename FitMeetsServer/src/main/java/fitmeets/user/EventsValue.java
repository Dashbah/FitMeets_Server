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
public class EventsValue {
    @Id
    @GeneratedValue
    private Long id;
    @JsonProperty("eventId")
    private Long value;

    public EventsValue(Long value) {
        this.value = value;
    }
}
