package ru.netology.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductRepositoryTest {

  private final ProductRepository repository = new ProductRepository();
  Product productBook = new Product(200, 11, "Printed");
  Product productSmartphone = new Product(45, 22, "Electronic");
  Product Bestseller = new Book(50, 1101, "Printed", "Bestseller");
  Product Detective = new Book(55, 1102, "Printed", "Detective");
  Product Poetry = new Book(65, 1103, "Printed", "Poetry");
  Product IPhone = new Smartphone(450, 2201, "Electronic", "IPhone 13 Pro");
  Product Samsung = new Smartphone(350, 2202, "Electronic", "Samsung Galaxy S22");
  Product Nokia = new Smartphone(280, 2203, "Electronic", "Nokia XR 20");

  @BeforeEach
  void saveAll() {
    repository.save(productBook);
    repository.save(productSmartphone);
    repository.save(Bestseller);
    repository.save(Detective);
    repository.save(Poetry);
    repository.save(IPhone);
    repository.save(Samsung);
    repository.save(Nokia);
  }

  @Test
  void findAllProducts() {
    Product[] expected = {productBook, productSmartphone, Bestseller, Detective, Poetry, IPhone, Samsung, Nokia};
    assertArrayEquals(expected, repository.findAll());
  }

  @Test
  void removeSeveralProductsById() {
    repository.removeById(2201);
    repository.removeById(1103);

    Product[] expected = {productBook, productSmartphone, Bestseller, Detective, Samsung, Nokia};
    assertArrayEquals(expected, repository.findAll());
  }
}