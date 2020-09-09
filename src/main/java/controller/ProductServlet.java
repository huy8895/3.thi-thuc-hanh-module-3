package controller;

import model.Category;
import model.Product;
import model.service.manager.DAOManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    private DAOManager daoManager;

    public void init() {
        daoManager = new DAOManager();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    System.out.println("creating..");
                    insertProduct(request, response);
                    break;
                case "edit":
                    System.out.println("editing..");
                    updateProduct(request, response);
                    break;
                case "delete":
                    System.out.println("deleting..");
                    deleteProduct(request, response);
                    break;
                default:
                    listProducts(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    System.out.println("show create");
                    showNewForm(request, response);
                    break;
                case "edit":
                    System.out.println("show edit");
                    showEditForm(request, response);
                    break;
                case "delete":
                    System.out.println("show delete");
                    showDeleteForm(request, response);
                    break;
                case "search":
                    System.out.println("search click button");
                    search(request, response);
                    break;
                default:
                    System.out.println("show list");
                    listProducts(request, response);
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {

        int productID = Integer.parseInt(request.getParameter("id"));
        System.out.println(productID + "edit");
        String name= request.getParameter("name");
        double price= Double.parseDouble(request.getParameter("price"));
        int  quantity= Integer.parseInt(request.getParameter("quantity"));
        String color= request.getParameter("color");
        String description= request.getParameter("description");
        int categoryID= Integer.parseInt(request.getParameter("categoryID"));
        daoManager.productDAO.updateProduct(new Product(productID,name,price,quantity,color,description,categoryID));
        listProducts(request,response);
    }

    private void insertProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String name= request.getParameter("name");
        double price= Double.parseDouble(request.getParameter("price"));
        int  quantity= Integer.parseInt(request.getParameter("quantity"));
        String color= request.getParameter("color");
        String description= request.getParameter("description");
        int categoryID= Integer.parseInt(request.getParameter("categoryID"));
        daoManager.productDAO.insertProduct(new Product(name,price,quantity,color,description,categoryID));
        listProducts(request,response);
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, SQLException, IOException {
        int productID = Integer.parseInt(request.getParameter("id"));
        daoManager.productDAO.deleteProduct(productID);
        listProducts(request,response);
    }
    private void listProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<Product> productList = daoManager.productDAO.selectAllProduct();

        request.setAttribute("productList", productList);
        request.setAttribute("categoryDAOImp", daoManager.categoryDAOImp);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/list.jsp");
        requestDispatcher.forward(request, response);
    }

    private void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String productName = request.getParameter("searchBox");
        List<Product> productList = daoManager.productDAO.searchProduct(productName);
        request.setAttribute("productList", productList);
        request.setAttribute("categoryDAOImp", daoManager.categoryDAOImp);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/list.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int productID = Integer.parseInt(request.getParameter("id"));
        Product product = daoManager.productDAO.selectProduct(productID);
        request.setAttribute("product",product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/edit.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int productID = Integer.parseInt(request.getParameter("id"));
        Product product = daoManager.productDAO.selectProduct(productID);
        request.setAttribute("product",product);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/delete.jsp");
        requestDispatcher.forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/create.jsp");
        requestDispatcher.forward(request, response);
    }
}
