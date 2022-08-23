package ru.netology.product;

public class Smartphone extends Product {
  private String model;

  public Smartphone(int price, int id, String name, String model) {
    super(price, id, name);
    this.model = model;
  }
}