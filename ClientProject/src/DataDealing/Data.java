package DataDealing;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import client.ClentData;
import client.ClientRegister;
import client.Mainstests;

public class Data {
	public int linhas=0;
	GerenciarPastas g1= new GerenciarPastas();
	File arquivo =new File(g1.newfile("databank"),"data.txt");
	
	public void cpyimg(String img) throws IOException {
		BufferedImage image = ImageIO.read(Mainstests.class.getResourceAsStream("/imgs/"+img));
		String userDir=System.getProperty("user.dir");
		try {
		    File outputfile = new File(userDir+"\\"+"databank"+"\\"+img);
		    ImageIO.write(image, "png", outputfile);
		} catch (IOException e) {
		   System.out.println("error ao copiar imagem");
		}	
	}
	

	public void criardata() throws IOException {
		File arquivo =new File(g1.newfile("databank"),"data.txt");
		this.cpyimg("client-management.png");
		FileWriter fw=new FileWriter(arquivo,true);
		fw.close();
	}
	//escrever login e senha no arquivo data
	public void escrever(String a,String b) throws IOException {
		FileWriter fw=new FileWriter(arquivo,true);
		BufferedWriter bw =new BufferedWriter(fw);
		bw.append(a+"-"+b);
		bw.newLine();
		bw.close();
		fw.close();
	}
	//corte da string localizando "-"
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
	//verificar se existe login no banco
	public boolean ler(String c) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader(arquivo));
		String linha=br.readLine();
		
	
		boolean check1=false;
		
		while(linha!=null) {
			if((corte(linha)).equals(c)) {
			
				check1=true;
			}
			
			linha=br.readLine();
		}
		br.close();
		return check1;
	}
	//verificar se login e senha estao no banco
	public boolean lerpass(String c,String p) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader(arquivo));
		String linha=br.readLine();
		boolean check1=false;
		while(linha!=null) {
			if((corte(linha)).equals(c)&&corte2(linha).equals(p)) {
				
				check1=true;
			}
			
			linha=br.readLine();
		}
		br.close();
		return check1;
		
	}
	//ler todos logins do banco 
	ArrayList<String> list=new ArrayList<String>();
	public ArrayList<String> lernomes() throws IOException {
		BufferedReader br=new BufferedReader(new FileReader(arquivo));
		String linha=br.readLine();
		while(linha!=null) {
			list.add(br.readLine());
			linha=br.readLine();
			}
		br.close();
		return list;
		}
	public void criarlogs() throws IOException {
		File logs =new File(g1.newfile("databank"),"logs.txt");
		FileWriter fw=new FileWriter(logs,true);
		fw.close();
	}
	//escrever  nomes perfils cpfs dos funcionarios registrados 
	public void escreverlog(FuncionariesData a) throws IOException {
		File logs =new File(g1.newfile("databank"),"logs.txt");
		FileWriter fw=new FileWriter(logs,true);
		BufferedWriter bw =new BufferedWriter(fw);
		bw.append(a.getNome()+"-"+a.getPerfil()+"-"+a.getCpf()+"-"+a.getSenha()+"-"+a.getLogin());
		bw.newLine();
		bw.close();
		fw.close();
		}
	//adiciona registros em um array
	ArrayList<String> registros=new ArrayList<String>();
	public ArrayList<String> lerregist() throws IOException {
		File logs =new File(g1.newfile("databank"),"logs.txt");
		BufferedReader br=new BufferedReader(new FileReader(logs));
		
		String linha=br.readLine();
		while(linha!=null) {
			registros.add(linha);
			linha=br.readLine();
			}
		br.close();
		return registros;
		}
	//pega uma linha dos logs e corta adicionando os dados em um array{nome,perfil,cpf,senha}
	public ArrayList<String> cortelogs(String a){
		ArrayList<String> logs=new ArrayList<String>();
		int f1=a.indexOf("-");
		int f2=a.lastIndexOf("-");
		String nome=a.substring(0,f1);
		String perfcpf=a.substring(f1+1,f2);
		int f3=perfcpf.indexOf("-");
		String senha=a.substring(f2+1,a.length());
		String perfil=perfcpf.substring(0,f3);
		String cpf=perfcpf.substring(f3+1,perfcpf.length());
		logs.add(nome);
		logs.add(perfil);
		logs.add(cpf);
		logs.add(senha);
		return logs;
	}
	//ler todos logs 
	public String lerlogs() throws IOException {
		File logs =new File(g1.newfile("databank"),"logs.txt");
		BufferedReader br=new BufferedReader(new FileReader(logs));
		
		String linha="";
		for(int j=0;j<=linhas/2;j++) {
			
			linha=br.readLine();
		}	
		br.close();
		return linha;
		}
	//varre os logs contando suas linhas
	public void start() throws IOException {
		File logs =new File(g1.newfile("databank"),"logs.txt");
		BufferedReader br=new BufferedReader(new FileReader(logs));
		String linha=br.readLine();
		while(linha!=null) {
			linhas++;
			linha=br.readLine();
			}
		br.close();
		}
	//armazena todos nomes em um array
	public ArrayList<String> nomes() throws IOException{
		ArrayList<String> nomes=new ArrayList<>();
		File logs =new File(g1.newfile("databank"),"logs.txt");
		BufferedReader br=new BufferedReader(new FileReader(logs));
		String linha="";
		
		while(linha!=null) {
			linha=br.readLine();
			if(linha!=null) {
				nomes.add(corte(linha));
				}
			}
		br.close();
		return nomes;
		}
	//armazena todos perfils em um array
	public ArrayList<String> perfils() throws IOException{
		ArrayList<String> perfils=new ArrayList<>();
		File logs =new File(g1.newfile("databank"),"logs.txt");
		BufferedReader br=new BufferedReader(new FileReader(logs));
		String linha="";
	
		while(linha!=null) {
			linha=br.readLine();
			
			if(linha!=null) {
			int ultimo=linha.lastIndexOf("-");
			int primeiro=linha.indexOf("-");
			String a1=linha.substring(primeiro+1,ultimo);
			perfils.add(corte(a1));
			}
			}
		br.close();
		return perfils;
		}
	//armazena todos cpfs em um array
	public ArrayList<String> cpf() throws IOException{
		ArrayList<String> cpf=new ArrayList<>();
		File logs =new File(g1.newfile("databank"),"logs.txt");
		BufferedReader br=new BufferedReader(new FileReader(logs));
		
		String linha="";
	
		while(linha!=null) {
			linha=br.readLine();
			if(linha!=null) {
			int ultimo=linha.lastIndexOf("-");
			int primeiro=linha.indexOf("-");
			String a1=linha.substring(primeiro+1,ultimo);
			String a2=(corte2(a1));
			cpf.add(corte(a2));
			}
			}
		br.close();
		return cpf;
		}
	//armazena todas senhas em um array
	public ArrayList<String> senha() throws IOException{
		ArrayList<String> senha=new ArrayList<>();
		File logs =new File(g1.newfile("databank"),"logs.txt");
		BufferedReader br=new BufferedReader(new FileReader(logs));
		
		String linha="";
	
		while(linha!=null) {
			linha=br.readLine();
			
			if(linha!=null) {
			int ultimo=linha.lastIndexOf("-");
			int primeiro=linha.indexOf("-");
			String a1=linha.substring(primeiro+1,ultimo);
			String a2=corte2(a1);
			int ultimo2=a2.indexOf("-");
			senha.add(a2.substring(ultimo2+1,a2.length()));
			}
			}
		br.close();
		return senha;
		}
	//devolve todos logins no "logs"
	public ArrayList<String> logins() throws IOException{
		ArrayList<String> logins=new ArrayList<>();
		File logs =new File(g1.newfile("databank"),"logs.txt");
		BufferedReader br=new BufferedReader(new FileReader(logs));
		
		String linha="";
	
		while(linha!=null) {
			linha=br.readLine();
			
			if(linha!=null) {
			int ultimo=linha.lastIndexOf("-");
			
			String a1=linha.substring(ultimo+1,linha.length());
			
			logins.add(a1);
			}
			}
		br.close();
		return logins;
		}
	//apaga determinada linha de um arquivo varrendo ele em busca dessa linha e criando outro arquivo sem a mesma
	public void remove(int a,String b) throws IOException {
		//1-logs
		//2-data
		//3-etc
		if(a==1) {
			ArrayList<String> regists=new ArrayList<>();
			File logs =new File(g1.newfile("databank"),"logs.txt");
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
			File logs1 =new File(g1.newfile("databank"),"logs.txt");
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
		if(a==2) {
			ArrayList<String>registers=new ArrayList<>();
			File regists =new File(g1.newfile("databank"),"data.txt");
			BufferedReader br=new BufferedReader(new FileReader(regists));
			String linha=br.readLine();
			registers.add(linha);
			while(linha!=null) {
				linha=br.readLine();
				registers.add(linha);
				}
			br.close();
			registers.remove(registers.size()-1);
			regists.delete();
			File regists1 =new File(g1.newfile("databank"),"data.txt");
			FileWriter fw=new FileWriter(regists1,true);
			BufferedWriter bw =new BufferedWriter(fw);
			for(int i=0;i<=registers.size()-1;i++) {
				if(registers.get(i).equals(b)) {
					registers.remove(i);
				}
			}
			for(int i=0;i<=registers.size()-1;i++) {
				bw.append(registers.get(i));
				bw.newLine();
			}
			bw.close();
			//registers.remove(registers.size()-1);
			}
		}
	
		public ArrayList<String> logins(String b) throws IOException {
			ArrayList<String> data=new ArrayList<>();
			File logs =new File(g1.newfile("databank"),"logs.txt");
			BufferedReader br=new BufferedReader(new FileReader(logs));
			String linha=br.readLine();
			
			while(linha!=null) {
				corte3(linha);
				if(corte3(linha).equals(b)) {
				
				int p1=linha.indexOf("-");	
				int pl1=linha.lastIndexOf("-");
				data.add(corte(linha));
				String a1=linha.substring(p1+1,pl1);
				data.add(corte(a1));
				int p2=a1.indexOf("-");
				String a2=a1.substring(p2+1,a1.length());
				data.add(corte(a2));
				break;
					}
				
				linha=br.readLine();
				
				}
			
			br.close();
			return data;
		}
		public ArrayList<String> cpflog(String b) throws IOException {
			ArrayList<String> data=new ArrayList<>();
			File logs =new File(g1.newfile("databank"),"logs.txt");
			BufferedReader br=new BufferedReader(new FileReader(logs));
			String linha=br.readLine();
			
			while(linha!=null) {
				corte3(linha);
				if(corte(linha).equals(b)) {
				
				int p1=linha.indexOf("-");	
				int pl1=linha.lastIndexOf("-");
				data.add(corte(linha));
				String a1=linha.substring(p1+1,pl1);
				data.add(corte(a1));
				int p2=a1.indexOf("-");
				String a2=a1.substring(p2+1,a1.length());
				data.add(corte(a2));
				break;
					}
				
				linha=br.readLine();
				
				}
			
			br.close();
			return data;
		}
		public boolean lerperf(String login,String perfil) throws IOException{
			File logs =new File(g1.newfile("databank"),"logs.txt");
			BufferedReader br=new BufferedReader(new FileReader(logs));
			String linha="";
			boolean a=false;
			linha=br.readLine();
			while(linha!=null) {
				if(corte3(linha).equals(login)) {
					int ultimo=linha.lastIndexOf("-");
					int primeiro=linha.indexOf("-");
					String a1=linha.substring(primeiro+1,ultimo);
					if(corte(a1).equals(perfil)) {
						return true;
					}
					
				}
				linha=br.readLine();
			}
			
			br.close();
			return false;
		}
		public ArrayList<String> cpfdata(String cpf) throws IOException{
			File logs =new File(g1.newfile("databank"),"logs.txt");
			ArrayList<String> data=new ArrayList<String>();
			BufferedReader br=new BufferedReader(new FileReader(logs));
			String linha="";
			linha=br.readLine();
			while(linha!=null) {
				String a1=corte2(linha);
				int ultimo=a1.indexOf("-")+1;
				String a2=a1.substring(ultimo,a1.length());
				if(corte(a2).equals(cpf)) {
					data.add(corte(linha));
					String a=corte2(linha);
					data.add(corte(a));
					String b=corte2(a);
					data.add(corte(b));
					String c=corte2(b);
					data.add(corte(c));
					String d=corte2(c);
					data.add(d);
					break;
				}
				linha=br.readLine();
			}
			br.close();
			return data;
		}
		public ImageIcon cpfimg(String cpf) throws IOException {
			String userDir=System.getProperty("user.dir");
			File path=new File(userDir+"\\"+"databank"+"\\"+"fcimgs");
			File imgs[]=path.listFiles();
			
			for(int i=0;i<=imgs.length-1;i++) {
				int a=imgs[i].getName().indexOf(".");
				String name=imgs[i].getName().substring(0,a);
				if(name.equals(cpf)) {
					File path1=new File(userDir+"\\"+"databank"+"\\"+"fcimgs"+"\\"+imgs[i].getName());
					BufferedImage img= ImageIO.read(path1);
					ImageIcon icon = new ImageIcon(img.getScaledInstance(255, 255, Image.SCALE_SMOOTH));
					return icon;
				}
				
			}
			return null;	
		}
		public void deletImg(String cpf) {
			String userDir=System.getProperty("user.dir");
			File path=new File(userDir+"\\"+"databank"+"\\"+"fcimgs");
			File imgs[]=path.listFiles();
			for(int i=0;i<=imgs.length-1;i++) {
				int a=imgs[i].getName().indexOf(".");
				String name=imgs[i].getName().substring(0,a);
				if(name.equals(cpf)) {
					File dlt=new File(userDir+"\\"+"databank"+"\\"+"fcimgs"+"\\"+imgs[i].getName());
					dlt.delete();
				}
				
			}
		}
		public void edit(String cpf,int op,String edi) throws IOException{
			File logs =new File(g1.newfile("databank"),"logs.txt");
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
					//perfil
					dat.add(corte(a1));
					//cpf
					dat.add(corte(a2));
					int ul=a2.indexOf("-");
					String a3=a2.substring(ul+1,a2.length());
					//senha
					dat.add(corte(a3));
					String senha=corte(a3);
					//login
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
						//editar perfil
						dat.set(1, edi);
						linov=dat.get(0)+"-"+dat.get(1)+"-"+dat.get(2)+"-"+dat.get(3)+"-"+dat.get(4);
						linhas.set(pos, linov);
						break;
					}
					else if(op==3) {
						//editar cpf
						dat.set(2, edi);
						linov=dat.get(0)+"-"+dat.get(1)+"-"+dat.get(2)+"-"+dat.get(3)+"-"+dat.get(4);
						linhas.set(pos, linov);
						break;
					}
					else if(op==4) {
						//senha
						dat.set(3, edi);
						linov=dat.get(0)+"-"+dat.get(1)+"-"+dat.get(2)+"-"+dat.get(3)+"-"+dat.get(4);
						linhas.set(pos, linov);
						editdata(2,login,edi);
						break;
					}
					
					else if(op==5) {
						//login
						dat.set(4, edi);
						linov=dat.get(0)+"-"+dat.get(1)+"-"+dat.get(2)+"-"+dat.get(3)+"-"+dat.get(4);
						linhas.set(pos, linov);
						editdata(1,login,edi);
						break;
					}
					
				}
				
			}
			File logs1 =new File(g1.newfile("databank"),"logs.txt");
			FileWriter fw=new FileWriter(logs1,true);
			BufferedWriter bw =new BufferedWriter(fw);
					
			for(int i=0;i<=linhas.size()-1;i++) {
				bw.append(linhas.get(i));
				bw.newLine();
			}		
			bw.close();
		}
		public void editdata(int op,String log,String edit) throws IOException{
			File regists =new File(g1.newfile("databank"),"data.txt");
			BufferedReader br=new BufferedReader(new FileReader(regists));
			ArrayList<String>registers=new ArrayList<>();
			String linha=br.readLine();
			registers.add(linha);
			while(linha!=null) {
				linha=br.readLine();
				registers.add(linha);
			}
			br.close();
			registers.remove(registers.size()-1);
			regists.delete();
			File regists1 =new File(g1.newfile("databank"),"data.txt");
			FileWriter fw=new FileWriter(regists1,true);
			BufferedWriter bw =new BufferedWriter(fw);
			int pos;
			for(int i=0;i<=registers.size()-1;i++) {
				if(corte(registers.get(i)).equals(log)){
					pos=i;
					String login=corte(registers.get(i));
					String senha=corte3(registers.get(i));
					if(op==1) {
						String lnov=edit+"-"+senha;
						registers.set(pos, lnov);
					}
					else if(op==2) {
						String lnov=login+"-"+edit;
						registers.set(pos, lnov);
					}
				}
				
			}
			for(int i=0;i<=registers.size()-1;i++) {
				bw.append(registers.get(i));
				bw.newLine();
			}
			bw.close();
		}
		
	}

