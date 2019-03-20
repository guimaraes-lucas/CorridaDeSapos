import java.util.Random;

public class Corrida {

	Random random = new Random();
	
	private int tamanhoPista = random.nextInt(300);
	private String nomeVencedor = "";

	public int getTamanhoPista() {
		return this.tamanhoPista;
	}

	public String getNomeVencedor() {
		return nomeVencedor;
	}

	public void setNomeVencedor(String nomeVencedor) {
		if (this.nomeVencedor.isEmpty()) {
			this.nomeVencedor = nomeVencedor;
		}
	}
}
