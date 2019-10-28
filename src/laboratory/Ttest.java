package laboratory;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class Ttest {
	public static void abc(String a){
		System.out.println(a);
	}
	public static void abc(int b){
		System.out.println(b);
	}

	public static void main(String[] args) {
		abc(1);
		abc("faf");
	}
}
