package io.github.doflavio;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


public class PrimeiroTeste {

    @Test
    public void deveSomarDoisNumeros(){
        //Cenário
        int numero1 = 10, numero2 = 5;

        //Execução
        int resultado = numero1 + numero2;

        //Verificação(Assertivas)

        //JUnit
        //Assert.assertEquals(15,resultado);

        //AssertJ - AssertJ(Biblioteca mais fluent)
        Assertions.assertThat(resultado).isEqualTo(15);

    }


}