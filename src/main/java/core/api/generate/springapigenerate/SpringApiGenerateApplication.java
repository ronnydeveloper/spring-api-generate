package core.api.generate.springapigenerate;

import generator.GeneratorModel;
import generator.GeneratorRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringApiGenerateApplication {

    public static void main(String[] args) {
        GeneratorModel.readXML();
//        GeneratorRepository.readXML();
        SpringApplication.run(SpringApiGenerateApplication.class, args);
    }


}
