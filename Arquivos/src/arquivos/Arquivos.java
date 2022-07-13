
package arquivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Arquivos {

  
    public static void main(String[] args) {
       Scanner arquivo;
       String nome="Dr"; 
       String nome_arquivo1="nomes1.txt";
       
        try {
            arquivo=new Scanner(new File(nome_arquivo1));
            int numero_linha=1;
            while (arquivo.hasNextLine())
            {
                String linha=arquivo.nextLine();
                if (linha.contains(nome))
                {
                    System.out.println(nome_arquivo1+"-"+linha+"-"+numero_linha);
                }  
                numero_linha++;
            }
            
            
        } catch (FileNotFoundException ex) {
            System.out.println("ERRO de arquivo");
        }
        
        
        
        
        
    }
    
}
