package tech.ada.pagamento.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Transacao {

    @Id
    public String id;

    private String pagador;
    private String recebedor;
    private Double valor;
    private LocalDateTime data;

    public Transacao(String pagador, String recebedor, Double valor) {
        this.pagador = pagador;
        this.recebedor = recebedor;
        this.valor = valor;
        this.data = LocalDateTime.now();
    }

    public Comprovante getComprovate() {
        Comprovante comprovante = new Comprovante();
        comprovante.setId(this.id);
        comprovante.setPagador(this.pagador);
        comprovante.setRecebedor(this.recebedor);
        comprovante.setValor(this.valor);
        comprovante.setData(this.data);
        return comprovante;
    }

}