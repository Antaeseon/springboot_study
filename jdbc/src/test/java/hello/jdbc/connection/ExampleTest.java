package hello.jdbc.connection;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExampleTest {

    @Autowired
    private Example example;

    @Test
    void helli() {
        example.print();
    }

}