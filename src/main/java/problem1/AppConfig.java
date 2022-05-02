package problem1;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;

@Configuration
@ComponentScan
@PropertySource("properties.properties")
public class AppConfig {
	
	@Autowired
	private Environment env;
	
	@Bean(value="cities")
	@Scope("prototype")
	public List<String> cities () {
		List<String> list = new ArrayList<>();
		list.add(env.getProperty("city1"));
		list.add(env.getProperty("city2"));
		list.add(env.getProperty("city3"));
		list.add(env.getProperty("city4"));
		list.add(env.getProperty("city5"));
		return list;
	}
	
	@Bean(value="students")
	public List<String> students() {
		List<String> list = new ArrayList<>();
		list.add("Jatin");
		list.add("Jobin");
		list.add("Shivendra");
		list.add("Ronald");
		list.add("Shravan");
		return list;
	}

}
