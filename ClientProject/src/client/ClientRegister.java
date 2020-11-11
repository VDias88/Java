package client;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import DataDealing.Data;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.Toolkit;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class ClientRegister extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtEmail;
	private JTextField txtTel;
	private JTextField txtCel;

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
					ClientRegister frame = new ClientRegister();
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
	Cliente c1=new Cliente();
	ClentData cd1=new ClentData();
	Data data1=new Data();
	private JTextField textField;
	public ClientRegister() {
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(ClientRegister.class.getResource("/imgs/Logo.png")));
		setResizable(false);
		setTitle("Cadastro de cliente");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 934, 596);
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setVisible(false);
		textField.setBounds(681, 367, 96, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Celular");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(12, 301, 61, 32);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_3 = new JLabel("Telefone");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(12, 248, 70, 32);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(12, 188, 50, 32);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_1 = new JLabel("CPF");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(12, 136, 50, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(12, 71, 50, 32);
		contentPane.add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNome.setBounds(70, 71, 403, 32);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCpf.setBounds(72, 136, 341, 32);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmail.setBounds(72, 188, 355, 32);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtTel = new JTextField();
		txtTel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTel.setBounds(80, 248, 302, 32);
		contentPane.add(txtTel);
		txtTel.setColumns(10);
		
		txtCel = new JTextField();
		txtCel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCel.setBounds(83, 301, 341, 32);
		contentPane.add(txtCel);
		txtCel.setColumns(10);
		
		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					
					c1.setNome(txtNome.getText());
					c1.setEmail(txtEmail.getText());
					c1.setTelefone(txtTel.getText());
					c1.setCelular(txtCel.getText());
					c1.setCpf(txtCpf.getText());
					
					try {
						cd1.start();
						if(!cd1.checkcpf(txtCpf.getText())) {
							cd1.write(c1);
							String file=textField.getText();
							if(file.isBlank()) {
								cd1.starimgs();
								data1.cpyimg("client-management.png");
								cd1.saveimg(System.getProperty("user.dir")+"\\"+"databank"+"\\"+"client-management.png",txtCpf.getText());
								JOptionPane.showMessageDialog(rootPane, "Cliente registrado sem foto!!");
							}else {
								cd1.saveimg(file, txtCpf.getText());
								JOptionPane.showMessageDialog(rootPane, "Cliente registrado!!");
							}
							
						}
						else {
							JOptionPane.showMessageDialog(rootPane, "CPF já registrado!!");
						}
					} catch (HeadlessException | IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(428, 506, 97, 25);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Escolher");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		btnNewButton_1.setBounds(681, 312, 97, 32);
		contentPane.add(btnNewButton_1);
		
		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(ClientRegister.class.getResource("/imgs/client-management.png")));
		lblImg.setBounds(609, 71, 228, 212);
		contentPane.add(lblImg);
		lblImg.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/client-management.png")).getImage().getScaledInstance(250,250, Image.SCALE_SMOOTH)));
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
		JLabel lblNewLabel_5 = new JLabel("Foto");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(719, 38, 70, 25);
		contentPane.add(lblNewLabel_5);
	}
}
