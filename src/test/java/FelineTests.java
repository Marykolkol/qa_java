import com.example.Animal;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

@RunWith(MockitoJUnitRunner.class)
public class FelineTests {
    @Mock
    Animal animal;

    @Spy
    Feline felineSpy = new Feline();

    @Test
    public void felineEatMeat() throws Exception {
        Feline feline = new Feline(animal);
        feline.eatMeat();
        Mockito.verify(animal).getFood("Хищник");
    }

    @Test
    public void getFelineFamily() {
        Feline feline = new Feline();
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void getNotRightFelineFamily() {
        Feline feline = new Feline();
        assertNotEquals("Куньи", feline.getFamily());
    }

    @Test
    public void getOneFelineKitten() {
        felineSpy.getKittens();
        Mockito.verify(felineSpy, Mockito.times(1)).getKittens(1);
    }

    @Test
    public void getMoreFelineKittens() {
        Feline feline = new Feline();
        int kittensCount = 10;
        assertEquals(kittensCount, feline.getKittens(kittensCount));
    }
}
