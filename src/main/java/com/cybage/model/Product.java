package com.cybage.model;

public class Product {

	int Pid;
	String Pname;
	double Pprice;
	public int getPid() {
		return Pid;
	}
	public void setPid(int pid) {
		Pid = pid;
	}
	public String getPname() {
		return Pname;
	}
	public void setPname(String pname) {
		Pname = pname;
	}
	public double getPprice() {
		return Pprice;
	}
	public void setPprice(double pprice) {
		Pprice = pprice;
	}
	@Override
	public String toString() {
		return "Product [Pid=" + Pid + ", Pname=" + Pname + ", Pprice=" + Pprice + "]";
	}
	public Product(int pid, String pname, double pprice) {
		super();
		Pid = pid;
		Pname = pname;
		Pprice = pprice;
	}
	public Product() {
		super();
	}
	
	
	
	
	
}
