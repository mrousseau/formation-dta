package fr.pizzeria.dao.pizza;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import fr.pizzeria.model.Pizza;

@Repository
public class PizzaDaoSpringH2 implements PizzaDao{

	private JdbcTemplate jdbcTemplate;
	@Autowired
	private DataSource dataSource; 
	
	@PostConstruct
	public void init(){
		this.jdbcTemplate = new JdbcTemplate(this.dataSource);
	}
	
	@Override
	public List<Pizza> findAll() {
		String sql = "SELECT * FROM pizza ";
		List<Pizza> l =this.jdbcTemplate.query(sql, new PizzaMapper());
		return l;
	}

	@Override
	public void save(Pizza p) {
		String sql = "INSERT INTO pizza (id,code,nom,prix,categoriePizza) VALUES(?,?,?,?,?)";
		this.jdbcTemplate.update(sql,p.getId(), p.getCode(), p.getNom(), p.getPrix(), p.getCategoriePizza());
	}

	@Override
	public void updatePizza(int id, Pizza p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePizza(int id) {
		// TODO Auto-generated method stub
		
	}
	
	public class PizzaMapper implements RowMapper<Pizza> {

		public Pizza mapRow(ResultSet rs, int rowNum) throws SQLException {
			Pizza p = new Pizza();
			p.setId(rs.getInt("id"));
			p.setCode(rs.getString("code"));
			p.setNom(rs.getString("nom"));
			p.setPrix(Double.parseDouble(rs.getString("prix")));
			p.setUrl(rs.getString("url"));
			return p;
		}

	}

}
