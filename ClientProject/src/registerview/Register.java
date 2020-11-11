package registerview;


import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import DataDealing.Data;
import DataDealing.FuncImgs;
import DataDealing.FuncionariesData;

import java.io.File;
import java.io.IOException;


import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.Choice;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class Register extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNome;
	private JLabel lblNewLabel_1;
	private JTextField txtCPF;
	private JLabel lblNewLabel_2;
	private JTextField txtLogin;
	private JLabel lblNewLabel_3;
	private JTextField txtPass1;
	private JTextField textField;

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
					Register frame = new Register();
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
	public Register() {
		FuncImgs cd1=new FuncImgs();
		Data d1=new Data();
		FuncionariesData f1=new FuncionariesData();
		setIconImage(Toolkit.getDefaultToolkit().getImage(Register.class.getResource("/imgs/Logo.png")));
		setResizable(false);
		setTitle("Registro de funcionarios");
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 780, 669);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(573, 463, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setVisible(false);
		lblNewLabel_3 = new JLabel("Senha:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(12, 303, 49, 25);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_2 = new JLabel("Login:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(12, 227, 59, 25);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel("CPF:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(12, 152, 56, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(12, 73, 59, 25);
		contentPane.add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNome.setBounds(12, 106, 466, 33);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCPF = new JTextField();
		txtCPF.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCPF.setBounds(12, 181, 320, 33);
		contentPane.add(txtCPF);
		txtCPF.setColumns(10);
		
		txtLogin = new JTextField();
		txtLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtLogin.setBounds(12, 257, 320, 33);
		contentPane.add(txtLogin);
		txtLogin.setColumns(10);
		
		txtPass1 = new JPasswordField();
		txtPass1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPass1.setBounds(12, 329, 320, 33);
		contentPane.add(txtPass1);
		txtPass1.setColumns(10);
		
		Choice ch2 = new Choice();
		ch2.setFont(new Font("Dialog", Font.PLAIN, 16));
		ch2.setBounds(12, 405, 196, 73);
		contentPane.add(ch2);
		ch2.add("Administrador");
		ch2.add("Funcionário");
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String login=txtLogin.getText();
				String pass=txtPass1.getText();
				
				try {
					d1.criardata();
					d1.criarlogs();
					if(d1.ler(txtLogin.getText())) {
						JOptionPane.showMessageDialog(rootPane, "Alguns dados já existem!!");
						
					}else {
						if(textField.getText().isEmpty()) {
							JOptionPane.showMessageDialog(rootPane, "Funcionários devem ter foto!!");
						}else {
							f1.setLogin(txtLogin.getText());
							f1.setSenha(txtPass1.getText());
							f1.setNome(txtNome.getText());
							f1.setCpf(txtCPF.getText());
							f1.setPerfil(ch2.getSelectedItem());
							d1.escrever(login,pass);
							d1.escreverlog(f1);
							cd1.starimgs();
							cd1.saveimg(textField.getText(), txtCPF.getText());
							JOptionPane.showMessageDialog(rootPane, "Você foi registrado com êxito!!");
						}
						
						
						
					}
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				} 
				
			
			}
		});
		contentPane.add(btnNewButton);
		btnNewButton.setBounds(111,530, 97, 25);
		
		JLabel lblNewLabel_4 = new JLabel("Perfil:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(12, 375, 49, 25);
		contentPane.add(lblNewLabel_4);
		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(Register.class.getResource("/imgs/client-management.png")));
		lblImg.setBounds(502, 181, 214, 219);
		contentPane.add(lblImg);
		lblImg.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/client-management.png")).getImage().getScaledInstance(225,225, Image.SCALE_SMOOTH)));
		JButton btnNewButton_1 = new JButton("Escolher");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser a=new JFileChooser();
				a.setDialogTitle("Selecione uma foto");
				
				int opc=a.showOpenDialog(null);
				if(opc==JFileChooser.APPROVE_OPTION) {
					File file =new File("Caminho");
					file=a.getSelectedFile();
					String filename=file.getAbsolutePath();
					ImageIcon img=new ImageIcon(a.getSelectedFile().getPath());
					lblImg.setIcon(new ImageIcon(img.getImage().getScaledInstance(lblImg.getWidth(), lblImg.getHeight(), Image.SCALE_SMOOTH)));
					cd1.starimgs();
					textField.setText(filename);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(572, 428, 97, 25);
		contentPane.add(btnNewButton_1);
		
		
		
		
		
	}
}
