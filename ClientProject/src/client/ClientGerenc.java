package client;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import DataDealing.Data;
import View.SecundariView;
import tabelas.TestModel;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import registerview.*;
import java.awt.SystemColor;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClientGerenc extends JFrame {

	private JPanel contentPane;

	private String atend=null;
	private String client=null;
	public String getAtend() {
		return atend;
	}
	public void setAtend(String atend) {
		this.atend = atend;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
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
					ClientGerenc frame = new ClientGerenc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 */
	TestModel tablemodeltest=new TestModel();
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtCpf;
	private JTextField txtPath;
	private JTextField txtTelef;
	private JTextField txtCel;
	public ClientGerenc() throws IOException {
		setTitle("Gerenciamento de clientes");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ClientGerenc.class.getResource("/imgs/Logo.png")));
		ClentData cl1=new ClentData();
		Toolkit tk = Toolkit.getDefaultToolkit();
	    Dimension d = tk.getScreenSize();

	    
		this.setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 1467, 816);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JMenuBar menuBar = new JMenuBar();
		JMenu avac = new JMenu("Avançado");
		JMenu opts = new JMenu("Opções");
		JMenu mnNewMenu = new JMenu("Gerenciar");
		menuBar.add(mnNewMenu);
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Estoque");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(rootPane, "Primeiro volte a página primária");
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Voltar");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					SecundariView s1=new SecundariView();
					s1.setVisible(true);
					s1.setAtendente(atend);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				dispose();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		menuBar.add(avac);
		menuBar.add(opts);
		menuBar.setBounds(0, 0, 1918, 26);
		contentPane.add(menuBar);
		
		
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ClientRegister cl1=new ClientRegister();
				cl1.setVisible(true);
			}
		});
		btnNewButton.setBounds(682, 641, 111, 25);
		contentPane.add(btnNewButton);
		
		JPanel editpanel = new JPanel();
		editpanel.setBackground(SystemColor.activeCaptionBorder);
		editpanel.setForeground(SystemColor.desktop);
		editpanel.setBounds(325, 72, 818, 559);
		contentPane.add(editpanel);
		editpanel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Telefone:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(413, 264, 81, 29);
		editpanel.add(lblNewLabel_3);
		
		txtPath = new JTextField();
		txtPath.setBounds(136, 357, 96, 19);
		editpanel.add(txtPath);
		txtPath.setColumns(10);
		txtPath.setVisible(false);
		
		JLabel txtImg = new JLabel("");
		txtImg.setIcon(new ImageIcon(ClientGerenc.class.getResource("/imgs/17004.png")));
		txtImg.setBounds(67, 66, 235, 242);
		editpanel.add(txtImg);
		txtImg.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/17004.png")).getImage().getScaledInstance(225,225, Image.SCALE_SMOOTH)));
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(294, 39, 64, 29);
		editpanel.add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNome.setBounds(368, 39, 440, 29);
		editpanel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(378, 137, 64, 29);
		editpanel.add(lblNewLabel_1);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEmail.setBounds(452, 137, 356, 29);
		editpanel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CPF:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(413, 199, 64, 29);
		editpanel.add(lblNewLabel_2);
		
		txtCpf = new JTextField();
		txtCpf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCpf.setBounds(484, 199, 324, 29);
		editpanel.add(txtCpf);
		txtCpf.setColumns(10);
		
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
					txtImg.setIcon(new ImageIcon(img.getImage().getScaledInstance(txtImg.getWidth(), txtImg.getHeight(), Image.SCALE_SMOOTH)));
					txtPath.setText(filename);
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(136, 318, 99, 29);
		editpanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Salvar");
		
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(20, 478, 118, 29);
		editpanel.add(btnNewButton_2);
		
		txtTelef = new JTextField();
		txtTelef.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtTelef.setBounds(525, 264, 283, 29);
		editpanel.add(txtTelef);
		txtTelef.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Celular:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(438, 318, 69, 29);
		editpanel.add(lblNewLabel_4);
		
		txtCel = new JTextField();
		txtCel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCel.setBounds(525, 318, 283, 29);
		editpanel.add(txtCel);
		txtCel.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Buscar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					try {
						if(txtCpf.getText().isEmpty()) {
							JOptionPane.showMessageDialog(rootPane, "Digite um cpf");
						} else if(!cl1.checkcpf(txtCpf.getText())){
							JOptionPane.showMessageDialog(rootPane, "Cpf não encontrado!!");
						}
						else {
							String nome=cl1.dados(txtCpf.getText()).get(0);
							String email=cl1.dados(txtCpf.getText()).get(1);
							String cpf=cl1.dados(txtCpf.getText()).get(4);
							String celular=cl1.dados(txtCpf.getText()).get(3);
							String telefone=cl1.dados(txtCpf.getText()).get(2);
							txtNome.setText(nome);
							txtCpf.setText(cpf);
							txtTelef.setText(telefone);;
							txtCel.setText(celular);
							txtEmail.setText(email);
							txtImg.setIcon(cl1.cpfimg(txtCpf.getText()));
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_3.setBounds(677, 478, 118, 29);
		editpanel.add(btnNewButton_3);
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nome=txtNome.getText();
				String email=txtEmail.getText();
				String cpf=txtCpf.getText();
				String celular=txtCel.getText();
				String telefone=txtTelef.getText();
				try {
					cl1.edit(cpf, 1, nome);
					cl1.edit(cpf, 2, email);
					cl1.edit(cpf, 3, telefone);
					cl1.edit(cpf, 4, celular);
					cl1.edit(cpf, 5, cpf);
					JOptionPane.showMessageDialog(rootPane, "Dados foram alterados com sucesso!");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
	
	}
}
