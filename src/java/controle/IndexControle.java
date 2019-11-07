package controle;

import dao.DAOAdm;
import dao.ExcecaoObjetoNaoEncontrado;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Administrador;

@ManagedBean 
@ViewScoped
public class IndexControle implements Serializable {

    private Administrador adm;
    private DAOAdm dao;

    public IndexControle() {
        adm = new Administrador();
        dao = new DAOAdm();
    }

    public String autenticar() {
        Administrador temp; // temp é o objeto retornado do arquivo
        // Método buscarPorLogin dispara exceção, então é obrigatório tratar
        try {
            temp = (Administrador) dao.buscaPorLogin(adm.getLogin());
        } catch (ExcecaoObjetoNaoEncontrado e) {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
            return null;  //fica na página
        }
        // Administrador existe mas a senha não confere
        if (! temp.getSenha().equals(adm.getSenha())){
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Senha incorreta", null));
            return null; 
        }
        return "menu";    // menu.xhtml
    }
    
    public void converter() {
        adm.setLogin(adm.getLogin().toUpperCase());
    }

    public Administrador getAdm() {
        return adm;
    }

    public void setAdm(Administrador adm) {
        this.adm = adm;
    }

    public DAOAdm getDao() {
        return dao;
    }

    public void setDao(DAOAdm dao) {
        this.dao = dao;
    }

}