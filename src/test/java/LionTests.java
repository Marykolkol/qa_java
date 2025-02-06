import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class LionTests {
    @Mock
    Feline feline;

    @Test
    public void lionCouldNotHaveMane() {
        AtomicReference<Lion> lion = null;
        Exception exception = assertThrows(Exception.class, () -> lion.set(new Lion(feline,"Молодняк")));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }

    @Test
    public void lionGetFood() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Lion lion = new Lion(feline, "Самец");
        assertEquals("Хищник хочет есть мяско", List.of("Животные", "Птицы", "Рыба"), lion.getFood());
    }

    @Test
    public void lionGetKittens() throws Exception {
        Mockito.when(feline.getKittens()).thenReturn(1);
        Lion lion = new Lion(feline, "Самец");
        assertEquals("Только один котенок", 1, lion.getKittens());
    }
}
