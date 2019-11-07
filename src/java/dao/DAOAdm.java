package dao;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import modelo.Administrador;
import util.JPAUtil;

public class DAOAdm implements Serializable {
    EntityManager manager;
    
    
    /**
     * Busca um objeto administrador com o login fornecido. 
     * @param login
     * @return
     * @throws ExcecaoObjetoNaoEncontrado 
     */
    public Administrador buscaPorLogin(String login) throws ExcecaoObjetoNaoEncontrado{
        Administrador temp = null;
        manager = JPAUtil.getEntityManager();
        String sql = "SELECT a FROM Administrador a WHERE a.login = :login";
        TypedQuery<Administrador> query = manager.createQuery(sql, Administrador.class);
        query.setParameter("login", login);
        try {
            temp = query.getSingleResult();
        } catch (Exception e) {  
            throw new ExcecaoObjetoNaoEncontrado("Nenhum objeto com este login");
        } finally {
            manager.close();
        }
        return temp;
    }
}