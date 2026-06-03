package Testes;

import MensageriaEmNuvem.SistemaNotificacao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SistemaNotificacaoTest {

    @Test
    void deveRetornarMensagemConvertidaCorretamente() {
        SistemaNotificacao sistema = new SistemaNotificacao();
        sistema.setMensagem("Mensagem de Teste");

        assertEquals("Mensagem de Teste", sistema.getMensagem());
    }

    @Test
    void deveGarantirConversaoParaBytesNoKafka() {
        SistemaNotificacao sistema = new SistemaNotificacao();
        sistema.setMensagem("Mensagem de Teste");

        byte[] payloadEsperado = "Mensagem de Teste".getBytes();
        assertArrayEquals(payloadEsperado, sistema.getPayloadKafka());
    }

    @Test
    void deveLidarComMensagemNula() {
        SistemaNotificacao sistema = new SistemaNotificacao();
        sistema.setMensagem(null);

        assertNull(sistema.getMensagem());
        assertNull(sistema.getPayloadKafka());
    }

}
