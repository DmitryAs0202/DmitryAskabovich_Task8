package entities;

import enums.ProductType;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

public class Product implements Serializable {

  public static final DateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
  private static final long serialVersionUID = -7673055660965860420L;

  private int id;
  private String name;
  private ProductType type;
  private Date dateOfManufacture;
  private int cost;

  public Product(int id, String name, ProductType type, Date dateOfManufacture, int cost) {
    this.id = id;
    this.name = name;
    this.type = type;
    this.dateOfManufacture = dateOfManufacture;
    this.cost = cost;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public ProductType getType() {
    return type;
  }

  public void setType(ProductType type) {
    this.type = type;
  }

  public String getDateOfManufacture() {
    return DATE_FORMAT.format(this.dateOfManufacture);
  }

  public void setDateOfManufacture(Date dateOfManufacture) {
    this.dateOfManufacture = dateOfManufacture;
  }

  public int getCost() {
    return cost;
  }

  public void setCost(int cost) {
    this.cost = cost;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Product)) {
      return false;
    }
    Product product = (Product) o;
    return Objects.equals(getName(), product.getName()) &&
        getType() == product.getType();
  }

  @Override
  public int hashCode() {
    return Objects.hash(getName(), getType());
  }

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append(id).append(". ");
    sb.append(name).append(", категория: ").append(type.toString());
    sb.append(", дата изготовления: ").append(getDateOfManufacture());
    sb.append(". Цена: ").append(cost).append(" BYN.");
    return sb.toString();
  }
}
