	import java.util.Scanner;

	public class Calculadora {
	    public static void main(String[] args) {
	        Scanner opc = new Scanner(System.in);

	        System.out.print("Digite o primeiro n�mero: ");
	        double num1 = opc.nextDouble();

	        System.out.print("Digite o segundo n�mero: ");
	        double num2 = opc.nextDouble();

	        System.out.println("\nOPERA��O:");
	        System.out.println("1 - Soma");
	        System.out.println("2 - Subtra��o");
	        System.out.println("3 - Multiplica��o");
	        System.out.println("4 - Divis�o");

	        int opcao = opc.nextInt();

	        double resultado = 0;

	        switch(opcao) {
	            case 1:
	                resultado = num1 + num2;
	                break;
	            case 2:
	                resultado = num1 - num2;
	                break;
	            case 3:
	                resultado = num1 * num2;
	                break;
	            case 4:
	                resultado = num1 / num2;
	                break;
	            default:
	                System.out.println("Op��o inv�lida!");
	                return;
	        }

	        System.out.println("O resultado �: " + resultado);
	    }
	}

