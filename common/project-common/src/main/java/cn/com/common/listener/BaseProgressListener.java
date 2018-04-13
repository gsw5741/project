package cn.com.common.listener;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;
/**
 * 上传进度监听器
 * @author Boss
 *
 */
public class BaseProgressListener implements ProgressListener {
    private HttpSession session;
    public BaseProgressListener(HttpSession session){
    	this.session=session;
    }
    /**
     * pBytesRead已上传
     * pContentLength 上传总大小
     */
	@Override
	public void update(long pBytesRead, long pContentLength, int pItems) {
		session.setAttribute("progress", (double)pBytesRead/pContentLength);

	}

}
