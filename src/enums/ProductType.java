package enums;

public enum ProductType {
  PHONE("Мобильные телефоны"),
  HEADPHONES("Наушники и аудио"),
  SMART_WATCH("Умные часы"),
  COMPUTER("Компьютеры и ноутбуки"),
  TV("Телевизоры, видео");

  private String name;

  ProductType(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return name;
  }
}
