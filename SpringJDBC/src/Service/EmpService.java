package Service;

import java.util.List;

import Klase.Employee;

public interface EmpService {

	public void addEmp(Employee emp);
	public void obrisiEmp(int id);
	public Employee dohvatiEmplById(int id);
	public void promeniEmail(String newMail,int id);
	public List<Employee>vratiPodatke();
	
}
