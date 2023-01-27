package guide.tm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.util.Map;

@SpringBootTest
public class JigErdTest {
    @Test
    void run(@Autowired DataSource dataSource) {
        jig.erd.JigErd.run(dataSource, Map.of(
                "jig.erd.output.directory", "./build-jig-erd",
                "jig.erd.output.format", "svg",
                "jig.erd.output.rankdir", "RL",
                "jig.erd.dot.custom.区分.label-pattern", ".+区分",
                "jig.erd.dot.custom.区分.shape", "parallelogram",
                "jig.erd.dot.custom.区分.fillcolor", "yellow"
        ));
    }
}