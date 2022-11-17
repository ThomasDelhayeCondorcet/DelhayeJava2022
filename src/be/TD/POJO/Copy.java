package be.TD.POJO;

import java.io.Serializable;

public class Copy implements Serializable{
	
	private static final long serialVersionUID = -4587535549659348913L;
	private VideoGame videoGame;
	private Player owner;
	private Loan loan;
	
	public Copy(VideoGame videoGame, Player owner) {
		this.videoGame = videoGame;
		this.owner = owner;
	}

	public VideoGame getVideoGame() {
		return videoGame;
	}

	public void setVideoGame(VideoGame videoGame) {
		this.videoGame = videoGame;
	}

	public Player getOwner() {
		return owner;
	}

	public void setOwner(Player owner) {
		this.owner = owner;
	}

	public Loan getLoan() {
		return loan;
	}

	public void setLoan(Loan loan) {
		this.loan = loan;
	}

	
	public void ReleaseCopy() {
		
	}
	
	public void Borrow() {
		
	}
	
	public boolean IsAvailable() {
		return false;
	}
}
