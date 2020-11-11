package estoque;

public class EstoqueProducts {
	private String descricao;
	private String preco;
	private String id;
	private String setor;
	private String quantidade;
	public EstoqueProducts(String descricao, String preco, String id, String setor,String quantidade) {
		super();
		this.descricao = descricao;
		this.preco = preco;
		this.id = id;
		this.quantidade=quantidade;
		this.setor = setor;
	}
	
	

	public EstoqueProducts() {
		// TODO Auto-generated constructor stub
	}
	public String getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(String quantidade) {
		this.quantidade = quantidade;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getPreco() {
		return preco;
	}
	public void setPreco(String preco) {
		this.preco = preco;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
}
