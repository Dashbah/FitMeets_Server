package fitmeets.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class SportType {
    @Id
    @GeneratedValue
    private Long id;
    @JsonProperty("userId")
    private String sportType;

    public SportType(String sportType) {
        this.sportType = sportType;
    }
}