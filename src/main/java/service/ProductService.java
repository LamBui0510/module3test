package service;

import dao.ProductDao;
import model.Product;

import java.util.List;

public class ProductService {
    ProductDao productDao= new ProductDao();
    List<Product> productList = productDao.findAll();

    public void add(Product product){
        productDao.add(product);
        productList = productDao.findAll();
    }
    public void update(int id, Product product){
        productDao.update(id,product);
        productDao.findAll();
    }
    public void delete(int id){
        productDao.delete(id);
        productDao.findAll();
    }

}
