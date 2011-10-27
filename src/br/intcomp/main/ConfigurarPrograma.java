package br.intcomp.main;

import java.util.Scanner;

public class ConfigurarPrograma {

	private static final String VERSAO_SISTEMA = "1.0";
	protected String tipoDeAgente;
	protected boolean comPenalizacao;
	protected int largura;
	protected int altura;
	protected boolean ehTeste;
	private double porcentagemDeSujeira;

	public ConfigurarPrograma(String[] args) {
		if (args.length == 1) {
			exibirInformacoes(args);
		} else if (args.length == 0) {
			configurar();
		} else if (args.length == 6) {
			configurar(args);
		} else {
			exibirComandos();
		}
	}

	private void exibirInformacoes(String[] args) {
		if (args[0].compareToIgnoreCase("-versao") == 0
				|| args[0].compareToIgnoreCase("-v") == 0) {
			System.out.println("Versão: " + VERSAO_SISTEMA);
			System.out.println("Equipe: Débora Martins e Marcos Brizeno");
			System.out.println("Inteligência Computacional - 2011.2");
			System.out.println("Professor Gustavo");
		}
	}

	private void exibirComandos() {
		System.out.println("Utilize [-ajuda | -a] para ver os comandos");
		System.out
				.println("Utilize [-versao | -v] para exibir a versão do programa");
		System.out
				.println("Utilize os seguintes comandos para configurar o ambiente");
		System.out.println("Escolher o tipo de agente:");
		System.out
				.println("[-estadointerno | -ei] Ambiente com agente de estado interno");
		System.out
				.println("[-acaoreacao | -ar] Ambiente com agente de ação e reação");
		System.out
				.println("Escolher se deve ser um ambiente de testes ou iterativo");
		System.out.println("[-teste | -t] Ambiente com teste");
		System.out.println("[-iterativo | -i] Ambiente iterativo");
		System.out
				.println("Escolher se o ambiente deve ou não penalizar seus agentes");
		System.out.println("[-compenalizacao | -cp] Ambiente com penalização");
		System.out.println("[-sempenalizacao | -sp] Ambiente sem penalização");
		System.out.println("Escolher as dimensões do ambiente");
		System.out.println("Largura do ambiente e Altura do Ambiente");
		System.out.println("Escolher porcentagem de sujeira no ambiente");
		System.out.println("Porcentagem de sujeira");
		System.out.println("\nExemplo de uso:");
		System.out.println("Aspirador de pó.jar -ei -i -sp 10 10 0.5");
		System.out
				.println("Cria um ambiente com um agente de estado interno, iterativo, sem penalização, com dimensão 10x10 e com 50% de sujeira");
		System.exit(1);
	}

	private void configurar(String[] args) {
		if (args[0].compareToIgnoreCase("-estadointerno") == 0
				|| args[0].compareToIgnoreCase("-ei") == 0) {
			tipoDeAgente = "Estado Interno";
		} else if (args[0].compareToIgnoreCase("-acaoreacao") == 0
				|| args[0].compareToIgnoreCase("-ar") == 0) {
			tipoDeAgente = "Ação Reação";
		} else {
			exibirComandos();
		}

		if (args[1].compareToIgnoreCase("-teste") == 0
				|| args[1].compareToIgnoreCase("-t") == 0) {
			ehTeste = true;
		} else if (args[1].compareToIgnoreCase("-iterativo") == 0
				|| args[1].compareToIgnoreCase("-i") == 0) {
			ehTeste = false;
		} else {
			exibirComandos();
		}

		if (args[2].compareToIgnoreCase("-compenalizacao") == 0
				|| args[2].compareTo("-cp") == 0) {
			comPenalizacao = true;
		} else if (args[2].compareToIgnoreCase("-sempenalizacao") == 0
				|| args[2].compareToIgnoreCase("-sp") == 0) {
			comPenalizacao = false;
		} else {
			exibirComandos();
		}

		largura = Integer.parseInt(args[3]);
		altura = Integer.parseInt(args[4]);
		porcentagemDeSujeira = Double.parseDouble(args[5]);

	}

	private void configurar() {
		System.out.println("Escolha as configurações:");
		Scanner scanner = new Scanner(System.in);
		while (true) {
			int escolha = 0;
			System.out.println("1. Agente Estado Interno");
			System.out.println("2. Agente Ação Reação");
			escolha = scanner.nextInt();
			if (escolha == 1) {
				tipoDeAgente = "Estado Interno";
				break;
			} else if (escolha == 2) {
				tipoDeAgente = "Ação Reação";
				break;
			}
		}

		while (true) {
			int escolha = 0;
			System.out.println("1. Ambiente para testes");
			System.out.println("2. Ambiente iterativo");
			escolha = scanner.nextInt();
			if (escolha == 1) {
				ehTeste = true;
				break;
			} else if (escolha == 2) {
				ehTeste = false;
				break;
			}
		}

		while (true) {
			int escolha = 0;
			System.out.println("1. Com penalização");
			System.out.println("2. Sem penalização");
			escolha = scanner.nextInt();
			if (escolha == 1) {
				comPenalizacao = true;
				break;
			} else if (escolha == 2) {
				comPenalizacao = false;
				break;
			}
		}

		System.out.print("Largura do Ambiente: ");
		largura = scanner.nextInt();

		System.out.print("Altura do Ambiente: ");
		altura = scanner.nextInt();

		System.out.print("Porcentagem de sujeira: ");
		porcentagemDeSujeira = scanner.nextDouble();
	}

	public String getTipoDeAgente() {
		return tipoDeAgente;
	}

	public boolean isComPenalizacao() {
		return comPenalizacao;
	}

	public int getLargura() {
		return largura;
	}

	public int getAltura() {
		return altura;
	}

	public boolean isEhTeste() {
		return ehTeste;
	}

	public double getPorcentagemDeSujeira() {
		return porcentagemDeSujeira;
	}

}
