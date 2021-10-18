import java.util.*;
public class CheminMine extends Mine{
	protected boolean est ;
	protected boolean ouest ;
	protected boolean nord;
	protected boolean sud ;
    boolean[] tab= {true,true,true,false,false};
    public CheminMine(String nom){
	super(nom);
	if(nom=="Depart   "){
	    est=true;
	    ouest=true;
	    nord=true;
	    sud=true;
	}
	else{
	    Random x= new Random();	
	    int a= x.nextInt(5);
	    int b= x.nextInt(5);
	    int c= x.nextInt(5);
	    int d= x.nextInt(5);
	    est=tab[a];
	    ouest=tab[b];
	    nord=tab[c] ;
	    sud=tab[d];
	}
    }
     public String toString(){
	 String s="";
	 if(ouest==true)s+="derrier,";
	 if(nord==true)s+="gauche,";
	 if(sud==true)s+="droite,";
	 if(est==true)s+="devant,";
	 return s;	 
     }
    
   public static void main(String[]args){
	CheminMine c1 = new CheminMine("chem1");
	System.out.println(c1.est);
	System.out.println(c1.nord);
	System.out.println(c1.ouest);
	System.out.println(c1.sud);
    }
}
