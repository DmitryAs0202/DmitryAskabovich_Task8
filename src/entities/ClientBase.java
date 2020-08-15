package entities;

import java.util.ArrayList;
import java.util.List;

public class ClientBase {

  List<Customer> customerList;

  public ClientBase() {
    customerList = new ArrayList<>();
    customerList.add(new Customer("Tim", "45656rt", 2500));
    customerList.add(new Customer("Mike1989", "ghs234", 5000));
    customerList.add(new Customer("Kruger345", "kr4565", 1000));
    customerList.add(new Customer("Nicole89", "hrosae234", 9000));
    customerList.add(new Customer("joan1992", "uimoon34", 4500));
    customerList.add(new Customer("HansSt", "municher56", 9600));
    customerList.add(new Customer("Kate22", "78345pass", 3000));
  }

  public boolean checkUser(String login, String password) {
    Customer customer = new Customer(login, password, 0);
    if (customerList.contains(customer)) {
      return true;
    } else {
      return false;
    }
  }

  public Customer getCustomer(String login, String password) {
    Customer customer = new Customer(login, password, 0);
    int index = customerList.indexOf(customer);
    return customerList.get(index);
  }

  public List<Customer> getCustomerList() {
    return customerList;
  }

  public void setCustomerList(List<Customer> customerList) {
    this.customerList = customerList;
  }
}
