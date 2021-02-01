package ru.eremenko.demo;

import org.springframework.beans.factory.annotation.Autowired;
import ru.eremenko.demo.model.User;
import ru.eremenko.demo.repo.UserRepo;

import java.time.LocalDate;
import java.util.*;

public class MyApp {
	@Autowired
	private static UserRepo userRepo;
	public static void main(String[] args) {
		if(args.length == 0){
			System.out.println("Введите параметр");
		}else {
			if(args[0].equals("1")){
				System.out.println("Создал БД");
			}
			if(args[0].equals("2")){
				String[] b = args[4].split("-");
				LocalDate birthday = LocalDate.of(Integer.parseInt(b[0]),Integer.parseInt(b[1]),Integer.parseInt(b[2]));
				userRepo.save(new User(args[1] +" "+args[2]+" "+args[3],birthday,args[5]));
			}
			if(args[0].equals("3")){
				for(User user : getUniq()){
					System.out.println(user.getUsername()+" "+user.getBirthday()+" "+user.getGender());
				}
			}
			if(args[0].equals("4")){

			}
			if(args[0].equals("5")){
				long before = System.currentTimeMillis();
				userRepo.findUserByUsernameStartingWithAndGender("F","male");
				System.out.println(System.currentTimeMillis() - before);
			}
		}
	}

	public static List<User> getUniq(){

		List<User> uniqUsers = userRepo.findDistinctByUsernameAndBirthday();
		Collections.sort(uniqUsers, Comparator.comparing(User::getUsername));
		return uniqUsers;
	}

}
