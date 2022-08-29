package ru.netology.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {

  ProductRepository repository = new ProductRepository();
  ProductManager manager = new ProductManager(repository);

  Product Bestseller = new Book(50, 1101, "HistoricalLiterature ", "Bestseller");
  Product Detective = new Book(450, 1102, "EnglishWriters", "Detective");
  Product Poetry = new Book(65, 1103, "ClassicLiterature", "Poetry");
  Product IPhone = new Smartphone(450, 2201, "ElectronicSectionOne", "IPhone 13 Pro");
  Product Samsung = new Smartphone(350, 450, "ElectronicSectionOne", "Samsung Galaxy S22");
  Product Nokia = new Smartphone(280, 2203, "ElectronicSectionSale", "Nokia XR 20");

  @BeforeEach
  void addAllProducts() {
    manager.add(Bestseller);
    manager.add(Detective);
    manager.add(Poetry);
    manager.add(IPhone);
    manager.add(Samsung);
    manager.add(Nokia);
  }

  @Test
  void searchSeveralProductsByText() {
    Product[] actual = manager.searchByProductsByText("al");
    Product[] expected = {Bestseller, Samsung, Nokia};
    assertArrayEquals(expected, actual);
  }

  @Test
  void searchOnlyOneProductByText() {
    Product[] actual = manager.searchByProductsByText("try");
    Product[] expected = {Poetry};
    assertArrayEquals(expected, actual);
  }

  @Test
  void searchMissingProductByText() {
    Product[] actual = manager.searchByProductsByText("abc");
    Product[] expected = {};
    assertArrayEquals(expected, actual);
  }

  @Test
  void searchOnlyOneProductByPriceAndId() {
    Product[] actual = manager.searchByPriceAndId(1101);
    Product[] expected = {Bestseller};
    assertArrayEquals(expected, actual);
  }

  @Test
  void searchSeveraProductsByPriceAndId() {
    Product[] actual = manager.searchByPriceAndId(450);
    Product[] expected = {Detective, IPhone, Samsung};
    assertArrayEquals(expected, actual);
  }

  @Test
  void searchMissingProductByPriceAndId() {
    Product[] actual = manager.searchByPriceAndId(77);
    Product[] expected = {};
    assertArrayEquals(expected, actual);
  }
}