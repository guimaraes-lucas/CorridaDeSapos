
public class Aplicacao {
	
	public static void main(String[] args) {
		
		Corrida corrida = new Corrida();
		Sapo[] competidor = new Sapo[4];
		
		for (int i = 0; i < competidor.length; i++) {
			competidor[i] = new Sapo(corrida);
		}
		
		competidor[0].setNome("João");
		competidor[1].setNome("Fulano");
		competidor[2].setNome("José");
		competidor[3].setNome("Lucas");
		
		for (Sapo sapo : competidor) {
			sapo.start();
		}
		
		for (Sapo sapo : competidor) {
			try {
				sapo.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("O vencedor é: " + corrida.getNomeVencedor());
	}
}
