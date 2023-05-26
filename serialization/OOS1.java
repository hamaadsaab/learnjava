import java.io.*;

class Student implements Externalizable {
    int m_roll;
    String m_name;
    private int m_bankAcc;
    static int s_c = 10;

    public Student() {
    }

    Student(int i, String n, int acc) {
        this.m_roll = i;
        this.m_name = n;
        this.m_bankAcc = acc;
    }

    void print() {
        System.out.println(m_roll + " " + m_name + " " + m_bankAcc + " " + s_c);
    }

    @Override
    public void writeExternal(ObjectOutput o) throws IOException {
        o.writeInt(m_roll);
        o.writeObject("jshjhsd");
        o.writeInt(m_bankAcc);
        o.writeInt(s_c);
    }

    @Override
    public void readExternal(ObjectInput o) throws IOException, ClassNotFoundException {
        this.m_roll = o.readInt();
        this.m_name = (String) o.readObject();
        this.m_bankAcc = o.readInt();
        Student.s_c = o.readInt();
    }
}

public class OOS1 {
    public static void main(String[] args) {
        Student st1 = new Student(531, "Hamaad Gwhafar", 133817);

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        FileInputStream fis = null;
        ObjectInputStream ois = null;

        try {
            fos = new FileOutputStream("SOutput.txt");
            oos = new ObjectOutputStream(fos);

            oos.writeObject(st1);

            fis = new FileInputStream("SOutput.txt");
            ois = new ObjectInputStream(fis);

            Student rec = null;
            while ((fis.available() != 0)) {
                rec = (Student) ois.readObject();
                rec.print();
            }

        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex);
        } finally {
            try {
                oos.close();
                ois.close();
            } catch (IOException e) {
                System.out.println(e);
            }
        }
    }
}
