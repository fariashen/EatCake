package eatcake.action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 实现显示上传到服务器的图片
 * @author vacation
 *
 */
public class ImgShowAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String path = null;

	HttpServletResponse response = ServletActionContext.getResponse();
	
	public void show() {
		try {
			path = new String(path.getBytes("ISO-8859-1"), "UTF-8");
			FileInputStream in = new FileInputStream(path);
			int size = in.available();
			byte data[]=new byte[size];
			in.read(data);
			response.setContentType("image/*");
			OutputStream out = response.getOutputStream();
			out.write(data);
			
			out.flush();
			out.close();
			in.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
	
	public void setPath(String path) {
		this.path = path;
	}


}
