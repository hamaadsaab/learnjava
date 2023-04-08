class lab01{
    public static void main(String[] args){
       double item1= 12.95;
       double item2= 24.95;
       double item3= 6.95;
       double item4= 4.95;
       double item5= 3.95;

    //    double arr[]={12.95,24.95,12.4,4,5.6};
       double subtotal=0;
       double salestax=0.06;
       double sales;

    //    for(int i=0;i<5;i++){
    //        System.out.println(arr[i]);
    //        subtotal = subtotal+arr[i];
    //       sales= 
           
    //    }

      System.out.println("price of item one: "+item1);
      System.out.println("price of item two: "+item2);
      System.out.println("price of item thre: "+item3);
      System.out.println("price of item four: "+item4);
      System.out.println("price of item five: "+item5);

  subtotal= item1+item2+item3+item4+item4;
  System.out.println("subtotal of the items is: "+ subtotal);

      System.out.println("amount of sales tax of item1 is :"+ salestax*item1);
      System.out.println("amount of sales tax of item2 is :"+ salestax*item2);
      System.out.println("amount of sales tax of item3 is :"+ salestax*item3);
      System.out.println("amount of sales tax of item4 is :"+ salestax*item4);
      System.out.println("amount of sales tax of item5 is :"+ salestax*item5);

     double totalsalestax= salestax*subtotal;
     System.out.println("total sales tax is : "+ totalsalestax);



    }
}