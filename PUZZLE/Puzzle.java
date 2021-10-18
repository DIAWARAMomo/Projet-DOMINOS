import javax.swing.JFrame;
import java.util.*;
import java.util.Collections;
public class Puzzle{
    protected Grille g;
    protected String pseudo;
    public Puzzle(){};
    public Puzzle(String p){
	this.pseudo=p;
	g=new Grille();
	initialisation();
    }

    public void initialisation(){
	LinkedList<Character>s=new LinkedList<Character>();
	int a=0;
	for (char c = 'A'; c <= 'Z'; c++) s.add(c);
	Collections.shuffle(s);
	for(int i=0;i<g.grilles.length;i++){
	    for(int j=0;j<g.grilles[i].length;j++){
		if(a>s.size()-1) g.grilles[i][j]='?';
		else{
		    g.grilles[i][j]=s.get(a);
		}
		a++;
	    }
	}
    }
        
    public void deplacer(char a){
	char x='?';
	for(int i=0;i<g.grilles.length;i++){
	    for(int j=0;j<g.grilles[i].length;j++){
		if(j!=g.grilles[i].length-1){
		    if(g.grilles[i][j]==a && g.grilles[i][j+1]==x){
			char temp=g.grilles[i][j];
			g.grilles[i][j]=g.grilles[i][j+1];
			g.grilles[i][j+1]=temp;
			return;
		    }
		}
		if(j!=0){
		    if(g.grilles[i][j]==a && g.grilles[i][j-1]==x){
			char temp=g.grilles[i][j];
			g.grilles[i][j]=g.grilles[i][j-1];
			g.grilles[i][j-1]=temp;
			return;
		    }
		}
		if(i!=g.grilles.length-1){
		    if(g.grilles[i][j]==a && g.grilles[i+1][j]==x){
		  	char temp=g.grilles[i][j];
			g.grilles[i][j]=g.grilles[i+1][j];
			g.grilles[i+1][j]=temp;
			return;
		    }
		}
		if(i!=0){
		    if( i!=0 && g.grilles[i][j]==a && g.grilles[i-1][j]==x){
			char temp=g.grilles[i][j];
			g.grilles[i][j]=g.grilles[i-1][j];
			g.grilles[i-1][j]=temp;
			return;
		    }
		}
	    }
	}
	System.out.println("this character is not movable ");
    }
    public boolean terminer(){
	LinkedList<Character>s=new LinkedList<Character>();	
     	for (char c = 'A'; c <= 'Z'; c++) s.add(c);
     	s.add('?');
     	s.add('?');
	String p="";
     	for(int i=0;i<g.grilles.length;i++){
     	    for(int j=0;j<g.grilles[i].length;j++){
		p+=g.grilles[i][j];
     	    }
     	}
	for(int i=0;i<s.size();i++){
	    if(s.get(i)!=p.charAt(i)) return false;
	}
     	return true;
    }
    public void commencer(){
	LinkedList<Character>s=new LinkedList<Character>();	
     	for (char c = 'A'; c <= 'Z'; c++) s.add(c);
	Scanner sc=new Scanner(System.in);
	System.out.println(" choisissez un pseudo ");
	String choix=sc.nextLine();
	Puzzle p=new Puzzle(choix);
	System.out.println( " le jeu est commencer \n         voici le plateau : " );
	p.g.afficher();
	while(!p.terminer()){
	    System.out.println(" veillez choisir le Charactère a deplacer ");
	    sc=new Scanner(System.in);
	    choix=sc.nextLine();
	    char choix2 = choix.charAt(0);
	    if(!s.contains(choix2)){
		System.out.println("ce choix n'est pas valable fait un choisissez un Charactère dans le puzzle ");
		sc=new Scanner(System.in);
		choix=sc.nextLine();
		 choix2 = choix.charAt(0);
	    }
	    p.deplacer(choix2);
	    p.g.afficher();
	}
	System.out.println(" felicitations vous avez gagner la partie " );
    }
    public static void main(String[]args){
	Puzzle p= new Puzzle();
	p.commencer();
	
	

    }
}
