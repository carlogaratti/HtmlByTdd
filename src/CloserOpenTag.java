
public class CloserOpenTag extends Closer {
	
	@Override
	public void doIt(StringBuilder sb) {
		sb.insert(0, "<");
		sb.append(">");
	}
}
