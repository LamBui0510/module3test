package controller;

import dao.CategoryDao;
import dao.ProductDao;
import model.Category;
import model.Product;
import service.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.util.List;
@WebServlet(urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    ProductDao productDao = new ProductDao();
    ProductService productService = new ProductService();
    CategoryDao categoryDao = new CategoryDao();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action="";
        }switch (action){
            case "create":
                List<Category> categoryList =categoryDao.findAll();
                categoryDao.findAll();
                req.setAttribute("category",categoryList);
                req.getRequestDispatcher("/view/createproduct.jsp").forward(req,resp);
                break;
            case "edit":
                categoryList =categoryDao.findAll();
                categoryDao.findAll();
                req.setAttribute("category",categoryList);
                req.getRequestDispatcher("/view/editproduct.jsp").forward(req,resp);
                break;
            case "delete":
                deleteProduct(req,resp);
                break;
            default: showProduct(req,resp);
        }


    }

    private void showProduct(HttpServletRequest req, HttpServletResponse resp) {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("view/showproduct.jsp");
        List<Product> productList = productDao.findAll();
        req.setAttribute("listproduct", productList);
        try {
            requestDispatcher.forward(req,resp);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        productService.delete(id);
        try {
            resp.sendRedirect("/product");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null){
            action="";
        }switch (action){
            case "create":
                createProduct(req,resp);
                break;
            case "edit":
                editProduct(req,resp);
                break;
            case "search":
                searchHocvien(req,resp);
                break;
            default:
        }
    }

    private void searchHocvien(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("search");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/view/showProduct.jsp");
        List<Product> productList = productDao.searchByName(name);;
        req.setAttribute("products", productList);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void editProduct(HttpServletRequest req, HttpServletResponse resp) {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        Double price = Double.valueOf(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String color = req.getParameter("color");
        String description = req.getParameter("description");
        int idCategory = Integer.parseInt(req.getParameter("idCategory"));
        Product product = new Product(id,name,price,quantity,color,description,idCategory);
        productService.update(id,product);
        try {
            resp.sendRedirect("/product");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createProduct(HttpServletRequest req, HttpServletResponse resp) {
        String name = req.getParameter("name");
        Double price = Double.valueOf(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        String color = req.getParameter("color");
        String description = req.getParameter("description");
        int idCategory = Integer.parseInt(req.getParameter("idCategory"));
        productService.add(new Product(name,price,quantity,color,description,idCategory));
        try {
            resp.sendRedirect("/product");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }
