package Test;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Klase.Employee;
import Service.EmpService;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AbstractApplicationContext con=new ClassPathXmlApplicationContext("springJDBC.xml");
		EmpService service=(EmpService) con.getBean("empServiceImpl");
		System.out.println("-----------------");
	/*	
		//kreiram nekog zaposlenog
		
		Employee e1=new Employee();
		e1.setEmpName("joca");
		e1.setEmail("joca0707953");
		e1.setSalary(450000);
		
		//metod iz EmpServiceImpl 
		service.addEmp(e1);
		
		*/
		
		//da dohvatim nekog zaposlenog iz baze za dati id
		/*
		Employee e=service.dohvatiEmplById(1);
		System.out.println(e.getEmpId()+"/"+e.getEmpName());
		*/
		
		//DA PRIKAZEM SVE KOJI POSTOJE U BAZI U FORMI LISTE
		List<Employee>al=service.vratiPodatke();
		for (Employee e : al) {
			System.out.println(e);
		}
		//PROMENA EMAILA ZA ZAPOSLENE
	//	service.promeniEmail("acikino", 1);
		System.out.println("*****");
		con.close();
	}

}
