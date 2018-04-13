package cn.cn.com.common.vo;
/**
 * 树形节点
 *
 */
public class TreeVO extends BaseVO {

	private static final long serialVersionUID = 1L;
    private String id;//节点ID
    private String pId;//上级节点ID;
    private String name;//节点名称
    private boolean isOpen;//是否折叠
    public TreeVO(String pId,String name,boolean isOpen){
    	this.pId = pId;
    	this.name = name;
    	this.isOpen = isOpen;
    }
    public TreeVO(String id,String pId,String name,boolean isOpen){
    	this.id = id;
    	this.pId = pId;
    	this.name = name;
    	this.isOpen = isOpen;
    }
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getpId() {
		return pId;
	}
	public void setpId(String pId) {
		this.pId = pId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isOpen() {
		return isOpen;
	}
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
    
}
