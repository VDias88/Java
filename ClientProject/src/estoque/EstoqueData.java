package estoque;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import DataDealing.GerenciarPastas;
public class EstoqueData {
	EstoqueProducts e1=new EstoqueProducts();
	GerenciarPastas g1= new GerenciarPastas();
	public int linhas=0;
	File estoq =new File(g1.newfile("databank"),"estoque.txt");
	public void criarnota(String cliente,ArrayList<String> ids,String atendente,String total) throws IOException {
		Double tot=0.0;
		String userDir=System.getProperty("user.dir");
		File estoq =new File(userDir,cliente+".txt");
		FileWriter fw=new FileWriter(estoq,true);
		BufferedWriter bw =new BufferedWriter(fw);
		bw.append("---------------------------");
		bw.newLine();
		bw.append("       Nota de compra      ");
		bw.newLine();
		bw.append("---------------------------");
		bw.newLine();
		bw.append("     Comprador= "+cliente   );
		bw.newLine();
		bw.append("     Atendente= "+atendente );
		bw.newLine();
		bw.append("---------------------------");
		bw.newLine();
		bw.append(" - - - - -Produtos- - - - -");
		bw.newLine();
		bw.append("Item------------------Preço");
		bw.newLine();
		for(int i=0;i<=ids.size()-1;i++) {
			
			bw.append(this.produtos(Integer.valueOf(ids.get(i))).get(0)+"-------------"+this.produtos(Integer.valueOf(ids.get(i))).get(1));
			tot=tot+Double.valueOf(this.produtos(Integer.valueOf(ids.get(i))).get(1));
			bw.newLine();
		}
		bw.append("---------------------------");
		bw.newLine();
		bw.append("Total= "+total);
		bw.newLine();
		bw.append("---------------------------");
		bw.close();
		fw.close();
	}
	public void criar() throws IOException {
		File estoq =new File(g1.newfile("databank"),"estoque.txt");
		FileWriter fw=new FileWriter(estoq,true);
		fw.close();
	}
	public void addproduto(EstoqueProducts a) throws IOException {
		FileWriter fw=new FileWriter(estoq,true);
		BufferedWriter bw =new BufferedWriter(fw);
		bw.append(a.getDescricao()+"-"+a.getPreco()+"-"+a.getId()+"-"+a.getSetor()+"-"+a.getQuantidade());
		bw.newLine();
		bw.close();
		fw.close();
	}
	public ArrayList<String> produtos(int id) throws IOException{
		ArrayList<String> produto=new ArrayList<>();
		BufferedReader br=new BufferedReader(new FileReader(estoq));
		String linha=br.readLine();
		while(linha!=null) {
			if(Integer.parseInt(corte8(3,linha))==id){
				produto.add(corte8(1,linha));
				produto.add(corte8(2,linha));
				produto.add(corte8(3,linha));
				produto.add(corte8(4,linha));
				produto.add(corte8(5,linha));
				break;
			}
			linha=br.readLine();
			
		}
		br.close();
		return produto;
	}
	public boolean exists(int id) throws IOException{
		BufferedReader br=new BufferedReader(new FileReader(estoq));
		String linha=br.readLine();
		if(Integer.parseInt(corte8(3,linha))==id) {
			return true;
		}
		while(linha!=null) {
			
			if(Integer.parseInt(corte8(3,linha))==id) {
				return true;
			}
			linha=br.readLine();
			
		}
		
		br.close();
		return false;
	}
	public boolean exists2(int id) throws IOException{
		BufferedReader br=new BufferedReader(new FileReader(estoq));
		String linha=br.readLine();
		if(linha==null) {
			return false;
		}
		while(linha!=null) {
			
			if(Integer.parseInt(corte8(3,linha))==id) {
				return true;
			}
			linha=br.readLine();
			
		}
		br.close();
		return false;
	}
	public static String corte8(int a,String b) {
		int primeiro=b.indexOf("-");
		int ultimo=b.lastIndexOf("-");
		switch(a) {
		case 1:
			return b.substring(0,primeiro);
		case 2:
			String l=b.substring(primeiro+1,ultimo);
			int p1=l.indexOf("-");
			return l.substring(0,p1);
		case 3:
			String l1=b.substring(primeiro+1,ultimo);
			int a1=l1.indexOf("-");
			int a4=l1.lastIndexOf("-");
			return l1.substring(a1+1,a4);
		case 4:
			String l2=b.substring(primeiro+1,ultimo);
			int a5=l2.lastIndexOf("-");
			return l2.substring(a5+1,l2.length());
		case 5:
			return b.substring(ultimo+1,b.length());
			default:
				return "error";
		}
	}
	public void start() throws IOException {
		BufferedReader br=new BufferedReader(new FileReader(estoq));
		String linha="";
		while(linha!=null) {
			
			linha=br.readLine();
			linhas++;
			
		}
		br.close();
	}
	public ArrayList<String> descricao(int desc) throws IOException{
		ArrayList<String> descricao=new ArrayList<>();
		BufferedReader br=new BufferedReader(new FileReader(estoq));
		String linha="";
		while(linha!=null) {
			linha=br.readLine();
			if(linha!=null)
			descricao.add(corte8(desc,linha));
		}
		
		br.close();
		return descricao;
	}
	public static String corte(String a) {
		int b=a.indexOf("-");
		String c=a.substring(0,b);
		return c;
	}
	public static String corte2(String a) {
		int b=a.indexOf("-");
		String c=a.substring(b+1,a.length());
		return c;
	}
	public static String corte3(String a) {
		int b=a.indexOf("-");
		int c=a.lastIndexOf("-");
		String d=a.substring(c+1,a.length());
		return d;
	}
	public void edit(String cpf,int op,String edi) throws IOException{
		File logs =new File(g1.newfile("databank"),"estoque.txt");
		BufferedReader br=new BufferedReader(new FileReader(logs));
		String linha=br.readLine();
		//guardar linhas em um arraylist
		ArrayList<String> linhas=new ArrayList<String>();
		linhas.add(linha);
		while(linha!=null) {
			linha=br.readLine();
			linhas.add(linha);
		}
		br.close();
		//Vinicius Monteiro Dias-Administrador-61262152305-8833-Dias
		linhas.remove(linhas.size()-1);
		logs.delete();
		String linov=null;
		int pos;
		for(int i=0;i<=linhas.size()-1;i++) {
			String a1=corte2(linhas.get(i));
			int ultimo=a1.indexOf("-")+1;
			String a2=a1.substring(ultimo,a1.length());
			String a7=corte(a2);
			if(a7.equals(cpf)) {
				pos=i;
				ArrayList<String> dat=new ArrayList<String>();
				//nome
				dat.add(corte(linhas.get(i)));
				//preço
				dat.add(corte(a1));
				//id
				dat.add(corte(a2));
				int ul=a2.indexOf("-");
				String a3=a2.substring(ul+1,a2.length());
				//setor
				dat.add(corte(a3));
				String senha=corte(a3);
				//quantidade
				dat.add(corte3(a3));
				String login=corte3(a3);
				if(op==1) {
					//editar nome
					dat.set(0, edi);
					linov=dat.get(0)+"-"+dat.get(1)+"-"+dat.get(2)+"-"+dat.get(3)+"-"+dat.get(4);
					linhas.set(pos, linov);
					break;
				}
				else if(op==2) {
					//editar preco
					dat.set(1, edi);
					linov=dat.get(0)+"-"+dat.get(1)+"-"+dat.get(2)+"-"+dat.get(3)+"-"+dat.get(4);
					linhas.set(pos, linov);
					break;
				}
				else if(op==3) {
					//editar id
					dat.set(2, edi);
					linov=dat.get(0)+"-"+dat.get(1)+"-"+dat.get(2)+"-"+dat.get(3)+"-"+dat.get(4);
					linhas.set(pos, linov);
					break;
				}
				else if(op==4) {
					//setor
					dat.set(3, edi);
					linov=dat.get(0)+"-"+dat.get(1)+"-"+dat.get(2)+"-"+dat.get(3)+"-"+dat.get(4);
					linhas.set(pos, linov);
					break;
				}
				
				else if(op==5) {
					//quantidade
					dat.set(4, edi);
					linov=dat.get(0)+"-"+dat.get(1)+"-"+dat.get(2)+"-"+dat.get(3)+"-"+dat.get(4);
					linhas.set(pos, linov);
					break;
				}
				
			}
			
		}
		File logs1 =new File(g1.newfile("databank"),"estoque.txt");
		FileWriter fw=new FileWriter(logs1,true);
		BufferedWriter bw =new BufferedWriter(fw);
				
		for(int i=0;i<=linhas.size()-1;i++) {
			bw.append(linhas.get(i));
			bw.newLine();
		}		
		bw.close();
	}
	public void remove(String b) throws IOException {
		//1-logs
		//2-data
		//3-etc
			ArrayList<String> regists=new ArrayList<>();
			File logs =new File(g1.newfile("databank"),"estoque.txt");
			BufferedReader br=new BufferedReader(new FileReader(logs));
			String linha=br.readLine();
			regists.add(linha);
			while(linha!=null) {
				linha=br.readLine();
				regists.add(linha);
				}
			br.close();
			regists.remove(regists.size()-1);
			logs.delete();
			File logs1 =new File(g1.newfile("databank"),"estoque.txt");
			FileWriter fw=new FileWriter(logs1,true);
			BufferedWriter bw =new BufferedWriter(fw);

			for(int i=0;i<=regists.size()-1;i++) {
				if(regists.get(i).equals(b)) {
					regists.remove(i);
				}	
			}
			for(int i=0;i<=regists.size()-1;i++) {
				bw.append(regists.get(i));
				bw.newLine();
			}
			bw.close();
			//regists.remove(regists.size()-1);
			
		
		}
	public boolean checkInt( String s ) {

    	// cria um array de char
    	char[] c = s.toCharArray();
    	boolean d = true;

    	for ( int i = 0; i < c.length; i++ )
    	    // verifica se o char não é um dígito
    	    if ( !Character.isDigit( c[ i ] ) ) {
    	        d = false;
    	        break;
    	    }
    	return d;
    	}
}
