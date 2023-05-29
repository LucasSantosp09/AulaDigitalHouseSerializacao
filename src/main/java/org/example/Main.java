package org.example;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        List<Contatos> contatos = new ArrayList<>();

        Contatos contato1 = new Contatos();
        contato1.setNome("Lucas");
        contato1.setEmail("lucassantos.p09@gmail.com");
        contato1.setTelefone("(00)0000-0000");

        Contatos contatos2 = new Contatos();
        contatos2.setNome("João");
        contatos2.setEmail("joao@gmail.com");
        contatos2.setTelefone("(11) 1111-1111");

        contatos.add(contato1);
        contatos.add(contatos2);

        //Criando arquivo contatos.txt
        FileOutputStream fileOutputStream = new FileOutputStream("contatos.txt");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        objectOutputStream.writeObject(contatos);



        //Lendo arquivo contato.txt

        FileInputStream fileInputStream = new FileInputStream("contatos.txt");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

        List<Contatos> contatosList = (List<Contatos>) objectInputStream.readObject();

        for (Contatos contato : contatosList){
            System.out.println("Nome: " + contato.getNome() + ", Email: " + contato.getEmail() + ", Contato: " + contato.getTelefone());
        }



    }
}