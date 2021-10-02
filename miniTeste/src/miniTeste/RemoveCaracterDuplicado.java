package miniTeste;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class RemoveCaracterDuplicado {

	public static void main(String[] args) throws IOException {

		boolean duplicado = true;
		//Scanner para entrada da String
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite a entrada: ");
		String entrada = scanner.nextLine();
		
		//Vetor que armazena a entrada separando as palavra por espaço
		String[] separadoPorPalavra = entrada.split(" ");
		
		//Vetor de String que ira receber as palavras corrigidas
		ArrayList<String> fraseCorrigida = new ArrayList<>();
		
		//Laço que percorre o array de palavras.
		for (int i = 0; i < separadoPorPalavra.length; i++) {
			
			//Variavel inicializada com o indice do vetor
			String palavras = separadoPorPalavra[i];
			String letrasBuscadas = "";
			String pedacoAvaliado = "";
			String prePedacoAvaliado = "";
			String palavraCorrigida = "";
			
			//Laço inicializado com o tamanho do vetor percorrendo as palavras decrescivamente
			// A cada repetiçao vai decrementando a palavra ate dar false e quebrar o laço
			//Por ex: roupaoupa =>  "roupaoup" "a";
			//     					"roupaou"  "pa"
			//						"roupao"   "upa"
			
			for (int l = palavras.length(); l > 0; l--) {
				
				prePedacoAvaliado = palavras.substring(0, l);
				
				letrasBuscadas = palavras.substring(l - 1);
				
				pedacoAvaliado = palavras.substring(0, l - 1);
				
				//Variavel inicializada com a palavra corrigida
				palavraCorrigida = prePedacoAvaliado;

				if (!pedacoAvaliado.contains(letrasBuscadas)) {
					break;
				}

			}
			
			// Adicionando as palavras corrigidas para o Array
			fraseCorrigida.add(i, palavraCorrigida);
			
			//Condiçao a palavra com a palavra corrigida
			if (palavras.equals(palavraCorrigida)) {
				//Se a palavra nao estiver duplicada retorna a entrada adicinando o "." no final da frase
				duplicado = false;
				System.out.println(entrada+".");
				return;
			}

		}
		
		//Instanciando a classe para concatenar as palavras corrigidas
		StringBuffer sb = new StringBuffer();
		for (String palavra : fraseCorrigida) {
			//condiçao que identifica a ultima letra para adicionar o "." no final da frase
			if (palavra.equals(fraseCorrigida.get(fraseCorrigida.size() - 1))) {
				sb.append(palavra + ".");

			} else {
				//Separa as String
				sb.append(palavra + " ");

			}

		}

		String saida = sb.toString();

		System.out.println(saida);
	}
}
