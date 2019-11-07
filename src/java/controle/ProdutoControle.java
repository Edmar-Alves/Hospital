package controle;

import dao.DAO;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import modelo.Produto;

@ManagedBean
@ViewScoped
public class ProdutoControle implements Serializable {
    private List<Produto> produtos;
    private Produto produto;
    private DAO<Produto> dao;
    private boolean popupNovo;
    private boolean popupAltera;
    private boolean popupEstoque;
    private int tipo;
    private int quantidadeMovimentada;
    
    public ProdutoControle(){
        produto = new Produto();
        dao = new DAO(Produto.class);
        produtos = dao.listarTodos();
        popupNovo = false;
        popupAltera = false;
        popupEstoque = false;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public void alterarEstoque (){
        if (tipo == 0){
            produto.setQuantidade(produto.getQuantidade()+quantidadeMovimentada);
        }
        else {
            if (quantidadeMovimentada <= produto.getQuantidade()){
            produto.setQuantidade(produto.getQuantidade()-quantidadeMovimentada);
            }
            else {
                FacesContext context = FacesContext.getCurrentInstance();
                context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Quantidade movimentada maior que a quantidade atual", null));
                return;
            }
        }    
        dao.alterar(produto);
        fecharPopupEstoque();     
    }

    public int getQuantidadeMovimentada() {
        return quantidadeMovimentada;
    }

    public void setQuantidadeMovimentada(int quantidadeMovimentada) {
        this.quantidadeMovimentada = quantidadeMovimentada;
    }
    
    
    
    public boolean isPopupEstoque() {
        return popupEstoque;
    }

    public void setPopupEstoque(boolean popupEstoque) {
        this.popupEstoque = popupEstoque;
    }
    
    public void abrePopupEstoque(){
        this.popupEstoque = true;
    }
    public void fecharPopupEstoque(){
        this.popupEstoque = false;
    }

    public void abrePopupNovo(){
        produto = new Produto();
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
        dao.inserir(produto);
        produtos = dao.listarTodos();
        fecharPopupNovo();
    }
    
    public void alterarTutor() {
        dao.alterar(produto);
        produtos = dao.listarTodos(); // atualiza a lista
        produto = new Produto(); 
        fecharPopupAltera();
    }
    
    public void excluir(Produto produto){
        dao.excluir(produto.getId());
        produtos.remove(produto);
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public DAO<Produto> getDao() {
        return dao;
    }

    public void setDao(DAO<Produto> dao) {
        this.dao = dao;
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
