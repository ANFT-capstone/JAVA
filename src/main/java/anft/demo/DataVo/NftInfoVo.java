package anft.demo.DataVo;

import java.sql.Timestamp;

public class NftInfoVo {
	public String nftNumber;
	public String label;
	public String category;
	public Timestamp createDate;
	public int price;
	public String uri;
	public char is_sell;
	public String createUser;
	
	public String getNftNumber() {
		return nftNumber;
	}
	public void setNftNumber(String nftNumber) {
		this.nftNumber = nftNumber;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Timestamp getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	public char getIs_sell() {
		return is_sell;
	}
	public void setIs_sell(char is_sell) {
		this.is_sell = is_sell;
	}
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	
}
