package DAO;

import java.util.List;

import Klase.Employee;


public interface EmpDao {
	public void createEmp(Employee emp);
	public void deleteEmp(int id);
	public Employee getEmplById(int id);
	public void updateEmail(String newMail,int id);
	public List<Employee>getAllDetails();
	public void prikaziMapu(int id);
}
