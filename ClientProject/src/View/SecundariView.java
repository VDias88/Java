package View;


import java.awt.EventQueue;
import DataDealing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import tabelas.*;
import estoque.EstoqueData;
import estoque.EstoqueView;
import client.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.ScrollPane;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Choice;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;

public class SecundariView extends JFrame {

	/**
	 * 
	 */
	
	private JPanel contentPane;
	private JTable produtos;
	public String atend=null;
	public String client=null;
	public String perfil;

	

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
					SecundariView frame = new SecundariView();
					
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
	ProductsTable testproducts=new ProductsTable();
	SecundariTable secprod=new SecundariTable();
	JFormattedTextField fmrcliente = new JFormattedTextField();
	JFormattedTextField frmtextCli = new JFormattedTextField();
	EstoqueData data=new EstoqueData();
	private JMenuItem mntmNewMenuItem_3 = new JMenuItem("Estoque");
	private JMenuItem mntmNewMenuItem = new JMenuItem("F\u00FAncionarios");
	ClentData clr2=new ClentData();
	Data dat=new Data();
	private JTextField txtProduct;
	private JTextField txtPreco;
	private JTextField txtSector;
	private JTextField txtEstoq;
	private JTextField txtId;
	private JTextField txtQnt;
	private JTextField txtTotal;
	private JTextField txtMone;
	private JTextField txtTroco;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblImg = new JLabel();
	private String atendcpf;
	public SecundariView() throws IOException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SecundariView.class.getResource("/imgs/Logo.png")));
		setTitle("Atendimento ao cliente");
		Toolkit tk = Toolkit.getDefaultToolkit();
	    Dimension d = tk.getScreenSize();
	    ClientCpf clr1=new ClientCpf();
	   
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setBounds(100, 100, 1596, 838);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1918, 26);
		JMenu opts = new JMenu("Opções");
		contentPane.setLayout(null);
		
		JMenu mnNewMenu_1 = new JMenu("Gerenciar");
		menuBar.add(mnNewMenu_1);
		
		mntmNewMenuItem_3.setVisible(true);
		
		System.out.println(this.getAtendente());
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					data.criar();
					EstoqueView estoqueview = new EstoqueView();
					estoqueview.setVisible(true);
					
					atend=getAtendente();
					estoqueview.setAtend(atend);
					dispose();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Clientes");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					ClientGerenc clt2=new ClientGerenc();
					atend=getAtendente();
					clt2.setAtend(atend);
					clt2.setVisible(true);
					dispose();
				} catch (IOException e) {
					
					e.printStackTrace();
				}
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		JMenu avac = new JMenu("Avançado");
		
		menuBar.add(avac);
		
		
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					Funcionaries f1=new Funcionaries();
					f1.setVisible(true);
					atend=getAtendente();
					f1.setAtend(atend);
					dispose();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		avac.add(mntmNewMenuItem);
		menuBar.add(opts);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Sair");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MainView mainview=new MainView();
				mainview.setVisible(true);
				dispose();
			}
		});
		opts.add(mntmNewMenuItem_2);
		contentPane.add(menuBar);
		
		JPanel panel = new JPanel();
		panel.setBounds(973, 36, 557, 497);
		panel.setBackground(SystemColor.activeCaption);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setClient("");
				clr1.setTxtCpf("");
			}
		});
		btnNewButton.setIcon(new ImageIcon(SecundariView.class.getResource("/imgs/logout10-512.png")));
		btnNewButton.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/logout10-512.png")).getImage().getScaledInstance(20,20, Image.SCALE_SMOOTH)));
		
				btnNewButton.setBounds(497, 58, 46, 30);
				panel.add(btnNewButton);
		
		JButton btnCliLog = new JButton("");
		btnCliLog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clr1.setVisible(true);
				
			}
		});
		btnCliLog.setIcon(new ImageIcon(SecundariView.class.getResource("/imgs/16036.png")));
		btnCliLog.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/16036.png")).getImage().getScaledInstance(22,22, Image.SCALE_SMOOTH)));
		btnCliLog.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCliLog.setBounds(441, 58, 46, 30);
		panel.add(btnCliLog);
		
		JLabel lblNewLabel = new JLabel("Cliente");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(12, 58, 58, 30);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Atendente");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(12, 13, 90, 30);
		panel.add(lblNewLabel_1);
		
		
		fmrcliente.setEditable(false);
		fmrcliente.setFont(new Font("Tahoma", Font.PLAIN, 17));
		fmrcliente.setBounds(93, 17, 345, 30);
		panel.add(fmrcliente);
		frmtextCli.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				try {
					clr2.start();
					if(frmtextCli.getText().isEmpty()) {
						frmtextCli.setText("Nenhum cliente encontrado!!");
					}
					else {
						setClient(clr2.dados(clr1.getTxtCpf()).get(0));
					}
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		frmtextCli.setBounds(93, 59, 345, 30);
		panel.add(frmtextCli);
		frmtextCli.setEditable(false);
		frmtextCli.setFont(new Font("Tahoma", Font.PLAIN, 17));
		
		JPanel panproduct = new JPanel();
		panproduct.setBackground(SystemColor.activeCaptionBorder);
		panproduct.setBounds(12, 110, 531, 377);
		panel.add(panproduct);
		panproduct.setLayout(null);
		
		txtProduct = new JTextField();
		txtProduct.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtProduct.setEditable(false);
		txtProduct.setBounds(100, 22, 421, 30);
		panproduct.add(txtProduct);
		txtProduct.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Produto:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(20, 19, 70, 30);
		panproduct.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Pre\u00E7o:");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(20, 78, 55, 30);
		panproduct.add(lblNewLabel_3);
		
		txtPreco = new JTextField();
		txtPreco.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtPreco.setEditable(false);
		txtPreco.setBounds(100, 78, 142, 30);
		panproduct.add(txtPreco);
		txtPreco.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Setor:");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_4.setBounds(252, 78, 43, 30);
		panproduct.add(lblNewLabel_4);
		
		txtSector = new JTextField();
		txtSector.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtSector.setEditable(false);
		txtSector.setBounds(305, 78, 216, 30);
		panproduct.add(txtSector);
		txtSector.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Estoque: ");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_5.setBounds(20, 133, 70, 30);
		panproduct.add(lblNewLabel_5);
		
		txtEstoq = new JTextField();
		txtEstoq.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtEstoq.setEditable(false);
		txtEstoq.setBounds(100, 133, 142, 30);
		panproduct.add(txtEstoq);
		txtEstoq.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("ID:");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_6.setBounds(252, 133, 28, 30);
		panproduct.add(lblNewLabel_6);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtId.setBounds(305, 133, 216, 30);
		panproduct.add(txtId);
		txtId.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Pesquisar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id=Integer.parseInt(txtId.getText());
				try {
					if(data.exists(id)) {
						txtProduct.setText(data.produtos(id).get(0));
						txtPreco.setText(data.produtos(id).get(1));
						txtSector.setText(data.produtos(id).get(3));
						txtEstoq.setText(data.produtos(id).get(4));	
					}
					else {
						JOptionPane.showMessageDialog(rootPane, "Produto não encontrado");
					}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(20, 322, 105, 30);
		panproduct.add(btnNewButton_1);
		
		JButton btnAdd = new JButton("Adicionar");
		
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdd.setBounds(219, 322, 95, 30);
		panproduct.add(btnAdd);
		
		JButton btnNewButton_3 = new JButton("Excluir");
		
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.setBounds(396, 322, 105, 30);
		panproduct.add(btnNewButton_3);
		
		JLabel lblNewLabel_7 = new JLabel("Quantidade:");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_7.setBounds(20, 190, 88, 30);
		panproduct.add(lblNewLabel_7);
		
		txtQnt = new JTextField();
		txtQnt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtQnt.setBounds(118, 190, 183, 30);
		panproduct.add(txtQnt);
		txtQnt.setColumns(10);
		//tabela produtos
		produtos = new JTable();
		produtos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		produtos.setBounds(478, 70, 961, 463);
		contentPane.add(produtos);
		produtos.setModel(secprod);
		produtos.getTableHeader().setReorderingAllowed (false);
		//scrolls
		JScrollPane scrollPane = new JScrollPane(produtos);
		scrollPane.setBounds(10, 36, 953, 497);
		scrollPane.setViewportView(produtos);
		contentPane.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(489, 534, 474, 257);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Total: ");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(10, 138, 78, 45);
		panel_1.add(lblNewLabel_8);
		
		txtTotal = new JTextField();
		txtTotal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTotal.setEditable(false);
		txtTotal.setBounds(80, 138, 164, 45);
		panel_1.add(txtTotal);
		txtTotal.setColumns(10);
		
		JLabel lblNewLabel_9 = new JLabel("Forma de pagamento:");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(10, 10, 218, 35);
		panel_1.add(lblNewLabel_9);
		
		Choice choice = new Choice();
		
		choice.setFont(new Font("Dialog", Font.PLAIN, 20));
		choice.setBounds(234, 10, 196, 35);
		choice.add("Dinheiro");
		choice.add("Cartão");
		panel_1.add(choice);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 534, 490, 257);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		lblImg.setText("");
		lblImg.setBounds(0, 0, 244, 247);
		panel_2.add(lblImg);
		if(this.fmrcliente.getText().isEmpty()) {

			lblImg.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/17004.png")).getImage().getScaledInstance(225,225, Image.SCALE_SMOOTH)));
		}else {
			
			lblImg.setIcon(dat.cpfimg(this.atendcpf));
		}
		
		JPanel pane_none = new JPanel();
		pane_none.setBackground(Color.LIGHT_GRAY);
		pane_none.setForeground(SystemColor.inactiveCaptionBorder);
		pane_none.setBounds(953, 534, 577, 257);
		contentPane.add(pane_none);
		pane_none.setLayout(null);
		
		JPanel pane_money = new JPanel();
		pane_money.setBackground(Color.LIGHT_GRAY);
		pane_money.setBounds(10, 10, 557, 237);
		pane_none.add(pane_money);
		pane_money.setLayout(null);
		
		JLabel lblNewLabel_11 = new JLabel("Dinheiro dado:");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_11.setBounds(10, 10, 145, 28);
		pane_money.add(lblNewLabel_11);
		
		txtMone = new JTextField();
		txtMone.addCaretListener(new CaretListener() {
			public void caretUpdate(CaretEvent arg0) {
				if(txtMone.getText().isEmpty()) {
					JOptionPane.showMessageDialog(rootPane, "Insira o dinheiro dado pelo cliente!");
				}
				else {
					double total=Double.parseDouble(txtTotal.getText());
					double mon=Double.parseDouble(txtMone.getText());
					double troco=mon-total;
					
					String.valueOf(troco);
					txtTroco.setText(String.format("%.2f", troco));
				}
				
			}
		});
		txtMone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtMone.setBounds(161, 10, 145, 28);
		pane_money.add(txtMone);
		txtMone.setColumns(10);
		
		JLabel lblNewLabel_12 = new JLabel("Troco:");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_12.setBounds(10, 48, 72, 28);
		pane_money.add(lblNewLabel_12);
		
		txtTroco = new JTextField();
		txtTroco.setEditable(false);
		txtTroco.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTroco.setBounds(92, 48, 145, 28);
		pane_money.add(txtTroco);
		txtTroco.setColumns(10);
		
		JButton blnClose = new JButton("Fechar compra");
		blnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(txtMone.getText().isEmpty()) {
					JOptionPane.showMessageDialog(rootPane, "Insira o dinheiro dado pelo cliente!");
				}else {
					
					ArrayList<String> ids=(ArrayList<String>) secprod.getId();
					try {
						data.criarnota(frmtextCli.getText(), ids, fmrcliente.getText(),txtTotal.getText());
						JOptionPane.showMessageDialog(rootPane, "Compra realizada");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
				
				//data.edit(txtId.getText(), 5, String.valueOf(qtd-qtd1));
			}
		});
		blnClose.setFont(new Font("Tahoma", Font.PLAIN, 20));
		blnClose.setBounds(0, 195, 170, 32);
		pane_money.add(blnClose);
		pane_money.setVisible(false);
		
		JPanel pane_card = new JPanel();
		pane_card.setBackground(Color.LIGHT_GRAY);
		pane_card.setBounds(10, 10, 557, 237);
		pane_none.add(pane_card);
		pane_card.setLayout(null);
		
				JPanel pane_credito = new JPanel();
				pane_credito.setBackground(Color.LIGHT_GRAY);
				pane_credito.setBounds(0, 45, 557, 192);
				pane_credito.setVisible(false);
				Choice choice_1 = new Choice();
				choice_1.addItemListener(new ItemListener() {
					public void itemStateChanged(ItemEvent arg0) {
						if(choice_1.getSelectedItem().equals("Crédito")) {
							pane_credito.setVisible(true);
						}
					}
				});
				choice_1.setFont(new Font("Dialog", Font.PLAIN, 20));
				choice_1.setBounds(65, 10, 149, 28);
				choice_1.add("Débito");
				choice_1.add("Crédito");
				
				pane_card.add(pane_credito);
				pane_credito.setLayout(null);
				
				JLabel lblNewLabel_10 = new JLabel("Nome:");
				lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblNewLabel_10.setBounds(10, 10, 56, 21);
				pane_credito.add(lblNewLabel_10);
				
				textField = new JTextField();
				textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
				textField.setBounds(64, 8, 379, 31);
				pane_credito.add(textField);
				textField.setColumns(10);
				
				JLabel lblNewLabel_13 = new JLabel("Cart\u00E3o:");
				lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblNewLabel_13.setBounds(10, 53, 56, 25);
				pane_credito.add(lblNewLabel_13);
				
				textField_1 = new JTextField();
				textField_1.setBounds(64, 52, 366, 31);
				pane_credito.add(textField_1);
				textField_1.setColumns(10);
				
				JButton btnNewButton_2 = new JButton("Fechar compra");
				btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
							JOptionPane.showMessageDialog(rootPane, "Compra realizada");
						
					}
				});
				btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
				btnNewButton_2.setBounds(10, 132, 155, 31);
				pane_credito.add(btnNewButton_2);
				pane_card.add(choice_1);
				pane_card.setVisible(false);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int id=Integer.parseInt(txtId.getText());
				
			try {
				if(data.exists(id)) {
					if(txtQnt.getText().isEmpty()) {
						JOptionPane.showMessageDialog(rootPane, "Digite uma quantidade");
					}else {
					String nome=data.produtos(id).get(0);
					String preco=data.produtos(id).get(1);
					String id2=data.produtos(id).get(2);
					String quanti=txtQnt.getText();
					//quantidade quem tem menos quantidade tirada
					secprod.addRow(nome, preco, id2,quanti);
				
					txtTotal.setText(String.valueOf(secprod.total()));
					}
				}else {
					JOptionPane.showMessageDialog(rootPane, "Produto não existente");
				}
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				secprod.removeRow(produtos.getSelectedRow());
				txtTotal.setText(String.valueOf(secprod.total()));
			}
		});
		choice.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				if(choice.getSelectedItem().equals("Dinheiro")){
					pane_card.setVisible(false);
					pane_money.setVisible(true);
				}
				else if((choice.getSelectedItem().equals("Cartão"))){
					pane_money.setVisible(false);
					pane_card.setVisible(true);
				}
			}
		});
	}
	public void checkPerf(String cpf) throws IOException {
		if(dat.logins(cpf).get(1).equals("Administrador")) {
			mntmNewMenuItem.setVisible(true);
			mntmNewMenuItem_3.setVisible(true);
		}
		else {
			mntmNewMenuItem.setVisible(false);
			mntmNewMenuItem_3.setVisible(false);
		}
	}
	public void setImg(String cpf) throws IOException {
		this.lblImg.setIcon(dat.cpfimg(cpf));
	}
	public void setImg() throws IOException {
		this.lblImg.setIcon(new ImageIcon(new javax.swing.ImageIcon(getClass().getResource("/imgs/17004.png")).getImage().getScaledInstance(225,225, Image.SCALE_SMOOTH)));
	}
	public String getAtendente() {
		return this.fmrcliente.getText();
	}
	public void setAtendente(String a) {
		this.fmrcliente.setText(a);
	}
	public void setClient(String a) {
		this.frmtextCli.setText(a);
	}
}
