package renomearparapje;

import java.io.File;
import java.util.Comparator;

public class Comparador implements Comparator<File> {
    
    @Override
    public int compare(File f1, File f2) {
        int num1, num2;
        num1 = retornaNumero(f1);
        num2 = retornaNumero(f2);
        if (num1 > num2) {
            return 1;
        }
        else {
            return -1;
        }
    }
    
    public int retornaNumero(File arq) {
        String num = "";
        for (int i = 0; i < arq.getName().length(); i++) {
            if (arq.getName().charAt(i) != '_') {
                num = num + arq.getName().charAt(i);
            }
            else {
                break;
            }
        }
        return Integer.parseInt(num);
    }
}
