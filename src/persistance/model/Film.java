package persistance.model;

public class Film 
{
	private Integer id;
	private String titolo;
	private Integer data;
	private Media media;
	
	public Film(){
		media = new Media();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	public Integer getData() {
		return data;
	}
	public void setData(Integer data) {
		this.data = data;
	}
	public Media getMedia() {
		return media;
	}
	public void setMedia(Media media) {
		this.media = media;
	}
}
