package problem1;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		List<Integer> cities = context.getBean("cities" ,List.class);
		List<Integer> students = context.getBean("students", List.class);
		System.out.println(cities);
		System.out.println(students);
	} 
}
