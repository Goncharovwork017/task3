import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;

/**
 * Created by ivan on 14.05.2017.
 */


@SpringBootApplication
@Configuration
public class App extends SpringBootServletInitializer {
    public static void main(String[] args) throws Exception{
        SpringApplication.run(App.class,args);

    }

}
