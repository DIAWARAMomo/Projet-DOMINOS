import java.util.LinkedList;
import java.util.*;
public abstract class JoueurG{
    protected String pseudo;
    protected LinkedList<Gommette> mesg;
    protected int score;
    public JoueurG(String nom){
	this.pseudo=nom;
	mesg= new LinkedList<Gommette>();
	score=0;
    }
    public JoueurG(){
	this.pseudo="inconnu";
	mesg= new LinkedList<Gommette>();
	score=0;
    }
    public void setPseudo(String n){this.pseudo=n;}
    public void setMesg(LinkedList<Gommette>m){mesg=m;}
    public void AfficherGommette(){
	System.out.println(this.pseudo);
	if(mesg.size()==0) {
	    System.out.println("pas de Gommette");
	    return ;
	}
	
	Iterator i = mesg.iterator();
	while(i.hasNext()){
	    Gommette x = (Gommette)i.next();
	    System.out.println(x+"-");
	}
    }
    public int compterGommette(){
	 return mesg.size();
     }
    
}
