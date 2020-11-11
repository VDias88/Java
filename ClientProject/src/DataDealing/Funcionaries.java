package DataDealing;

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

public class Funcionaries extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTable table_1;
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
					Funcionaries frame = new Funcionaries();
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
	private JTextField txtPerfil;
	private JTextField txtCpf;
	private JTextField txtLog;
	private JTextField txtSenha;
	private JTextField txtPath;
	public Funcionaries() throws IOException {
		FuncImgs imgs1=new FuncImgs();
		setTitle("Gerenciamento de funcionarios");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Funcionaries.class.getResource("/imgs/Logo.png")));
		Register r1=new Register();
		Toolkit tk = Toolkit.getDefaultToolkit();
	    Dimension d = tk.getScreenSize();
	    Data a1=new Data();
	    
		this.setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, d.width, d.height);
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
		menuBar.add(avac);
		JMenuItem mntmNewMenuItem = new JMenuItem("Voltar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					SecundariView s1=new SecundariView();
					s1.setVisible(true);
					//s1.setImg(a1.logins(txtLog.getText()).get(2));
					s1.setAtendente(atend);
					dispose();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		avac.add(mntmNewMenuItem);
		menuBar.add(opts);
		menuBar.setBounds(0, 0, 1918, 26);
		contentPane.add(menuBar);
		JTable table_1=new JTable();
		contentPane.add(table_1);
		table_1.setBounds(78, 90, 614, 498);
		
		table_1.setModel(tablemodeltest);
		table_1.getTableHeader().setReorderingAllowed (false);
		table_1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		a1.lerregist();
		
			//colocar coisas na tabela
			 a1.start();
			for(int i=0;i<=a1.linhas-1;i++) {
				tablemodeltest.addRow(a1.nomes().get(i), a1.perfils().get(i), a1.cpf().get(i));
			}
		
		//scrool pane
		JScrollPane scrollPane = new JScrollPane(table_1);
		
		//scrollPane.setViewportView(table_1);
		scrollPane.setBounds(78, 90, 614, 498);
		scrollPane.setViewportView(table_1);
		contentPane.add(scrollPane);
		
		JButton btnRemove = new JButton("Excluir");
		btnRemove.setBounds(78, 601, 97, 25);
		contentPane.add(btnRemove);
		
		
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				r1.setVisible(true);
			}
		});
		btnNewButton.setBounds(595, 601, 97, 25);
		contentPane.add(btnNewButton);
		
		JPanel editpanel = new JPanel();
		editpanel.setBackground(SystemColor.activeCaptionBorder);
		editpanel.setForeground(SystemColor.desktop);
		editpanel.setBounds(764, 90, 689, 498);
		contentPane.add(editpanel);
		editpanel.setLayout(null);
		
		txtPath = new JTextField();
		txtPath.setBounds(109, 357, 96, 19);
		editpanel.add(txtPath);
		txtPath.setColumns(10);
		txtPath.setVisible(false);
		
		JLabel txtImg = new JLabel("");
		txtImg.setIcon(new ImageIcon(Funcionaries.class.getResource("/imgs/17004.png")));
		txtImg.setBounds(42, 60, 235, 242);
		editpanel.add(txtImg);
		txtImg.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/17004.png")).getImage().getScaledInstance(225,225, Image.SCALE_SMOOTH)));
		
		JLabel lblNewLabel = new JLabel("Nome:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(165, 21, 64, 29);
		editpanel.add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNome.setBounds(239, 21, 440, 29);
		editpanel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Perfil:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(365, 60, 64, 29);
		editpanel.add(lblNewLabel_1);
		
		txtPerfil = new JTextField();
		txtPerfil.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPerfil.setBounds(459, 60, 220, 29);
		editpanel.add(txtPerfil);
		txtPerfil.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CPF:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(365, 99, 64, 29);
		editpanel.add(lblNewLabel_2);
		
		txtCpf = new JTextField();
		txtCpf.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtCpf.setBounds(439, 99, 240, 29);
		editpanel.add(txtCpf);
		txtCpf.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Login:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(365, 138, 64, 29);
		editpanel.add(lblNewLabel_3);
		
		txtLog = new JTextField();
		txtLog.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtLog.setBounds(459, 138, 220, 29);
		editpanel.add(txtLog);
		txtLog.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Senha:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(365, 177, 64, 29);
		editpanel.add(lblNewLabel_4);
		
		txtSenha = new JTextField();
		txtSenha.setEditable(false);
		txtSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSenha.setBounds(439, 177, 240, 29);
		editpanel.add(txtSenha);
		txtSenha.setColumns(10);
		
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
		btnNewButton_1.setBounds(109, 318, 99, 29);
		editpanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Salvar");
		
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNewButton_2.setBounds(281, 437, 118, 29);
		editpanel.add(btnNewButton_2);
		table_1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				try {
					String cpf=(String) table_1.getValueAt(table_1.getSelectedRow(), 2);
					txtCpf.setText(cpf);
					String nome=a1.cpfdata(cpf).get(0);
					String perfil=a1.cpfdata(cpf).get(1);
					String senha=a1.cpfdata(cpf).get(3);
					String login=a1.cpfdata(cpf).get(4);
					txtNome.setText(nome);
					txtLog.setText(login);
					txtPerfil.setText(perfil);
					txtSenha.setText(senha);
					txtImg.setIcon(a1.cpfimg(txtCpf.getText()));
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					a1.edit(txtCpf.getText(), 1, txtNome.getText());
					a1.edit(txtCpf.getText(), 2, txtPerfil.getText());
					a1.edit(txtCpf.getText(), 3, txtCpf.getText());
					a1.edit(txtCpf.getText(), 4, txtSenha.getText());
					a1.edit(txtCpf.getText(), 5, txtLog.getText());
					imgs1.saveimg(txtPath.getText(), txtCpf.getText());
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		});
		btnRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String linhadelet=tablemodeltest.getvalues(table_1.getSelectedRow());
				
				try {
					a1.remove(2,a1.logins().get(table_1.getSelectedRow())+"-"+a1.senha().get(table_1.getSelectedRow()));
					a1.remove(1, linhadelet+"-"+a1.senha().get(table_1.getSelectedRow())+"-"+a1.logins().get(table_1.getSelectedRow()));
					a1.deletImg(txtCpf.getText());
					JOptionPane.showMessageDialog(rootPane, "Funcionario excluido");
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				tablemodeltest.removeRow(table_1.getSelectedRow());
				
			}
		});
	
	}
}
