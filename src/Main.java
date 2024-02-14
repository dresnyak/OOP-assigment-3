import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.lang.Iterable;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DBWork a = new DBWork();
        User currUser = new User();
        User currUser1 = new User();
        int isAuth = 0;
        System.out.println("Здравствуйте! Это мой первый проект с дата базами");
        while(true) {
            System.out.println("Чтобы вы хотели сделать?");
            System.out.println("1. Авторизоваться" + '\n' + "2. Зарегистрироваться");
            int p = scanner.nextInt();
            if (p == 2) {
                System.out.println("Ваш емайл: ");
                String email = scanner.next();
                System.out.println("Ваше имя: ");
                String name = scanner.next();
                System.out.println("Ваша фамилия: ");
                String surname = scanner.next();
                System.out.println("Введите ваш пароль: ");
                String pass = scanner.next();
                System.out.println("Введите ваш возраст: ");
                int age = scanner.nextInt();
                currUser.setEmail(email);
                currUser.setName(name);
                currUser.setSurname(surname);
                currUser.setAge(age);
                currUser.setEmail(email);
                currUser.setPass(pass);
                a.InsertUser(currUser);
                System.out.println("Вы зарегистрированы!" + '\n' + "Осталось зайти на ваш аккаунт");
            } else if (p == 1) {
                System.out.println("Введите вашу почту: ");
                String checkEmail = scanner.next();
                System.out.println("Введите ваш пароль: ");
                String checkPass = scanner.next();
                currUser1 = a.CurrUser(checkEmail);
                if (currUser1 != null) {
                    if (a.checkPass(currUser1, checkPass)) {
                        isAuth = 1;
                        System.out.println("Вы успешно авторизованы!");
                        break;
                    } else {
                        //
                        // System.out.println(currUser1.toString());
                        System.out.println("Неправильный пароль!");
                    }
                } else {
                    System.out.println("Такого пользователя не существует");
                }
            } else {
                System.out.println("Такого действия нету!");
            }
        }
        while(isAuth == 1){
            System.out.println("Чтобы вы хотели сделать?" + '\n' + "1. Изменить пароль" + '\n' + "2. Удалить аккаунт");
            int b = scanner.nextInt();
            if(b == 1){
                System.out.print("Введите ваш старый пароль: ");
                String oldPass = scanner.next();
                System.out.print("Введите ваш новый пароль: ");
                String newPass = scanner.next();
                a.ChangePass(currUser1, oldPass, newPass);
            }
            else if(b == 2){
                System.out.println("Вы уверены что хотите удалить свой аккаунт?" + '\n' + "1. Да" + '\n' + "2. Нет");
                b = scanner.nextInt();
                if(b == 1){
                    a.delUser(currUser1);
                    isAuth = 0;

                    System.out.println("Пользователь был удален!");
                }
            }
            else{
                System.out.println("Такого действия нету!");
            }
        }
    }
}