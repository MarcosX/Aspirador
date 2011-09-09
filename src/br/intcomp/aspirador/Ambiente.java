package br.intcomp.aspirador;

import br.intcomp.aspirador.Sala.EstadoDaSala;

public class Ambiente {
	private int altura, largura;
	private Sala[][] ambiente;
	private Aspirador agente;
	private int posAgenteX, posAgenteY;

	public Ambiente(int largura, int altura) {
		this.largura = altura;
		this.altura = largura;
		ambiente = new Sala[largura][altura];
		for (int i = 0; i < largura; i++) {
			for (int j = 0; j < altura; j++) {
				if (isParede(largura, altura, i, j))
					ambiente[i][j] = new Sala(EstadoDaSala.obstaculo);
				else
					ambiente[i][j] = new Sala();
			}
		}
		agente = new Aspirador();
		posAgenteX = 1;
		posAgenteY = 1;
	}

	private boolean isParede(int largura, int altura, int i, int j) {
		return i == 0 || j == 0 || i == largura - 1 || j == altura - 1;
	}

	public Sala getSala(int i, int j) {
		return ambiente[i][j];
	}

	public void mostrarAmbiente() {
		for (int i = 0; i < altura; i++) {
			for (int j = 0; j < largura; j++) {
				if (i == posAgenteX && j == posAgenteY) {
					System.out.print('@');
				} else {
					System.out.print(ambiente[i][j].getDscSala());
				}
			}
			System.out.println();
		}
	}

	public void setSujeira(int x, int y) {
		if (isPosicaoValida(x, y))
			ambiente[x][y].estado = EstadoDaSala.sujo;
	}

	public void setObstaculo(int x, int y) {
		if (isPosicaoValida(x, y))
			ambiente[x][y].estado = EstadoDaSala.obstaculo;
	}

	private boolean isPosicaoValida(int x, int y) {
		return (x >= 0 && x < altura) && (y >= 0 && y < largura)
				&& ambiente[x][y].estado != EstadoDaSala.obstaculo;
	}

	private void moverAgente() {
		while (!isPosicaoValida(posAgenteX + agente.getVelX(), posAgenteY
				+ agente.getVelY())) {
			agente.perceberObstaculoSala(ambiente[posAgenteX][posAgenteY]);
		}
		posAgenteX += agente.getVelX();
		posAgenteY += agente.getVelY();
	}

	public void executarAgente() {
		agente.perceberSala(ambiente[posAgenteX][posAgenteY]);
		moverAgente();
	}

	public void setPosicaoAgente(int x, int y) {
		posAgenteX = x;
		posAgenteY = y;
	}

	public boolean existeSujeira() {
		for (int i = 0; i < altura; i++) {
			for (int j = 0; j < largura; j++) {
				if (ambiente[i][j].estado == EstadoDaSala.sujo) {
					return true;
				}
			}
		}
		return false;
	}

	public void mostrarPontuacao() {
		System.out.println(agente.getPontuacao());
	}

	public void setPorcentagemDeSujeira(double d) {
		int numeroDeSujeiras = (int) ((altura - 2) * (largura - 2) * d);
		for (int i = 0; i < numeroDeSujeiras; i++) {
			int x = (int) (Math.random() * altura - 1) + 1;
			int y = (int) (Math.random() * largura - 1) + 1;
			while (ambiente[x][y].estado == EstadoDaSala.sujo
					|| ambiente[x][y].estado == EstadoDaSala.obstaculo) {
				x = (int) (Math.random() * altura - 1) + 1;
				y = (int) (Math.random() * largura - 1) + 1;
			}
			ambiente[x][y].estado = EstadoDaSala.sujo;
		}
	}
}
