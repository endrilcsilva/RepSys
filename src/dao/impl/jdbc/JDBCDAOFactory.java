package dao.impl.jdbc;

import java.util.Properties;

import dao.DAOException;
import dao.DAOFactory;
import dao.spec.IContaDAO;
import dao.spec.IContaValorFixoDAO;
import dao.spec.IContaValorVariavelDAO;
import dao.spec.IEmprestimoDAO;
import dao.spec.IFaturaTelefonicaDAO;
import dao.spec.IItemFaturaTelefonicaDAO;
import dao.spec.INumeroTelefonicoDAO;
import dao.spec.IUsuarioDAO;

public class JDBCDAOFactory extends DAOFactory {

	private Properties properties;
	
	/**
	 * Implementaçãoo do padrão Factory Method
	 * 
	 * java.util.Properties é uma extensão de java.util.HashTable.
	 * @param properties
	 */
	public JDBCDAOFactory(Properties properties) {
		this.properties = properties;
	}

	public IEmprestimoDAO getEmprestimoDAO() throws DAOException {
		return new EmprestimoJDBCDAO(this.properties);
	}
        
	//TODO: acertas estes métodos após implementar os DAOS
    public IFaturaTelefonicaDAO getFaturaTelefonicaDAO() throws DAOException {
        //return new FaturaTelefonicaJDBCDAO(this.properties);
    	return null;
	}

	public IItemFaturaTelefonicaDAO getItemFaturaTelefonicaDAO() throws DAOException {
		//return new ItemFaturaTelefonicaJDBCDAO(this.properties);
		return null;
	}

	public INumeroTelefonicoDAO getNumeroTelefonicoDAO() throws DAOException {
		//return new NumeroTelefonicoJDBCDAO(this.properties);
		return null;
	}

	@Override
	public IUsuarioDAO getUsuarioDAO() throws DAOException {
		// TODO Auto-generated method stub
		return new UsuarioJDBCDAO(this.properties);
	}

	@Override
	public IContaDAO getContaDAO() throws DAOException {
		// TODO Auto-generated method stub
		return new ContaJDBCDAO(this.properties);
	}

	@Override
	public IContaValorFixoDAO getContaValorFixoDAO() throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IContaValorVariavelDAO getContaValorVariavelDAO()
			throws DAOException {
		// TODO Auto-generated method stub
		return null;
	}
        
        
}
