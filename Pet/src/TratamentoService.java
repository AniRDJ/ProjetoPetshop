import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TratamentoService {

    public void adicionarTratamento(Tratamento tratamento) throws SQLException {
        String sql = "INSERT INTO tratamentos (pet_id, descricao, preco, data) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, tratamento.getPetId());
            stmt.setString(2, tratamento.getDescricao());
            stmt.setDouble(3, tratamento.getPreco());
            stmt.setDate(4, new java.sql.Date(tratamento.getData().getTime()));
            stmt.executeUpdate();
        }
    }

    public List<Tratamento> listarTratamentos() throws SQLException {
        String sql = "SELECT * FROM tratamentos";
        List<Tratamento> tratamentos = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Tratamento tratamento = new Tratamento();
                tratamento.setId(rs.getInt("id"));
                tratamento.setPetId(rs.getInt("pet_id"));
                tratamento.setDescricao(rs.getString("descricao"));
                tratamento.setPreco(rs.getDouble("preco"));
                tratamento.setData(rs.getDate("data"));
                tratamentos.add(tratamento);
            }
        }
        return tratamentos;
    }

    public void atualizarTratamento(Tratamento tratamento) throws SQLException {
        String sql = "UPDATE tratamentos SET descricao = ?, preco = ?, data = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, tratamento.getDescricao());
            stmt.setDouble(2, tratamento.getPreco());
            stmt.setDate(3, new java.sql.Date(tratamento.getData().getTime()));
            stmt.setInt(4, tratamento.getId());
            stmt.executeUpdate();
        }
    }

    public void deletarTratamento(int id) throws SQLException {
        String sql = "DELETE FROM tratamentos WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
