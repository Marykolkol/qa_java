import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class CatTests {
    @Mock
    Feline feline;

    @Test
    public void getCatSound() {
        Cat cucumber = new Cat(feline);
        assertEquals("Мяу", cucumber.getSound());
    }

    @Test
    public void getWrongCatSound() {
        Cat bus = new Cat(feline);
        assertNotEquals("Муууу", bus.getSound());
    }

    @Test
    public void catGetFood() throws Exception {
        Cat tuzik = new Cat(feline);
        tuzik.getFood();
        Mockito.verify(feline, Mockito.times(1)).eatMeat();
    }
}
