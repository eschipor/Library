package persistance.model;

public class Media 
{
	private Integer id;
	private String nome;
	private String tipo;
	private String indirizzo;
	private Long size;
	
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
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	public Long getSize() {
		return size;
	}
	public void setSize(long l) {
		this.size = l;
	}
}
