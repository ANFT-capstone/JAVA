package DataVo;

import java.sql.Timestamp;

public class NftCategoryVo {
	public String category;
	public Timestamp createDate;
	public String createUser;
	public int NftNums;
	public int categoryNumber;
	
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
	public String getCreateUser() {
		return createUser;
	}
	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}
	public int getNftNums() {
		return NftNums;
	}
	public void setNftNums(int nftNums) {
		NftNums = nftNums;
	}
	public int getCategoryNumber() {
		return categoryNumber;
	}
	public void setCategoryNumber(int categoryNumber) {
		this.categoryNumber = categoryNumber;
	}
}
