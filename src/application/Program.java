package application;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Program {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(3, 4, 5, 10, 7);
		
		//map pega cada elemento da lista e transforma. Gera outra stream, no caso elem original vezes 10
		Stream<Integer> st1 = list.stream().map(x -> x * 10);
		
		//toArray terminal processa e da resultado
		System.out.println(Arrays.toString(st1.toArray()));
		
		//somar todos elementos stream
		//list.stream cria stream a partir da lista
		//reduce uma operação terminal
		//reduce pega um elemento inical neuto 0 e depois função recebeu dois elemento e depois resultadando x+y
		int sum= list.stream().reduce(0, (x,y) -> x + y);
		System.out.println("Sum = " + sum);
		
		//se fosse produtório seria a multiplicação e o elmento neutro seria 1
		int mult= list.stream().reduce(1, (x,y) -> x * y);
		System.out.println("Multiplicação = " + mult);
		
		//criando nova lista. Filter (filtrar) com base no predicado gera uma nova stream com elemen. que satisfaçam o predicado
		List<Integer> newList = list.stream()
				.filter(x -> x %2 == 0)//todos elmento pares. 
				.map(x -> x * 10)//O map transforma em outra stream. Pega os pares do filter e multiplica cada elemn. por 10
				.collect(Collectors.toList());//operação terminal transformar stream em uma lista
		
		//pega os pares no caso 4 e o 10 e multiplica por 10
		System.out.println(Arrays.toString(newList.toArray()));
	
	}

}
