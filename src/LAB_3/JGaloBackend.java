package LAB_3;

public class JGaloBackend implements JGaloInterface {
    private char [][] tabuleiro;
    private char current_player;
    private  char first_player;


    public JGaloBackend() {
        this.tabuleiro=new char[3][3];
        this.first_player='X';
        this.current_player=this.first_player;

    }

    @Override
    public char getActualPlayer() {
        return this.current_player;
    }

    @Override
    public boolean setJogada(int lin, int col) {


            this.tabuleiro[lin-1][col-1]=this.current_player;

            if(this.current_player=='X')
                this.current_player='O';
            else if(this.current_player=='O')
                this.current_player='X';
            return  true;




    }

    @Override
    public boolean isFinished() {
        for(int i=0;i<this.tabuleiro.length;i++){
            if(this.tabuleiro[i][0]==this.tabuleiro[i][1] & this.tabuleiro[i][1]==this.tabuleiro[i][2]){
                System.out.println(this.tabuleiro[i][0]+"--"+this.tabuleiro[i][1]+"--"+this.tabuleiro[i][2]);
                return true;
            }

        }

        return false;
    }

    @Override
    public char checkResult() {
        return 0;
    }
}
