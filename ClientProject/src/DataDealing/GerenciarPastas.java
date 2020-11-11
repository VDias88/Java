package DataDealing;

import java.io.File;

public class GerenciarPastas {
	//pasta onde o programa estara
	static String userDir=System.getProperty("user.dir");
	public String newfile(String name) {
		
		File pasta=new File(userDir,name);
		pasta.mkdirs();
		return userDir+"\\"+name;
	}

}
