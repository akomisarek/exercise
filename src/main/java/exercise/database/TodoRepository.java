package exercise.database;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class TodoRepository {
    private ConcurrentHashMap<UUID, Todo> repo = new ConcurrentHashMap<>();

    public Todo addTodo(Todo todo) {
        todo.setId(UUID.randomUUID());
        repo.put(todo.getId(), todo);

        return todo;
    }

    public Optional<Todo> deleteTodo(UUID uuid) {
        return Optional.ofNullable(repo.remove(uuid));
    }

    public Optional<Todo> deleteTodo(Todo todo) {
        return deleteTodo(todo.getId());
    }

    public List<Todo> getTodo() {
        return new ArrayList<>(repo.values());
    }

}
