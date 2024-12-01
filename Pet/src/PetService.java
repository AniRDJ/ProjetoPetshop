import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PetService {

    public void adicionarPet(Pet pet) throws SQLException {
        String sql = "INSERT INTO pets (nome, especie, idade) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pet.getNome());
            stmt.setString(2, pet.getEspecie());
            stmt.setInt(3, pet.getIdade());
            stmt.executeUpdate();
        }
    }

    public List<Pet> listarPets() throws SQLException {
        String sql = "SELECT * FROM pets";
        List<Pet> pets = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Pet pet = new Pet();
                pet.setId(rs.getInt("id"));
                pet.setNome(rs.getString("nome"));
                pet.setEspecie(rs.getString("especie"));
                pet.setIdade(rs.getInt("idade"));
                pets.add(pet);
            }
        }
        return pets;
    }

    public void atualizarPet(Pet pet) throws SQLException {
        String sql = "UPDATE pets SET nome = ?, especie = ?, idade = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, pet.getNome());
            stmt.setString(2, pet.getEspecie());
            stmt.setInt(3, pet.getIdade());
            stmt.setInt(4, pet.getId());
            stmt.executeUpdate();
        }
    }

    public void deletarPet(int id) throws SQLException {
        String sql = "DELETE FROM pets WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }
    }
}
