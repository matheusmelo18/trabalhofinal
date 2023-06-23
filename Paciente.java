class Paciente {
    private String nome;
    private String cpf;
    private String telefone;
    private String convenio;
    private String diagnostico;
    private int consultasMes;

    public Paciente(String nome, String cpf, String telefone, String convenio, String diagnostico, int consultasMes) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.convenio = convenio;
        this.diagnostico = diagnostico;
        this.consultasMes = consultasMes;
        this.calcularValorConsultas(consultasMes);
    }

    public String getNome() {
        return nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setConvenio(String convenio) {
        this.convenio = convenio;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public void setConsultasMes(int consultasMes) {
        this.consultasMes = consultasMes;
    }

    public double calcularValorConsultas(double valorConsulta) {
        return valorConsulta * consultasMes;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + "\nCPF: " + cpf + "\nTelefone: " + telefone + "\nConvênio: " + convenio +
                "\nDiagnóstico: " + diagnostico + "\nNúmero de consultas do mês: " + consultasMes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getConvenio() {
        return convenio;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public int getConsultasMes() {
        return consultasMes;
    }
}