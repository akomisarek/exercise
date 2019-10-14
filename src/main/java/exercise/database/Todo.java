package exercise.database;

import java.time.ZonedDateTime;
import java.util.UUID;

public class Todo {
    private UUID id;

    private String name;
    // private ZonedDateTime date;

    public UUID getId() {
        return id;
    }

    public Todo setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Todo setName(String name) {
        this.name = name;
        return this;
    }
//
//    public ZonedDateTime getDate() {
//        return date;
//    }
//
//    public Todo setDate(ZonedDateTime date) {
//        this.date = date;
//        return this;
//    }
}
