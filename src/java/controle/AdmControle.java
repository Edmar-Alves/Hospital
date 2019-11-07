package controle;

import dao.DAO;
import dao.DAOAdm;
import dao.ExcecaoObjetoNaoEncontrado;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Administrador;

@ManagedBean
@ViewScoped
public class AdmControle implements Serializable {

    private Administrador adm;
    private DAO<Administrador> dao;
    private List<Administrador> lista;
    private boolean popupNovo;
    private boolean popupAltera;

    public AdmControle() {
        adm = new Administrador();
        dao = new DAO(Administrador.class);
        lista = dao.listarTodos();
        popupNovo = false;    // fica oculto
        popupAltera = false;  // fica oculto
    }

    public void abrePopupNovo() {
        adm = new Administrador();
        this.popupNovo = true;
    }

    public void fecharPopupNovo() {
        this.popupNovo = false;
    }
    
    public void abrePopupAltera(){        
        this.popupAltera = true;
    }
    
    public void fecharPopupAltera(){
        this.popupAltera = false;
    }

    public void converter() {
        adm.setLogin(adm.getLogin().toUpperCase());
    }
    
    public void alterar(){
        abrePopupAltera();
    }

    public void inserir() {
        // só pode inserir se não existir o login
        converter();
        boolean jaExiste = true;
        try {
            Administrador temp = new DAOAdm().buscaPorLogin(adm.getLogin());
        } catch (ExcecaoObjetoNaoEncontrado e) {
            jaExiste = false;
        }
        if (!jaExiste) {
            dao.inserir(adm);
            lista = dao.listarTodos();
            adm = new Administrador();  // apenas para limpar os campos
            fecharPopupNovo();
        } else {
            FacesContext fc = FacesContext.getCurrentInstance();
            fc.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Já existe este LOGIN", null));
        }

    }

    
    public void alterarAdministrador() {
        dao.alterar(adm);
        lista = dao.listarTodos(); // atualiza a lista
        adm = new Administrador(); 
        fecharPopupAltera();
    }
    
    public void excluir(Administrador adm){
        dao.excluir(adm.getId());
        lista.remove(adm);
    }
       
    public Administrador getAdm() {
        return adm;
    }

    public void setAdm(Administrador adm) {
        this.adm = adm;
    }

    public DAO<Administrador> getDao() {
        return dao;
    }

    public void setDao(DAO<Administrador> dao) {
        this.dao = dao;
    }

    public List<Administrador> getLista() {
        return lista;
    }

    public void setLista(List<Administrador> lista) {
        this.lista = lista;
    }

    public boolean isPopupNovo() {
        return popupNovo;
    }

    public void setPopupNovo(boolean popupNovo) {
        this.popupNovo = popupNovo;
    }

    public boolean isPopupAltera() {
        return popupAltera;
    }

    public void setPopupAltera(boolean popupAltera) {
        this.popupAltera = popupAltera;
    }

}