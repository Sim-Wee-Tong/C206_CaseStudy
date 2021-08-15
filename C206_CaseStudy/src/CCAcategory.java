public class CCAcategory {
	private String categoryName;
	private int categoryID;
	
	public CCAcategory(String categoryName, int categoryID) {
		this.categoryName = categoryName;
		this.categoryID = categoryID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public int getCategoryID() {
		return categoryID;
	}
}
