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
	@Override
	public Employee dohvatiEmplById(int id) {
		return empdao.getEmplById(id);
	}

	public void prikaziMapu(int id) {
		empdao.prikaziMapu(id);
	}
	

}
