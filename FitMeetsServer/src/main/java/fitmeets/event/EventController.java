package fitmeets.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.interfaces.EdECKey;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/event")
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    public List<Event> getEvents() {
        return eventService.getEvents();
    }

    @PostMapping("/add")
    public void registerNewEvent(@RequestBody Event event) {
        eventService.addNewEvent(event);
    }

    @PostMapping("/subscribe")
    public void subscribeUserToEvent(@RequestBody SubscribeToEventRequest request) {
        eventService.subscribeUserToEvent(request.getUserId(), request.getEventId());
    }

}
