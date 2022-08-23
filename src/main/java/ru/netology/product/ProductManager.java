package ru.netology.product;

public class ProductManager {

  private final ProductRepository repository;

  public ProductManager(ProductRepository repository) {
    this.repository = repository;
  }

  public void add(Product product) {
    repository.save(product);
  }

  public Product[] searchByName(String text) {
    Product[] result = new Product[0];
    for (Product product : repository.findAll()) {
      if (matchesName(product, text)) {
        Product[] tmp = new Product[result.length + 1];
        System.arraycopy(result, 0, tmp, 0, result.length);
        tmp[tmp.length - 1] = product;
        result = tmp;
      }
    }
    return result;
  }

  public boolean matchesName(Product product, String search) {
    if (product.getName().contains(search)) {
      return product.getName().contains(search);
    }
    return false;
  }

  public Product[] searchByPrice(int price) {
    Product[] result = new Product[0];
    for (Product product : repository.findAll()) {
      if (matchesPrice(product, price)) {
        Product[] tmp = new Product[result.length + 1];
        System.arraycopy(result, 0, tmp, 0, result.length);
        tmp[tmp.length - 1] = product;
        result = tmp;
      }
    }
    return result;
  }

  public boolean matchesPrice(Product product, int search) {
    if (product.getPrice() == search) {
      return true;
    } else {
      return false;
    }
  }
}
