package sql;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class SolicitacaoDAO {
	private Connection connection;

    public SolicitacaoDAO() {
        this.connection = DatabaseConnection.getConnection();
    }

    public void criarSolicitacao(Solicitacao solicitacao) {
        // Verificar se já existe uma solicitação aprovada para o mesmo espaço e horário
        String checkSql = "SELECT COUNT(*) FROM solicitacoes WHERE id_espaco = ? AND data_reserva = ? AND status = 'Aprovado'";
        try (PreparedStatement checkStmt = connection.prepareStatement(checkSql)) {
            checkStmt.setInt(1, solicitacao.getIdEspaco());
            checkStmt.setTimestamp(2, Timestamp.valueOf(solicitacao.getDataReserva()));
            ResultSet rs = checkStmt.executeQuery();
            if (rs.next() && rs.getInt(1) > 0) {
                System.out.println("Erro: O espaço já está reservado para o horário solicitado.");
                return;
            }
        } catch (SQLException e) {
            System.out.println("Erro ao verificar disponibilidade do espaço: " + e.getMessage());
            return;
        }

        // Inserir a nova solicitação
        String sql = "INSERT INTO solicitacoes (id_usuario, id_espaco, data_solicitacao, data_reserva, status) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, solicitacao.getIdUsuario());
            stmt.setInt(2, solicitacao.getIdEspaco());
            stmt.setTimestamp(3, Timestamp.valueOf(solicitacao.getDataSolicitacao()));
            stmt.setTimestamp(4, Timestamp.valueOf(solicitacao.getDataReserva()));
            stmt.setString(5, solicitacao.getStatus());
            stmt.executeUpdate();
            System.out.println("Solicitação criada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao criar solicitação: " + e.getMessage());
        }
    }

    // Método para listar solicitações pendentes
    public List<Solicitacao> listarSolicitacoesPendentes() {
        List<Solicitacao> solicitacoes = new ArrayList<>();
        String sql = "SELECT * FROM solicitacoes WHERE status = 'Pendente'";
        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Solicitacao solicitacao = new Solicitacao(
                    rs.getInt("id"),
                    rs.getInt("id_usuario"),
                    rs.getInt("id_espaco"),
                    rs.getString("data_solicitacao"),
                    rs.getString("data_reserva"),
                    rs.getString("status"),
                    rs.getString("justificativa")
                );
                solicitacoes.add(solicitacao);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar solicitações: " + e.getMessage());
        }
        return solicitacoes;
    }

    // Método para aprovar/rejeitar uma solicitação
    public void avaliarSolicitacao(int idSolicitacao, String status, String justificativa) {
        String sql = "UPDATE solicitacoes SET status = ?, justificativa = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, status);
            stmt.setString(2, justificativa);
            stmt.setInt(3, idSolicitacao);
            stmt.executeUpdate();
            System.out.println("Solicitação avaliada com sucesso!");
        } catch (SQLException e) {
            System.out.println("Erro ao avaliar solicitação: " + e.getMessage());
        }
    }

public Solicitacao buscarSolicitacaoPorId(int id) {
    String sql = "SELECT * FROM solicitacoes WHERE id = ?";
    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return new Solicitacao(
                rs.getInt("id"),
                rs.getInt("id_usuario"),
                rs.getInt("id_espaco"),
                rs.getString("data_solicitacao"),
                rs.getString("data_reserva"),
                rs.getString("status"),
                rs.getString("justificativa")
            );
        }
    } catch (SQLException e) {
        System.out.println("Erro ao buscar solicitação: " + e.getMessage());
    }
    return null;
}
}