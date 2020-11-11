package DataDealing;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

public class FuncImgs {
	//pasta onde o programa estara
			static String userDir=System.getProperty("user.dir");
			public String newfile(String name) {
				File pasta=new File(userDir+"\\"+"databank",name);
				pasta.mkdirs();
				return userDir+"\\"+name;
			}
	public void starimgs() {
		newfile("fcimgs");
	}
	
	
	public void saveimg(String path,String name) throws IOException{
		FileInputStream origem;
		FileOutputStream destino;

		FileChannel fcOrigem;
		FileChannel fcDestino;

		origem = new FileInputStream(path);//arquivo que você quer copiar
		destino = new FileOutputStream(FuncImgs.userDir+"\\"+"databank"+"\\"+"fcimgs"+"\\"+name+".jpeg");//onde irá ficar a copia do aquivo

		    fcOrigem = origem.getChannel();
		    fcDestino = destino.getChannel();

		    fcOrigem.transferTo(0, fcOrigem.size(), fcDestino);//copiando o arquivo e salvando no diretório que você escolheu

		    origem.close();
		    destino.close();
	}
}
