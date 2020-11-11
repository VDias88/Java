package View;


import java.awt.EventQueue;
import registerview.*;
import DataDealing.*;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Choice;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
public class MainView extends JFrame {

	private JPanel contentPane;
	private JTextField txtLog;
	private JTextField txtF2;

	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainView frame = new MainView();
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
	public MainView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainView.class.getResource("/imgs/Logo.png")));
		setResizable(false);
		setTitle("MK-1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1094, 683);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(MainView.class.getResource("/imgs/17004.png")));
		lblImg.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/17004.png")).getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH)));
		lblImg.setBounds(424, 51, 209, 256);
		contentPane.add(lblImg);
		
		txtLog = new JTextField();
		txtLog.setText("Login");
		txtLog.setBounds(424, 320, 209, 28);
		contentPane.add(txtLog);
		txtLog.setColumns(10);
		
		Choice ch1 = new Choice();
		ch1.setBounds(424, 364, 209, 43);
		contentPane.add(ch1);
		
		JButton btnB2 = new JButton("Registrar");
		btnB2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Register r1=new Register();
				r1.setVisible(true);
			}
		});
		btnB2.setBounds(424, 519, 209, 43);
		contentPane.add(btnB2);
		
		txtF2 = new JPasswordField();
		txtF2.setText("Senha");
		txtF2.setBounds(424, 402, 209, 28);
		contentPane.add(txtF2);
		txtF2.setColumns(10);
		
		JButton btnB1 = new JButton("Log in");
		btnB1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String log=txtLog.getText();
				String senha=txtF2.getText();
				String perf=ch1.getSelectedItem();
				Data d1=new Data();
				
				try {
					d1.escrever("", "");
					if(!d1.ler(log)) {
						JOptionPane.showMessageDialog(rootPane, "Voce não esta registrado");
					}
					else if(d1.lerpass(log,senha)&&(d1.lerperf(log, perf))) {
						SecundariView s1=new SecundariView();
						s1.setAtendente(d1.logins(txtLog.getText()).get(0));
						s1.setImg(d1.logins(txtLog.getText()).get(2));
						//d1.cpfdata(d1.logins(txtLog.getText()).get(2)).get(1)
						s1.checkPerf(txtLog.getText());
						s1.setVisible(true);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(rootPane, "Dados incorretos");
					}
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				
				}
		});
		btnB1.setBounds(424, 451, 209, 43);
		contentPane.add(btnB1);
		ch1.add("Funcionário");
		ch1.add("Administrador");
		
	}
	
	
	
}
