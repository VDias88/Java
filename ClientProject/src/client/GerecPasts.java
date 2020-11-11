package client;

import java.io.File;

public class GerecPasts {
	//pasta onde o programa estara
		static String userDir=System.getProperty("user.dir");
		public String newfile(String name) {
			File pasta=new File(userDir+"\\"+"databank",name);
			pasta.mkdirs();
			return userDir+"\\"+name;
		}
}
