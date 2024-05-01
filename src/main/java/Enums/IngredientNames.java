package Enums;

public enum IngredientNames {
	SPAGETTI("Spagetti"),
	MEATBALL("Meatball"),
	SAUCE("Sauce"),
	BREADSTICK("Breadstick"),
	SALAD("Salad"),
	MOZZARELLA("Mozzarella");
	
	private final String displayName;
	
	IngredientNames(String displayName) {
		this.displayName = displayName;
	}
	
	public String getDisplayName() {
		return displayName;
	}
}
