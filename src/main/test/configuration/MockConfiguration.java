package configuration;

import exercise.controller.ExerciseController;
import exercise.database.TodoRepository;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MockConfiguration {
    @Bean
    @Primary
    public TodoRepository todoRepository() {
        return Mockito.mock(TodoRepository.class);
    }

    @Bean
    @Primary
    public ExerciseController exerciseController() {
        return Mockito.mock(ExerciseController.class);
    }

}
