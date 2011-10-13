
public class RunnableHTMLCirillo {
	public static void main(String[] args) {
		Persist persist = new Persist();
		Closer closer = new CloserOpenTag();
		Content content  = new Content();
		
		Assemblatore assemblatore = new Assemblatore(persist, closer, content);
		assemblatore.doName("!DOCTYPE html");
		assemblatore.doAttribute();
		assemblatore.encloseTag();
		assemblatore.write();
		
		content.add("lang", "en");
		Assemblatore assemblatore1 = new Assemblatore(persist, closer, content);
		assemblatore1.doName("html");
		assemblatore1.doAttribute();
		assemblatore1.encloseTag();
		assemblatore1.write();
	}
}
