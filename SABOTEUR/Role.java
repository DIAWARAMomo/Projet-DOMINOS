public class Role extends Carte{
    protected String role;
    public Role(String r){
	super(r);
	if(r == "Mineur" || r == "Saboteur"){
	    this.role = r;
	} else {
	    this.role = "Mineur";
	}
    }
    public Role(){
	super("Mineur");
	this.role = "Mineur";
    }
    public boolean EstMiner(){
	return (this.role == "Mineur");
    }
    public boolean EstSaboteur(){
	return (this.role == "Saboteur");
    }
    public String toString(){
	return "Role: "+this.role;
    }
    
}
