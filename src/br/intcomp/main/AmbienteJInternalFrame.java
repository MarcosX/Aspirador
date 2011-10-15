package br.intcomp.main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class AmbienteJInternalFrame extends JFrame implements AmbienteWindow {

	protected int largura, altura;
	protected Image imgParede;
	protected Image imgPoeira;
	protected Image imgAspirador;
	protected Image imgChao;
	protected String[] linhasAmbiente;
	private String info;

	public AmbienteJInternalFrame(int largura, int altura) {
		super();
		this.largura = largura;
		this.altura = altura;

		imgParede = Toolkit.getDefaultToolkit().getImage("./rsc/parede.png");
		imgPoeira = Toolkit.getDefaultToolkit().getImage("./rsc/poeira.png");
		imgAspirador = Toolkit.getDefaultToolkit().getImage(
				"./rsc/aspirador.png");
		imgChao = Toolkit.getDefaultToolkit().getImage("./rsc/chao.jpg");

		setLayout(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize((largura + 2) * 50 + 5, (altura + 2) * 50 + 80);
		setVisible(true);
	}

	@Override
	public void desenharAmbiente(String dscAmbiente) {
		linhasAmbiente = dscAmbiente.split("\n");
		repaint();
	}

	public void paint(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		for (int i = 0; i < linhasAmbiente.length; i++) {
			char[] coluna = linhasAmbiente[i].toCharArray();
			for (int j = 0; j < coluna.length; j++) {
				switch (coluna[j]) {
				case '$':
					g2.drawImage(imgAspirador, i * 50, j * 50 + 75, this);
					break;
				case '-':
					g2.drawImage(imgChao, i * 50, j * 50 + 75, this);
					break;
				case 'X':
					g2.drawImage(imgPoeira, i * 50, j * 50 + 75, this);
					break;
				case '#':
					g2.drawImage(imgParede, i * 50, j * 50 + 75, this);
					break;
				default:
					break;
				}
			}
		}
		g2.clearRect(10, -10, 200, 50);
		g2.drawString(info, 10, 40);
		g2.finalize();
	}

	@Override
	public void mostrarInformações(String info) {
		this.info = info;
		repaint();
	}

	@Override
	public void mostrarRelatorioFinal(String relatorio) {
		JOptionPane.showMessageDialog(null, relatorio, "Resultado: ",
				JOptionPane.INFORMATION_MESSAGE, null);
		System.exit(0);
	}

}
