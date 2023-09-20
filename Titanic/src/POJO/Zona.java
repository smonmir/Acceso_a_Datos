package POJO;

public enum Zona {

	PROA(1,2,3), POPA(4,5,6), BABOR(7,8,9), ESTRIBOR(10,11,12);
	
	private int escalera1, escalera2, escalera3;
	
	
	Zona (int escalera1, int escalera2, int escalera3) {
		this.escalera1 = escalera1;
		this.escalera2 = escalera2;
		this.escalera3 = escalera3;
	}


	public int getEscalera1() {
		return escalera1;
	}

	public int getEscalera2() {
		return escalera2;
	}

	public int getEscalera3() {
		return escalera3;
	}

	
}
