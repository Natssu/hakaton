package src.main.java.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Drzava {
	
	@Id
	private String countryName;
	private String countryCode;
	private double totalContryPrice;
	private double totalCountryRevenue;
	
	public double getTotalContryPrice() {
		return totalContryPrice;
	}
	public void setTotalContryPrice(double totalContryPrice) {
		this.totalContryPrice = totalContryPrice;
	}
	public double getTotalCountryRevenue() {
		return totalCountryRevenue;
	}
	public void setTotalCountryRevenue(double totalCountryRevenue) {
		this.totalCountryRevenue = totalCountryRevenue;
	}
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
	

}
