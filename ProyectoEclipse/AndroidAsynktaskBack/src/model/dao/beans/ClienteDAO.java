package model.dao.beans;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.beans.Cliente;
import model.dao.DAO;
import model.motor.Motor;
import model.motor.MotorMySQL;

public class ClienteDAO implements DAO<Cliente, Integer> {

	private Motor motor;
	private PreparedStatement pst;

	public ClienteDAO() {
		motor = new MotorMySQL();
	}

	@Override
	public int add(Cliente bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Cliente bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Cliente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cliente findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Cliente findByNamePass(String email, String pass) {
		String sql = "SELECT * FROM `usuario` WHERE `EMAIL` = ? AND `PASS` = ?";
		List<Cliente> lstCliente = new ArrayList<Cliente>();
		try {
			pst = this.motor.connect().prepareStatement(sql);
			
			pst.setString(1, email);
			pst.setString(2, pass);

			ResultSet rs = this.motor.executeQuery(pst);
			while (rs.next()) {
				Cliente cliente = new Cliente();

				cliente.setIdUsuario(rs.getInt(1));
				cliente.setEmail(rs.getString(2));
				cliente.setPass(rs.getString(3));

				lstCliente.add(cliente);
			}

		} catch (SQLException e) {

		} finally {
			this.motor.disconnect();
		}
		return (!lstCliente.isEmpty()) ? lstCliente.get(0) : null;
	}

}
