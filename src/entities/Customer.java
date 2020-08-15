package entities;

import java.util.Objects;

public class Customer {

  private String login;
  private String password;
  private int moneyAmount;

  public Customer(String login, String password, int moneyAmount) {
    this.login = login;
    this.password = password;
    this.moneyAmount = moneyAmount;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getMoneyAmount() {
    return moneyAmount;
  }

  public void setMoneyAmount(int moneyAmount) {
    this.moneyAmount = moneyAmount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Customer)) {
      return false;
    }
    Customer customer = (Customer) o;
    return Objects.equals(getLogin(), customer.getLogin()) &&
        Objects.equals(getPassword(), customer.getPassword());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getLogin(), getPassword());
  }

  @Override
  public String toString() {
    return "Customer{" +
        "login='" + login + '\'' +
        ", password='" + password + '\'' +
        '}';
  }
}
