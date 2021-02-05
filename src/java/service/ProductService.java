/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ProductDAO;
import java.util.ArrayList;
import model.Product;

/**
 *
 * @author be_me
 */
public class ProductService {
    
    public ArrayList<Product> getHomePageProducts(){
        
        ProductDAO pDao = new ProductDAO();
        return pDao.getTopProducts(10);
        
    }
        
    

   public void insertProduct(Product nproduct){
        ProductDAO pDao = new ProductDAO();
        pDao.insertProduct(nproduct);
        return;
        
    }
    public ArrayList<Product> getAllProduct(){
       
        ProductDAO pDao = new ProductDAO();
        ArrayList<Product> productList = pDao.getAllProduct();
        return productList;
        
    }
    
}