package br.intcomp.main;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class AmbienteJInternalFrame extends JFrame implements AmbienteWindow {

	protected int largura, altura;
	protected Container container;
	protected JLabel[] labelAmbiente;

	public AmbienteJInternalFrame(int largura, int altura) {
		super();
		this.largura = largura;
		this.altura = altura;
		labelAmbiente = new JLabel[largura + 2];

		setLocationRelativeTo(null);
		setLayout(null);
		container = getContentPane();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(200 + (altura + 2) * 10, 100 + (largura + 2) * 10);
		setVisible(true);
	}

	@Override
	public void desenharAmbiente(String dscAmbiente) {
		String[] linhasAmbiente = dscAmbiente.split("\n");

		container.removeAll();
		for (int i = 0; i < linhasAmbiente.length; i++) {
			labelAmbiente[i] = new JLabel(linhasAmbiente[i]);
			labelAmbiente[i].setBounds(30, -170 + i * 10, 400, 400);
			container.add(labelAmbiente[i]);
		}
		container.repaint();
	}

	@Override
	public void mostrarInformações(String info) {
		JLabel informacoes = new JLabel(info);
		informacoes.setBounds(5, -190, 300, 400);
		container.add(informacoes);
		container.repaint();
	}

	@Override
	public void mostrarRelatorioFinal(String relatorio) {
		JOptionPane.showMessageDialog(null, relatorio, "Resultado: ",
				JOptionPane.INFORMATION_MESSAGE, null);
		System.exit(0);
	}

}
