package com.cybage.PMS;

import com.cybage.dao.ProductDAO;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ProductDAO pr=new ProductDAO();
        pr.run();
    }
}
