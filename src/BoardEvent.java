import java.util.EventListener;
import java.util.EventObject;

@SuppressWarnings("serial")
public class BoardEvent extends EventObject
{
	int value;
	
	public BoardEvent(Object source)
	{
		super(source);
		if (source instanceof Integer)
			this.value = (int)source;
	}
	
	public int getValue() {
		return this.value;
	}
}

 interface BoardEventListener extends EventListener
 {
	 public void boardEventOccurred(BoardEvent evt);
 }