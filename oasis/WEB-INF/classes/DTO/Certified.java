package DTO;

public class Certified {
	private int idx;
	//인증 번호
	private String certified_num;
	private String member_email;
	private String wrdate;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getCertified_num() {
		return certified_num;
	}
	public void setCertified_num(String certified_num) {
		this.certified_num = certified_num;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public String getWrdate() {
		return wrdate;
	}
	public void setWrdate(String wrdate) {
		this.wrdate = wrdate;
	}

}
