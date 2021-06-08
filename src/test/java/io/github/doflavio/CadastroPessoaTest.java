package io.github.doflavio;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class CadastroPessoaTest {

    @Test
    public void deveriaCriarOCadastraoDePessoas() {
        //Cenário
        CadastroPessoas cadastro = new CadastroPessoas();

        //Verificação
        Assertions.assertThat(cadastro.getPessoas()).isEmpty();
    }

    @Test
    public void deveAdicionarUmaPessoa(){
        //Cenário
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Wilson");


        //Execução
        cadastroPessoas.adicionar(pessoa);

        //Verificação
        Assertions
                .assertThat(cadastroPessoas.getPessoas())
                .isNotEmpty()
                .hasSize(1)
                .contains(pessoa);

    }

    @Test(expected = PessoaSemNomeException.class)
    public void naoDeveAdicionarPessoaComNomeVazio() {
        //Cenário
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        //Execução
        cadastroPessoas.adicionar(pessoa);
    }

    @Test
    public void deveRemoverUmaPessoa(){
        //Cenário
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Wilson");
        cadastroPessoas.adicionar(pessoa);

        //execução
        cadastroPessoas.remover(pessoa);

        //Verificação
        Assertions.assertThat(cadastroPessoas.getPessoas()).isEmpty();
    }

    @Test(expected = CadastroVazioException.class)
    public void deveLancarErroAoTentarRemoverPessoaInexistente() {
        //Cenário
        CadastroPessoas cadastroPessoas = new CadastroPessoas();
        Pessoa pessoa = new Pessoa();

        //execução
        cadastroPessoas.remover(pessoa);
    }
}
