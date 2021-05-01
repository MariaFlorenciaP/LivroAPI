package br.edu.ifsc.livro;

import java.util.ArrayList;
import java.util.List;

public class LivroDataSource {
	
	private static List<Livro> livros = new ArrayList<>();

    public static void criarLista() {
        livros.add(new Livro(1, 9781, "O Mundo Funk Carioca", "Hermano Vianna ", "Zahar", new Double(199.99)));
        livros.add(new Livro(2, 9782, "21 Lessons for the 21st Century", "Yuval Harari", "Random House", new Double(149)));
        livros.add(new Livro(3, 9783, "Breve Historia do Mundo", "Ernst H. Gombrich", "Martins", new Double(89)));
        livros.add(new Livro(4, 9784, "Correspondências", "Clarice Lispector", "Rocco", new Double(99)));
        livros.add(new Livro(5, 9785, "A economia das trocas simbólicas", "Pierre Bourdieu", "Perspectiva", new Double(189)));
    }

    public static void adicionar(Livro livro) {
        livros.add(livro);
    }

    public static List<Livro> getAll() {
        return livros;
    }

    public static Livro getPorIsbn(int isbn) {
        for (Livro livro : livros) {
            if (livro.getIsbn() == isbn) {
                return livro;
            }
        }
        return null;
    }

    public static Livro getPorAutor(String autor) {
        for (Livro livro : livros) {
            if (livro.getAutor().equalsIgnoreCase(autor)) {
                return livro;
            }
        }
        return null;
    }

    public static Livro getPorTitulo(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equalsIgnoreCase(titulo)) {
                return livro;
            }
        }
        return null;
    }

    public static LivroDTO getPorIsbnDTO(int isbn) {
        for (Livro livro : livros) {
            if (livro.getIsbn() == isbn) {
                return new LivroDTO(livro.getTitulo(), livro.getAutor(), livro.getEditora(), livro.getPreco());
            }
        }
        return null;
    }

    public static List<LivroDTO> getAllDTO() {
        List<LivroDTO> dtos = new ArrayList<>();
        for (Livro livro : livros) {
            dtos.add(new LivroDTO(livro.getTitulo(), livro.getAutor(), livro.getEditora(), livro.getPreco()));

        }
        return dtos;
    }

    public static Livro reajustarPrecoPorId(int id, int taxa) {
        for (Livro livro : livros) {
            if (livro.getId() == id) {
                Double preco = livro.getPreco() + livro.getPreco() * (taxa / 100.0);
                livro.setPreco(preco);
                return livro;
            }
        }
        return null;
    }

    public static List<Livro> reajustarPreco(int taxa) {
        for (Livro livro : livros) {
            Double preco = livro.getPreco() + livro.getPreco() * (taxa / 100.0);
            livro.setPreco(preco);
        }
        return livros;
    }

}
