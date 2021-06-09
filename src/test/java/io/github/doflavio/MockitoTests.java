package io.github.doflavio;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class MockitoTests {

    @Mock
    List<String> listaOutraFormaMock;

    @Test
    public void primeiroTesteMockito(){
        List<String> lista = Mockito.mock(ArrayList.class);

        Mockito.when( lista.size() ).thenReturn(20);

        int size = lista.size();

        Assertions.assertThat(size).isEqualTo(20);

    }

    @Test
    public void outraFormaTesteMockito(){
        Mockito.when( listaOutraFormaMock.size() ).thenReturn(20);
        int size = listaOutraFormaMock.size();
        /*
        int size = 0;
        if(1==2){
            size = listaOutraFormaMock.size();
        }
        */

        Assertions.assertThat(size).isEqualTo(20);

        // Verifica se chamou o método size da lista
        //Mockito.verify(listaOutraFormaMock).size();
        //Mockito.verify(listaOutraFormaMock,Mockito.times(2)).size(); //Verifica quantas vezes chamamos
        //Mockito.verify(listaOutraFormaMock,Mockito.never()).size(); //Verifica se nunca foi chamado
    }

    @Test
    public void inOrderTesteMockito(){
        listaOutraFormaMock.size();
        listaOutraFormaMock.add("");

        InOrder inOrder = Mockito.inOrder(listaOutraFormaMock);
        inOrder.verify(listaOutraFormaMock).size();
        inOrder.verify(listaOutraFormaMock).add("");
    }
}
