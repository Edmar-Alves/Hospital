package controle;

import dao.DAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Tutor;

@ManagedBean
@ViewScoped
public class TutorControle implements Serializable {
    private List<Tutor> tutores;
    private Tutor tutorSelecionado;
    private DAO<Tutor> dao;
    private boolean popupNovo;
    private boolean popupAltera;
    
    public TutorControle(){
        tutorSelecionado = new Tutor();
        dao = new DAO(Tutor.class);
        tutores = dao.listarTodos();
        popupNovo = false;
        popupAltera = false;
    }
    
    public void abrePopupNovo(){
        tutorSelecionado = new Tutor();
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
    
    public void alterar(){
        abrePopupAltera();
    }
    
    public void inserir(){
        dao.inserir(tutorSelecionado);
        tutores = dao.listarTodos();
        fecharPopupNovo();
    }
    
    public void alterarTutor() {
        dao.alterar(tutorSelecionado);
        tutores = dao.listarTodos(); // atualiza a lista
        tutorSelecionado = new Tutor(); 
        fecharPopupAltera();
    }
    
    public void excluir(Tutor tutorSelecionado){
        dao.excluir(tutorSelecionado.getId());
        tutores.remove(tutorSelecionado);
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
    
    public List<Tutor> getTutores() {
        return tutores;
    }

    public void setTutores(List<Tutor> tutores) {
        this.tutores = tutores;
    }

    public Tutor getTutorSelecionado() {
        return tutorSelecionado;
    }

    public void setTutorSelecionado(Tutor tutorSelecionado) {
        this.tutorSelecionado = tutorSelecionado;
    }

    public DAO<Tutor> getDao() {
        return dao;
    }

    public void setDao(DAO<Tutor> dao) {
        this.dao = dao;
    }
    
}