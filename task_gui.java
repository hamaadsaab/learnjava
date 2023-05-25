import javax.swing.*;
public class task_gui{
    public static void main(String[] args){
       int total;
        // Scanner obj = new Scanner(System.in);
     String val1=  JOptionPane.showInputDialog("enter the val1");
        int num1=Integer.parseInt(val1);
         String val2=  JOptionPane.showInputDialog("enter the val2");
        int num2=Integer.parseInt(val2 );
         String val3=  JOptionPane.showInputDialog("enter the val3");
        int num3=Integer.parseInt( val3 );
        
         
    //     //  int val1 = obj.nextInt();
    //    String val2=  JOptionPane.showInputDialog("enter the val2");
    //     //  int val2 = obj.nextInt();
    //     String val3= JOptionPane.showInputDialog("enter the val3");
    //     //  int val3 = obj.nextInt();

        total = num1+num2+num3;
        JOptionPane.showMessageDialog(null, "total value is "+ total);
    }
}


// import javax.swing.*;

// public class task_gui{

//     public static void main(String[] args) {
//         //... Initialization
//         String degree, batch, section, id;

//         //... Prompt and read input.
//         degree = JOptionPane.showInputDialog("Please Enter degree");

//         batch = JOptionPane.showInputDialog("Please Enter batch");

// 	section = JOptionPane.showInputDialog("Please Enter section");

//         id = JOptionPane.showInputDialog("Please Enter ID");

//         //... Display output
//        JOptionPane.showMessageDialog(null, "Your Roll Number: " +degree+batch+section+id);
//     }
// }