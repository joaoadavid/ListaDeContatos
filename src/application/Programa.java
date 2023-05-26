package application;

import java.util.Scanner;

import servicos.ContatoComercial;
import servicos.ContatoNaoEncontradoException;
import servicos.ContatoPessoal;
import servicos.GerenciadorDeContatos;

public class Programa {

    public static void main(String[] args) {
        GerenciadorDeContatos GerenciadorDeContatos  = new GerenciadorDeContatos();
        Scanner scanner = new Scanner(System.in);

        int opcao;
        do {
            System.out.println("\nAgenda - Escolha uma opção:");
            System.out.println("1. Adicionar contato pessoal");
            System.out.println("2. Adicionar contato comercial");
            System.out.println("3. Deletar contato");
            System.out.println("4. Buscar contato");
            System.out.println("5. Exibir todos os contatos");
            System.out.println("6. Sair");
            System.out.println();

            opcao = scanner.nextInt();
            System.out.println();
            scanner.nextLine(); 
            

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do contato pessoal: ");
                    String nomePessoal = scanner.nextLine();
                    System.out.print("Digite o telefone do contato pessoal: ");
                    String telefonePessoal = scanner.nextLine();
                    System.out.print("Digite o email do contato pessoal: ");
                    String emailPessoal = scanner.nextLine();
                    ContatoPessoal contatoPessoal = new ContatoPessoal(nomePessoal, telefonePessoal, emailPessoal);
                    GerenciadorDeContatos.adicionarContato(contatoPessoal);
                    break;
                case 2:
                    System.out.print("Digite o nome do contato comercial: ");
                    String nomeComercial = scanner.nextLine();
                    System.out.print("Digite o telefone do contato comercial: ");
                    String telefoneComercial = scanner.nextLine();
                    System.out.print("Digite a empresa do contato comercial: ");
                    String empresaComercial = scanner.nextLine();
                    ContatoComercial contatoComercial = new ContatoComercial(nomeComercial, telefoneComercial, empresaComercial);
                    GerenciadorDeContatos.adicionarContato(contatoComercial);
                    break;
                case 3:
                    System.out.print("Digite o nome do contato: ");
                    String nome = scanner.nextLine();
                    try {
                    	GerenciadorDeContatos.deletarContato(nome);
                    } catch (ContatoNaoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Digite o nome do contato: ");
                    nome = scanner.nextLine();
                    try {
                    	GerenciadorDeContatos.buscarContato(nome);
                    } catch (ContatoNaoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                	GerenciadorDeContatos.exibirTodosContatos();
                    break;
                case 6:
                    System.out.println("Encerrando a agenda.");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 6);

        scanner.close();
    }

}
