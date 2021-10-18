public class Gommette{
    protected String forme;
    protected String couleur;
    public Gommette(String f,String c){
	this.forme=f;
	this.couleur=c;
    }
    public void changerCoté(){
	String temp = forme;
	forme=couleur;
	couleur=temp;
    }
 public String toString(){
      return"[ "+this.forme+" | "+this.couleur+" ]"; 
	}  
    public String getForme(){return this.forme;}
     public String getCouleur(){return this.couleur;}

 public static void main(String[]args){
	Gommette g= new Gommette("carré","blanc");
	System.out.println(g.toString());
	g.changerCoté();
	System.out.println(g.toString());
    }
    
}
