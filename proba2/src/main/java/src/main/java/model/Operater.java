package src.main.java.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Operater {
	
	@Id
	private String operaterName;
	private double operaterPrice;
	private double operaterRevenue;
	public String getOperaterName() {
		return operaterName;
	}
	public void setOperaterName(String operaterName) {
		this.operaterName = operaterName;
	}
	public double getOperaterPrice() {
		return operaterPrice;
	}
	public void setOperaterPrice(double operaterPrice) {
		this.operaterPrice = operaterPrice;
	}
	public double getOperaterRevenue() {
		return operaterRevenue;
	}
	public void setOperaterRevenue(double operaterRevenue) {
		this.operaterRevenue = operaterRevenue;
	}

}
