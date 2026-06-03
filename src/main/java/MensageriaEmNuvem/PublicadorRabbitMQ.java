package MensageriaEmNuvem;

public class PublicadorRabbitMQ implements IPublicador {

    private String mensagem;

    @Override
    public String getMensagem() {
        return this.mensagem;
    }

    @Override
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

}
