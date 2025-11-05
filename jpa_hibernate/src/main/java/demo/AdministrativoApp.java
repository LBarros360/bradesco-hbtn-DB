package demo;

import entities.Pessoa;
import entities.Produto;
import models.PessoaModel;
import models.ProdutoModel;
import java.util.Date;
import java.util.List;

public class AdministrativoApp {
    public static void main(String[] args) {

        //PRODUTO
        ProdutoModel produtoModel = new ProdutoModel();

        Produto p1 = new Produto("TV", 300.0, true, 100);
        Produto p2 = new Produto("Notebook", 500.0, true, 2);

        // 1) Criando um produto
        produtoModel.create(p1);
        produtoModel.create(p2);

        //2) Atualizando produto
        p1.setPreco(500.0);
        p2.setPreco(700.0);
        produtoModel.update(p1);
        produtoModel.update(p2);

        //3) Buscando produto por id
        produtoModel.findById(p1.getId());
        produtoModel.findById(p2.getId());

        //4) Buscando todos os produtos na base de dados
        List<Produto> produtos = produtoModel.findAll();
        if (!produtos.isEmpty()) {
            System.out.println("##LISTA DE PRODUTOS:");
            produtos.forEach(System.out::println);

        }

        //5) Excluindo produto
        produtoModel.delete(p1);


        //PESSOA
        PessoaModel pessoaModel = new PessoaModel();
        Pessoa ps1 = new Pessoa("João Neves", "joao.neves@gmail.com", 37, "06623919938", new Date(01/01/1988));

        //1) Criando uma pessoa
        pessoaModel.create(ps1);

        //2) Atualizando uma pessoa
        ps1.setIdade(30);
        pessoaModel.update(ps1);

        //4) Buscando todos as pessoas na base de dados
        List<Pessoa> pessoas = pessoaModel.findAll();
        if (!pessoas.isEmpty()) {
            System.out.println("##LISTA DE PESSOAS:");
            pessoas.forEach(System.out::println);
        }

        //5) Excluindo pessoa
        pessoaModel.delete(ps1);
   }
}
