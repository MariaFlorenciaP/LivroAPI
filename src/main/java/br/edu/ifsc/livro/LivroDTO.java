package br.edu.ifsc.livro;

public class LivroDTO {
	
	 private String titulo;
	    private String autor;
	    private String editora;
	    private Double preco;

	    public LivroDTO() {
	    }

	    public LivroDTO(String titulo, String autor, String editora, Double preco) {
	        this.titulo = titulo;
	        this.autor = autor;
	        this.editora = editora;
	        this.preco = preco;
	    }

	    public String getTitulo() {
	        return titulo;
	    }

	    public void setTitulo(String titulo) {
	        this.titulo = titulo;
	    }

	    public String getAutor() {
	        return autor;
	    }

	    public void setAutor(String autor) {
	        this.autor = autor;
	    }

	    public String getEditora() {
	        return editora;
	    }

	    public void setEditora(String editora) {
	        this.editora = editora;
	    }

	    public Double getPreco() {
	        return preco;
	    }

	    public void setPreco(Double preco) {
	        this.preco = preco;
	    }

}
