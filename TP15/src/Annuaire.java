import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class Annuaire {
	private HashMap<String, String> map;
	
	public Annuaire() {
		
		this.map = new HashMap<String, String>();
	}


	public void enregistrerArrivee(String string, String string2) {
		this.map.put(string, string2);
	}

	public Object bureau(String string) {
		return this.map.get(string);
		
	}

	public void modifierBureau(String string, String string2) {
		this.map.replace(string, string2);
		
	}

	public Collection<String> personnels(String string) {
		return null;
	}

	public Collection<String> bureaux() {
		
		return new HashSet<>(this.map.values());
	}

	public void enregistrerDepart(String string) {
		this.map.remove(string);
		
	}

	public Collection<String> personnels() {
		return this.map.keySet();
		
	}

	public HashMap<String,List<String>> occupationBureaux() {
		HashMap<String,List<String>> inversed = new HashMap<>();
		for (HashMap.Entry<String,String> entry : this.map.entrySet()) {
			if (!inversed.containsKey(entry.getValue())){
				inversed.put(entry.getValue(), new ArrayList<>());
			}
			inversed.get(entry.getValue()).add(entry.getKey());	
		}
		
		return inversed;
		
	}



}
