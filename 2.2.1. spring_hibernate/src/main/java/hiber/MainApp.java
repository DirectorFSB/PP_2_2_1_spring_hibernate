package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      User user1 = new User("Эрик", "Давидыч", "Davidich@mail.ru" , new Car("BMW x5",1234_56789));
      User user2 = new User("Вова", "Путин", "Putin@mail.ru" , new Car("Mersedes w221",9876_54321));
      User user3 = new User("Степашка", "Иванов", "Ivanov@mail.ru" , new Car("Lada vesta",123454321));
      User user4 = new User("Герман", "Миллер", "Miller@mail.ru" , new Car("Volvo v90",987656789));
      userService.add(user1);
      userService.add(user2);
      userService.add(user3);
      userService.add(user4);
      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println(user.getCar().toString());
         System.out.println();
      }
      System.out.println(userService.getUserWithCar("BMW x5" , 1234_56789).toString());
      context.close();
   }
}
