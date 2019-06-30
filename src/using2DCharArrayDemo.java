import javax.swing.*;

public class using2DCharArrayDemo {
    public static void main(String[] args) {
        int[] size = {3,12,4,7};
        char[][] symbs = new char[size.length][];
        char s = 'A';
        String txt = "";
        for (int i = 0; i < symbs.length; i++) {
            symbs[i] = new char[size[i]];
            for (int j = 0; j < symbs[i].length; j++) {
                symbs[i][j] = s;
                s++;
                txt+= "| " + symbs[i][j] + " ";
            }
            txt+= "|\n";
        }
        JOptionPane.showMessageDialog(null,
                txt,
                "Массив со строками разной длины",
                JOptionPane.PLAIN_MESSAGE);
    }
}
