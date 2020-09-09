package model.service.category;

import model.Category;
import model.JDBC;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryDAOImp implements ICategory {
    private static final String SELECT_CATEGORY_BY_ID_SQL = "SELECT * FROM Category where id = ?;";

    @Override
    public Category selectCategory(int id) throws SQLException {
        System.out.println("SELECT_CATEGORY_BY_ID_SQL");
        Category category = new Category();
        Connection connection = JDBC.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CATEGORY_BY_ID_SQL);
        preparedStatement.setInt(1, id);
        try {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                category.setName(name);
                category.setId(id);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public boolean insertCategory() {
        return false;
    }

    @Override
    public boolean updateCategory() {
        return false;
    }

    @Override
    public boolean deleteCategory() {
        return false;
    }
}
