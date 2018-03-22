package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import Klase.Employee;

public class EmpDaoImpl implements EmpDao {

	private SimpleJdbcCall poziv;
	
	public void setPoziv(SimpleJdbcCall poziv) {
		this.poziv = poziv;
	}
	//OVO JE PRIMER NOVOG SA JDBCTEMPLATE
	@Override
	public void createEmp(Employee emp) {
		
	}
	
	@Override
	public Employee getEmplById(int id) {
		poziv.withProcedureName("getEmployeeByNameAndSalaryUsingId");
		MapSqlParameterSource input=new MapSqlParameterSource();
		input.addValue("zapId", id);
		Map<String,Object>output=poziv.execute(input);
		Employee emp=new Employee();
		
		emp.setEmpName((String)output.get("zapime"));//NEKAKO SE PROMENILA VREDNOST PRIVREMENE PROMENLJIVE U zapime umesto ZapIme
		emp.setSalary((Double)output.get("zapplata"));
		return emp;
	}

	public void prikaziMapu(int id) {
		poziv.withProcedureName("getEmployeeByNameAndSalaryUsingId");
		MapSqlParameterSource input=new MapSqlParameterSource();
		input.addValue("zapId", id);
		Map<String,Object>output=poziv.execute(input);
		for(Map.Entry<String, Object> xx:output.entrySet()) {
			System.out.println(xx.getKey()+"*/*"+xx.getValue());
		}
		
	}
	@Override
	public void updateEmail(String newMail, int id) {
	

	}

	@Override
	public List<Employee> getAllDetails() {
		return null;
	
	}
	@Override
	public void deleteEmp(int id) {
		
		}

	}
	


