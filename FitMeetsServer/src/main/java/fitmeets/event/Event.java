package fitmeets.event;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
// @JsonAutoDetect
public class Event {

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
    private LocalDate date;

    private LocalTime time;

    private String place;

    private Integer minAge;

    private Integer maxAge;

    private String city;

    private String description;
    private String sportType;

    private Integer numOfParticipants;


    @OneToMany(cascade = CascadeType.ALL)
    // @JoinColumn(name = "user_id")
    private List<UserIdValue> subscribers;

    // private File photo;
    public Event(LocalDate date, LocalTime time, String place, Integer minAge, Integer maxAge, String city,
                 String description, String sportType, Integer numOfParticipants, List<UserIdValue> subscribers) {
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
