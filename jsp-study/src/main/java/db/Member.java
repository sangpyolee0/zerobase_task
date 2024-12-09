package db;

import java.util.Date;

public class Member {

    private String memberType;
    private String userId;
    private String name;
    private String password;
    
    private String mobileNo;
    private boolean marketingYN;
    private Date registerDate;

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public boolean isMarketingYN() {
		return marketingYN;
	}

	public void setMarketingYN(boolean marketingYN) {
		this.marketingYN = marketingYN;
	}

	public Date getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
    
    
}
