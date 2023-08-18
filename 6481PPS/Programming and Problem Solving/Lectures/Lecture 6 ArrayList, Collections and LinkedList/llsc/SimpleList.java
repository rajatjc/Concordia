// SimpleList.java
//
// An interface that defines the method that must be implmemented by any
// class that serves as a list

public interface SimpleList {

	public int getSize();
	
	public Object getObjectAt(int index);
	
	public void setObjectAt(int index, Object thing);
	
	public void insertObjectAt(int index, Object thing);
	
	public void deleteObjectAt(int index);
	
	public void append(Object thing);

}
