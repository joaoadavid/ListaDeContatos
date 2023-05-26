package servicos;

import java.util.HashMap;
import java.util.Map;

public class GerenciadorDeContatos {
    private Map<String, Contato> contatos;

    public GerenciadorDeContatos() {
        contatos = new HashMap<>();
    }

    public void adicionarContato(Contato contato) {
        contatos.put(contato.getNome(), contato);
        System.out.println("Contato adicionado: " + contato);
    }

    public void deletarContato(String nome) throws ContatoNaoEncontradoException {
        Contato contato = contatos.remove(nome);
        if (contato != null) {
            System.out.println("Contato removido: " + contato);
        } else {
            throw new ContatoNaoEncontradoException("Contato não encontrado.");
        }
    }

    public void buscarContato(String nome) throws ContatoNaoEncontradoException {
        Contato contato = contatos.get(nome);
        if (contato != null) {
            System.out.println("Contato encontrado: " + contato);
        } else {
            throw new ContatoNaoEncontradoException("Contato não encontrado.");
        }
    }

    public void exibirTodosContatos() {
        if (contatos.isEmpty()) {
            System.out.println("Agenda vazia.");
        } else {
            System.out.println("Lista de contatos:");
            for (Contato contato : contatos.values()) {
                System.out.println(contato);
            }
        }
    }
}
