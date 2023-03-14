import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class FabricaDeConexao {

	public Connection recuperarConexao() throws SQLException {
		return
				DriverManager.getConnection("jdbc:mysql://localhost/agendatelefonica?useTimezone=true&serverTimezone=UTC"
						, "root", "632154");
	}
	
	public void adicionarContato() throws SQLException {
		Connection con = recuperarConexao();
		
		System.out.print("Digite um nome: ");
		@SuppressWarnings("resource")
		Scanner entrada1 = new Scanner(System.in);
		String nome = entrada1.next();
		
		System.out.print("Digite um numero: ");
		@SuppressWarnings("resource")
		Scanner entrada2 = new Scanner(System.in);
		String numero = entrada2.next();
		
		
		PreparedStatement stm = con.prepareStatement("INSERT INTO contatos(nome, numero) VALUES (?, ?)");
		stm.setString(1, nome);
		stm.setString(2, numero);
		stm.execute();
		System.out.println("Contato Adicionado! \n");
		
	}
	
	public void verContato() throws SQLException {
		Connection con = recuperarConexao();
		Statement stm = con.createStatement();
		stm.execute("SELECT ID, NOME, NUMERO FROM contatos");
		
		ResultSet rst = stm.getResultSet();
		
		while(rst.next()) {
			Integer id = rst.getInt("ID");
			String nome = rst.getString("NOME");
			String numero = rst.getString("NUMERO");
			System.out.println("Código: " + id);
			System.out.printf("Nome: %s, Numero: %s", nome, numero);
			System.out.println("\n");
			
		}
		
	}

	public void deletarContato() throws SQLException {
		Connection con = recuperarConexao();
		System.out.print("Digite um ID para deletar: ");
		@SuppressWarnings("resource")
		Scanner entrada1 = new Scanner(System.in);
		String id = entrada1.next();
		
		PreparedStatement stm = con.prepareStatement("DELETE FROM contatos WHERE id = ?");
		stm.setString(1, id);
		stm.execute();
		System.out.println("Contato deletado! \n");
				
	}
	
}