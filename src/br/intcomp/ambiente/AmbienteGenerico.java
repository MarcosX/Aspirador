package br.intcomp.ambiente;

import br.intcomp.enums.EstadoDaSala;

/**
 * Define um ambiente genérico, apenas constrói o ambiente, dado as dimensões de
 * altura e largura e distribui a sujeira, dado uma porcentagem.
 */

public abstract class AmbienteGenerico {
	protected int altura, largura;
	protected Sala[][] ambiente;
	protected int totalSujeiras;

	public AmbienteGenerico(int largura, int altura) {
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
	}

	private boolean isParede(int largura, int altura, int i, int j) {
		return i == 0 || j == 0 || i == largura - 1 || j == altura - 1;
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

	protected int getSujeirasRestantes() {
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
			int x = ((int) ((Math.random() * 100) % largura));
			int y = ((int) ((Math.random() * 100) % altura));
			while (ambiente[x][y].estado == EstadoDaSala.sujo
					|| ambiente[x][y].estado == EstadoDaSala.obstaculo) {
				x = ((int) ((Math.random() * 100) % largura));
				y = ((int) ((Math.random() * 100) % altura));
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

	public abstract String getDscAmbiente();

	public abstract String mostrarInformacoes();

	public abstract String mostrarRelatorioFinal();

	public abstract void executarAgente();
}