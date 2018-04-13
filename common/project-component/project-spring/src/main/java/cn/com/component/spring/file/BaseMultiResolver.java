package cn.com.component.spring.file;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.web.multipart.MultipartException;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.util.WebUtils;

import java.util.List;

/**
 * 自定义文件上传
 * @author Boss
 *
 */
public class BaseMultiResolver extends CommonsMultipartResolver {

	private ProgressListener progressListener;

	public void setProgressListener(ProgressListener progressListener) {
		this.progressListener = progressListener;
	}

	@Override
	protected MultipartParsingResult parseRequest(HttpServletRequest request) throws MultipartException {
		String encoding=determineEncoding(request);
		FileUpload fileUpload = prepareFileUpload(encoding);
		//设置监听
		fileUpload.setProgressListener(progressListener);

		return super.parseRequest(request);
	}

	
	
    
}
