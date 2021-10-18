public class Domino {
   private  int m1; // marque 1
   private  int m2; // marque 2
  
    public Domino(int vm1, int vm2) {
	this.m1 = vm1;
	this.m2 = vm2;
    }
    public int getM1(){return this.m1;}
    public int getM2(){return this.m2;}
    
   public boolean estDouble(){
       if( this.m1==this.m2){
	   // System.out.println("le Domino ("+ this.m1 +"," +this.m2 +")" + " est double");
	   return true;}
       else{
	   // System.out.println ("le Domino ("+ this.m1 +"," +this.m2 +")" + " n'est pas double");
	   return false;}
    }
    public int valeur(){
	// System.out.println("le domino (" + this.m1 +"," + this.m2 +")" + " a une valeur " + (m1+m2));
	return (m1+m2);
    }
    public void changerCoté(){
	int temp = m1;
	m1=m2;
	m2=temp;
    }
    public String toString(){
      return"[ "+this.m1+" | "+this.m2+" ]"; 
	}  
    
  
    public static void main(String[]args){
	Domino d= new Domino(1,2);
	System.out.println(d.toString());
	d.valeur();
	d.estDouble();
    }
}
