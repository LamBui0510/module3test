package service;

import dao.ProductDao;
import model.Product;

public class ProductService {
    ProductDao productDao= new ProductDao();

    public void add(Product product){
        productDao.add(product);
        productDao.findAll();
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
