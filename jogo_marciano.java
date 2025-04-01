import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main
{   
    private static final int MAX_TENTATIVAS = 5;
    private static final ArrayList<Integer> recordes = new ArrayList<>();
    private static int marcianoPosicao;
    
	public static void main(String[] args) {
	    
	    Scanner scanner = new Scanner(System.in);
        mostrarIntroducao();

        while (true) {
            jogar(scanner);
            System.out.print("Deseja jogar novamente? (s/n): ");
            String resposta = scanner.next();
            if (!resposta.equalsIgnoreCase("s")) {
                break;
            }
        }

        mostrarRecordes();
        scanner.close();
    }

    private static void mostrarIntroducao() {
        System.out.println("Bem-vindo ao Jogo do Marciano!");
        System.out.println("Você deve adivinhar a posição do marciano em um tabuleiro de 1 a 10.");
        System.out.println("Você tem " + MAX_TENTATIVAS + " tentativas para acertar.");
        System.out.println("Boa sorte!");
    }

    private static void jogar(Scanner scanner) {
        marcianoPosicao = (int) (Math.random() * 10) + 1;
        int tentativas = 0;
        boolean acertou = false;

        while (tentativas < MAX_TENTATIVAS) {
            System.out.print("Tentativa " + (tentativas + 1) + ": Adivinhe a posição do marciano (1-10): ");
            int palpite = scanner.nextInt();
            tentativas++;

            if (palpite == marcianoPosicao) {
                System.out.println("Parabéns! Você acertou em " + tentativas + " tentativas.");
                recordes.add(tentativas);
                Collections.sort(recordes);
                acertou = true;
                break;
            } else if (palpite < marcianoPosicao) {
                System.out.println("O marciano está em uma posição maior.");
            } else {
                System.out.println("O marciano está em uma posição menor.");
            }
        }

        if (!acertou) {
            System.out.println("Você não conseguiu adivinhar. O marciano estava na posição " + marcianoPosicao + ".");
        }
    }

    private static void mostrarRecordes() {
        System.out.println("Melhores Jogadas:");
        for (int i = 0; i < recordes.size(); i++) {
            System.out.println((i + 1) + "º lugar: " + recordes.get(i) + " tentativas");
        }
		
    }
}