import java.util.*;
public class CarteDarriver extends CheminMine{
    protected  boolean gauche;
    protected boolean droite;
    boolean[] tab= {true,true,true,false,false};
      public CarteDarriver(String nom){
	super(nom);
	 Random x= new Random(5);	
	    int a= x.nextInt(5);
	    int b= x.nextInt(5);
	this.gauche=tab[a];
	this.droite=tab[b];

    }

  
}
