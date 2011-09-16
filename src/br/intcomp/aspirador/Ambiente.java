package br.intcomp.aspirador;

import br.intcomp.aspirador.Sala.EstadoDaSala;

public class Ambiente {
	private int altura, largura;
	private Sala[][] ambiente;
	private AspiradorRandom agenteRandom;
	private AspiradorEstadoInterno agenteEstadoInterno;
	private int totalSujeiras;

	public Ambiente(int largura, int altura) {
		this.largura = altura + 2;
		this.altura = largura + 2;
		ambiente = new Sala[this.largura][this.altura];
		for (int i = 0; i < this.largura; i++) {
			for (int j = 0; j < this.altura; j++) {
				if (isParede(this.largura, this.altura, i, j))
					ambiente[i][j] = new Sala(EstadoDaSala.obstaculo);
				else
					ambiente[i][j] = new Sala();
			}
		}
		agenteRandom = new AspiradorRandom();
		agenteEstadoInterno = new AspiradorEstadoInterno();
	}

	public Sala getSala(int x, int y) {
		return ambiente[x][y];
	}

	private boolean isParede(int largura, int altura, int i, int j) {
		return i == 0 || j == 0 || i == largura - 1 || j == altura - 1;
	}

	public void mostrarAmbiente() {
		for (int j = 0; j < altura; j++) {
			for (int i = 0; i < largura; i++) {
				if (i == agenteRandom.getPosicaoX()
						&& j == agenteRandom.getPosicaoY()) {
					System.out.print('R');
				} else if (i == agenteEstadoInterno.getPosicaoX()
						&& j == agenteEstadoInterno.getPosicaoY()) {
					System.out.print('E');
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
		return (x > 0 && x < largura) && (y > 0 && y < altura)
				&& ambiente[x][y].estado != EstadoDaSala.obstaculo;
	}

	public void executarAgenteRandom() {
		if (!agenteRandom.sensorSujeira.acionarSensor(getSalaAtualRandom())) {
			while (agenteRandom.sensorProximaSalaOcupada
					.acionarSensor(getProximaSalaRandom())) {
				agenteRandom.direcaoRandom();
			}
			agenteRandom.atuadorMovimento();
		}
		agenteRandom.direcaoRandom();
	}

	public void executarAgenteEstadoInterno() {
		if (!agenteEstadoInterno.sensorSujeira.acionarSensor(getSalaAtualEI())) {
			boolean isProximaSalaOcupada = agenteEstadoInterno.sensorProximaSalaOcupada
					.acionarSensor(getProximaSalaEI());
			boolean isProximaSalaVisitada = agenteEstadoInterno.isSalaVisitada(
					agenteEstadoInterno.getProximaPosicaoX(),
					agenteEstadoInterno.getProximaPosicaoY());
			if (isProximaSalaOcupada || isProximaSalaVisitada) {
				agenteEstadoInterno.girarNoventaGraus();
			}
			agenteEstadoInterno.atuadorMovimento();
		}
	}

	private Sala getSalaAtualEI() {
		return ambiente[agenteEstadoInterno.getPosicaoX()][agenteEstadoInterno
				.getPosicaoY()];
	}

	private Sala getProximaSalaEI() {
		return ambiente[agenteEstadoInterno.getProximaPosicaoX()][agenteEstadoInterno
				.getProximaPosicaoY()];
	}

	private Sala getProximaSalaRandom() {
		return ambiente[agenteRandom.getProximaPosicaoX()][agenteRandom
				.getProximaPosicaoY()];
	}

	private Sala getSalaAtualRandom() {
		return ambiente[agenteRandom.getPosicaoX()][agenteRandom.getPosicaoY()];
	}

	public void setPosicaoAgente(int x, int y) {
		agenteRandom.setPosicao(x, y);
	}

	public boolean existeSujeira() {
		for (int i = 0; i < largura; i++) {
			for (int j = 0; j < altura; j++) {
				if (ambiente[i][j].estado == EstadoDaSala.sujo) {
					return true;
				}
			}
		}
		return false;
	}

	public void mostrarInformacoes() {
		System.out.println("Sujeira: " + getSujeirasRestantes() + "/"
				+ totalSujeiras + " Pontuacao Random: "
				+ agenteRandom.getPontuacao() + " Pontuacao EI: "
				+ agenteEstadoInterno.getPontuacao());
	}

	private int getSujeirasRestantes() {
		int sujeirasRestantes = 0;
		for (int i = 1; i < largura - 1; i++) {
			for (int j = 0; j < altura - 1; j++) {
				if (ambiente[i][j].estado == EstadoDaSala.sujo) {
					sujeirasRestantes += 1;
				}
			}
		}
		return sujeirasRestantes;
	}

	public void setPorcentagemDeSujeira(double d) {
		totalSujeiras = (int) (((altura - 2) * (largura - 2) - getTotalDeObstaculos()) * d);
		for (int i = 0; i < totalSujeiras; i++) {
			int x = ((int) ((Math.random() * 10) % largura - 1) + 1);
			int y = ((int) ((Math.random() * 10) % altura - 1) + 1);
			while (ambiente[x][y].estado == EstadoDaSala.sujo
					|| ambiente[x][y].estado == EstadoDaSala.obstaculo) {
				x = ((int) ((Math.random() * 10) % largura - 1) + 1);
				y = ((int) ((Math.random() * 10) % altura - 1) + 1);
			}
			ambiente[x][y].estado = EstadoDaSala.sujo;
		}
	}

	private int getTotalDeObstaculos() {
		int totalDeObstaculos = 0;
		for (int i = 1; i < largura - 1; i++) {
			for (int j = 1; j < altura - 1; j++) {
				if (ambiente[i][j].estado == EstadoDaSala.obstaculo)
					totalDeObstaculos += 1;
			}
		}
		return totalDeObstaculos;
	}
}
