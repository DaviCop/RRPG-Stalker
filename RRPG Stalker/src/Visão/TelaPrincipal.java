package Visão;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextPane;

import Logic.Stalkerbot2;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;

public class TelaPrincipal {

	private JFrame frmProgramaAltamenteTecnologico;
	private JTextField txtNick;
	public static String logsDeTeste;
	public boolean rodandoBusca = false;
	public Stalkerbot2[] botBusca = new Stalkerbot2[500];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frmProgramaAltamenteTecnologico.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		
		JButton btnResultado = new JButton("Iniciar Busca");
		
		/*JStopTheCount stopSc = new JStopTheCount();
		stopSc.setVisible(true);*/
		frmProgramaAltamenteTecnologico = new JFrame();
		frmProgramaAltamenteTecnologico.setTitle("RRPG Stalker 2020.0.0.3");
		frmProgramaAltamenteTecnologico.setResizable(false);
		frmProgramaAltamenteTecnologico.setBounds(100, 100, 557, 301);
		frmProgramaAltamenteTecnologico.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmProgramaAltamenteTecnologico.getContentPane().setLayout(null);
		
		JTextPane txtpnLogField = new JTextPane();
		txtpnLogField.setText("Programa criado com o intuito de encontrar o Yipeekiyaay nas mesas de hentai e zoar ele. Use com sabedoria.");
		txtpnLogField.setEditable(false);
		txtpnLogField.setBounds(240, 11, 282, 86);
		frmProgramaAltamenteTecnologico.getContentPane().add(txtpnLogField);
		
		JLabel lblNewLabel = new JLabel("Nick do Player:");
		lblNewLabel.setBounds(10, 34, 101, 25);
		frmProgramaAltamenteTecnologico.getContentPane().add(lblNewLabel);
		
		txtNick = new JTextField();
		txtNick.setBounds(121, 35, 109, 24);
		frmProgramaAltamenteTecnologico.getContentPane().add(txtNick);
		txtNick.setColumns(10);
		
		JTextPane textResult = new JTextPane();
		textResult.setEditable(false);
		textResult.setText("O Resultado da busca ira aparecer aqui, ela pode demorar algum tempo dependendo do seu computador e da velocidade da sua internet.\r\n\r\nO codigo fonte desse programa est\u00E1 disponivel no GitHub.\r\nLink: https://github.com/DaviCop/RRPG-Stalker/");
		textResult.setBounds(60, 148, 462, 98);
		frmProgramaAltamenteTecnologico.getContentPane().add(textResult);
		
		JButton btnPararBusca = new JButton("Parar a Busca");
		btnPararBusca.setEnabled(false);
		btnPararBusca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnResultado.setEnabled(true);
				btnPararBusca.setEnabled(false);
				for (int i = 0 ; i<=499 ; i++) {
					botBusca[i].setEmExecução(false);
					
				}
				rodandoBusca = false;
			}
		});
		btnPararBusca.setBounds(404, 114, 118, 23);
		frmProgramaAltamenteTecnologico.getContentPane().add(btnPararBusca);
		
		
		btnResultado.setEnabled(true);
		btnResultado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nickkk = txtNick.getText();
				btnResultado.setEnabled(false);
				btnPararBusca.setEnabled(true);
				
				if(nickkk.equals("") == true) {
					txtpnLogField.setText("Insira um Nick Valido!");
					btnResultado.setEnabled(true);
					btnPararBusca.setEnabled(false);
				}else {
				
					int myI = 0;
					for (int i = 0 ; i<=499 ; i++) {
						botBusca[i] = new Stalkerbot2(nickkk, myI, myI+500, i);
						myI += 500;
						
					}
					
					rodandoBusca = true;
					
					
					
					
				
				
				
			}}
		});
		
		
		
		btnResultado.setBounds(259, 114, 109, 23);
		frmProgramaAltamenteTecnologico.getContentPane().add(btnResultado);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setMaximum(250000);
		progressBar.setBounds(24, 113, 225, 24);
		frmProgramaAltamenteTecnologico.getContentPane().add(progressBar);
		
		JLabel lblNewLabel_1 = new JLabel("Resultado");
		lblNewLabel_1.setBounds(240, 247, 68, 14);
		frmProgramaAltamenteTecnologico.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Feito por algum Davi ai - 2020.0.0.3");
		lblNewLabel_2.setBounds(336, 247, 205, 14);
		frmProgramaAltamenteTecnologico.getContentPane().add(lblNewLabel_2);
		
		
		
		
		new Thread() {

		    
		    public void run() {
		      while(true) {
		    	  System.out.checkError();//essa linha é crucial para o funcionamento do codigo, por motivos que eu desconheço.
		    	  if(rodandoBusca==true) {
		    		 
		    		  int progressBarValue = 0;
		    		  String currentFindLocals = "";
		    		  for (int i = 0 ; i<=499 ; i++) {
							progressBarValue += botBusca[i].getPorcentagemDaBusca();
							progressBar.setValue(progressBarValue);
							if(botBusca[i].getResult().equals("") == false) {
								currentFindLocals += botBusca[i].getResult();
							}
							
						}
		    		  textResult.setText(currentFindLocals);
		    		  txtpnLogField.setText("Busca em Andamento \n Total de mesas visitadas: "+progressBarValue+ " De um total de: 250000 IDs.");
		    		  if(progressBarValue >= 250000) {
		    			  
		    			  for (int i = 0 ; i<=499 ; i++) {
								botBusca[i].setEmExecução(false);
								
								}
		    			  btnResultado.setEnabled(true);
						  btnPararBusca.setEnabled(false);
						  rodandoBusca = false;
		    		  }
		    		  try {
						TimeUnit.SECONDS.sleep(1);
					} catch (InterruptedException e) {
						
						e.printStackTrace();
					}
		    	  }
		      }

		    }
		  }.start();
		
	}
}
