package catalogo;

/**
 * Created by hdant on 28/08/2016.
 */
public enum Categoria {
	OBRIGATORIA("Obrigatória"), LIMITADA("Opção Limitada"), LIVRE("Livre Escolha");

	private String categoria;

	Categoria(String c) {
		this.categoria = c;
	}

	public String getCategoria() {
		return categoria;
	}
}
