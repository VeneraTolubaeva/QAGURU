package properties.tests;

import org.junit.jupiter.api.Test;

public class SystemPropertiesTests {

    @Test
    void systemPropertiesTest(){
        String browser = System.getProperty("browser");
        System.out.println(browser);
    }
    @Test
    void systemProperties1Test(){
        System.setProperty("browser", "chrome");
        String browser = System.getProperty("browser");
        System.out.println(browser);
    }
    @Test
    void systemProperties2Test(){
        System.setProperty("browser", "mozilla");
        String browser = System.getProperty("browser");
        System.out.println(browser);
    }
}
