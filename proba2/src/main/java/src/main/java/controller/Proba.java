package src.main.java.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Observable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import src.main.java.dao.CountryDao;
import src.main.java.model.Country;
import src.main.java.model.Operater;
import src.main.java.model.Servis;



@RestController
@RequestMapping("/rest")
public class Proba{
	
	@Autowired
	private CountryDao countryDao;
	

	@RequestMapping(value="/proba",method=RequestMethod.POST,headers="Accept=application/json")
	public void addCountris(@RequestBody Country country){
		System.out.println("Stiglo");
		countryDao.addCountry(country);
	}
	
	@RequestMapping(value="/proba",method=RequestMethod.GET,headers="Accept=application/json")
	public @ResponseBody ArrayList<Country> getCountris(){
		System.out.println("Saljem!");
		ArrayList<Country> listec=new ArrayList<Country>(countryDao.getAllCountries());
		//Object obj=new Object();
		//synchronized (obj) {
		//Collections.copy(listec,countryDao.getAllCountries());
		//	countryDao.getAllCountries().clear();
		//}	
		countryDao.getAllCountries().clear();
		//System.out.println(listec.get(0)+" Kurcina");
		return listec;
	}
	
	@RequestMapping(value="/proba/operateri",method=RequestMethod.GET,headers="Accept=application/json")
	public @ResponseBody Map<String,Operater> getOperators(){
		System.out.println("Saljem");
		return countryDao.getOperateri();
	}
	
	@RequestMapping(value="/proba/servisi",method=RequestMethod.GET,headers="Accept=application/json")
	public @ResponseBody Map<String,Servis> getServisi(){
		System.out.println("Saljem");
		return countryDao.getServisi();
	}
	
	@RequestMapping(value="/proba/operateri/{operaterName}",method=RequestMethod.GET,headers="Accept=application/json")
	public @ResponseBody Operater getOperator(@PathVariable("operaterName") String operaterName){
		System.out.println("Saljem");
		return countryDao.getOperateri().get(operaterName);
	}
	
	@RequestMapping(value="/proba/servisi/{servisName}",method=RequestMethod.GET,headers="Accept=application/json")
	public @ResponseBody Servis getServis(@PathVariable("servisName") String servisName){
		System.out.println("Saljem");
		return countryDao.getServisi().get(servisName);
	}
	
	
	

}
