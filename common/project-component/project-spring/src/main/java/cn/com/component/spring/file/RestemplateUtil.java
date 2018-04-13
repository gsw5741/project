package cn.com.component.spring.file;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class RestemplateUtil {
	private int a = 8;
	private String s = "";
	
    public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public String getS() {
		return s;
	}

	public void setS(String s) {
		this.s = s;
	}

	public static void main(String[] args) {
		Integer a = new Integer(15);
		Integer b = 15;
		Byte byte1 = 125;
		Byte byte2 = 125;
		Integer c = new Integer(15);
		System.out.println(byte1==byte2);
		System.out.println(a==b);
		System.out.println(a==c);
		System.out.println(a.intValue()==c);
		System.out.println(a.equals(b));
		System.out.println(a.equals(c));
	}
}
