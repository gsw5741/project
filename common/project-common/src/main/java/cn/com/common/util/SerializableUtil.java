package cn.com.common.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializableUtil {
	//序列化
	public static byte[] serializable(Object obj) {
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream oos = null;
		byte[] rv = null;
		try {
			oos = new ObjectOutputStream(out);
			oos.writeObject(obj);
			return out.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			close(oos);
			close(out);
		}
		return rv;
	}
	//反序列化
    public static  <T> T deserializable(byte[] in,Class<T> c){
    	ByteArrayInputStream bis=new ByteArrayInputStream(in);
    	ObjectInputStream ois=null;
    	Object obj=null;
    	try {
    		ois=new ObjectInputStream(bis);
    		obj=ois.readObject();
		} catch (Exception e) {
			
			e.printStackTrace();
		}finally{
			close(ois);
			close(bis);
		}
    	return (T) obj;
    }
	public static void close(Closeable closeable) {
		if (!StringUtil.isEmpty(closeable)) {
			try {
				closeable.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
