package com.example.crud.controller;

import com.example.crud.model.Product;
import com.example.crud.service.ProductService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ProductServlet", urlPatterns = "/home")
public class ProductServlet extends HttpServlet {
    private final ProductService productService = new ProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        action(request,response);
    }

    private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action==null) {
            action = "";
        }

        switch (action) {
            case "createGet":
                createControl(request, response);
                break;
            case "createPost":
                create(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "updateGet":
                updateControl(request, response);
                break;
            case "updatePost":
                update(request, response);
                break;
            default:
                displayAll(request, response);
                break;
        }
    }

    public void createControl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("create.jsp");
    }

    public void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));

        productService.createProduct(new Product(id,name,price));
        ArrayList<Product> products = productService.display();

        request.setAttribute("products", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("display.jsp");
        requestDispatcher.forward(request,response);

    }

    public void updateControl(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Product product = productService.getProduct(id);
        if (product != null) {
            request.setAttribute("product", product);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("update.jsp");
            requestDispatcher.forward(request, response);
        }
    }

    public void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Product product = productService.getProduct(id);
        if (product != null) {
            product.setName(request.getParameter("name"));
            product.setPrice(Double.parseDouble(request.getParameter("price")));
        }

        int index = -1;
        ArrayList<Product> products = productService.display();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId().equals(product.getId())) {
                index = i;
            }
        }

        productService.updateProduct(index, product);
        products = productService.display();

        request.setAttribute("products", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("display.jsp");
        requestDispatcher.forward(request, response);
    }

    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Product product = productService.getProduct(id);
        if (product!= null) {
            productService.deleteProduct(product);
        }
        ArrayList<Product> products = productService.display();
        request.setAttribute("products", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("display.jsp");
        requestDispatcher.forward(request, response);
    }

    public void displayAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Product> products = productService.display();
        request.setAttribute("products", products);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("display.jsp");
        requestDispatcher.forward(request,response);
    }

}
