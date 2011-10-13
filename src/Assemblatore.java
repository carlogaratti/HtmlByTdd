
public class Assemblatore {
	
	protected StringBuilder sb;
	private Persist persist;
	private Closer closer;
	private Content content;
	
	public Assemblatore(Persist persist, Closer closer, Content content) {
		this.persist = persist;
		this.closer  = closer;
		this.content = content;
		sb = new StringBuilder();
	}

	public void doName(String name) {
		sb.append(name);
	}

	public void encloseTag() {
		closer.doIt(sb);
	}

	public String write(){
		persist.doIt(sb);
		return sb.toString();
	}

	public void doAttribute() {
		content.doIt(sb);
		
	}
	
	

}
