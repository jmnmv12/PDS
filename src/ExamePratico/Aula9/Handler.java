package ExamePratico.Aula9;

public abstract class Handler {
    private Handler succ=null;
    private String lang;




    public void Translate(String language){
        if(succ!=null){
            succ.Translate(language);
        }
        else
            System.out.println("Cant translate");
    }

    public boolean canTranslate(String language){
        return language==lang;
    }

    public Handler setSucc(Handler b){
        succ=b;
        return this;
    }
}
