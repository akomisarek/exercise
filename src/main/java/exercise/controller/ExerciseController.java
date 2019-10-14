package exercise.controller;

import exercise.database.Todo;
import exercise.database.TodoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/todo")
public class ExerciseController {

    private final TodoRepository todoRepository;

    public ExerciseController(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    @GetMapping("/")
    public ResponseEntity<List<Todo>> get() {
        return ResponseEntity.ok(todoRepository.getTodo());
    }

    @PostMapping("/")
    public ResponseEntity<Todo> post(@RequestBody Todo todo) {
        return ResponseEntity.ok(todoRepository.addTodo(todo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Todo> delete(@PathVariable String id) {
        return todoRepository.deleteTodo(UUID.fromString(id))
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
