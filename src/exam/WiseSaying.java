package exam;

public class WiseSaying {
	private int id;
	private String wise;
	private String author;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getWise() {
		return wise;
	}

	public void setWise(String wise) {
		this.wise = wise;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public WiseSaying(int id, String wise, String author) {
		this.id = id;
		this.wise = wise;
		this.author = author;
	}
	
}
