package ExamePratico.Aula9;


public class EN extends Handler {

    @Override
    public boolean canTranslate(String language) {
        return "EN"== language;
    }

    @Override
    public void Translate(String language) {
        if(canTranslate(language)){
            System.out.println("Translated to english");
        }
        else
            super.Translate(language);


    }
}
