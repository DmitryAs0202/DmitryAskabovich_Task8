package entities;

import enums.ProductType;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {

  private static int idCounter;

  private Map<Integer, Product> products;

  public Store() {
    products = new HashMap<>();
    idCounter++;
    products.put(idCounter, new Product(idCounter, "Iphone XS 64GB", ProductType.PHONE,
        new Date("12 December 2019"), 1750));
    idCounter++;
    products.put(idCounter, new Product(idCounter, "Iphone XS MAX 64GB", ProductType.PHONE,
        new Date("17 January 2019"), 1950));
    idCounter++;
    products.put(idCounter, new Product(idCounter, "Iphone XR 64GB", ProductType.PHONE,
        new Date("8 June 2019"), 1550));
    idCounter++;
    products.put(idCounter, new Product(idCounter, "Samsung Galaxy A41 64GB",
        ProductType.PHONE, new Date("20 June 2020"), 543));
    idCounter++;
    products.put(idCounter, new Product(idCounter, "Samsung Galaxy S20 Ultra 5G 512GB",
        ProductType.PHONE, new Date("19 March 2020"), 3400));
    idCounter++;
    products.put(idCounter, new Product(idCounter, "Samsung Galaxy S10 Lite",
        ProductType.PHONE, new Date("2 April 2020"), 1150));
    idCounter++;
    products.put(idCounter, new Product(idCounter, "Sony MDR-ZX660AP",
        ProductType.HEADPHONES, new Date("4 July 2020"), 100));
    idCounter++;
    products.put(idCounter, new Product(idCounter, "Sony MDR-ZX310AP",
        ProductType.HEADPHONES, new Date("6 May 2020"), 39));
    idCounter++;
    products.put(idCounter, new Product(idCounter, "Apple EarPods с разъёмом 3.5 мм",
        ProductType.HEADPHONES, new Date("9 May 2020"), 60));
    idCounter++;
    products.put(idCounter, new Product(idCounter, "Apple EarPods с разъёмом Lightning",
        ProductType.HEADPHONES, new Date("25 May 2020"), 65));
    idCounter++;
    products.put(idCounter, new Product(idCounter, "Apple AirPods 2",
        ProductType.HEADPHONES, new Date("13 April 2020"), 460));
    idCounter++;
    products.put(idCounter, new Product(idCounter, "Samsung Galaxy Watch 3 45mm",
        ProductType.SMART_WATCH, new Date("25 April 2020"), 1397));
    idCounter++;
    products.put(idCounter, new Product(idCounter,
        "Xiaomi Amazfit Stratos 3 Standard Edition", ProductType.SMART_WATCH,
        new Date("15 March 2020"), 513));
    idCounter++;
    products.put(idCounter, new Product(idCounter, "Samsung Galaxy Watch 3 41mm",
        ProductType.SMART_WATCH, new Date("29 August 2019"), 1325));
    idCounter++;
    products.put(idCounter, new Product(idCounter, "Apple Watch Series 5 44 мм",
        ProductType.SMART_WATCH, new Date("15 July 2020"), 1008));
    idCounter++;
    products.put(idCounter, new Product(idCounter, "Apple Watch Series 4 LTE 44mm",
        ProductType.SMART_WATCH, new Date("20 July 2020"), 2361));
    idCounter++;
    products.put(idCounter, new Product(idCounter, "HP Laptop 15S-EQ1042UR",
        ProductType.COMPUTER, new Date("28 July 2020"), 1150));
    idCounter++;
    products.put(idCounter, new Product(idCounter, "HP Gaming Pavilion 15-DK0022UR",
        ProductType.COMPUTER, new Date("10 July 2020"), 2334));
    idCounter++;
    products.put(idCounter, new Product(idCounter, "Samsung UE43N5570AU",
        ProductType.TV, new Date("8 June 2020"), 850));
    idCounter++;
    products.put(idCounter, new Product(idCounter, "Sony KD-55XG8596",
        ProductType.TV, new Date("20 June 2020"), 2450));

  }

  public void showProducts() {
    System.out.println();
    System.out.println("Доступные товары:");
    products.forEach((k, v) -> System.out.println(v));
  }

  public boolean checkId(int id) {
    if (products.containsKey(id)) {
      return true;
    } else {
      return false;
    }
  }

  public Product getProduct(int number) {
    Product chosen = products.get(number);
    return chosen;
  }

  public void removeProduct(int number) {
    products.remove(number);
  }

  public Map<Integer, Product> getProducts() {
    return products;
  }

  public void setProducts(Map<Integer, Product> products) {
    this.products = products;
  }


}
