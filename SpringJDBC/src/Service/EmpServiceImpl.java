package Service;

import java.util.List;

import DAO.EmpDao;
import Klase.Employee;
//PONASA SE KAO KONTROLER U BIBLIOTEKA PROJEKTU
public class EmpServiceImpl implements EmpService {

	private EmpDao empdao;
	
	
	public void setEmpdao(EmpDao empdao) {
		this.empdao = empdao;
	}

	@Override//OVDE JE ADD I POZVAO JE IZ DBkOMUNIKACIJE CREATE METODU
	public void addEmp(Employee emp) {
		empdao.createEmp(emp);
	}
	@Override
	public void obrisiEmp(int id) {
		empdao.deleteEmp(id);
	}

	@Override
	public Employee dohvatiEmplById(int id) {
		return empdao.getEmplById(id);
	}

	@Override
	public void promeniEmail(String newMail, int id) {
		empdao.updateEmail(newMail, id);
	}

	@Override
	public List<Employee> vratiPodatke() {	
		return empdao.getAllDetails();
	}

}
