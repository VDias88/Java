package client;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import DataDealing.GerenciarPastas;
public class ClentData {
	GerenciarPastas g1=new GerenciarPastas();
	File clientes =new File(g1.newfile("databank"),"client.txt");
	GerecPasts g2=new GerecPasts();
	//criar pasta para salvar imagens dos clientes
	
	
	public void starimgs() {
		
		g2.newfile("climgs");
	}
	public ImageIcon cpfimg(String cpf) throws IOException {
		String userDir=System.getProperty("user.dir");
		File path=new File(userDir+"\\"+"databank"+"\\"+"climgs");
		File imgs[]=path.listFiles();
		
		for(int i=0;i<=imgs.length-1;i++) {
			int a=imgs[i].getName().indexOf(".");
			String name=imgs[i].getName().substring(0,a);
			if(name.equals(cpf)) {
				File path1=new File(userDir+"\\"+"databank"+"\\"+"climgs"+"\\"+imgs[i].getName());
				BufferedImage img= ImageIO.read(path1);
				ImageIcon icon = new ImageIcon(img.getScaledInstance(255, 255, Image.SCALE_SMOOTH));
				return icon;
			}
			
		}
		return null;	
	}
	
	public void saveimg(String path,String name) throws IOException{
		FileInputStream origem;
		FileOutputStream destino;

		FileChannel fcOrigem;
		FileChannel fcDestino;

		origem = new FileInputStream(path);//arquivo que você quer copiar
		destino = new FileOutputStream(GerecPasts.userDir+"\\"+"databank"+"\\"+"climgs"+"\\"+name+".png");//onde irá ficar a copia do aquivo

		    fcOrigem = origem.getChannel();
		    fcDestino = destino.getChannel();

		    fcOrigem.transferTo(0, fcOrigem.size(), fcDestino);//copiando o arquivo e salvando no diretório que você escolheu

		    origem.close();
		    destino.close();
	}
	public void start() throws IOException {
		File clientes =new File(g1.newfile("databank"),"client.txt");
		FileWriter fw=new FileWriter(clientes,true);
		fw.close();
	}
	public static String corte(String cliente) {
		int a=cliente.lastIndexOf("-");
		return cliente.substring(a+1,cliente.length());
	}
	public static String corte6(String a,int b) {
		int p1=a.indexOf("-");
		int l1=a.lastIndexOf("-");
		String nome=a.substring(0,p1);
		String cpf=a.substring(l1+1,a.length());
		String a1=a.substring(p1+1,l1);
		int p2=a1.indexOf("-");
		int l2=a1.lastIndexOf("-");
		String email=a1.substring(0,p2);
		String celular=a1.substring(l2+1,a1.length());
		String telefone=a1.substring(p2+1,l2);
		
		if(b==0) {
			return nome;
		}
		else if(b==1) {
			return email;
		}
		else if(b==2) {
			return telefone;
		}
		else if(b==3){
			return celular;
		}
		else if(b==4) {
			return cpf;
		}
		else {return "";}
	}
	public void write(Cliente a) throws IOException {
		File clientes =new File(g1.newfile("databank"),"client.txt");
		FileWriter fw=new FileWriter(clientes,true);
		BufferedWriter bw =new BufferedWriter(fw);
		bw.append(a.getNome()+"-"+a.getEmail()+"-"+a.getTelefone()+"-"+a.getCelular()+"-"+a.getCpf());
		bw.newLine();
		bw.close();
		fw.close();
	}
	
	public boolean checkcpf(String cpf) throws IOException {
		BufferedReader br=new BufferedReader(new FileReader(clientes));
		String linha=br.readLine();
		boolean check1=false;
		while(linha!=null) {
			if(corte(linha).equals(cpf)) {
				check1=true;
			}
			linha=br.readLine();
		}
		br.close();
		return check1;
	}
	public ArrayList<String> dados(String cpf) throws IOException{
		ArrayList<String> data=new ArrayList<String>();
		BufferedReader br=new BufferedReader(new FileReader(clientes));
		String linha=br.readLine();
		boolean check1=false;
		while(linha!=null) {
			if(corte6(linha,4).equals(cpf)) {
				data.add(corte6(linha,0));
				data.add(corte6(linha,1));
				data.add(corte6(linha,2));
				data.add(corte6(linha,3));
				data.add(corte6(linha,4));
				check1=true;
			}
			linha=br.readLine();
		}
		br.close();
		
		
		
		return data;
	}
	public static String corte1(String a) {
		int b=a.indexOf("-");
		String c=a.substring(0,b);
		return c;
	}
	public static String corte3(String a) {
		int b=a.indexOf("-");
		int c=a.lastIndexOf("-");
		String d=a.substring(c+1,a.length());
		return d;
	}
	public static String corte2(String a) {
		int b=a.indexOf("-");
		String c=a.substring(b+1,a.length());
		return c;
	}
	public void edit(String cpf,int op,String edi) throws IOException{
		File logs =new File(g1.newfile("databank"),"client.txt");
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
			String a7=corte1(a2);
			//Vinicius Monteiro Dias-Administrador-612621-88331755-Dias88
			//Ana paula-email-telefone-celular-cpf
			
			if(corte3(linhas.get(i)).equals(cpf)) {
				pos=i;
				ArrayList<String> dat=new ArrayList<String>();
				//nome
				dat.add(corte1(linhas.get(i)));
				//email
				dat.add(corte1(a1));
				//telefone
				dat.add(corte1(a2));
				int ul=a2.indexOf("-");
				String a3=a2.substring(ul+1,a2.length());
				//celular
				dat.add(corte1(a3));
				String senha=corte1(a3);
				//cpf
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
					break;
				}
				
				else if(op==5) {
					//login
					dat.set(4, edi);
					linov=dat.get(0)+"-"+dat.get(1)+"-"+dat.get(2)+"-"+dat.get(3)+"-"+dat.get(4);
					linhas.set(pos, linov);
					break;
				}
				
			}
			else {
				System.out.println("Error");
				break;
			}
			
		}
		File logs1 =new File(g1.newfile("databank"),"client.txt");
		FileWriter fw=new FileWriter(logs1,true);
		BufferedWriter bw =new BufferedWriter(fw);
				
		for(int i=0;i<=linhas.size()-1;i++) {
			bw.append(linhas.get(i));
			bw.newLine();
		}		
		bw.close();
	}
	
}
