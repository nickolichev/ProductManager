package ru.netology.product;

public class ProductRepository {
    private Product[] products = new Product[0];

    public void save(Product newProduct) {
      Product[] tmp = new Product[products.length + 1];
      System.arraycopy(products, 0, tmp, 0, products.length);
      tmp[tmp.length - 1] = newProduct;
      products = tmp;
    }

    public void removeById(int id) {
      int length = products.length - 1;
      Product[] tmp = new Product[length];
      int index = 0;
      for (Product product : products) {
        if (product.getId() != id) {
          tmp[index] = product;
          index++;
        }
      }
      products = tmp;
    }

    public Product[] findAll() {
      return products;
    }
  }

