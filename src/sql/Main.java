package sql;

import java.util.List;
import java.util.Scanner;

public class Main {

	 public static void main(String[] args) {
		  EspacoDAO espacoDAO = new EspacoDAO();
	        UsuarioDAO usuarioDAO = new UsuarioDAO();
	        SolicitacaoDAO solicitacaoDAO = new SolicitacaoDAO();

	        Scanner scanner = new Scanner(System.in);
	        int opcao;

	        do {
	            System.out.println("\n==== Gestão de Espaços ====");
	            System.out.println("1. Cadastrar Usuário");
	            System.out.println("2. Listar Usuários");
	            System.out.println("3. Cadastrar Espaço");
	            System.out.println("4. Listar Espaços");
	            System.out.println("5. Criar Solicitação");
	            System.out.println("6. Listar Solicitações Pendentes");
	            System.out.println("7. Avaliar Solicitação");
	            System.out.println("0. Sair");
	            System.out.print("Escolha uma opção: ");
	            opcao = scanner.nextInt();
	            scanner.nextLine(); // Limpar buffer

	            switch (opcao) {
	                case 1: // Cadastrar Usuário
	                    System.out.print("Nome do usuário: ");
	                    String nomeUsuario = scanner.nextLine();
	                    System.out.print("Tipo de usuário (Solicitante/Gestor): ");
	                    String tipoUsuario = scanner.nextLine();
	                    Usuario usuario = new Usuario(0, nomeUsuario, tipoUsuario);
	                    usuarioDAO.cadastrarUsuario(usuario);
	                    break;

	                case 2: // Listar Usuários
	                    System.out.println("\nUsuários cadastrados:");
	                    List<Usuario> usuarios = usuarioDAO.listarUsuarios();
	                    for (Usuario u : usuarios) {
	                        System.out.println(u.getId() + " - " + u.getNome() + " (" + u.getTipoUsuario() + ")");
	                    }
	                    break;

	                case 3: // Cadastrar Espaço
	                    System.out.print("Nome do espaço: ");
	                    String nomeEspaco = scanner.nextLine();
	                    System.out.print("Descrição: ");
	                    String descricao = scanner.nextLine();
	                    System.out.print("Capacidade: ");
	                    int capacidade = scanner.nextInt();
	                    scanner.nextLine(); // Limpar buffer
	                    System.out.print("Equipamentos disponíveis: ");
	                    String equipamentos = scanner.nextLine();
	                    Espaco espaco = new Espaco(0, nomeEspaco, descricao, capacidade, equipamentos, true);
	                    espacoDAO.cadastrarEspaco(espaco);
	                    break;

	                case 4: // Listar Espaços
	                    System.out.println("\nEspaços cadastrados:");
	                    List<Espaco> espacos = espacoDAO.listarEspacos();
	                    for (Espaco e : espacos) {
	                        System.out.println(e.getId() + " - " + e.getNome() + " (" + e.getCapacidade() + " pessoas)");
	                    }
	                    break;

	                case 5: // Criar Solicitação
	                    System.out.println("\nCriação de Solicitação");
	                    System.out.print("ID do solicitante: ");
	                    int idUsuario = scanner.nextInt();
	                    System.out.print("ID do espaço desejado: ");
	                    int idEspaco = scanner.nextInt();
	                    scanner.nextLine(); // Limpar buffer
	                    System.out.print("Data da reserva (YYYY-MM-DD HH:MM:SS): ");
	                    String dataReserva = scanner.nextLine();
	                    String dataSolicitacao = java.time.LocalDateTime.now().toString(); // Data atual
	                    Solicitacao solicitacao = new Solicitacao(0, idUsuario, idEspaco, dataSolicitacao, dataReserva, "Pendente", null);
	                    solicitacaoDAO.criarSolicitacao(solicitacao);
	                    break;

	                case 6: // Listar Solicitações Pendentes
	                    System.out.println("\nSolicitações pendentes:");
	                    List<Solicitacao> solicitacoesPendentes = solicitacaoDAO.listarSolicitacoesPendentes();
	                    for (Solicitacao s : solicitacoesPendentes) {
	                        System.out.println("ID: " + s.getId() + " | Usuário: " + s.getIdUsuario() + 
	                                           " | Espaço: " + s.getIdEspaco() + 
	                                           " | Data Reserva: " + s.getDataReserva() +
	                                           " | Status: " + s.getStatus());
	                    }
	                    break;

	                case 7: // Avaliar Solicitação
	                    System.out.print("\nID da solicitação a avaliar: ");
	                    int idSolicitacao = scanner.nextInt();
	                    scanner.nextLine(); // Limpar buffer
	                    System.out.print("Aprovar ou Rejeitar? (A/R): ");
	                    String status = scanner.nextLine();
	                    status = status.equalsIgnoreCase("A") ? "Aprovado" : "Rejeitado";
	                    System.out.print("Justificativa (opcional): ");
	                    String justificativa = scanner.nextLine();
	                    solicitacaoDAO.avaliarSolicitacao(idSolicitacao, status, justificativa);
	                    break;

	                case 0:
	                    System.out.println("Saindo...");
	                    break;

	                default:
	                    System.out.println("Opção inválida!");
	            }
	        } while (opcao != 0);

	        scanner.close();
	    }
	}