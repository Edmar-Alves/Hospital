package modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Tutor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 30)
    private String nome;
    @Column(length = 14)
    private String cpf;
    @Column (length = 50)
    private String cidade;
    @Column (length = 50)
    private String estado;
    @Column (length = 100)
    private String endereco;
    @Column (length = 12)
    private String telefone;
    
    @OneToMany(mappedBy = "tutor", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Animal> animal;
    
    public Tutor(){
        this.nome = "";
        this.cpf = "";
        this.cidade = "";
        this.estado = "";
        this.endereco = "";
        this.telefone = "";
    }
    
    public Tutor(String nome, String cpf, String cidade, String estado, String endereco, String telefone){
        this.nome = nome;
        this.cpf = cpf;
        this.cidade = cidade;
        this.estado = estado;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Animal> getAnimal() {
        return animal;
    }

    public void setAnimal(List<Animal> animal) {
        this.animal = animal;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.nome);
        hash = 17 * hash + Objects.hashCode(this.cpf);
        hash = 17 * hash + Objects.hashCode(this.cidade);
        hash = 17 * hash + Objects.hashCode(this.estado);
        hash = 17 * hash + Objects.hashCode(this.endereco);
        hash = 17 * hash + Objects.hashCode(this.telefone);
        hash = 17 * hash + Objects.hashCode(this.animal);
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
        final Tutor other = (Tutor) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.cidade, other.cidade)) {
            return false;
        }
        if (!Objects.equals(this.estado, other.estado)) {
            return false;
        }
        if (!Objects.equals(this.endereco, other.endereco)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
//        if (!Objects.equals(this.animal, other.animal)) {
//            return false;
//        }
        return true;
    }

    @Override
    public String toString() {
        return "Tutor{" + "id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", cidade=" + cidade + ", estado=" + estado + ", endereco=" + endereco + ", telefone=" + telefone + ", animal=" + animal + '}';
    }

    
  
}
    

