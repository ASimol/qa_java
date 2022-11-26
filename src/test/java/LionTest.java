import com.example.Lion;
import com.example.Feline;
import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static junit.framework.TestCase.assertEquals;

@RunWith(Parameterized.class)
public class LionTest{

    private final String sexSelection;
    private final boolean expected;

    public LionTest(String gender, boolean expected) {
        this.sexSelection = gender;
        this.expected = expected;
    }

    @Before
    public void initMocks() throws Exception {
        MockitoAnnotations.openMocks(this).close();
    }
    Feline feline = Mockito.mock(Feline.class);

    @Parameterized.Parameters
    public static Object[] getGenderAnimal() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    @Test
    public void GetKittens() throws Exception {
        Lion lion = new Lion(feline, sexSelection);
        int expected = 1;
        Mockito.when(feline.getKittens()).thenReturn(expected);
        int actual = lion.getKittens();
        assertEquals(expected, actual);
    }

    @Test
    public void Sex() throws Exception {
        Lion lion = new Lion(feline, sexSelection);
        boolean actual = lion.doesHaveMane();
        assertEquals(expected, actual);
    }

    @Test
    public void GetFood() throws Exception {
        Lion lion = new Lion(feline, sexSelection);
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expected);
        List<String> actual = lion.getFood();
        assertEquals(expected, actual);
    }
}