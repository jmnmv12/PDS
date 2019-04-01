
package aula02.T1.pratica1.versao1;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;



/**
 *
 * @author andre 89334
 */

public class sopaDeLetras {
    
    //estruturas de dados
    public static  List<String> words = new ArrayList<>();
    public  static List<String> puzzle = new ArrayList<>();
    public static List<String> contents = null;
   
    
    
   
    
    public static Boolean checkSize(List<String> file){
        int dimension=file.get(0).length();
        int i;
        boolean check;
        for (i=0; i<dimension && file.get(i).length() == dimension && dimension<=60 ;i++){
            check=true;
            for (int j=0 ; j<file.get(i).length() ; j++){
                if (Character.isLowerCase(file.get(i).charAt(j))){
                    check = false;
                    break;
                }
              }
            if(check){
            puzzle.add(file.get(i));
            check=true;
            }
        }
        
        if (puzzle.size()==dimension){
            for (i = dimension; i<file.size();i++ ){
                String listWords[] = file.get(i).split( "[\\s,;]+");
                for (String solution : listWords)
                    words.add(solution);
            }
            return true;
        }else {
            System.out.println("Puzzle não tem tamanho quadrático!");
            return false;
        }
         
                
    }
    
    public static Boolean checkAlphabetical (List<String> solutionWords){
            Boolean onlyLetters=true;
            for (String letter : solutionWords){
                for (int i = 0; i<letter.length() ; i++){
                    if (Character.isDigit(letter.charAt(i))){
                        onlyLetters=false;
                        System.out.println("Solução de palavras contém números!");
                                }
                }
            }
            
            return onlyLetters;
    } 
    
    public static Boolean checkSizeWordPuzzle(List <String> solutionWords){
        Boolean checkSize = true;
        
        for (String word : solutionWords){
            if( word.length()<3 ){
                checkSize=false;
                System.out.println("Palavras solução com tamanho menor que 3 letras!");
            }
        }
        
        return checkSize;
    }
    
    public static Boolean checkRedundancy(List<String> solutionWords){
        Boolean checkRed = true;
        for (int i = 0; i<solutionWords.size() ; i++){
            for (int j = 0; j<solutionWords.size(); j++){
                if (solutionWords.get(i).contains(solutionWords.get(j)) && i!=j)
                    checkRed = false;
                    break;
            }
            if(!checkRed){
                System.out.println("Solução de palavras tem redundância!");
                break;
            }
                
        }
            return checkRed;
    }

    public static void main(String[] args) {
   
        Path file=Paths.get("sdl_04.txt");
        try{
            contents = Files.readAllLines(file);
            if (checkSize(contents) && checkAlphabetical(words) && checkSizeWordPuzzle(words) && checkRedundancy(words) ){
                System.out.println("Aprovado!");
            }
            
        }catch(IOException ex){
                ex.printStackTrace();
        }
      
        /*
        Solution 
        */
        
        WSSolver bot = new WSSolver (puzzle , words );
        bot.findWordsHV();
        bot.showSolution();
        
      
      
     
        
        
    
    }
}
