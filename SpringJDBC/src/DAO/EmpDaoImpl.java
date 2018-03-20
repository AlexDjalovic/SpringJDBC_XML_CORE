package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import Klase.Employee;

public class EmpDaoImpl implements EmpDao {

	//private DataSource dataSource;
	private JdbcTemplate template;
	/*public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.template=new JdbcTemplate(dataSource);
		this.named=new NamedParameterJdbcTemplate(dataSource);
	}*/
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
//OVO JE PRIMER KLASICNOG JDBC ZA INSERT
	
	/*@Override
	public void createEmp(Employee emp) {
		Connection con=null;
		PreparedStatement ps;
		
	try {
		con=dataSource.getConnection();
		String sSQL="INSERT INTO employee(EmpName,salary,email) VALUES(?,?,?)";
		ps=con.prepareStatement(sSQL);
		ps.setString(1, emp.getEmpName());
		ps.setDouble(2,emp.getSalary());
		ps.setString(3, emp.getEmail());
		
		int tt=ps.executeUpdate();
		if(tt>0) {
			System.out.println("kreiran je "+tt+" zaposleni");
		}
	}catch(Exception e) {
		e.getMessage();
	}finally {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
	}
	}
*/
	
	//OVO JE PRIMER NOVOG SA JDBCTEMPLATE
	@Override
	public void createEmp(Employee emp) {
		String sSQL="INSERT INTO employee(EmpName,salary,email) VALUES(?,?,?)";
		int tt=template.update(sSQL, new Object[]{emp.getEmpName(),emp.getSalary(),emp.getEmail()});
		//OVO JE DRUGI NACIN ZA PISANJE DA NE BUDU U 2 REDA VEC SVE U JEDNOM ->->ISTI REZULTATI
		//template.update("INSERT INTO employee(EmpName,salary,email) VALUES(?,?,?)",emp.getEmpName(),emp.getSalary(),emp.getEmail());
		if(tt>0) {
			System.out.println("dodat je jos 1 zaposleni");
		}
	}
	
	
	
	@Override
	public Employee getEmplById(int id) {
		String upit="SELECT * FROM employee WHERE EmpId=?";
		//zato sto imamo id mora da se traze parametri sql,rowmapper,args!!!!!!!!
		Employee emp=template.queryForObject(upit, new EmpRowMapper(), id);
		return emp;
	}

	@Override
	public void updateEmail(String newMail, int id) {
		String upit="UPDATE employee SET email=? WHERE EmpId=?";
		//biram update(sql,args) koji vraca int
		int tt=template.update(upit, newMail,id);
		if(tt>0) {
			System.out.println("promenjen je email zaposlenog");
		}

	}

	@Override
	public List<Employee> getAllDetails() {
		String upit="SELECT * FROM employee";
		List<Employee>lista=template.query(upit, new EmpRowMapper());
		return lista;
	}
	@Override
	public void deleteEmp(int id) {
		String upit="DELETE FROM employee WHERE EmpId=?";
		//koristi se isto kao i kod updateEmail update(sql,args) ovde sql ima delete a kao args koristim id
		int tt=template.update(upit, id);
		if(tt>0) {
			System.out.println("zaposleni je obrisan");
		}

	}
	

}
