package Visão;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logic.StalkerBot;

import javax.swing.JTextPane;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class JStopTheCount extends JFrame {
	public boolean renderizado = false;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JStopTheCount frame = new JStopTheCount();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JStopTheCount() {
		
		setTitle("Stop The Count");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 323, 172);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextPane txtpnABuscaEst = new JTextPane();
		txtpnABuscaEst.setText("A busca est\u00E1 em andamento e sera exibida\r\nna tela anterior quando for concluida.\r\nCaso queira parar a busca, aperte no bot\u00E3o abaixo.");
		txtpnABuscaEst.setBounds(10, 0, 297, 74);
		contentPane.add(txtpnABuscaEst);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setIndeterminate(false);
		progressBar.setValue(0);
		progressBar.setMinimum(0);
		progressBar.setBounds(85, 118, 146, 14);
		contentPane.add(progressBar);
		
		JButton btnNewButton = new JButton("Stop");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StalkerBot.stopTheCount = true;
				progressBar.setValue(0);
				progressBar.setIndeterminate(false);
			}
		});
		btnNewButton.setBounds(114, 84, 89, 23);
		contentPane.add(btnNewButton);
		
		renderizado = true;
	}

}
