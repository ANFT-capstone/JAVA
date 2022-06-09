package anft.demo.DataVo;

import java.sql.Timestamp;

public class RequestHistoryVo {
	public int requestId;
	public String requestUser;
	public int requestFunction;
	public Timestamp requestDate;
	public String parameters;
	public char result;
	
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public String getRequestUser() {
		return requestUser;
	}
	public void setRequestUser(String requestUser) {
		this.requestUser = requestUser;
	}
	public int getRequestFunction() {
		return requestFunction;
	}
	public void setRequestFunction(int requestFunction) {
		this.requestFunction = requestFunction;
	}
	public Timestamp getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(Timestamp requestDate) {
		this.requestDate = requestDate;
	}
	public String getParameters() {
		return parameters;
	}
	public void setParameters(String parameters) {
		this.parameters = parameters;
	}
	public char getResult() {
		return result;
	}
	public void setResult(char result) {
		this.result = result;
	}
}
