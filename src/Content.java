import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


public class Content {

	private LinkedHashMap<String, String> attributes = new LinkedHashMap<String, String>();
	
	public void add(String key, String value) {
		attributes.put(key, value);
	}

	public void doIt(StringBuilder sb) {
		Set keySet = attributes.keySet();
		for (Object key : keySet){
			sb.append(" ");
			sb.append(key);
			sb.append("=");
			sb.append("\"");
			sb.append(attributes.get(key));
			sb.append("\"");
		}
		
	}

}
