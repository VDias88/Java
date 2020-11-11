package estoque;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import DataDealing.*;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import tabelas.*;
import DataDealing.Data;
import View.MainView;
import View.SecundariView;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.List;
import java.awt.Toolkit;
import java.io.IOException;

import javax.swing.JList;
import javax.swing.JMenu;

import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class EstoqueView extends JFrame {

	private JPanel contentPane;
	private JTable produtos;
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
					EstoqueView frame = new EstoqueView();
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
	EstoqueTable testproducts=new EstoqueTable();
	private JTextField txtDescricao;
	private JTextField txtpreco;
	private JTextField txtSetor;
	private JTextField txtId;
	private JTextField txtQuantidade;
	public EstoqueView() throws IOException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(EstoqueView.class.getResource("/imgs/Logo.png")));
		setTitle("Gerenciamento de estoque");
		Toolkit tk = Toolkit.getDefaultToolkit();
	    Dimension d = tk.getScreenSize();
	    EstoqueData a1=new EstoqueData();
		this.setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Data d1=new Data();
		setBounds(100, 100, d.width, d.height);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1918, 26);
		JMenu avac = new JMenu("Avançado");
		JMenu opts = new JMenu("Opções");
		
		JMenu mnNewMenu = new JMenu("Gerenciar");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Voltar");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					SecundariView a1;
					a1 = new SecundariView();
					a1.setVisible(true);
					a1.setAtendente(atend);
					//hhhha1.setImg(d1.logins(txtLog.getText()).get(2));
					dispose();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		menuBar.add(avac);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("F\u00FAncionarios");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(rootPane, "Primeiro volte a página primária");
			}
		});
		contentPane.setLayout(null);
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
		//tabela produtos
		produtos = new JTable();
		produtos.setFont(new Font("Tahoma", Font.PLAIN, 15));
		produtos.setBounds(478, 70, 961, 463);
		contentPane.add(produtos);
		produtos.setModel(testproducts);
		produtos.getTableHeader().setReorderingAllowed (false);
		//preenchimento
		a1.start();
		for(int i=0;i<=a1.linhas-2;i++) {
			testproducts.addRow(a1.descricao(1).get(i),a1.descricao(2).get(i),a1.descricao(3).get(i),a1.descricao(4).get(i), a1.descricao(5).get(i));
		}
		//scrolls
		JScrollPane scrollPane = new JScrollPane(produtos);
		scrollPane.setBounds(29, 70, 734, 906);
		scrollPane.setViewportView(produtos);
		contentPane.add(scrollPane);
		
		JPanel paneladd = new JPanel();
		paneladd.setBounds(775, 70, 698, 281);
		contentPane.add(paneladd);
		paneladd.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(12, 13, 53, 37);
		paneladd.add(lblNewLabel);
		
		txtDescricao = new JTextField();
		txtDescricao.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtDescricao.setBounds(69, 13, 457, 37);
		paneladd.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JLabel lblPreco = new JLabel("Pre\u00E7o");
		lblPreco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPreco.setBounds(12, 83, 53, 37);
		paneladd.add(lblPreco);
		
		txtpreco = new JTextField();
		txtpreco.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtpreco.setBounds(69, 83, 214, 37);
		paneladd.add(txtpreco);
		txtpreco.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Setor");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(323, 83, 46, 37);
		paneladd.add(lblNewLabel_1);
		
		txtSetor = new JTextField();
		txtSetor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSetor.setBounds(368, 84, 302, 37);
		paneladd.add(txtSetor);
		txtSetor.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(12, 147, 32, 37);
		paneladd.add(lblNewLabel_2);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtId.setBounds(69, 148, 214, 37);
		paneladd.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Quantidade");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(323, 148, 83, 37);
		paneladd.add(lblNewLabel_3);
		
		txtQuantidade = new JTextField();
		txtQuantidade.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtQuantidade.setBounds(418, 148, 252, 37);
		paneladd.add(txtQuantidade);
		txtQuantidade.setColumns(10);
		produtos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				try {
					txtDescricao.setText(a1.produtos(Integer.valueOf( (String) produtos.getValueAt(produtos.getSelectedRow(), 2))).get(0));
					txtpreco.setText(a1.produtos(Integer.valueOf( (String) produtos.getValueAt(produtos.getSelectedRow(), 2))).get(1));
					txtId.setText(a1.produtos(Integer.valueOf( (String) produtos.getValueAt(produtos.getSelectedRow(), 2))).get(2));
					txtSetor.setText(a1.produtos(Integer.valueOf( (String) produtos.getValueAt(produtos.getSelectedRow(), 2))).get(3));
					txtQuantidade.setText(a1.produtos(Integer.valueOf( (String) produtos.getValueAt(produtos.getSelectedRow(), 2))).get(4));
					
				} catch (NumberFormatException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}});
		JButton btnAdd = new JButton("Adicionar");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EstoqueProducts p1=new EstoqueProducts();
				p1.setDescricao(txtDescricao.getText());
				p1.setPreco(txtpreco.getText());
				p1.setId(txtId.getText());
				p1.setSetor(txtSetor.getText());
				p1.setQuantidade(txtQuantidade.getText());
				try {
					if(!a1.checkInt(txtId.getText())) {
						JOptionPane.showMessageDialog(rootPane, "Id escreva um Id com apenas números!!");
					}
					else if((a1.exists2(Integer.valueOf(txtId.getText())))) {
						JOptionPane.showMessageDialog(rootPane, "Id já existente");
					}
					else {
						a1.addproduto(p1);
						testproducts.addRow(txtDescricao.getText(), txtpreco.getText(), txtId.getText(), txtSetor.getText(), txtQuantidade.getText());
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				
			}
		});
		btnAdd.setBounds(202, 221, 116, 37);
		paneladd.add(btnAdd);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String line=txtDescricao.getText()+"-"+txtpreco.getText()+"-"+txtId.getText()+"-"+txtSetor.getText()+"-"+txtQuantidade.getText();
				try {
					a1.remove(line);
					testproducts.removeRow(produtos.getSelectedRow());
					JOptionPane.showMessageDialog(rootPane, "Produto excluido!!");
				} catch (IOException e) {

					e.printStackTrace();
				}
			}
		});
		btnExcluir.setBounds(12, 221, 109, 36);
		paneladd.add(btnExcluir);
		
		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String desc=txtDescricao.getText();
				String preco=txtpreco.getText();
				String id=txtId.getText();
				String setor=txtSetor.getText();
				String quanti=txtQuantidade.getText();
				try {
					a1.edit(id, 1, desc);
					a1.edit(id, 2, preco);
					a1.edit(id, 3, id);
					a1.edit(id, 4, setor);
					a1.edit(id, 5, quanti);
					JOptionPane.showMessageDialog(rootPane, "Alterações feitas com sucesso!!");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSalvar.setBounds(579, 221, 109, 36);
		paneladd.add(btnSalvar);
		
		JButton btnNew = new JButton("Novo");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtDescricao.setText("");
				txtpreco.setText("");
				txtId.setText("");
				txtSetor.setText("");
				txtQuantidade.setText("");
			}
		});
		btnNew.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnNew.setBounds(398, 221, 116, 37);
		paneladd.add(btnNew);
		}
}
