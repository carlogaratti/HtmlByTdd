import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;


public class TestHTMLCirillo {
	
	private Assemblatore assemblatore;
	Persist persist; 
	Closer closer;
	Content content;

	@Before
	public void init(){
		persist = new Persist();
		closer = new CloserOpenTag();
		content  = new Content();
	}
	
	@Test
	public void DocTypehtmlTag(){
		Assemblatore assemblatore = new Assemblatore(persist, closer, content);
		assemblatore.doName("!DOCTYPE html");
		assemblatore.doAttribute();
		assemblatore.encloseTag();
		assertEquals("<!DOCTYPE html>", assemblatore.write());
	}
	
	
	@Test
	public void htmlTag(){
		content.add("lang", "en");
		Assemblatore assemblatore = new Assemblatore(persist, closer, content);
		assemblatore.doName("html");
		assemblatore.doAttribute();
		assemblatore.encloseTag();
		assertEquals("<html lang=\"en\">", assemblatore.write());
	}
	
	@Test
	public void headTag(){
		Assemblatore assemblatore = new Assemblatore(persist, closer, content);
		assemblatore.doName("head");
		assemblatore.doAttribute();
		assemblatore.encloseTag();
		assertEquals("<head>", assemblatore.write());
	}
	
	@Test
	public void openCloseMetaTag(){
		closer = new CloserOnlySingleTag();
		content.add("charset", "utf-8");
		Assemblatore assemblatore = new Assemblatore(persist, closer, content);
		assemblatore.doName("meta");
		assemblatore.doAttribute();
		assemblatore.encloseTag();
		assertEquals("<meta charset=\"utf-8\"/>", assemblatore.write());
	}
	
	@Test
	public void titleTag(){
		Assemblatore assemblatore = new Assemblatore(persist, closer, content);
		assemblatore.doName("title");
		assemblatore.doAttribute();
		assemblatore.encloseTag();
		assertEquals("<title>", assemblatore.write());
	}
	
	@Test
	public void simpleElement(){
		Assemblatore assemblatore = new Assemblatore(persist, closer, content);
		assemblatore.doName("Smashing HTML5!");
		assemblatore.doAttribute();
		assertEquals("Smashing HTML5!", assemblatore.write());
		
	}
	
	@Test
	public void closedTitleTag(){
		closer = new CloserClosedTag();
		Assemblatore assemblatore = new Assemblatore(persist, closer, content);
		assemblatore.doName("title");
		assemblatore.doAttribute();
		assemblatore.encloseTag();
		assertEquals("</title>", assemblatore.write());
	}
	
	@Test
	public void closedHeadTag(){
		closer = new CloserClosedTag();
		Assemblatore assemblatore = new Assemblatore(persist, closer, content);
		assemblatore.doName("head");
		assemblatore.doAttribute();
		assemblatore.encloseTag();
		assertEquals("</head>", assemblatore.write());
	}
    
	@Test
	public void bodyTag(){
		content.add("id", "index");
		content.add("class", "home");
		Assemblatore assemblatore = new Assemblatore(persist, closer, content);
		assemblatore.doName("body");
		assemblatore.doAttribute();
		assemblatore.encloseTag();
		assertEquals("<body id=\"index\" class=\"home\">", assemblatore.write());
	}
	
	@Test
	public void formTag(){
		closer = new CloserOpenTag();
		content.add("action", "/html_5/tags/html_form_tag_action.cfm");
		content.add("method", "get");
		Assemblatore assemblatore = new Assemblatore(persist, closer, content);
		assemblatore.doName("form");
		assemblatore.doAttribute();
		assemblatore.encloseTag();
		assertEquals("<form action=\"/html_5/tags/html_form_tag_action.cfm\" method=\"get\">", assemblatore.write());
	}
	
	@Test
	public void simpleElement1(){
		Assemblatore assemblatore = new Assemblatore(persist, closer, content);
		assemblatore.doName("Username");
		assemblatore.doAttribute();
		assertEquals("Username", assemblatore.write());
		
	}
	
	@Test
	public void inputTagPassword(){
		closer = new CloserOnlySingleTag();
		content.add("type", "text");
		content.add("name", "username");
		content.add("value", "");
		content.add("maxlength", "100");
		Assemblatore assemblatore = new Assemblatore(persist, closer, content);
		assemblatore.doName("input");
		assemblatore.doAttribute();
		assemblatore.encloseTag();
		assertEquals("<input type=\"text\" name=\"username\" value=\"\" maxlength=\"100\"/>", assemblatore.write());
	}
	
	@Test
	public void brTag(){
		closer = new CloserClosedTag();
		Assemblatore assemblatore = new Assemblatore(persist, closer, content);
		assemblatore.doName("br");
		assemblatore.doAttribute();
		assemblatore.encloseTag();
		assertEquals("</br>", assemblatore.write());
	}

	@Test
	public void simpleElement2(){
		Assemblatore assemblatore = new Assemblatore(persist, closer, content);
		assemblatore.doName("Password");
		assemblatore.doAttribute();
		assertEquals("Password", assemblatore.write());
		
	}
	
	@Test
	public void inputTagUsername(){
		closer = new CloserOnlySingleTag();
		content.add("type", "password");
		content.add("name", "password");
		content.add("value", "");
		content.add("maxlength", "100");
		Assemblatore assemblatore = new Assemblatore(persist, closer, content);
		assemblatore.doName("input");
		assemblatore.doAttribute();
		assemblatore.encloseTag();
		assertEquals("<input type=\"password\" name=\"password\" value=\"\" maxlength=\"100\"/>", assemblatore.write());
	}
	
	@Test
	public void inputTagSubmit(){
		closer = new CloserOnlySingleTag();
		content.add("type", "submit");
		content.add("value", "Submit");
		Assemblatore assemblatore = new Assemblatore(persist, closer, content);
		assemblatore.doName("input");
		assemblatore.doAttribute();
		assemblatore.encloseTag();
		assertEquals("<input type=\"submit\" value=\"Submit\"/>", assemblatore.write());
	}
	
	
	@Test
	public void closedFormTag(){
		closer = new CloserClosedTag();
		Assemblatore assemblatore = new Assemblatore(persist, closer, content);
		assemblatore.doName("form");
		assemblatore.doAttribute();
		assemblatore.encloseTag();
		assertEquals("</form>", assemblatore.write());
	}
	
	@Test
	public void closedBodyTag(){
		closer = new CloserClosedTag();
		Assemblatore assemblatore = new Assemblatore(persist, closer, content);
		assemblatore.doName("body");
		assemblatore.doAttribute();
		assemblatore.encloseTag();
		assertEquals("</body>", assemblatore.write());
	}
	
	@Test
	public void closedHtmlTag(){
		closer = new CloserClosedTag();
		Assemblatore assemblatore = new Assemblatore(persist, closer, content);
		assemblatore.doName("html");
		assemblatore.doAttribute();
		assemblatore.encloseTag();
		assertEquals("</html>", assemblatore.write());
	}
	
}
