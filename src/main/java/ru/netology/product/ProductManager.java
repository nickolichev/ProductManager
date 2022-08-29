package ru.netology.product;

public class ProductManager {

  private final ProductRepository repository;

  public ProductManager(ProductRepository repository) {
    this.repository = repository;
  }

  public void add(Product product) {
    repository.save(product);
  }

  public Product[] searchByProductsByText(String text) {
    Product[] result = new Product[0];
    for (Product product : repository.findAll()) {
      if (matchesProductsByText(product, text)) {
        Product[] tmp = new Product[result.length + 1];
        System.arraycopy(result, 0, tmp, 0, result.length);
        tmp[tmp.length - 1] = product;
        result = tmp;
      }
    }
    return result;
  }

  public boolean matchesProductsByText(Product product, String search) {
    if (product instanceof Smartphone) {
      Smartphone smartphone = (Smartphone) product;
      if (product.getName().contains(search) || smartphone.getModel().contains(search)) {
        return true;
      }
    }
    if (product instanceof Book) {
      Book book = (Book) product;
      return product.getName().contains(search) || book.getGenre().contains(search);
    }
    return false;
  }

  public Product[] searchByPriceAndId(int number) {
    Product[] result = new Product[0];
    for (Product product : repository.findAll()) {
      if (matchesPricePriceAndId(product, number)) {
        Product[] tmp = new Product[result.length + 1];
        System.arraycopy(result, 0, tmp, 0, result.length);
        tmp[tmp.length - 1] = product;
        result = tmp;
      }
    }
    return result;
  }

  public boolean matchesPricePriceAndId(Product product, int search) {
    if (product instanceof Smartphone) {
      Smartphone smartphone = (Smartphone) product;
      if (product.getPrice() == search) {
        return true;
      }
      if (smartphone.getId() == search) {
        return true;
      }
    }
    if (product instanceof Book) {
      Book book = (Book) product;
      if (product.getPrice() == search) {
        return true;
      }
      return book.getId() == search;
    }
    return false;
  }
}
