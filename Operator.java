import java.util.*;

import myPackage.Member;

public class Operator {
	
	public static void main(String[] args) {
		
		ArrayList<SmartPhone> list = new ArrayList<SmartPhone>();
		SmartPhone s = new SmartPhone();		
		list.add(s);
		
		FoldableSmartPhone fs= new FoldableSmartPhone();
		list.add(fs);
		
		GlassesPhone gf = new GlassesPhone();
		list.add(gf);
		
		for(int i=0; i < list.size(); i++) {
			SmartPhone x = list.get(i);
			x.display();
		}
		
	}	
	
	public static void printSmartPhoneName(SmartPhone s) { 
		System.out.println(s.os);
		if(s instanceof FoldableSmartPhone ) {
			FoldableSmartPhone f = (FoldableSmartPhone)s;	
			f.folding();
		}
	}
}
