package guide.tm;

import jig.erd.JigErd;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.util.Map;

@SpringBootTest
public class ErdTest {
    @Test
    void run(@Autowired DataSource dataSource) {
        JigErd.run(dataSource);
    }
}