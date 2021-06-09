package io.github.doflavio;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


public class CalculadoraTeste {

    Calculadora calculadora;
    int numero1 = 10, numero2 = 5;

    @BeforeEach
    public void setUp() {
        calculadora = new Calculadora();
    }

    @Test
    public void deveSomarDoisNumeros(){

        Calculadora calculadora = new Calculadora();

        //Cenário
        //int numero1 = 10, numero2 = 5;

        //Execução
        int resultado = calculadora.somar(numero1,numero2);

        // Verificação(Assertivas)AssertJ
        Assertions.assertThat(resultado).isEqualTo(15);

    }

    @Test
    public void deveSubtrairDoisNumeros(){

        Calculadora calculadora = new Calculadora();

        //Cenário

        //Execução
        int resultado = calculadora.subtrair(numero1,numero2);

        // Verificação(Assertivas)AssertJ
        Assertions.assertThat(resultado).isEqualTo(5);

    }

    @Test
    public void deveMultiplicarSubtrairDoisNumeros(){

        Calculadora calculadora = new Calculadora();

        //Cenário

        //Execução
        int resultado = calculadora.multiplicar(numero1,numero2);

        // Verificação(Assertivas)AssertJ
        Assertions.assertThat(resultado).isEqualTo(50);

    }

    @Test
    public void deveDividirDoisNumeros(){

        Calculadora calculadora = new Calculadora();

        //Cenário

        //Execução
        float resultado = calculadora.dividir(numero1,numero2);

        // Verificação(Assertivas)AssertJ
        Assertions.assertThat(resultado).isEqualTo(2);

    }

    @Test
    public void naoDeveSomarNumerosNegativos(){
        Calculadora calculadora = new Calculadora();

        //Cenário
        int num1 = -10, num2 = 5;

        //Execução
        org.junit.jupiter.api.Assertions.assertThrows(
                RuntimeException.class,
                () -> calculadora.somar(num1,num2));

    }

    @Test
    public void naoDeveDividirPorZero(){
        Calculadora calculadora = new Calculadora();

        //Cenário
        int num1 = 10, num2 = 0;

        //Execução
        org.junit.jupiter.api.Assertions.assertThrows(
                ArithmeticException.class,
                () -> calculadora.dividir(num1,num2));

    }
}

class Calculadora {
    int somar(int num1,int num2){
        if(num1 < 0 || num2 < 0){
            throw new RuntimeException("Não é permitido somar números negativos");
        }
        return num1 + num2;
    }

    int subtrair(int num1,int num2){
        return num1 - num2;
    }

    int multiplicar(int num1,int num2){
        return num1 * num2;
    }

    float dividir(int num1,int num2){
        return num1 / num2;
    }
}
