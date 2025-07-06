package cl.duoc.ms_sales_db.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI apiInfo(){
        return new OpenAPI()
                   .info(new Info().title("Documentación Sales DB")
                                    .description("A continuación puedes ver los métodos a utilizar")
                                    .version("1.0.0"));
    }

}
