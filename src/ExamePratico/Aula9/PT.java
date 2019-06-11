package ExamePratico.Aula9;


public class PT extends Handler {

    @Override
    public boolean canTranslate(String language) {
        return "PT"== language;
    }

    @Override
    public void Translate(String language) {
        if(canTranslate(language)){
            System.out.println("Translated to portuguese");
        }
        else
            super.Translate(language);


    }
}
