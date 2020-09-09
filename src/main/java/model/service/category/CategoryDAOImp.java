package model.service.category;

import model.Category;

public class CategoryDAOImp implements ICategory {
    private static final String SELECT_CATEGORY_BY_ID_SQL = "SELECT * FROM Category where id = ?;";

    @Override
    public Category selectCategory(int id) {
        return null;
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
