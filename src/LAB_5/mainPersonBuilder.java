package LAB_5;


public class mainPersonBuilder {



    public static void main(String[] args) {
        PersonBuilder pessoaA=new PersonBuilder()
                .newFirstName("Joao")
                .newLastName("Vasconcelos")
                .isHomeOwner(false);

        System.out.println(pessoaA);
    }
}



