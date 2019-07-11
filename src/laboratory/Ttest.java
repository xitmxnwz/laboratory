package laboratory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class Ttest {
		public static String a =new String("123");
		public static String b =new String("[0-9][0-9][0-9]");
		
		
	    public  void doTest(){
	    	Pattern pattern = Pattern.compile(b);
	    	Matcher matcher = pattern.matcher(a);
	    	while(matcher.find()) {
	    		System.out.println(matcher.group());
	    	}
	    }  
	    
	    @Test
		public void abc() {
	    	String b=new StringBuilder("fwfewf").toString();
//	    	String c=new String("123");
//	    	String d= b.intern();
	    	System.out.println(b.intern()==b);
	    }
		
}
