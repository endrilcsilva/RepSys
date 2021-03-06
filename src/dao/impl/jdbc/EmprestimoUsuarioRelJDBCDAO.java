package dao.impl.jdbc;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Properties;

import util.Configuration;
import vo.EmprestimoUsuarioRelVO;
import vo.EmprestimoVO;
import vo.ObjectVO;
import vo.UsuarioVO;
import vo.VOException;
import dao.DAOException;
import dao.spec.IEmprestimoUsuarioRelDAO;

public abstract class EmprestimoUsuarioRelJDBCDAO extends GenericJDBCDAO
		implements IEmprestimoUsuarioRelDAO {

	public EmprestimoUsuarioRelJDBCDAO(Properties properties)
			throws DAOException {
		super(properties);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(ObjectVO vo) throws DAOException {
		String sql = "INSERT INTO " + this.getTableName()
				+ " (DATA_HORA, EMAIL) VALUES(?, ?)";
		try {

			PreparedStatement stmt = this.getConnection().prepareStatement(sql);
			EmprestimoUsuarioRelVO eur = (EmprestimoUsuarioRelVO) vo;

			Date dt = new Date(eur.getEmprestimo().getDataHora().getTime()
					.getTime());
			stmt.setDate(1, dt);
			stmt.setString(2, eur.getUsuario().getEmail());

			stmt.executeUpdate();
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	@Override
	public void delete(ObjectVO vo) throws DAOException {
		String sql = "DELETE FROM " + this.getTableName()
				+ " WHERE DATA_HORA = ? AND EMAIL = ?";
		try {
			EmprestimoUsuarioRelVO euc = (EmprestimoUsuarioRelVO) vo;
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);

			Date dt = new Date(euc.getEmprestimo().getDataHora().getTime()
					.getTime());
			stmt.setDate(1, dt);
			stmt.setString(2, euc.getUsuario().getEmail());

			stmt.executeUpdate();
		} catch (Exception e) {
			throw new DAOException(e);
		}

	}

	@Override
	public void update(ObjectVO vo) throws DAOException {
		throw new DAOException("Update não permitido para a tabela "
				+ getTableName());
	}

	@Override
	protected String getTableName() {
		return "EMPRESTIMO_USUARIO_DEVEDOR";
	}

	@Override
	protected ObjectVO createVO(ResultSet rs) throws DAOException, VOException {
		try {
			String email = rs.getString("EMAIL");
			Date dt = rs.getDate("DATA_HORA");
			Calendar cal = new GregorianCalendar();
			cal.setTime(dt);

			EmprestimoJDBCDAO eDAO = new EmprestimoJDBCDAO(Configuration
					.getInstance().getProperties());
			EmprestimoVO emprestimo = eDAO.selectByData(cal);

			UsuarioJDBCDAO uDAO = new UsuarioJDBCDAO(Configuration
					.getInstance().getProperties());
			UsuarioVO usuario = uDAO.selectByEmail(email);

			return new EmprestimoUsuarioRelVO(emprestimo, usuario);
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	public List<UsuarioVO> getUsuarios(EmprestimoVO emprestimo)
			throws DAOException {
		List<UsuarioVO> list = new ArrayList<UsuarioVO>();
		String sql = "SELECT EMAIL FROM " + this.getTableName()
				+ " WHERE DATA_HORA = ?";

		UsuarioJDBCDAO uDAO = new UsuarioJDBCDAO(Configuration.getInstance()
				.getProperties());
		Date dt = new Date(emprestimo.getDataHora().getTime().getTime());

		try {

			PreparedStatement stmt = this.getConnection().prepareStatement(sql);
			stmt.setDate(1, dt);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				String email = rs.getString("EMAIL");
				list.add(uDAO.selectByEmail(email));
			}

			return list;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

	public List<EmprestimoVO> getEmprestimos(UsuarioVO usuario)
			throws DAOException {
		List<EmprestimoVO> list = new ArrayList<EmprestimoVO>();
		String sql = "SELECT DATA_HORA FROM " + this.getTableName()
				+ " WHERE EMAIL = ?";

		EmprestimoJDBCDAO eDAO = new EmprestimoJDBCDAO(Configuration
				.getInstance().getProperties());

		try {

			PreparedStatement stmt = this.getConnection().prepareStatement(sql);
			stmt.setString(1, usuario.getEmail());

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Date dt = rs.getDate("DATA_HORA");
				Calendar cal = new GregorianCalendar();
				cal.setTime(dt);
				list.add(eDAO.selectByData(cal));
			}

			return list;
		} catch (Exception e) {
			throw new DAOException(e);
		}
	}

}
