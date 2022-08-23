package ru.netology.product;

public class Book extends Product {
  private String genre;

  public Book(int price, int id, String name, String genre) {
    super(price, id, name);
    this.genre = genre;
  }
}