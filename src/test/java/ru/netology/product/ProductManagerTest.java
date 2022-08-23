package ru.netology.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductManagerTest {

  ProductRepository repository = new ProductRepository();
  ProductManager manager = new ProductManager(repository);

  Product Bestseller = new Book(50, 1101, "Printed", "Bestseller");
  Product Detective = new Book(55, 1102, "Printed", "Detective");
  Product Poetry = new Book(65, 1103, "Printed", "Poetry");
  Product IPhone = new Smartphone(450, 2201, "Electronic", "IPhone 13 Pro");
  Product Samsung = new Smartphone(350, 2202, "Electronic", "Samsung Galaxy S22");
  Product Nokia = new Smartphone(280, 2203, "Electronic", "Nokia XR 20");

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
  void searchSeveralProductByText() {
    Product[] actual = manager.searchByName("ect");
    Product[] expected = {IPhone, Samsung, Nokia};
    assertArrayEquals(expected, actual);
  }

  @Test
  void searchOnlyOneProductByPrice() {
    Product[] actual = manager.searchByPrice(65);
    Product[] expected = {Poetry};
    assertArrayEquals(expected, actual);
  }
}