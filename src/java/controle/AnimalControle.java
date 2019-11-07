package controle;;

import dao.DAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import modelo.Animal;
import modelo.Tutor;

@ManagedBean
@ViewScoped
public class AnimalControle implements Serializable {
    private List<Animal> animais;
    private Animal animal;
    private DAO<Animal> dao;
    private List<Tutor> tutores;
    private Tutor tutor;
    private DAO<Tutor> daodono;
    private boolean popupNovo;
    private boolean popupAltera;


    public AnimalControle(){
    animal = new Animal();
    dao = new DAO(Animal.class);
    animais = dao.listarTodos();
    tutor = new Tutor();
    daodono = new DAO(Tutor.class);
    tutores = daodono.listarTodos();
    popupNovo = false;
    popupAltera = false;
    }

    public void inserir(){
        dao.inserir(animal);
        animais = dao.listarTodos();
        fecharPopupNovo();
    }
    
    public void alterarAnimal() {
        dao.alterar(animal);
        animais = dao.listarTodos(); // atualiza a lista
        animal = new Animal(); 
        fecharPopupAltera();
    }
    
    public void excluir(Animal animal){
        dao.excluir(animal.getId());
        animais.remove(animal);
    }
    
    public void abrePopupNovo(){
        animal = new Animal();
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

    public List<Animal> getAnimais() {
        return animais;
    }

    public void setAnimais(List<Animal> animais) {
        this.animais = animais;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public DAO<Animal> getDao() {
        return dao;
    }

    public void setDao(DAO<Animal> dao) {
        this.dao = dao;
    }

    public List<Tutor> getTutores() {
        return tutores;
    }

    public void setTutores(List<Tutor> tutores) {
        this.tutores = tutores;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    public DAO<Tutor> getDaodono() {
        return daodono;
    }

    public void setDaodono(DAO<Tutor> daodono) {
        this.daodono = daodono;
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