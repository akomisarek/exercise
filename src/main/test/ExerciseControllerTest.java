import exercise.controller.ExerciseController;
import exercise.database.Todo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ExerciseControllerTest {

    @MockBean
    private ExerciseController exerciseController;


    private Todo generateRandomTodo() {
        Random random = new Random();
        return new Todo().setId(UUID.randomUUID()).setName("name" + random.nextInt());
    }

    @Test
    public void testGetRequest() {
        Mockito.when(exerciseController.get())
                .thenReturn(ResponseEntity.ok(Arrays.asList(this.generateRandomTodo(), this.generateRandomTodo())));

        List<Todo> list = exerciseController.get().getBody();
        Assert.assertEquals(2, list.size());
    }

}
