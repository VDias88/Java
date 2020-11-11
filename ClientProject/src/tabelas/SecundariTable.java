package tabelas;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class SecundariTable extends AbstractTableModel {
	private List<String> descricao = new ArrayList<>();
	private List<String> preco = new ArrayList<>();
	private List<String> id = new ArrayList<>();
	public List<String> getId() {
		return id;
	}
	private List<String> quantidade = new ArrayList<>();
	
	private String[] colunas = {"Descriçao","Preço","ID","Quantidade"};
    
    @Override
    public String getColumnName(int column) {
        return colunas[column]; 
    }
    
	@Override
	public int getColumnCount() {
        return colunas.length;
    }

	@Override
	 public int getRowCount() {
        return descricao.size();
    }

	@Override
public Object getValueAt(int linha, int coluna) {
        
        switch(coluna){
            case 0:
                return descricao.get(linha);
            case 1:
                return preco.get(linha);
            case 2: 
                return id.get(linha);
            case 3:
            	return quantidade.get(linha);
        }
        
        return null;
        
    }
	public double total () {
		double t=0;
		for(int i=0;i<=preco.size()-1;i++) {
			String pr=preco.get(i);
			//pr.replaceAll(",", ".");
			int q=Integer.parseInt(quantidade.get(i));
			double p=Double.parseDouble(pr);
			t+=q*p;
		}
		return t;
	}
	
	public void addRow(String nome,String preco,String id,String quantidade){
        this.descricao.add(nome);
        this.preco.add(preco);
        this.id.add(id);
        this.quantidade.add(quantidade);
        this.fireTableDataChanged();
    }
	public void removeRow(int linha){
        this.descricao.remove(linha);
        this.preco.remove(linha);
        this.id.remove(linha);
        this.quantidade.remove((linha));
        this.fireTableRowsDeleted(linha, linha);
    }

}
