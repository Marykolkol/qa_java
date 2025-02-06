import com.example.Feline;
import com.example.Lion;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class LionParameterizedTests {
    @Rule
    public MockitoRule rule = MockitoJUnit.rule();
    @Mock
    public Feline feline;

    String sex;
    boolean expectedHasMane;

    public LionParameterizedTests(String sex, boolean expectedHasMane) {
        this.sex = sex;
        this.expectedHasMane = expectedHasMane;
    }

    @Parameterized.Parameters
    public static Object[][] getSex() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void lionHasMane() throws Exception {
        Lion lion = new Lion(feline, sex);
        assertEquals(expectedHasMane, lion.doesHaveMane());
    }
}
