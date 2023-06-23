import java.util.Scanner;
class Aplicacao {
    private static CadastroPacientes cadastro;
    private static Scanner scanner;

    public static void main(String[] args) {
        cadastro = new CadastroPacientes();
        scanner = new Scanner(System.in);

        int opcao = -1;

        while (opcao != 0) {
            exibirMenu();
            opcao = lerOpcao();

            switch (opcao) {
                case 1:
                    cadastrarPaciente();
                    break;
                case 2:
                    removerPaciente();
                    break;
                case 3:
                    printarInformações();
                    break;
                case 4:
                    escreverNomesOrdemAlfabetica();
                    break;
                case 5:
                    calcularMediaConsultas();
                    break;
                case 6:
                    calcularPorcentagemDiagnosticos();
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("==== Menu ====");
        System.out.println("1. Adicionar paciente");
        System.out.println("2. Remover paciente");
        System.out.println("3. Exibir todos os pacientes");
        System.out.println("4. Exibir nomes dos pacientes em ordem alfabética");
        System.out.println("5. Calcular média de consultas dos pacientes");
        System.out.println("6. Calcular porcentagem de diagnósticos");
        System.out.println("0. Sair do programa");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao() {
        return scanner.nextInt();
    }

    private static void cadastrarPaciente() {
        scanner.nextLine(); // Limpar o buffer do teclado

        System.out.print("Nome do paciente: ");
        String nome = scanner.nextLine();

        System.out.print("CPF do paciente: ");
        String cpf = scanner.nextLine();

        System.out.print("Telefone do paciente: ");
        String telefone = scanner.nextLine();

        System.out.print("Convênio do paciente: ");
        String convenio = scanner.nextLine();

        System.out.print("Diagnóstico do paciente (1-Covid, 2-Dengue, 3-Influenza, 4-Meningite, 5-Outro): ");
        int diagnosticoOpcao = scanner.nextInt();
        String diagnostico;

        switch (diagnosticoOpcao) {
            case 1:
                diagnostico = "Covid";
                break;
            case 2:
                diagnostico = "Dengue";
                break;
            case 3:
                diagnostico = "Influenza";
                break;
            case 4:
                diagnostico = "Meningite";
                break;
            default:
                diagnostico = "Outro";
                break;
        }

        System.out.print("Número de consultas do mês: ");
        int consultasMes = scanner.nextInt();

        Paciente paciente = new Paciente(nome, cpf, telefone, convenio, diagnostico, consultasMes);
        cadastro.adicionarPaciente(paciente);
        System.out.println();
    }

    private static void removerPaciente() {
        System.out.print("Digite o índice do paciente que deseja remover: ");
        int index = scanner.nextInt();
        cadastro.removerPaciente(index - 1);
        System.out.println();
    }

    private static void printarInformações() {
        cadastro.escreverCadastro();
        System.out.println();
    }

    private static void escreverNomesOrdemAlfabetica() {
        cadastro.escreverNomesOrdemAlfabetica();
        System.out.println();
    }

    private static void calcularMediaConsultas() {
        double media = cadastro.calcularMediaConsultas();
        System.out.println("Média de consultas dos pacientes: " + media);
        System.out.println();
    }

    private static void calcularPorcentagemDiagnosticos() {
        cadastro.calcularPorcentagemDiagnosticos();
        System.out.println();
    }
}
