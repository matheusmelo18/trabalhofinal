import java.util.Arrays;

class CadastroPacientes {
    private Paciente[] pacientes;
    private int count;

    public CadastroPacientes() {
        pacientes = new Paciente[10];
        count = 0;
    }

    public void adicionarPaciente(Paciente paciente) {
        if (count < pacientes.length) {
            pacientes[count] = paciente;
            count++;
            System.out.println("Paciente adicionado com sucesso.");
        } else {
            System.out.println("Não tem mais espaço para cadastrar ninguem");
        }
    }

    public void removerPaciente(int index) {
        if (index >= 0 && index < count) {
            for (int i = index; i < count - 1; i++) {
                pacientes[i] = pacientes[i + 1];
            }
            pacientes[count - 1] = null;
            count--;
            System.out.println("Paciente removido com sucesso.");
        } else {
            System.out.println("Índice inválido. Não foi possível remover o paciente.");
        }
    }

    public void escreverCadastro() {
        for (int i = 0; i < count; i++) {
            System.out.println("Paciente " + (i + 1) + ":");
            System.out.println(pacientes[i]);
            System.out.println();
        }
    }

    public void escreverNomesOrdemAlfabetica() {
        if (count > 0) {
            Paciente[] pacientesOrdenados = Arrays.copyOf(pacientes, count);
            Arrays.sort(pacientesOrdenados, (a, b) -> a.getNome().compareToIgnoreCase(b.getNome()));
            System.out.println("Nomes dos pacientes em ordem alfabética:");
            for (Paciente paciente : pacientesOrdenados) {
                System.out.println(paciente.getNome());
            }
        } else {
            System.out.println("Não há pacientes cadastrados.");
        }
    }

    public double calcularMediaConsultas() {
        if (count > 0) {
            int somaConsultas = 0;
            for (int i = 0; i < count; i++) {
                somaConsultas += pacientes[i].getConsultasMes();
            }
            return (double) somaConsultas / count;
        } else {
            return 0;
        }
    }

    public void calcularPorcentagemDiagnosticos() {
        if (count > 0) {
            int[] diagnosticoCount = new int[5]; // 5 diagnósticos possíveis

            for (int i = 0; i < count; i++) {
                String diagnostico = pacientes[i].getDiagnostico();
                switch (diagnostico) {
                    case "Covid":
                        diagnosticoCount[0]++;
                        break;
                    case "Dengue":
                        diagnosticoCount[1]++;
                        break;
                    case "Influenza":
                        diagnosticoCount[2]++;
                        break;
                    case "Meningite":
                        diagnosticoCount[3]++;
                        break;
                    default:
                        diagnosticoCount[4]++; // Outro
                        break;
                }
            }

            System.out.println("Porcentagem de pacientes por diagnóstico:");
            System.out.println("Covid: " + (double) diagnosticoCount[0] * 100 / count + "%");
            System.out.println("Dengue: " + (double) diagnosticoCount[1] * 100 / count + "%");
            System.out.println("Influenza: " + (double) diagnosticoCount[2] * 100 / count + "%");
            System.out.println("Meningite: " + (double) diagnosticoCount[3] * 100 / count + "%");
            System.out.println("Outro: " + (double) diagnosticoCount[4] * 100 / count + "%");
        } else {
            System.out.println("Não há pacientes cadastrados.");
        }
    }   
}
