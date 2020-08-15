package execution;

import entities.ClientBase;
import entities.Customer;
import entities.Order;
import entities.Product;
import entities.Store;
import enums.ProductType;
import exceptions.NoSuchIdException;
import exceptions.NotEnoughMoneyException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static final String GREETING = "Приветствуем вас в магазине Mobile Store!";
  public static final String LOGIN_REQUEST = "Введите логин: ";
  public static final String PASSWORD_REQUEST = "Введите Пароль: ";
  public static final String CHECKING_FAILING = "Введены некорректные данные. "
      + "Проверьте логин и пароль";
  public static final String PRE_MENU = "Меню";
  public static final String FIRST_ITEM = "1.Показать список товаров";
  public static final String SECOND_ITEM = "2.Заказать товар";
  public static final String THIRD_ITEM = "3.Проверить сумму на счете";
  public static final String FOURTH_ITEM = "4.Показать корзину заказанных товаров";
  public static final String FIFTH_ITEM = "5.Записать список заказанных товаров в файл для печати";
  public static final String SIXTH_ITEM = "6.Запись объекта заказа в файл(Сериализация)";
  public static final String SEVENTH_ITEM = "7.Чтение объекта заказа из файла(Десериализация)";
  public static final String EIGHT_ITEM = "8.Выход";
  public static final String NOT_ENOUGH_MONEY = "Недостаточно денег для покупки товара ";
  public static final String CHECK_BALANCE = "На вашем счете: ";
  public static final String BYN = " BYN";
  public static final String INVALID_MENU_ITEM = "Выбран несуществующий пункт меню";
  public static final String SUCCESSFUL_PURCHASE = "Вы приобрели: ";
  public static final String NO_PRODUCT = "Не существет товара под номером ";
  public static final String FILE_PATH1 = "src/Order.txt";
  public static final String FILE_PATH2 = "src/OrderObject.txt";
  public static final Scanner SCANNER = new Scanner(System.in);
  public static final BufferedReader READER = new BufferedReader(new InputStreamReader(System.in));
  public static ClientBase clientBase = new ClientBase();
  public static Store store = new Store();
  public static Customer customer;
  public static Order customerOrder = new Order();


  public static void main(String[] args) {
    System.out.println(GREETING);
    boolean checking = true;
    while (checking) {
      System.out.print(LOGIN_REQUEST);
      String login = SCANNER.nextLine();
      System.out.print(PASSWORD_REQUEST);
      String password = SCANNER.nextLine();
      if (clientBase.checkUser(login, password)) {
        System.out.println("Вход выполнен успешно");
        customer = clientBase.getCustomer(login, password);
        checking = false;
      } else {
        System.out.println(CHECKING_FAILING);
      }
    }
    showMenu();


  }

  public static void showMenu() {
    System.out.println();
    System.out.println(PRE_MENU);
    System.out.println(
        FIRST_ITEM + "\n" + SECOND_ITEM + "\n" + THIRD_ITEM + "\n" + FOURTH_ITEM + "\n" + FIFTH_ITEM
            + "\n" + SIXTH_ITEM + "\n" + SEVENTH_ITEM + "\n" + EIGHT_ITEM);
    System.out.print("Выберите пункт из меню: ");
    int choice = SCANNER.nextInt();
    menuChoice(choice);
  }

  public static void menuChoice(int choice) {
    switch (choice) {
      case 1:
        store.showProducts();
        showMenu();
        break;
      case 2:
        System.out.print("Введите номера товаров через пробел: ");
        String order = null;
        try {
          order = READER.readLine();
        } catch (IOException e) {
          System.out.println("Введены некорректные данные");
          showMenu();
        }
        String[] order1 = order.split(" ");
        for (int i = 0; i < order1.length; i++) {
          int temp = Integer.parseInt(order1[i]);
          if (store.checkId(temp)) {
            Product product = store.getProduct(temp);
            if (product.getCost() <= customer.getMoneyAmount()) {
              customerOrder.add(product);
              customer.setMoneyAmount(customer.getMoneyAmount() - product.getCost());
              store.removeProduct(temp);
              System.out.println(SUCCESSFUL_PURCHASE + product.getName());
            } else {
              try {
                throw new NotEnoughMoneyException(NOT_ENOUGH_MONEY + product.getName());
              } catch (NotEnoughMoneyException e) {
                System.out.println(e.getMessage());
              }

            }
          } else {
            try {
              throw new NoSuchIdException(NO_PRODUCT + temp);
            } catch (NoSuchIdException e) {
              System.out.println(e.getMessage());
            }
          }
        }
        showMenu();
        break;
      case 3:
        System.out.println(CHECK_BALANCE + customer.getMoneyAmount() + BYN);
        showMenu();
        break;
      case 4:
        System.out.println("Ваши товары: ");
        List<Product> list = customerOrder.getProducts();
        list.forEach(product -> System.out.println(product));
        showMenu();
        break;
      case 5:
        File file = new File(FILE_PATH1);
        try {
          PrintWriter pw = new PrintWriter(file);
          List<Product> cart = customerOrder.getProducts();
          cart.forEach(product -> pw.println(product));
          pw.close();
          System.out.println("Запись выполнена!");
        } catch (FileNotFoundException e) {
          System.out.println("Ошибка с записью в файл!");
        }
        showMenu();
        break;
      case 6:
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
            "src/OrderObject.txt"))) {
          oos.writeObject(customerOrder);
          System.out.println("Сериализация выполнена!");

        } catch (IOException e) {
          e.printStackTrace();
        }

        showMenu();
        break;
      case 7:
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH2))) {
          Order readOrder = (Order) ois.readObject();
          System.out.println("Чтение выполнено");
          System.out.println(readOrder);

        } catch (IOException | ClassNotFoundException e) {
          e.printStackTrace();
        }

        showMenu();
        break;
      case 8:
        return;
      default:
        System.out.println(INVALID_MENU_ITEM);
        showMenu();
        break;
    }
  }


}
