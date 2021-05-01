package br.edu.ifsc.livro;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LivroController {
	
	//declaraçoes---->consumir/produzir
	@RequestMapping(value = "/adicionar_livro", method = RequestMethod.POST,
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Livro novo(@RequestBody Livro livro) {
		LivroDataSource.adicionar(livro);
		return livro;
	}

	 @RequestMapping(value = "/livro/{id}/{isbn}/{titulo}/{autor}/{editora}/{preco}")
	    public Livro adicionar(
	            @PathVariable("id") int id,
	            @PathVariable("isbn") int isbn,
	            @PathVariable("titulo") String titulo,
	            @PathVariable("autor") String autor,
	            @PathVariable("editora") String editora,
	            @PathVariable("preco") Double preco) {
	        Livro livro = new Livro(id, isbn, titulo, autor, editora, preco);
	        LivroDataSource.adicionar(livro);
	        return livro;
	    }

	    @RequestMapping(value = "/getAll")
	    public List<Livro> getAll() {
	        return LivroDataSource.getAll();
	    }

	    @RequestMapping(value = "/getPorIsbn/{isbn}")
	    public Livro getPorIsbn(@PathVariable("isbn") int isbn) {
	        return LivroDataSource.getPorIsbn(isbn);
	    }

	    @RequestMapping(value = "/getPorAutor/{autor}")
	    public Livro getPorIsbn(@PathVariable("autor") String autor) {
	        return LivroDataSource.getPorAutor(autor);
	    }

	    @RequestMapping(value = "/getPorTitulo/{titulo}")
	    public Livro getPorTitulo(@PathVariable("titulo") String titulo) {
	        return LivroDataSource.getPorTitulo(titulo);
	    }

	    @RequestMapping(value = "/getPorIsbnDTO/{isbn}")
	    public LivroDTO getPorIsbnDTO(@PathVariable("isbn") int isbn) {
	        return LivroDataSource.getPorIsbnDTO(isbn);
	    }

	    @RequestMapping(value = "/getAllDTO")
	    public List<LivroDTO> getAllDTO() {
	        return LivroDataSource.getAllDTO();
	    }

	    @RequestMapping(value = "/reajustarPrecoPorId/{id}/{taxa}")
	    public Livro reajustarPrecoPorId(@PathVariable("id") int id, @PathVariable("taxa") int taxa) {
	        return LivroDataSource.reajustarPrecoPorId(id, taxa);
	    }

	    @RequestMapping(value = "/reajustarPreco/{taxa}")
	    public List<Livro> reajustarPreco(@PathVariable("taxa") int taxa) {
	        return LivroDataSource.reajustarPreco(taxa);
	    }
}
