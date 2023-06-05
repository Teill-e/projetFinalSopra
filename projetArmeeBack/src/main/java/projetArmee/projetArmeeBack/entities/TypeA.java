package projetArmee.projetArmeeBack.entities;

public enum TypeA {
//@JsonProperty("fusil_dassaut")
fusil_dassaut(10,10),
//@JsonProperty("mitraillette")
mitraillette(15,15),
//@JsonProperty("fusil_de_precision")
fusil_de_precision(5,5),
pistolet(5,5),pierrier(5,5),grenade(10,10),roquette(20,20),couteau(5,5),mine(10,10);
	
	private int prix;
	private int degat;

	private TypeA(int prix, int degat) {
		this.prix = prix;
		this.degat = degat;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public int getDegat() {
		return degat;
	}

	public void setDegat(int degat) {
		this.degat = degat;
	} 
}
