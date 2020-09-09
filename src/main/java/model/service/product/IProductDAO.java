package model.service.product;

import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    public Product selectProduct(int id) throws SQLException;

    public boolean insertProduct(Product product);

    public boolean updateProduct(Product product);

    public boolean deleteProduct(Product product);

    public List<Product> searchProduct(String productName);

    public List<Product> selectAllProduct() throws SQLException;
}
