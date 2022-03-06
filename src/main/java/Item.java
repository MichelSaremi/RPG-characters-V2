import java.util.ArrayList;

public abstract class Item {
	
	//---attributes
	private String name;
	private int required_level;
	private ArrayList<String> character = new ArrayList<String>();
	
	//---constructors
	public Item(String name, int required_level, String[] character) {
		this.name = name;
		this.required_level = required_level;
		this.character.add(character[0]);
		this.character.add(character[1]);
		this.character.add(character[2]);
	}
	
	//---getters
	public String getName() {
		return name;
	}
	public int getRequired_level() {
		return required_level;
	}
	
	public ArrayList<String> getChar() {
		return character;
	}

}
