package tabelas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import DataDealing.FuncionariesData;
import DataDealing.Data;
public class TestModel extends AbstractTableModel{
	Data d1=new Data();
	public List<String> nomes = new ArrayList<>();
	private List<String> perfil = new ArrayList<>();
	private List<String> cpf = new ArrayList<>();
    private String[] colunas = {"Nome","Perfil","CPF"};

    @Override
    public String getColumnName(int column) {
        return colunas[column]; 
    }
    
    @Override
    public int getRowCount() {
        return nomes.size();
    }

    @Override
    public int getColumnCount() {
        return colunas.length;
    }

    @Override
    public Object getValueAt(int linha, int coluna) {
        
        switch(coluna){
            case 0:
                return nomes.get(linha);
            case 1:
                return perfil.get(linha);
            case 2: 
                return cpf.get(linha);
        }
        
        return null;
        
    }
    
    public void addRow(String nome,String perfil,String cpf){
        this.nomes.add(nome);
        this.perfil.add(perfil);
        this.cpf.add(cpf);
        this.fireTableDataChanged();
    }
    public void setValues() throws IOException {
    	d1.start();
    	for(int i=0;i<=d1.linhas-1;i++) {
    		this.nomes.add(d1.nomes().get(i));
    		this.perfil.add(d1.perfils().get(i));
    		this.cpf.add(d1.cpf().get(i));
    	}
    }
    
    public void removeRow(int linha){
        this.nomes.remove(linha);
        this.perfil.remove(linha);
        this.cpf.remove(linha);
        this.fireTableRowsDeleted(linha, linha);
    }
    public String getvalues(int linha) {
    	return nomes.get(linha)+"-"+perfil.get(linha)+"-"+cpf.get(linha);
    }
    
}
