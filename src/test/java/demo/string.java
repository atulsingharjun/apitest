package demo;

public class string {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="hello";
		String rev ="";
		  for (int i = s.length() - 1; i >= 1; i--) {
	            rev = rev + s.charAt(i); 
	        }
		 // System.out.println(rev);
		  
		  rev = "h" + rev.substring(0); 
		  System.out.println(rev);
	}

}
