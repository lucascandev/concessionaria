// Declaração da classe Veiculo
public class Veiculo {
    // Declaração das variáveis de instância da classe
    String modelo;
    String fabricante;
    String placa;
    String cor;
    boolean ipvaPago;
    String condicao;
    String antigoDono;

    // Construtor da classe Veiculo
    public Veiculo(String modelo, String fabricante, String placa, String cor, boolean ipvaPago, String condicao, String antigoDono) {
        // Inicialização das variáveis de instância com os valores passados como parâmetros para o construtor
        this.modelo = modelo;
        this.fabricante = fabricante;
        this.placa = placa;
        this.cor = cor;
        this.ipvaPago = ipvaPago;
        this.condicao = condicao;
        this.antigoDono = antigoDono;
    }

    // Métodos getter e setter para cada variável de instância
    // Getter para a variável modelo
    public String getModelo() {
        return modelo;
    }

    // Setter para a variável modelo
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    // Getter para a variável fabricante
    public String getFabricante() {
        return fabricante;
    }

    // Setter para a variável fabricante
    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    // Getter para a variável placa
    public String getPlaca() {
        return placa;
    }

    // Setter para a variável placa
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    // Getter para a variável cor
    public String getCor() {
        return cor;
    }

    // Setter para a variável cor
    public void setCor(String cor) {
        this.cor = cor;
    }

    // Getter para a variável ipvaPago
    public boolean isIpvaPago() {
        return ipvaPago;
    }

    // Setter para a variável ipvaPago
    public void setIpvaPago(boolean ipvaPago) {
        this.ipvaPago = ipvaPago;
    }

    // Getter para a variável condicao
    public String getCondicao() {
        return condicao;
    }

    // Setter para a variável condicao
    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }

    // Getter para a variável antigoDono
    public String getAntigoDono() {
        return antigoDono;
    }

    // Setter para a variável antigoDono
    public void setAntigoDono(String antigoDono) {
        this.antigoDono = antigoDono;
    }

    // Método toString para retornar uma representação em String do objeto Veiculo
    @Override
    public String toString() {
        return "Modelo: " + modelo + ", Fabricante: " + fabricante + ", Placa: " + placa + ", Cor: " + cor + ", IPVA Pago: " + (ipvaPago ? "Sim" : "Não") + ", Condição: " + condicao + ", Antigo Dono: " + antigoDono;
    }
}