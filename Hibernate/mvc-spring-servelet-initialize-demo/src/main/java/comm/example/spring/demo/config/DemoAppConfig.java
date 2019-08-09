package comm.example.spring.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;




@Configuration
@EnableWebMvc
@ComponentScan (basePackages="comm.example.spring.demo")
public class DemoAppConfig 
{
	@Bean
	public ViewResolver viewResolver()
	{
		return new InternalResourceViewResolver("/WEB-INF/view/",".jsp");
	}

}
