package tools;

public class CodigoUFABC {
	private String codigo;
	private int ano;

	public CodigoUFABC(String c) {
		String[] cSplit = c.split("-");
		this.codigo = cSplit[0];
		this.ano = Integer.parseInt(cSplit[1]);
	}

	public String getCodigo() {
		return codigo;
	}

	public int getAno() {
		return ano;
	}

}
