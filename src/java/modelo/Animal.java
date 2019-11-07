package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Animal implements Serializable {   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 30)
    private String especie;
    @Column(length = 30)
    private String raca;
    @Column(length = 30)
    private String nome;
    @Column
    private Integer idade;
    
    @ManyToOne
    @JoinColumn(name = "tutor")
    private Tutor tutor;
    
    public Animal(){
        this.especie = "";
        this.raca = "";
        this.nome = "";
        this.idade = 0;
        this.tutor = new Tutor();
    }
    
    public Animal(String especie, String raca, String nome, Integer idade, Tutor tutor){
        this.especie = especie;
        this.raca = raca;
        this.nome = nome;
        this.idade = idade;
        this.tutor = tutor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Tutor getTutor() {
        return tutor;
    }

    public void setTutor(Tutor tutor) {
        this.tutor = tutor;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.id);
        hash = 79 * hash + Objects.hashCode(this.especie);
        hash = 79 * hash + Objects.hashCode(this.raca);
        hash = 79 * hash + Objects.hashCode(this.nome);
        hash = 79 * hash + Objects.hashCode(this.idade);
        hash = 79 * hash + Objects.hashCode(this.tutor);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Animal other = (Animal) obj;
        if (!Objects.equals(this.especie, other.especie)) {
            return false;
        }
        if (!Objects.equals(this.raca, other.raca)) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.idade, other.idade)) {
            return false;
        }
//        if (!Objects.equals(this.tutor, other.tutor)) {
//            return false;
//        }
        return true;
    }

    @Override
    public String toString() {
        return "Animal{" + "id=" + id + ", especie=" + especie + ", raca=" + raca + ", nome=" + nome + ", idade=" + idade + ", tutor=" + tutor + '}';
    }

}
