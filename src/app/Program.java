package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Fisica;
import entities.Juridica;
import entities.Pessoa;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Pessoa> list = new ArrayList<>();

		System.out.print("Enter the number of tax payers: ");
		int n = sc.nextInt();

		for (int i = 0; i < n; i++) {
			System.out.println("Tax payer #" + (i + 1) + " data: ");
			System.out.print("Individual or company (i/c)? ");
			char c = sc.next().charAt(0);
			sc.nextLine();
			System.out.print("Name: ");
			String nome = sc.nextLine();
			System.out.print("Anual income: ");
			double rendaAnual = sc.nextDouble();

			if (c == 'i') {
				System.out.print("Health expenditures: ");
				double gastosSaude = sc.nextDouble();

				list.add(new Fisica(nome, rendaAnual, gastosSaude));
			} else {
				System.out.print("Number of employees: ");
				int numeroFuncionarios = sc.nextInt();

				list.add(new Juridica(nome, rendaAnual, numeroFuncionarios));
			}

		}

		System.out.println("");

		double soma = 0;
		System.out.println("TAXES PAID:");
		for (Pessoa p : list) {
			double taxa = p.imposto();
			System.out.println(p);
			soma += taxa;
		}

		System.out.println("");
		System.out.println("TOTAL TAXES: $ " + String.format("%.2f", soma));

		sc.close();

	}

}
