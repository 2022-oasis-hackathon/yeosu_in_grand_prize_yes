package DTO;

public class Oasis_chatroom {
	private int idx;
	private String chat;
	private String wrdate;
	private int reservation_idx;
	private String member_email;
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getChat() {
		return chat;
	}
	public void setChat(String chat) {
		this.chat = chat;
	}
	public String getWrdate() {
		return wrdate;
	}
	public void setWrdate(String wrdate) {
		this.wrdate = wrdate;
	}
	public int getReservation_idx() {
		return reservation_idx;
	}
	public void setReservation_idx(int reservation_idx) {
		this.reservation_idx = reservation_idx;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
}
