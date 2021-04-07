package trabalho.um;


import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import java.awt.Color;

public class Tela {

	private JFrame frmCalculadoraDeNotao;
	private JTextField tfExpressao;
	private JRadioButton rdbPilhaLista;
	private JRadioButton rdbPilhaVetor;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela window = new Tela();
					window.frmCalculadoraDeNotao.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Tela() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculadoraDeNotao = new JFrame();
		frmCalculadoraDeNotao.setTitle("Calculadora de nota\u00E7\u00E3o p\u00F3s-fixa");
		frmCalculadoraDeNotao.getContentPane().setBackground(Color.WHITE);
		frmCalculadoraDeNotao.setBackground(Color.WHITE);
		frmCalculadoraDeNotao.setBounds(100, 100, 450, 244);
		frmCalculadoraDeNotao.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculadoraDeNotao.getContentPane().setLayout(null);
		
		tfExpressao = new JTextField();
		tfExpressao.setBackground(new Color(245, 245, 245));
		tfExpressao.setBounds(10, 33, 414, 38);
		frmCalculadoraDeNotao.getContentPane().add(tfExpressao);
		tfExpressao.setColumns(10);
		
		JLabel lbExpressao = new JLabel("Express\u00E3o:");
		lbExpressao.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbExpressao.setBounds(10, 11, 95, 17);
		frmCalculadoraDeNotao.getContentPane().add(lbExpressao);
		
		JButton btnNewButton = new JButton("Calcular");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(rdbPilhaLista.isSelected() && rdbPilhaVetor.isSelected()) {
					JOptionPane.showMessageDialog(frmCalculadoraDeNotao, "Selecione apenas um tipo de lista");
				} else {
					Calculadora calculadora = new Calculadora();
					calculadora.setTipoLista(rdbPilhaLista.isSelected());
					
					try {
						double resultado = calculadora.calcular(tfExpressao.getText());
						textArea.setText(String.valueOf(resultado));
						
					} catch (Exception e) {
						JOptionPane.showMessageDialog(frmCalculadoraDeNotao, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
					}
				}
				
			}
		});
		btnNewButton.setBounds(10, 100, 95, 26);
		frmCalculadoraDeNotao.getContentPane().add(btnNewButton);
		
		rdbPilhaLista = new JRadioButton("Utilizar pilha de lista");
		rdbPilhaLista.setSelected(true);
		rdbPilhaLista.setBackground(new Color(255, 255, 255));
		rdbPilhaLista.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbPilhaLista.setBounds(111, 100, 139, 23);
		frmCalculadoraDeNotao.getContentPane().add(rdbPilhaLista);
		
		rdbPilhaVetor = new JRadioButton("Utilizar pilha de vetor");
		rdbPilhaVetor.setBackground(new Color(255, 255, 255));
		rdbPilhaVetor.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbPilhaVetor.setBounds(253, 100, 151, 23);
		frmCalculadoraDeNotao.getContentPane().add(rdbPilhaVetor);
		
		rdbPilhaLista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbPilhaLista.isSelected()) {
					rdbPilhaVetor.setSelected(false);
				} else if (!rdbPilhaVetor.isSelected()) {
					rdbPilhaLista.setSelected(true);
				}
			}
		});
		
		rdbPilhaVetor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbPilhaVetor.isSelected()) {
					rdbPilhaLista.setSelected(false);
				} else if (!rdbPilhaLista.isSelected()) {
					rdbPilhaVetor.setSelected(true);
				}
			}
		});
		
		textArea = new JTextArea();
		textArea.setBackground(new Color(211, 211, 211));
		textArea.setForeground(Color.BLACK);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 18));
		textArea.setEditable(false);
		textArea.setBounds(103, 153, 321, 38);
		frmCalculadoraDeNotao.getContentPane().add(textArea);
		
		JLabel lbResultado = new JLabel("Resultado:");
		lbResultado.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lbResultado.setBounds(10, 166, 95, 14);
		frmCalculadoraDeNotao.getContentPane().add(lbResultado);
	}
}
