package dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import util.JPAUtil;

/**
* Classe genérica para persistir objetos. 
 * @param <T> Tipo da classe 
 */
public class DAO <T> implements Serializable {

    private final Class<T> classe;
    EntityManager manager;

    public DAO(Class<T> classe) {
        this.classe = classe;
    }
    
    public T alterar(T objeto) {
        manager = JPAUtil.getEntityManager();
        manager.getTransaction().begin();
        objeto = manager.merge(objeto);
        manager.getTransaction().commit();
        manager.close();
        return objeto;
    }
    public T buscarPorCodigo(Object id) {
        T objeto;
        manager = JPAUtil.getEntityManager();
        objeto = manager.find(classe, id);
        manager.close();
        return objeto;
    }
    
    public T buscarPorNome(String nome) throws ExcecaoObjetoNaoEncontrado{
        T temp = null;
        manager = JPAUtil.getEntityManager();
        String sql = "SELECT o FROM "+ classe.getName() +" o WHERE o.nome = :nome";
        TypedQuery<T> query = manager.createQuery(sql, classe);
        query.setParameter("nome", nome);
        try {
            temp = query.getSingleResult();
        } catch (Exception e) {  
            throw new ExcecaoObjetoNaoEncontrado("Nenhum objeto com este nome");

        } finally {
            manager.close();
        }
        return temp;
    }
        
    public void excluir(Integer id) {
        manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        T temp = manager.find(classe, id);
        manager.remove(temp);
        tx.commit();
        manager.close();
    }

    
    public void inserir(T objeto) {
        manager = JPAUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        manager.persist(objeto);
        tx.commit();       
    }
       
    public List<T> listarTodos() {        
        manager = JPAUtil.getEntityManager();
        CriteriaQuery<T> query = 
                manager.getCriteriaBuilder().createQuery(classe);
        query.select(query.from(classe));
        List<T> lista = manager.createQuery(query).getResultList();
        manager.close();      
        return lista;
    }

}