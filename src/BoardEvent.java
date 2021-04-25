import java.util.EventListener;
import java.util.EventObject;

@SuppressWarnings("serial")
public class BoardEvent extends EventObject
{
	CellObject object;
	
	public BoardEvent(Object cellObject)
	{
		super(cellObject);
		if (source instanceof CellObject)
			this.object = (CellObject)cellObject;
	}
	
	public CellObject getObject() {
		return this.object;
	}
}

 interface BoardEventListener extends EventListener
 {
	 public void boardEventOccurred(BoardEvent evt);
 }