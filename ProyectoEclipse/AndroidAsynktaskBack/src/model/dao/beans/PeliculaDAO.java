package model.dao.beans;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.beans.Pelicula;
import model.dao.DAO;
import model.motor.Motor;
import model.motor.MotorMySQL;

public class PeliculaDAO implements DAO<Pelicula, Integer> {

	private Motor motor;
	private PreparedStatement pst;

	public PeliculaDAO() {
		motor = new MotorMySQL();
	}

	@Override
	public int add(Pelicula bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Pelicula bean) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ArrayList<Pelicula> findAll() {
		String sql = "SELECT * FROM `pelicula` ";
		ArrayList<Pelicula> lstPelicula = new ArrayList<>();

		try {
			pst = this.motor.connect().prepareStatement(sql);

			ResultSet rs = this.motor.executeQuery(pst);
			while (rs.next()) {
				Pelicula pelicula = new Pelicula();

				pelicula.setIdPelicula(rs.getInt(1));
				pelicula.setTitulo(rs.getString(2));
				pelicula.setFoto(rs.getString(3));

				lstPelicula.add(pelicula);
			}

		} catch (SQLException e) {

		} finally {
			this.motor.disconnect();
		}
		return lstPelicula;
	}

	@Override
	public Pelicula findById(Integer id) {
		String sql = "SELECT * FROM `pelicula` WHERE `ID_PELICULA` = ?";
		List<Pelicula> lstPelicula = new ArrayList<>();

		try {
			pst = this.motor.connect().prepareStatement(sql);

			pst.setInt(1, id);

			ResultSet rs = this.motor.executeQuery(pst);
			while (rs.next()) {
				Pelicula pelicula = new Pelicula();

				pelicula.setIdPelicula(rs.getInt(1));
				pelicula.setTitulo(rs.getString(2));
				pelicula.setFoto(rs.getString(3));

				lstPelicula.add(pelicula);
			}

		} catch (SQLException e) {

		} finally {
			this.motor.disconnect();
		}
		return (!lstPelicula.isEmpty()) ? lstPelicula.get(0) : null;
	}

}
