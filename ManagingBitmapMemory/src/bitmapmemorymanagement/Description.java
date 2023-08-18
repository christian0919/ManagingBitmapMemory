package bitmapmemorymanagement;

public class Description {


	String decenas;
	String centenas;
	String unidades;

	public Description(String decenas, String centenas, String unidades) {
		this.decenas = decenas;
		this.centenas = centenas;
		this.unidades = unidades;
		PrepareStrings();
	}
	
	
	private void PrepareStrings(){
	
		for(int i = 0; i < 12 ; i++ ){
			this.unidades = this.unidades + " 0 1 2 3 4 5 6 7 8 9";
		}
		this.unidades = this.unidades + " 0 1 2 3 4 5 6 7";
		
		
		for(int i = 9; i > 0 ; i--){
			this.decenas = i +" "+i +" "+i +" "+i +" "+i +" "+i +" "+i +" "+i +" "+i +" "+i + " "+this.decenas;
		}
		this.decenas =" "+this.decenas+ "0 0 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 2 2 2 2 2 2 2 2";
		
		for(int i = 1; i <= 28 ; i++){
			this.centenas = this.centenas + " 1";
		}
	}
	
	public String GetHundreds(){
		return this.centenas;
	}
	public String GetUnits(){
		return this.unidades;
	}
	public String GetTeens(){
		return this.decenas;
	}
	
}
