package MensageriaEmNuvem;

public class SistemaNotificacao {

    IPublicador publicador;
    KafkaAdapter mensageria;

    public SistemaNotificacao() {
        publicador = new PublicadorRabbitMQ();
        mensageria = new KafkaAdapter(publicador);
    }

    public void setMensagem(String mensagem) {
        publicador.setMensagem(mensagem);
        mensageria.salvarMensagem();
    }

    public String getMensagem() {
        return mensageria.recuperarMensagem();
    }

    public byte[] getPayloadKafka() {
        return mensageria.getPayload();
    }

}
