package model;

public enum GameEnum {
	PLAYERONETOKEN ("X"),  
	PLAYERTWOTOKEN ("O"), 
	EMPTYSLOTTOKEN ("."); 


	private final String _boardToken;

	GameEnum(String boardToken) {
		this._boardToken = boardToken;
	}

	public String getBoardToken() {
		return this._boardToken;
	}

}