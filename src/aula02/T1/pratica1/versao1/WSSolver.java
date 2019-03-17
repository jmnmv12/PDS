

package aula02.T1.pratica1.versao1;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author andre 89334
 */
public class WSSolver {

    private List<String> words = new ArrayList<>();
    private List<String> puzzle = new ArrayList<>();
    private List<String> matriTransp= new ArrayList<>(); 
    private List <String> index = new ArrayList<>();
    private List <String> direct = new ArrayList<>();
    
    
    public WSSolver (List<String> puzzle, List<String> words){
        this.words = words;
        this.puzzle = puzzle;
    }
    
   /*
    Function transposed( matrix of Letters Soup  ) do the transposed matrix of Letter Soup for be easir to find the words on vertical
  */
    
    public void transposed(){
        
        int dimension = puzzle.size();        
                
        for(int i = 0; i<dimension ; i++){ 
            
            String wordTrans = "";
            
            for (String soupWord : puzzle ){
                wordTrans+=Character.toString(soupWord.charAt(i));
            }
            matriTransp.add(wordTrans);

        }
        
    }
    /*
    To find the letters in diagonal
    */
    
    public String searchDiagonal ( int line , int  row , String solutionWord){
        
        int i;
        int di = solutionWord.length();
        int max = puzzle.size();
        
        for (i = 1; i<di ; i++){
            
             if ( (line-i < 0 || row-i<0) || (solutionWord.charAt(i) != puzzle.get(line-i).charAt(row-i)))
                 break;              
        }
        
        if (i == di){
                 return "UpLeft";
             }
        
        for (i = 1; i<di ; i++){
            if ( (line+i >=max || row-i <0  ) || (solutionWord.charAt(i) != puzzle.get(line+i).charAt(row-i) ))
                break;               
        }
        
        if (i == di){
                 return "DownLeft";
             }
        
        for (i = 1; i<di ; i++){
            if ( (line-i<0 || row+i >= max  ) || (solutionWord.charAt(i) != puzzle.get(line-i).charAt(row+i) ))
                break;
           
                
        }
         if (i == di){
                 return "UpRigth";
             }
        
         for (i = 1; i<di ; i++){
            if ( (line+i>=max || row+i >= max  ) || (solutionWord.charAt(i) != puzzle.get(line+i).charAt(row+i) ))
                break;                
        }
         if (i == di){
                
                 return "DownRigth";
             }
         
         return null;
        
        
        
        
    }
    
    public void findWordsHV(){
        
        transposed();
        
        int row;
        
        for (String solutionWord : words  ){
            solutionWord = solutionWord.toUpperCase();
            Boolean check  = true;
            int line = 0;
            
            /*
            To find words in horizontal
            */
            
            for (String wordSoup : puzzle ){
                
                line ++;
                if (wordSoup.contains(solutionWord)){
                    
                    row = wordSoup.indexOf( solutionWord.charAt(0) );
                    index.add( String.valueOf(line) +","+ String.valueOf(row) );
                    direct.add("rigtht");
                    check=false;
                    break;
                    
                } else if ( wordSoup.contains(new StringBuilder(solutionWord).reverse().toString() ) ){
                   
                    row = wordSoup.indexOf( solutionWord.charAt(0) )+1 ;
                    index.add( String.valueOf(line) + ","+String.valueOf(row) );
                    direct.add("left");
                    check=false;
                    break;
                }
                
                /*
                To find words in diagonal with function searchFunction()
                */
                
                String r;
             
                for ( int l = 0; l < wordSoup.length() ; l++){
                    
                    if ( wordSoup.charAt(l) == solutionWord.charAt(0) ){
                        
                        r = searchDiagonal( line-1 , l , solutionWord);
                        
                        if (r != null){
                            l+=1;
                            index.add(String.valueOf(line) + ","+String.valueOf(l));
                            direct.add(r);
                            check=false;
                            break;
                            
                        }
                    }
                    
                }
                
             
                       
            }
            
            /*
            To find words in vertical
            */
            if (check){
            line=0;
            for (String wordSoup : matriTransp){
                line++;
                if (wordSoup.contains(solutionWord)){
                    
                    row = wordSoup.indexOf( solutionWord.charAt(0) ) +1;
                        
                    index.add( String.valueOf(row) +","+ String.valueOf(line) );
                    direct.add("down");
                    
                    break;
                    
                } else if ( wordSoup.contains(new StringBuilder(solutionWord).reverse().toString() ) ){
                    
                    row = wordSoup.indexOf( solutionWord.charAt(0) ) + 1 ;
                    
                    index.add( String.valueOf(row) +","+ String.valueOf(line) );
                    direct.add("up");
                    break;
                    
                }
            }     
        }
        } 
        
        
        
    }
    
    public void showSolution(){
        if ( words.size() == index.size()){
        for (int i = 0; i<words.size() ; i++){
            System.out.format("%-10s            %-5s      %-5s            %-5s\n",words.get(i), words.get(i).length(), index.get(i), direct.get(i));
        }
        }else{
            System.err.println("Tem palavras solução duplicadas!");
        }
       
            
    }
    
    
    
    
    
    
}
