package src.main.java.dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import src.main.java.model.Country;
import src.main.java.model.Drzava;
import src.main.java.model.Operater;
import src.main.java.model.Servis;

@Repository
public class CountryDao implements Observer{
	
	
	private TimerReport timerReport;
	private ArrayList<Country> countries=new ArrayList<Country>();
	private Map<String,Drzava> drzave=new HashMap<String,Drzava>();
	private Map<String,Operater> operateri=new HashMap<String,Operater>();
	private Map<String,Servis> servisi=new HashMap<String,Servis>();
	
	
	
	
	public CountryDao() {
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("src/main/resources/servisi.txt")));
		    String line = br.readLine();

		    while (line != null) {
		        Servis servis=new Servis();
		        servis.setServisName(line);
		        servis.setServisPrice(0);
		        servis.setServisRevenue(0);
		        servisi.put(servis.getServisName(),servis);
		        
		        line = br.readLine();
		    }
		    br.close();
		    br = new BufferedReader(new FileReader(new File("src/main/resources/operateri.txt")));
		    line = br.readLine();
		    while (line != null) {
		        Operater operater=new Operater();
		        operater.setOperaterName(line);
		        operater.setOperaterPrice(0);
		        operater.setOperaterRevenue(0);
		        operateri.put(operater.getOperaterName(),operater);
		        
		        line = br.readLine();
		    }
		    
		    br.close();
		    
		    br = new BufferedReader(new FileReader(new File("src/main/resources/drzave.txt")));
		    line = br.readLine();
		    while (line != null) {
		        Drzava drzava=new Drzava();
		        drzava.setCountryCode(line.substring(0,line.indexOf(',')).trim());
		        drzava.setCountryName(line.substring(line.indexOf(',')+1,line.length()).trim());
		        drzava.setTotalContryPrice(0);
		        drzava.setTotalCountryRevenue(0);
		        
		        line = br.readLine();
		        drzave.put(drzava.getCountryCode(),drzava);
		    }
		    br.close();
		    
		    
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(servisi.size());
		System.out.println(drzave.keySet());
		System.out.println(operateri.keySet());
		timerReport=new TimerReport();
		timerReport.start();
		timerReport.addObserver(this);
		
		
	}
	
	
	
	public void addCountry(Country country){
		countries.add(country);
		System.out.println(country.getCountryName());
		System.out.println(country.getCountryCode());
		System.out.println(country.getTimeStamp());
		System.out.println(country.isSuccessful());
		System.out.println(country.getOperator());
		System.out.println(country.getService());
		System.out.println(country.getPrice());
		System.out.println(country.getRevenue());
		System.out.println(country.getServiceType());
		System.out.println("dodato");
		
		try {
			addRevenuServis(country.getService(),country.getRevenue());
			addPriceServis(country.getService(),country.getPrice());
			addRevenueOperater(country.getOperator(),country.getRevenue());
			addPriceOperater(country.getOperator(),country.getPrice());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	public ArrayList<Country> getCountries() {
		return countries;
	}


	public void setCountries(ArrayList<Country> countries) {
		this.countries = countries;
	}


	public Map<String, Drzava> getDrzave() {
		return drzave;
	}


	public void setDrzave(Map<String, Drzava> drzave) {
		this.drzave = drzave;
	}


	public Map<String, Operater> getOperateri() {
		return operateri;
	}


	public void setOperateri(Map<String, Operater> operateri) {
		this.operateri = operateri;
	}


	public Map<String, Servis> getServisi() {
		return servisi;
	}


	public void setServisi(Map<String, Servis> servisi) {
		this.servisi = servisi;
	}


	public ArrayList<Country> getAllCountries(){
		return countries;
	}
	
	private void addRevenuServis(String name,double revenue) throws Exception{
		System.out.println(name);
		if(servisi.containsKey(name)){
		servisi.get(name).setServisRevenue(servisi.get(name).getServisRevenue()+revenue);
		}
		else
		{
			throw new Exception();
		}
	}
	
	private void addPriceServis(String name,double price) throws Exception{
		if(servisi.containsKey(name)){
		servisi.get(name).setServisPrice(servisi.get(name).getServisPrice()+price);
		}
		else
		{
			throw new Exception();
		}
	}
	
	private void addPriceOperater(String name,double price) throws Exception{
		if(operateri.containsKey(name)){
			operateri.get(name).setOperaterPrice(operateri.get(name).getOperaterPrice()+price);
		}
		else
		{
			throw new Exception();
		}
	}
	
	private void addRevenueOperater(String name,double price) throws Exception{
		if(operateri.containsKey(name)){
			operateri.get(name).setOperaterRevenue(operateri.get(name).getOperaterRevenue()+price);
		}
		else
		{
			throw new Exception();
		}
	}
	
	private void addPriceCountry(String name,double price) throws Exception{
		if(operateri.containsKey(name)){
			operateri.get(name).setOperaterPrice(operateri.get(name).getOperaterPrice()+price);
		}
		else
		{
			throw new Exception();
		}
	}
	
	private void addCountry(String name,double price) throws Exception{
		if(operateri.containsKey(name)){
			operateri.get(name).setOperaterPrice(operateri.get(name).getOperaterPrice()+price);
		}
		else
		{
			throw new Exception();
		}
	}
	
	
	
	


	@Override
	public void update(Observable o, Object arg) {
		System.out.println("Updateaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		
	}

}
