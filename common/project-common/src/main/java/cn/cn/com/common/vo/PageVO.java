package cn.cn.com.common.vo;

public class PageVO<T> extends BaseVO {

	private static final long serialVersionUID = 1L;
	private Page<?> page;
	private T param;
	public PageVO(){
		
	}
    public PageVO(Page<?> page,T param){
    	this.page=page;
    	this.param=param;
    }
	public <S> Page<S> getPage() {
		return (Page<S>) page;
	}

	public void setPage(Page<?> page) {
		this.page = page;
	}

	public T getParam() {
		return param;
	}

	public void setParam(T param) {
		this.param = param;
	}

}
