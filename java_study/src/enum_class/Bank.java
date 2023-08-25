package enum_class;

public enum Bank {
	IBK_BC("3K", "기업비씨", "IBK_BC"),
	GWANGJUBANK("46", "광주", "GWANGJUBANK"),
	LOTTE("71", "롯데", "LOTTE"),
	KDBBANK("30", "산업", "KDBBANK"),
	BC("31", "-", "BC"),
	SAMSUNG("51", "삼성", "SAMSUNG");
	
	private String bankCode;
	private String bankNameWithKR;
	private String bankNameWithEN;
	
	Bank(String bankCode, String bankNameWithKR, String bankNameWithEN) {
		this.bankCode = bankCode;
		this.bankNameWithKR = bankNameWithKR;
		this.bankNameWithEN = bankNameWithEN;
	}
	
	public String getBankCode() {
		return bankCode;
	}
	
	public String getBankNameWithKR() {
		return bankNameWithKR;
	}
	
	public String getBankNameWithEN() {
		return bankNameWithEN;
	}
}
