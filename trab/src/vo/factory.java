package vo;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class factory {
	
     public static void main (String [] args){


		ArrayList<String> a = new ArrayList();


		ArrayList<String> y = new ArrayList();

		String fileName = "megaa.csv";
		File file = new File(fileName);

		try {
			Scanner scanner = new Scanner (file);
			while(scanner.hasNext()) { 
				String mega = scanner.next();
				String [] valores = mega.split(",");
				a.add(valores[2]);
				a.add(valores[3]);
				a.add(valores[4]);
				a.add(valores[5]);
				a.add(valores[6]);
				a.add(valores[7]); // COLUNAS QUE CONTÉM OS NÚMEROS DO JOGO
			}
			scanner.close();
		} catch(FileNotFoundException e) {
		}
		 


		int tamanho = a.size();
		int cont = 0;
		String numeros [] = new String [tamanho];
		int n [] = new int [tamanho];
		int [] resultadoAnual = new int [tamanho]; // PARA CRIAR MATRIZ
		int vezes [] = new int [61]; // NUMEROS DO SORTEIO DE 1 ATE 60
		int aux [] = new int [5];

		System.out.println(a);

		for (int i = 0; i < tamanho; i++) {
			n[i] = Integer.parseInt(a.get(i)); // CONVERTENDO O ARRAY DE STRING EM INTEIRO 
			resultadoAnual[i] = Integer.parseInt(a.get(i));
		} 


		Arrays.sort(n); // ORDEDANDO TOS VALORES

		for (int i = 0; i <= 60; i++) {
			for(int j = 0; j < tamanho; j++) { 
				if(i == n[j]) { // CONFERE A QUANTIDADE DE VEZES QUE O NÚMERO APARECEU
					cont++;
					vezes[i] = cont; // PARA ARMAZENAR NO VETOR AUXILIAR
				} 
			}
			cont = 0; // REINICIA QUANDO O I ALTERA
		}

		int maPos1 = 0; int maPos2 = 0; int maPos3 = 0; int maPos4 = 0; int maPos5 = 0;
		int ma1 = vezes[0]; int ma2 = 0; int ma3 = 0; int ma4 = 0; int ma5 = 0;
		// numeros que mais apareceram

		for(int i = 0; i <= 60; i++) {
			if(vezes[i] > ma1) {
				ma1 = vezes[i];
				maPos1 = i; 
			} 
		}
		for(int i = 0; i <= 60; i++) {
			if(vezes[i] > ma2 && vezes[i] <= ma1 && i != maPos1) {
				ma2 = vezes[i];
				maPos2 = i; 
			} 
		}
		for(int i = 0; i <= 60; i++) {
			if(vezes[i] >= ma3 && vezes[i] <= ma2 && i != maPos2) {
				ma3 = vezes[i];
				maPos3 = i; 
			}
		}
		for(int i = 0; i <= 60; i++) {
			if(vezes[i] >= ma4 && vezes[i] <= ma3 && i != maPos3) {
				ma4 = vezes[i];
				maPos4 = i; 
			}
		} 
		for(int i = 0; i <= 60; i++) {
			if(vezes[i] >= ma5 && vezes[i] <= ma4 && i != maPos4) {
				ma5 = vezes[i];
				maPos5 = i;
			}
		}
		System.out.println("NÚMEROS QUE MAIS APARECERAM\n");
		System.out.println("Número "+maPos1+ " apareceu "+ma1+" vezes");
		System.out.println("Número "+maPos2+ " apareceu "+ma2+" vezes");
		System.out.println("Número "+maPos3+ " apareceu "+ma3+" vezes");
		System.out.println("Número "+maPos4+ " apareceu "+ma4+" vezes");
		System.out.println("Número "+maPos5+ " apareceu "+ma5+" vezes");

		int mePos1 = 0; int mePos2 = 0; int mePos3 = 0; int mePos4 = 0; int mePos5 = 0; 
		int me1 = ma1; int me2 = 0; int me3 = 0; int me4 = 0; int me5 = 0;  
		//numeros que menos apareceram
		for(int i = 1; i <= 60; i++) {
			if(vezes[i] < me1) {
				me1 = vezes[i];
				mePos1 = i;
			} 
		}
		int auxiliar = vezes[60];
		for(int i = 1; i <= 60; i++) {
			if(vezes[i] < auxiliar && vezes[i] > me1) {
				auxiliar = vezes[i];
				me2 = vezes[i];
				mePos2 = i;
			} 
		}
		auxiliar = vezes[60];
		for(int i = 1; i <= 60; i++) {
			if(vezes[i] <= auxiliar && vezes[i] > me2) {
				auxiliar = vezes[i];
				me3 = vezes[i];
				mePos3 = i;
			}
		}
		auxiliar = vezes[60];
		for(int i = 1; i <= 60; i++) {
			if(vezes[i] <= auxiliar && vezes[i] > me3) {
				auxiliar = vezes[i];
				me4 = vezes[i];
				mePos4 = i;
			} 
		}
		auxiliar = vezes[60];
		for(int i = 1; i <= 60; i++) {
			if(vezes[i] <= auxiliar && vezes[i] > me4) {
				auxiliar= vezes[i];
				me5 = vezes[i];
				mePos5 = i;
			} 
		}
		/* System.out.println("\nNÚMEROS QUE MENOS APARECERAM\n");
	System.out.println("Número "+mePos1+ " apareceu "+me1+" vezes");
	System.out.println("Número "+mePos2+ " apareceu "+me2+" vezes");
	System.out.println("Número "+mePos3+ " apareceu "+me3+" vezes");
	System.out.println("Número "+mePos4+ " apareceu "+me4+" vezes");
	System.out.println("Número "+mePos5+ " apareceu "+me5+" vezes"); */

		/*System.out.println();
	for(int i = 0; i <= 60; i++) {
	System.out.println("Numero "+i+" apareceu "+vezes[i]+" vezes");
	}*/

	}
     }

