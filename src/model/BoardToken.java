package model;

public enum BoardToken {
	PLAYERONETOKEN ("X"),  
	PLAYERTWOTOKEN ("O"), 
	EMPTYSLOTTOKEN ("."); 


	private final String _boardToken;

	BoardToken(String boardToken) {
		this._boardToken = boardToken;
	}

	public String getBoardToken() {
		return this._boardToken;
	}

}