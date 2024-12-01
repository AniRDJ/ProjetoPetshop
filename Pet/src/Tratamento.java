import java.util.Date;

public class Tratamento {
    private int id;
    private int petId;
    private String descricao;
    private double preco;
    private Date data;

    // Getters e Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getPetId() { return petId; }
    public void setPetId(int petId) { this.petId = petId; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    public Date getData() { return data; }
    public void setData(Date data) { this.data = data; }
}
