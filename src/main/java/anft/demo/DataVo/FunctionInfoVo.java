package anft.demo.DataVo;

public class FunctionInfoVo {
	public String functionLabel;
	public int functionID;
	public String parameterList;
	public String httpUrl;
	
	public String getFunctionLabel() {
		return functionLabel;
	}
	public void setFunctionLabel(String functionLabel) {
		this.functionLabel = functionLabel;
	}
	public int getFunctionID() {
		return functionID;
	}
	public void setFunctionID(int functionID) {
		this.functionID = functionID;
	}
	public String getParameterList() {
		return parameterList;
	}
	public void setParameterList(String parameterList) {
		this.parameterList = parameterList;
	}
	public String getHttpUrl() {
		return httpUrl;
	}
	public void setHttpUrl(String httpUrl) {
		this.httpUrl = httpUrl;
	}
}
