package ru.netology.product;

public class Product {
  private int price;
  private int id;
  private String name;

  public Product(int price, int id, String name) {
    this.price = price;
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getPrice() {
    return price;
  }
}