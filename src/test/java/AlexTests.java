import com.example.Alex;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class AlexTests {

    @Mock
    Feline feline;

    @Test
    public void alexHaveMane() throws Exception {
        Alex alex = new Alex(feline);
        assertTrue(alex.doesHaveMane());
}

    @Test
    public void alexGetFood() throws Exception {
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        Alex alex = new Alex(feline);
        assertEquals("Хищник хочет есть мяско", List.of("Животные", "Птицы", "Рыба"), alex.getFood());
    }

    @Test
    public void alexGetKittens() throws Exception {
        Alex alex = new Alex(feline);
        assertEquals("У Алекса даже жены нет, какие дети!", 0, alex.getKittens());
    }

    @Test
    public void alexGetPlaceOfLiving() throws Exception{
        Alex alex = new Alex(feline);
        assertEquals("В прописке остался зоопарк!", "Нью-Йоркский зоопарк", alex.getPlaceOfLiving());
    }

    @Test
    public void alexGetFriends() throws Exception{
        Alex alex = new Alex(feline);
        assertEquals("Только самые близкие", List.of("Марти", "Глория", "Мелман"), alex.getFriends());
    }
}
