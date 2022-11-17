package pro.sky.java.course3.weblibrary;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pro.sky.java.course3.weblibrary.service.EmployeeService;

@SpringBootApplication
public class WebLibraryApplication {

    public static void main(String[] args) {
        EmployeeService.firstFillingEmployees();
        SpringApplication.run(WebLibraryApplication.class, args);
    }

}
