import com.example.Feline;
import org.junit.Test;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class FelineTest {

    Feline feline = new Feline();

    @Test
    public void felineGetFamily() {
        assertEquals("Кошачьи",feline.getFamily());
    }

    @Test
    public void felineGetKittens() {
        assertEquals(1,feline.getKittens());
    }

    @Test
    public void felineEatMeat() throws Exception{
        List<String> expected = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expected, feline.eatMeat());
    }
}