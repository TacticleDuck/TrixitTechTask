import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MainTest {

    @BeforeMethod
    public void setup() {
        System.out.println("setup");
    }

    @Test
    public void test() {
        System.out.println("test");
    }

    @AfterMethod
    public void cleanup() {
        System.out.println("cleanup");
    }
}
