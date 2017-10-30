import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

import com.gmtx.shebao_yzw.tool.PropUtil;


public class text {

	public static void main(String[] args) throws URISyntaxException, IOException {
		// TODO Auto-generated method stub
		//路径的几种方式,注意this不能再静态方法中用
		//ClassLoader.getSystemResource();
		//this.getClass.getClassLoader().getResource();  
		//this.getClass.getResource();
		//new File("").getAbsolutePath());
		URL url = ClassLoader.getSystemResource("webServiceURL.properties");
		PropUtil pUtil = new PropUtil(url);
		String resultString = pUtil.getPro("brURL");
		System.out.println(resultString);
	}

}
