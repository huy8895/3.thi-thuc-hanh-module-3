package model.service.category;

import model.Category;

import java.sql.SQLException;

public interface ICategory {
    public Category selectCategory(int id) throws SQLException;

    public boolean insertCategory();

    public boolean updateCategory();

    public boolean deleteCategory();
}
