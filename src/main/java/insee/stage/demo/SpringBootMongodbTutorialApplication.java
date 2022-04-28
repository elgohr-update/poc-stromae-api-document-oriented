package insee.stage.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@EnableSwagger2
@Import(SpringFoxConfig.class)
public class SpringBootMongodbTutorialApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootMongodbTutorialApplication.class, args);
    }
}
