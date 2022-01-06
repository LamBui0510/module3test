package dao;

import model.Product;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDao implements IDAO <Product> {
    ConnectionJDBC connectionJDBC = new ConnectionJDBC();
    @Override
    public void add(Product product) {
        String insertProduct = "Insert into product (name,price,quantity,color,description,idCategory) values(?,?,?,?,?,?) ";
        try {
            PreparedStatement preparedStatement = connectionJDBC.getConnection().prepareStatement(insertProduct);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setInt(6, product.getIdCategories());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        String select = "Select product.*, category.namecategory from product join category on product.idCategory = category.idCategory";
        try {
            preparedStatement = ConnectionJDBC.getConnection().prepareStatement(select);
            ConnectionJDBC.getConnection().setAutoCommit(false);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String description = rs.getString("description");
                String namecategory = rs.getString("namecategory");
                productList.add(new Product(id, name, price, quantity, color, description, namecategory));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public void delete(int id) {
        String delete = "Delete from product where id = ?";
        try {
            PreparedStatement preparedStatement = ConnectionJDBC.getConnection().prepareStatement(delete);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void update(int id, Product product) {
        String update = "Update product set name= ?,price= ?,quantity= ?,color= ?,description= ?,idCategory= ? where id =? ";
        try {
            PreparedStatement preparedStatement = ConnectionJDBC.getConnection().prepareStatement(update);
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setInt(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setInt(6, product.getIdCategories());
            preparedStatement.setInt(7, id);
            preparedStatement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Product> searchByName(String findName) {
        List<Product> productList = new ArrayList<>();
        String selectByName = "Select product.*, category.namecategory from product join category on product.idCategory = category.idCategory where product.name like  '%" + findName + "%'";
        try {
            PreparedStatement preparedStatement = ConnectionJDBC.getConnection().prepareStatement(selectByName);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                Double price = rs.getDouble("price");
                int quantity = rs.getInt("quantity");
                String color = rs.getString("color");
                String description = rs.getString("description");
                String namecategory = rs.getString("namecategory");
                productList.add(new Product(id, name, price, quantity, color, description, namecategory));
            }return productList;
        } catch (SQLException e) {
            e.printStackTrace();
        } return null;
    }
}
