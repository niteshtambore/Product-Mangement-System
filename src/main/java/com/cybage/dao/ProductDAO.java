package com.cybage.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Scanner;

import org.omg.CORBA.PUBLIC_MEMBER;

import com.cybage.DBController.DBController;
import com.cybage.model.Product;
import com.cybage.utility.JDBCUtility;

public class ProductDAO {
	
	Scanner sc = new Scanner(System.in);
	private DBController handler = new DBController();
			
	public ProductDAO(int productId, String productName, double productPrice) {
		// TODO Auto-generated constructor stub
	}

	public ProductDAO() {
		// TODO Auto-generated constructor stub
	}

	public void addProduct() {
		System.out.println("Enter Product Id:");
		int productId=sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter Product Name:");
		String productName=sc.nextLine();
		sc.hasNextLine();
		
		System.out.println("Enter Product Price:");
		double productPrice=sc.nextDouble();
		sc.hasNextLine();
		
		Product product = new Product(productId,productName, productPrice);
		
		if(handler.insertProduct(product)) {
			System.out.println("Product Saved to Database");
		}
		else {
			System.out.println("Product not Saved to Database");
		}
	}
	
	public void deleteProduct() {
		System.out.println("Please enter Product id:");
		int id=sc.nextInt();
		
		if(handler.deleteProduct(id)) {
			System.out.println("Product with id "+id+" has been deleted");
		}
		else {
			System.out.println("Product with id "+id+" cannot be deleted");
		}
	}
	
	public void updateProduct() {
		System.out.println("Please enter Product id:");
		int id=sc.nextInt();
		
		Product product=handler.getProduct(id);
		
		if(product==null) {
			System.out.println("No such Product found with ID "+id);
			return;
		}
		else {
		
		System.out.println("\nProduct ID: "+product.getPid());
		System.out.println("\nProduct Name: "+product.getPname());
		System.out.println("\nProduct Price: "+product.getPprice());
		
		System.out.println();
		
		System.out.println("Please enter new Product ID: ");
		int pNewId=sc.nextInt();
		System.out.println("Please enter new Product name: ");
		String pNewName=sc.next();
		System.out.println("Please enter new Product Price: ");
		double pNewPrice=sc.nextDouble();
		}
		
		if(handler.deleteProduct(id)) {
			System.out.println("Product with id "+id+" has been deleted");
		}
		else {
			System.out.println("Product with id "+id+" cannot be deleted");
		}
	}
	
	public void displayProduct() {
		ArrayList<Product> products=handler.getProducts();
		System.out.println(String.format("%-12s %-30s %s%n","Product Id","Product Name","Product Price"));
		for (Product product : products) {
			System.out.println(product);
		}
	}
	
	public int menu(){
		System.out.println("PRODUCT MANAGEMENT SYSTEM");
		System.out.println("1.Add new Product");
		System.out.println("2.Delete a Product");
		System.out.println("3.Update a Product");
		System.out.println("4.Display all Products");
		System.out.println("5.Quit");
		
		int choice ;
		do {
			System.out.println("Enter Option:");
			choice=sc.nextInt();
		} while (choice < 1 || choice > 5);
		return choice;
		
	}
	
	public void run() {
		int choice;
		
		do {
			choice=menu();
			System.out.println();
			
			if (choice==1) {
				addProduct();
			} else if(choice==2) {
				deleteProduct();
			}
			else if (choice==3) {
				updateProduct();
			}
			else if(choice==4) {
				displayProduct();
		}
			
			System.out.println();
	}while(choice!=5);

	}
}