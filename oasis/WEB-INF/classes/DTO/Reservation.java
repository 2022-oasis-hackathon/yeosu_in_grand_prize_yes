package DTO;

//예약
public class Reservation {
	private int idx;
	//시작시간
	private String start_time;
	//종료시간
	private String end_time;
	//상태
	private String status;
	//종료예정시간
	private String estimate_time;
	//주문자 인덱스
	private String member_email;
	//픽업자 인덱스
	private String pickup_member_email;
	//수고비
	private int reward;
	//출발지
	private String departure;
	//도착지
	private String destination;
	//이동수단
	private String mobility;
	//요청사항
	private String requested;
	//물품 항목
	private String text;
	//평가
	private int score;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEstimate_time() {
		return estimate_time;
	}
	public void setEstimate_time(String estimate_time) {
		this.estimate_time = estimate_time;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public String getPickup_member_email() {
		return pickup_member_email;
	}
	public void setPickup_member_email(String pickup_member_email) {
		this.pickup_member_email = pickup_member_email;
	}
	public int getReward() {
		return reward;
	}
	public void setReward(int reward) {
		this.reward = reward;
	}
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getMobility() {
		return mobility;
	}
	public void setMobility(String mobility) {
		this.mobility = mobility;
	}
	public String getRequested() {
		return requested;
	}
	public void setRequested(String requested) {
		this.requested = requested;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

}
