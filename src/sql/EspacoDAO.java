package sql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EspacoDAO {
    private Connection connection;

    public EspacoDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    // Método para inserir um espaço no banco de dados
    public void cadastrarEspaco(Espaco espaco) {
        String sql = "INSERT INTO espacos (nome, descricao, capacidade, equipamentos_disponiveis, disponivel) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, espaco.getNome());
            stmt.setString(2, espaco.getDescricao());
            stmt.setInt(3, espaco.getCapacidade());
            stmt.setString(4, espaco.getEquipamentosDisponiveis());
            stmt.setBoolean(5, espaco.isDisponivel());
            stmt.executeUpdate();
            System.out.println("Espaço cadastrado com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar espaço: " + e.getMessage());
        }
    }

    // Método para listar todos os espaços
    public List<Espaco> listarEspacos() {
    	List<Espaco> espacos = new ArrayList<>();
        String sql = "SELECT * FROM espacos";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Espaco espaco = new Espaco(
                    rs.getInt("id"),
                    rs.getString("nome"),
                    rs.getString("descricao"),
                    rs.getInt("capacidade"),
                    rs.getString("equipamentos_disponiveis"),
                    rs.getBoolean("disponivel")
                );
                espacos.add(espaco);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar espaços: " + e.getMessage());
        }
        return espacos;
    }
}
