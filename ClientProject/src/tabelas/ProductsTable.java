package tabelas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import DataDealing.FuncionariesData;
import DataDealing.Data;
public class ProductsTable extends AbstractTableModel{
	Data d1=new Data();
	public List<String> descricao = new ArrayList<>();
	private List<String> preco = new ArrayList<>();
	private List<String> id = new ArrayList<>();

    private String[] colunas = {"Descriçao","Preço","ID"};

    @Override
    public String getColumnName(int column) {
        return colunas[column]; 
    }
    
    @Override
    public int getRowCount() {
        return descricao.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
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
        }
        
        return null;
        
    }
    
    public void addRow(String nome,String perfil,String cpf){
        this.descricao.add(nome);
        this.preco.add(perfil);
        this.id.add(cpf);

        this.fireTableDataChanged();
    }
    public void setValues() throws IOException {
    	d1.start();
    	for(int i=0;i<=d1.linhas-1;i++) {
    		this.descricao.add(d1.nomes().get(i));
    		this.preco.add(d1.perfils().get(i));
    		this.id.add(d1.cpf().get(i));

    	}
    }
    
    public void removeRow(int linha){
        this.descricao.remove(linha);
        this.preco.remove(linha);
        this.id.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    public String getvalues(int linha) {
    	return descricao.get(linha)+"-"+preco.get(linha)+"-"+id.get(linha);
    }
    
}
