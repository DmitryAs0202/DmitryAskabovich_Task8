package entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Order implements Serializable {

  private static final long serialVersionUID = -8740007752249074129L;

  private List<Product> products;

  public Order() {
    products = new ArrayList<>();
  }

  public void add(Product product) {
    products.add(product);
  }

  public List<Product> getProducts() {
    return products;
  }

  public void setProducts(List<Product> products) {
    this.products = products;
  }

  @Override
  public String toString() {
    return products.toString();
  }
}
