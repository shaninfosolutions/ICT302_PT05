package pt05.com.sg.data.dto;

public class NotiRuleScoreCard {
	
	private Long bestScore;
	
	private Long worstScore;
	
	

	public NotiRuleScoreCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public NotiRuleScoreCard(Long bestScore, Long worstScore) {
		super();
		this.bestScore = bestScore;
		this.worstScore = worstScore;
	}



	public Long getBestScore() {
		return bestScore;
	}

	public void setBestScore(Long bestScore) {
		this.bestScore = bestScore;
	}

	public Long getWorstScore() {
		return worstScore;
	}

	public void setWorstScore(Long worstScore) {
		this.worstScore = worstScore;
	}
	
	

}
