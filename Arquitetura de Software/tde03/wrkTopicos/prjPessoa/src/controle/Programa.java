package controle;

import java.util.Scanner;

import modelo.Pessoa;

public class Programa {

	public static void listarPessoas(Pessoa[] pessoas) {
		System.out.println("Listando o Array");
		System.out.println("================");
		for(int i = 0; i < pessoas.length; i++)
			System.out.println(pessoas[i]);
	}

	public static void posicionarMaisVelho(Pessoa[] pessoas, int pos) {
		// Listando os dados da pessoa mais velha
		int indiceDoMaisVelho = 0;
		for(int j = 1; j <= pos; j++) {
			if(pessoas[j].getIdade() > pessoas[indiceDoMaisVelho].getIdade())
				indiceDoMaisVelho = j;
		}

		// Trocando
		Pessoa aux = pessoas[pos];
		pessoas[pos] = pessoas[indiceDoMaisVelho];
		pessoas[indiceDoMaisVelho] = aux;
	}

	public static Pessoa criarPessoa() {
		Scanner teclado = new Scanner(System.in);
		System.out.println("Lendo os dados de uma nova Pessoa");
		System.out.println("=================================");
		System.out.println("Entre com o cpf");
		String cpf = teclado.nextLine();
		System.out.println("Entre com o nome");
		String nome = teclado.nextLine();
		System.out.println("Entre com a idade");
		String aux = teclado.nextLine();
		int idade = Integer.parseInt(aux);
		return new Pessoa(cpf, nome, idade);
	}

	public static void main(String[] args) {
		Pessoa[] array = new Pessoa[4];

		// Instanciando 10 objetos Pessoa
		for(int i = 0; i < array.length; i++)
			array[i] = criarPessoa();

		// Listando o array
		listarPessoas(array);

		//
		for(int k = array.length - 1; k > 0; k--)
			posicionarMaisVelho(array, k);

		// Listando o array
		listarPessoas(array);
	}

}
