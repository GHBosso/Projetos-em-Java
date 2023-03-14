import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class TesteAgenda {
	
	public static void main(String[] args) throws SQLException {
		
		FabricaDeConexao fc = new FabricaDeConexao();
		Connection con = fc.recuperarConexao();
		
		while (true) {
		System.out.println("~~~~AGENDA TELEFONICA~~~~");
		System.out.println("1 - ADICIONAR CONTATO");
		System.out.println("2 - VER CONTATOS");
		System.out.println("3 - REMOVER CONTATO");
		System.out.println("4 - SAIR");
		
		System.out.print("Digite a opção que você deseja: ");
		
		@SuppressWarnings("resource")
		Scanner entrada = new Scanner(System.in);
		int opc = entrada.nextInt();
			
		if (opc == 1) {
			fc.adicionarContato();
			}
		else if(opc == 2) {
			fc.verContato();
		}
		else if (opc == 3) {
			fc.deletarContato();
		}
		else if (opc == 4) {
			System.out.println("Saindo!");
			entrada.close();
			con.close();
			break;
		}
		}
		
	}

}
