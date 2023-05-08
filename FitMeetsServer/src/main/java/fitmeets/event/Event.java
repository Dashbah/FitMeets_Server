package fitmeets.event;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import org.springframework.boot.jackson.JsonComponent;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table
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
    private String description;
    @JsonProperty
    private int numOfParticipants;
    // private File photo;

    public Event(Long id, LocalDate date, LocalTime time, String place, Integer minAge,
                 Integer maxAge, String description, int numOfParticipants) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.place = place;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.description = description;
        this.numOfParticipants = numOfParticipants;
    }

    public Event() {

    }

    public Event(LocalDate date, LocalTime time, String place, Integer minAge, Integer maxAge, String description, int numOfParticipants) {
        this.date = date;
        this.time = time;
        this.place = place;
        this.minAge = minAge;
        this.maxAge = maxAge;
        this.description = description;
        this.numOfParticipants = numOfParticipants;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", date=" + date +
                ", time=" + time +
                ", place='" + place + '\'' +
                ", minAge=" + minAge +
                ", maxAge=" + maxAge +
                ", description='" + description + '\'' +
                ", numOfParticipants=" + numOfParticipants +
                '}';
    }
}
