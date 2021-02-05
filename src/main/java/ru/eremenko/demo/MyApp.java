package ru.eremenko.demo;

import java.sql.SQLException;

import ru.eremenko.demo.repo.WorkWithDb;

public class MyApp {

	public static void main(String[] args) throws SQLException {
		WorkWithDb workWithDb = new WorkWithDb();

		if(args.length == 0){
			System.out.println("Введите параметр");
		}else {
			if(args[0].equals("1")){
				workWithDb.createTable();
			}
			if(args[0].equals("2")){
				workWithDb.createUser(args[1] +" "+args[2]+" "+args[3],args[4],args[5]);
			}
			if(args[0].equals("3")){
				for(String[] user : workWithDb.getUniq()){
					System.out.print("ФИО: "+user[0].trim()+" дата рождения: "+user[1]+" пол: "+user[2]);
					System.out.println();
				}
			}
			if(args[0].equals("4")){

			}
			if(args[0].equals("5")){
				workWithDb.getStartWithF();
			}
		}
	}

}
