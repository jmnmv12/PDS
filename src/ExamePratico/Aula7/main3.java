package ExamePratico.Aula7;

public class main3 {
    public static void main(String[] args) {
        Bloco principal = new Bloco("Main");
        Bloco top = new Bloco("Top");
        Bloco bot = new Bloco("Bottom");
        top.add(new Retangulo("jogo"));
        principal.add(top);
        principal.add(bot);
        bot.add(new Circulo("rosa"));
        bot.add(new Quadrado("verde"));
        top.add(new Bloco("Outra área"));
        principal.draw();
    }
}
