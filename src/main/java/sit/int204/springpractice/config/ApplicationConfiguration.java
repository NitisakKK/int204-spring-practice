package sit.int204.springpractice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sit.int204.springpractice.utils.ListMapper;

@Configuration
public class ApplicationConfiguration {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    @Bean
    public ListMapper listMapper() {
        return new ListMapper();
    }
}
