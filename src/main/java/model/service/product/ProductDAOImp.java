package model.service.product;

import model.JDBC;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAOImp implements IProductDAO {
//    public Product(int id, String name, double price, int quantity, String color, String description, int categoryID) {

    private static final String INSERT_PRODUCT_SQL = "INSERT INTO Product" +
            " (name, price,quantity,color,description,categoryID) VALUES " +
            " (?, ?, ?, ?, ?,?);";
    private static final String SELECT_PRODUCT_BY_ID_SQL = "SELECT * FROM Product where id = ?;";
    private static final String SELECT_PRODUCT_BY_NAME_SQL = "SELECT * FROM Product where name like ?;";
    private static final String SELECT_ALL_PRODUCT_SQL = "SELECT * FROM Product";
    private static final String DELETE_PRODUCT_BY_ID_SQL = "DELETE  FROM Product where id = ?;";
    private static final String UPDATE_PRODUCT_SQL = "UPDATE Product SET " +
            "name = ?, price = ? , quantity = ?, color = ?, description = ?, categoryID = ?" +
            "where id = ?;";


    @Override
    public Product selectProduct(int id) throws SQLException {
        System.out.println("SELECT_PRODUCT_BY_ID_SQL");
       Product product = new Product();
        Connection connection = JDBC.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_ID_SQL);
        preparedStatement.setInt(1,id);
        try {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                int categoryID = resultSet.getInt("categoryID");
                product.setId(id);
                product.setName(name);
                product.setPrice(price);
                product.setQuantity(quantity);
                product.setColor(color);
                product.setDescription(description);
                product.setCategoryID(categoryID);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public boolean insertProduct(Product product) {

        System.out.println("INSERT_PRODUCT_SQL");
        try
                (Connection connection = JDBC.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(INSERT_PRODUCT_SQL);) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setDouble(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setString(5, product.getDescription());
            preparedStatement.setInt(6, product.getCategoryID());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateProduct(Product product) {
        System.out.println("UPDATE_PRODUCT_SQL");
        try
                (Connection connection = JDBC.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT_SQL);) {
            preparedStatement.setString(1, product.getName());
            preparedStatement.setDouble(2, product.getPrice());
            preparedStatement.setDouble(3, product.getQuantity());
            preparedStatement.setString(4, product.getColor());
            preparedStatement.setInt(5, product.getCategoryID());
            preparedStatement.setInt(6, product.getId());
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteProduct(int  productID) {
        System.out.println("DELETE_PRODUCT_BY_ID_SQL");
        try
            (Connection connection = JDBC.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT_BY_ID_SQL);) {
            preparedStatement.setInt(1, productID);
            return preparedStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Product> searchProduct(String productName) throws SQLException {
        System.out.println("SELECT_PRODUCT_BY_NAME_SQL");
        List<Product> productList = new ArrayList<>();
        Connection connection = JDBC.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCT_BY_NAME_SQL);
        preparedStatement.setString(1,"%"+productName+"%");
        try {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                int categoryID = resultSet.getInt("categoryID");
                productList.add(new Product(id, name, price, quantity, color, description, categoryID));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }

    @Override
    public List<Product> selectAllProduct() throws SQLException {
        System.out.println("SELECT_ALL_PRODUCT_SQL");
        List<Product> productList = new ArrayList<>();
        Connection connection = JDBC.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_PRODUCT_SQL);
        try {
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double price = resultSet.getDouble("price");
                int quantity = resultSet.getInt("quantity");
                String color = resultSet.getString("color");
                String description = resultSet.getString("description");
                int categoryID = resultSet.getInt("categoryID");
                productList.add(new Product(id, name, price, quantity, color, description, categoryID));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productList;
    }
}
