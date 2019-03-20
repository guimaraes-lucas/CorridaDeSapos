import java.util.Random;

public class Sapo extends Thread {
	
	private static final int MAX_DISTANCIA_PULO = 10;
	private static final int MAX_TEMPO_DESCANSO = 300;
	private static int colocacao;
	Random random = new Random();
	
	private String nome = "";
	private int ultimoPulo = 0;
	private int distanciaPercorrida = 0;
	private Corrida corrida;
	
	public Sapo(Corrida corrida) {
		this.corrida = corrida;
	}
	
	public void pular() {
		this.ultimoPulo = random.nextInt(MAX_DISTANCIA_PULO);
		this.setDistanciaPercorrida(this.getDistanciaPercorrida() 
				+ ultimoPulo);
	}
	
	public void descansar() {
		try {
			Thread.sleep(random.nextInt(MAX_TEMPO_DESCANSO));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while (this.distanciaPercorrida < this.corrida.getTamanhoPista()) {
			pular();
			avisarSituacao();
			descansar();
		}
		
		this.corrida.setNomeVencedor(this.nome);
		cruzarLinhaDeChegada();
	}

	private void avisarSituacao() {
		System.out.println(nome + " pulou " + ultimoPulo + "cm. A distância percorrida foi de " + distanciaPercorrida + "cm");
	}
	
	private synchronized void cruzarLinhaDeChegada() {
			colocacao++;
			System.out.println("==> " + nome + " cruzou a linha de chegada em " + colocacao + "º lugar!");
	}

	public int getDistanciaPercorrida() {
		return distanciaPercorrida;
	}

	public void setDistanciaPercorrida(int distanciaPercorrida) {
		this.distanciaPercorrida = distanciaPercorrida;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
