package model.service.manager;

import model.service.category.CategoryDAOImp;
import model.service.product.ProductDAOImp;

public class DAOManager {
    public final ProductDAOImp productDAO = new ProductDAOImp();
    public final CategoryDAOImp categoryDAOImp = new CategoryDAOImp();


}
