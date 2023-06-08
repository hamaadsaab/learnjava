package Inheritance;

  class Print1{
	
	 void showparent(){
	System.out.println("This is the Parent class");
	 }
} 

 class Print2 extends Print1{
	 void showchild(){
	System.out.println("This is the Parent class");
	 }
}

public class Print_Parent{
	 public static void main(String[] args){
		  Print1 obj = new Print1();
		  obj.showparent();
		  
		  Print2 obj2 = new Print2();
		  obj2.showchild();
		  
		  obj2.showparent();
		  }
	
}