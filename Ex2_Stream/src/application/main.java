package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Pessoa;

public class main {

	public static void main(String[] args) {
		String path = "D:\\Estudos\\Curso java\\Projetos\\Ex2_Stream\\pessoas.txt";
		List<Pessoa> list = new ArrayList<Pessoa>();
		Scanner sc = new Scanner(System.in);
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			while(line!=null) {
				String[] pes = line.split(",");
				Pessoa pessoa = new Pessoa(pes[1],pes[0], Double.parseDouble(pes[2]));
				list.add(pessoa);
				line = br.readLine();
			}
			System.out.println("Enter salary: ");
			double salario = sc.nextDouble();
			Comparator<String> cp = (s1,s2) -> s1.toLowerCase().compareTo(s2.toLowerCase());
			List<String> emails = list.stream()
										.filter(p-> p.getSalario()> salario)
										.map(p-> p.getEmail()).sorted()
										.collect(Collectors.toList());
			System.out.println("Email of people whose salary is more than: "+salario);
			emails.forEach(System.out::println);
			
			double soma = list.stream()
									.filter(p-> p.getNome().toUpperCase().startsWith("M", 0))
									.map(p->p.getSalario())
									.reduce(0.0, (x,y)-> x + y);
			System.out.println("Sum of salary of people whose name starts with 'M': "+soma);
									
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc.close();
	}

}
