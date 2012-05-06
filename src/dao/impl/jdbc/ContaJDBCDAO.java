package dao.impl.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import vo.ContaVO;
import vo.ObjectVO;
import vo.UsuarioVO;
import dao.DAOException;
import dao.DAOFactory;
import dao.spec.IContaDAO;
import dao.spec.IUsuarioDAO;

class ContaJDBCDAO extends GenericJDBCDAO implements IContaDAO {

	public ContaJDBCDAO(Properties properties) throws DAOException {
		super(properties);
	}

	public void update(ObjectVO vo) throws DAOException {
		String sql = "UPDATE " + this.getTableName()
				+ " VALOR = ?, EMAIL = ? WHERE NOME = ?";
		try {
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);
			ContaVO conta = (ContaVO) vo;
			stmt.setDouble(1, conta.getSaldo());
			stmt.setString(2, conta.getUsuario().getEmail());
			stmt.setString(3, conta.getNome());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public void insert(ObjectVO vo) throws DAOException {
		String sql = "INSERT INTO " + this.getTableName()
				+ " (NOME, VALOR, EMAIL) VALUES (?,?,?)";
		try {
			ContaVO conta = (ContaVO) vo;
			PreparedStatement stmt = this.getConnection().prepareStatement(sql);
			stmt.setString(1, conta.getNome());
			stmt.setDouble(2, conta.getSaldo());
			stmt.setString(3, conta.getUsuario().getEmail());
			stmt.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}

	public ContaVO selectByUsuario(String email) throws DAOException {
		ContaVO vo = null;
		String sql = "SELECT * FROM " + this.getTableName()
				+ " WHERE EMAIL = " + email;
		try {
			Statement stmt = this.getConnection().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				vo = (ContaVO) this.createVO(rs);
			}
		} catch (SQLException e) {
			throw new DAOException(e);
		}
		return vo;
	}

	public String getTableName() {
		return "CONTA";
	}

	protected ObjectVO createVO(ResultSet rs) throws DAOException {
		try {
			String nome = rs.getString("NOME");
			float valor = rs.getFloat("VALOR");
			String userEmail = rs.getString("EMAIL");
			String desc = rs.getString("DESCRICAO");
			
			IUsuarioDAO userDAO = DAOFactory.getInstance().getUserDAO();
			UsuarioVO user = (UsuarioVO) userDAO.selectByEmail(userEmail);
			return new ContaVO(nome, new Double(valor), user, desc);
		} catch (SQLException e) {
			throw new DAOException(e);
		}
	}
}
