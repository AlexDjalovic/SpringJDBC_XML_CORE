package DAO;


import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import Klase.Employee;

public class EmpDaoImpl implements EmpDao {

	// kada imam mnogo ? u sql upitima onda je bolje koristiti
	// namedParameterJdbcTemplate umesto JdbcTemplate
	// i objekat tipa MapSqlParameterSource=>glumi PreparedStatement
	
	private NamedParameterJdbcTemplate named;

	public void setNamed(NamedParameterJdbcTemplate named) {
		this.named = named;
	}

	// ZA INSERT UPDATE I DELETE SE KORISTI NAMED.UPDATE();
	// ZA SELECT GDE TREBA DA SE VRATI LISTA MOZE SAMO NAMED.QUERY()
	// ZA SELECT GDE SE VRACAJU PODACI ZA JEDNOG ZAPOSLENOG NAMED.QUERYFOROBJECT();
	@Override
	public void createEmp(Employee emp) {
		String sSQL = "INSERT INTO employee(EmpName,salary,email) VALUES(:ime,:plata,:mail)";
		MapSqlParameterSource mm = new MapSqlParameterSource();
		mm.addValue("ime", emp.getEmpName());
		mm.addValue("plata", emp.getSalary());
		mm.addValue("mail", emp.getEmail());
		int tt = named.update(sSQL, mm);
		if (tt > 0) {
			System.out.println("dodat je jos 1 zaposleni");
		}
	}

	@Override
	public void deleteEmp(int id) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Employee getEmplById(int id) {
		String seel="SELECT * FROM employee WHERE EmpId=:ide";
		MapSqlParameterSource mm=new MapSqlParameterSource();
		mm.addValue("ide", id);
		//named.queryForObject(sql, paramMap, rowMapper)
		Employee emp=(Employee) named.queryForObject(seel, mm, new EmpRowMapper());
		System.out.println("zaposleni sa id:"+id+" je "+emp);
		return emp;
	}
	@Override
	public void updateEmail(String newMail, int id) {
		String SQLW="UPDATE employee SET email=:mail WHERE EmpId=:ide";	
		MapSqlParameterSource input=new MapSqlParameterSource();
		input.addValue("mail", newMail);
		input.addValue("ide", id);
		int tt=named.update(SQLW, input);
		if(tt>0) {
			System.out.println("promenjen je mejl i glasi: "+newMail);
		}
	}

	@Override
	public List<Employee> getAllDetails() {
		String SQL="SELECT * FROM employee";
		List<Employee>lista=named.query(SQL, new EmpRowMapper());
		return lista;
	}
	
	
	
	}
	


