package tabelas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import DataDealing.FuncionariesData;
import DataDealing.Data;
public class EstoqueTable extends AbstractTableModel{
	Data d1=new Data();
	public List<String> descricao = new ArrayList<>();
	private List<String> preco = new ArrayList<>();
	private List<String> id = new ArrayList<>();
	private List<String> setor = new ArrayList<>();
	private List<String> quantidade = new ArrayList<>();
    private String[] colunas = {"Descriçao","Preço","ID","Setor","Qantidade"};

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
            case 3:
            	return setor.get(linha);
            case 4:
            	return quantidade.get(linha);
        }
        
        return null;
        
    }
    
    public void addRow(String descricao,String preco,String id,String setor,String quantidade){
        this.descricao.add(descricao);
        this.preco.add(preco);
        this.id.add(id);
        this.setor.add(setor);
        this.quantidade.add(quantidade);
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
        this.setor.remove(linha);
        this.quantidade.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    public String getvAlues(int linha) {
    	return descricao.get(linha)+"-"+preco.get(linha)+"-"+id.get(linha)+"-"+setor.get(linha)+"-"+quantidade.get(linha);
    }
    
}
