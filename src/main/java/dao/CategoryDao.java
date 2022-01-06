package dao;

import model.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDao {

    public List<Category> findAll() {
        List<Category> categoryList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        String select = "Select *from category";
        try {
            preparedStatement = ConnectionJDBC.getConnection().prepareStatement(select);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idCategory = rs.getInt("idCategory");
                String namecategory = rs.getString("namecategory");
                categoryList.add(new Category(idCategory,namecategory));

            } return categoryList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}
