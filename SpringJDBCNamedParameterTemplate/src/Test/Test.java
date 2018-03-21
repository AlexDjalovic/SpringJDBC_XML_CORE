package Test;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import Klase.Employee;
import Service.EmpService;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		AbstractApplicationContext con=new ClassPathXmlApplicationContext("springJDBCNamed.xml");
		EmpService service=(EmpService) con.getBean("empServiceImpl");	
		//kreiram nekog zaposlenog
		
	/*	Employee e1=new Employee();
		e1.setEmpName("amos");
		e1.setEmail("amici2509013");
		e1.setSalary(3666325);
		
		//metod iz EmpServiceImpl 
		service.addEmp(e1);*/
		List<Employee> ll=service.vratiPodatke();
		for (Employee e : ll) {
			System.out.println(e);
		}
		service.promeniEmail("acciikkiinnoo", 1);
		service.dohvatiEmplById(1);
		
		//da dohvatim nekog zaposlenog iz baze za dati id
		/*
		Employee e=service.dohvatiEmplById(1);
		System.out.println(e.getEmpId()+"/"+e.getEmpName());
		*/
		
		//DA PRIKAZEM SVE KOJI POSTOJE U BAZI U FORMI LISTE
		/*List<Employee>al=service.vratiPodatke();
		for (Employee e : al) {
			System.out.println(e);
		}*/
		//PROMENA EMAILA ZA ZAPOSLENE
	//	service.promeniEmail("aca2410985", 2);
		
		con.close();
	}

}
