package MensageriaEmNuvem;

public class KafkaAdapter extends PublicadorKafka {

    private IPublicador publicadorRabbitMQ;

    public KafkaAdapter(IPublicador publicadorRabbitMQ) {
        this.publicadorRabbitMQ = publicadorRabbitMQ;
    }

    public String recuperarMensagem() {
        if (this.getPayload() != null) {
            publicadorRabbitMQ.setMensagem(new String(this.getPayload()));
        } else {
            publicadorRabbitMQ.setMensagem(null);
        }
        return publicadorRabbitMQ.getMensagem();
    }

    public void salvarMensagem() {
        if (publicadorRabbitMQ.getMensagem() != null) {
            this.setPayload(publicadorRabbitMQ.getMensagem().getBytes());
        } else {
            this.setPayload(null);
        }
    }

}
