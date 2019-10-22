package br.com.badcompany.android.backend.model;

public class Moto {
	private int id;
	private String modelo;
	private String marca;
	private String imagem;
	private boolean ehFavorito;

	public Moto(int id, String modelo, String marca, String imagem, boolean ehFavorito) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.marca = marca;
		this.imagem = imagem;
		this.ehFavorito = ehFavorito;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public boolean isEhFavorito() {
		return ehFavorito;
	}

	public void setEhFavorito(boolean ehFavorito) {
		this.ehFavorito = ehFavorito;
	}
}
