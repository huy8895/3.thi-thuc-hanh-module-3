package model.service.category;

import model.Category;

public interface ICategory {
    public Category selectCategory(int id);

    public boolean insertCategory();

    public boolean updateCategory();

    public boolean deleteCategory();
}
