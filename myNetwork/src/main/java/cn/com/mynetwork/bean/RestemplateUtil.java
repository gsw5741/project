package cn.com.mynetwork.bean;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.alibaba.druid.sql.visitor.functions.Char;

public class RestemplateUtil {
	private int a = 8;
	private String s = "";
	static Integer as = 150;
	static Integer ds = 150;
    public int getA() {
		return a;
	}
    public RestemplateUtil(){}
    public RestemplateUtil(String s){
    	
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
	public static void f2(byte x){
		System.out.println(x);
	}
	public static void f2(char x){
		System.out.println(x);
	}
    public  static void f1(double x){
    	System.out.println(x);
    }
   
    public static void f4(RestemplateUtil rs){
    	rs.setA(10);
    }
	public static void main(String... args) {
		f1('x');
	}
	
	public final String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
}
