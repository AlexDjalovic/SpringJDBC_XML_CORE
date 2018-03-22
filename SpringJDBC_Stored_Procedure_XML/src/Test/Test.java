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
	//Employee emp1=service.dohvatiEmplById(1);
	//System.out.println(emp1);
		service.prikaziMapu(1);
	
		System.out.println("*****");
		Employee e1=service.dohvatiEmplById(1);
		System.out.println(e1);
		con.close();
	}

}
