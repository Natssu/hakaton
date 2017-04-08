package src.main.java.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Servis {
	
	@Id
	private String servisName;
	private double servisPrice;
	private double servisRevenue;
	
	public Servis() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public String getServisName() {
		return servisName;
	}



	public void setServisName(String servisName) {
		this.servisName = servisName;
	}



	public double getServisPrice() {
		return servisPrice;
	}



	public void setServisPrice(double servisPrice) {
		this.servisPrice = servisPrice;
	}



	public double getServisRevenue() {
		return servisRevenue;
	}
	public void setServisRevenue(double servisRevenue) {
		this.servisRevenue = servisRevenue;
	}

}
