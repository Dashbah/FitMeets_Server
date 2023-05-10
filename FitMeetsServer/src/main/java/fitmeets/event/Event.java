package fitmeets.event;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
// @JsonAutoDetect
public class Event {
    @JsonProperty
    @Id
    @SequenceGenerator(
            name = "event_sequence",
            sequenceName = "event_name",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "event_sequence"
    )
    private Long id;
    @JsonProperty
    private LocalDate date;
    @JsonProperty
    private LocalTime time;
    @JsonProperty
    private String place;
    @JsonProperty
    private Integer minAge;
    @JsonProperty
    private Integer maxAge;

    @JsonProperty
    private String city;
    @JsonProperty
    private String description;
    @JsonProperty
    private String sportType;
    @JsonProperty
    private int numOfParticipants;

    @JsonProperty
    @OneToMany(cascade = CascadeType.ALL)
    // @JoinColumn(name = "user_id")
    private List<UserIdValue> subscribers;

    // private File photo;
    public Event(LocalDate date, LocalTime time, String place, Integer minAge, Integer maxAge, String city,
                 String description, String sportType, int numOfParticipants, List<UserIdValue> subscribers) {
        this.date = date;
        this.time = time;
        this.place = place;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.city = city;
        this.description = description;
        this.sportType = sportType;
        this.numOfParticipants = numOfParticipants;
        this.subscribers = subscribers;
    }

}
