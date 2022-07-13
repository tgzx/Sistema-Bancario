public class ContaBanco {
    public int numConta;
    protected String tipoConta; // "cc" conta corrente ou "cp" conta poupança
    private String dono;
    private float saldo;
    private boolean status;

    public ContaBanco(String dono, String tipoConta, int numConta) {
        this.numConta = numConta;
        this.tipoConta = tipoConta;
        this.dono = dono;
        this.abrirConta();
        this.status = true;
        this.pagarMensal();
        this.info();
    }

    public static void menu1() {
        System.out.println("Selecione um dos itens a seguir:");
        System.out.println("1 - Sacar");
        System.out.println("2 - Depositar");
        System.out.println("3 - Abrir conta");
        System.out.println("4 - Fechar conta");
        System.out.println("5 - Exibir contas cadastradas - (Para testes)");
        System.out.println("6 - Sair\n");
    }

    public void info() {
        System.out.println(" ");
        String res = " ";
        if (getTipoConta().equals("cc") || getTipoConta().equals("CC")){
            res = "Conta Corrente";
        } else if (getTipoConta().equals("cp") || getTipoConta().equals("CP")){
            res = "Conta Poupanca";
        }
        System.out.println(this.dono + " - Conta: " + (this.numConta + 1) + " " + res);
        System.out.println("Saldo disponível: " + (int) this.saldo);
        System.out.println(status ? "Conta ativa" : "Conta desativada.");
    }

    public void info(float saque) {
        System.out.println(" ");
        String res = " ";
        if (getTipoConta().equals("cc") || getTipoConta().equals("CC")){
            res = "Conta Corrente";
        } else if (getTipoConta().equals("cp") || getTipoConta().equals("CP")){
            res = "Conta Poupanca";
        }
        System.out.println(this.dono + " - Conta: " + (this.numConta + 1)+ " " + res);
        System.out.println("Saque realizado: " + saque);
        System.out.println("Saldo disponível: " + (int) this.saldo);
    }

    public float abrirConta(){
        float saldo = 0;
        if (getTipoConta().equals("cc") || getTipoConta().equals("CC")){
            System.out.println("   ___    ___    _  _   _____     _   \n" +
                    "  / __|  / _ \\  | \\| | |_   _|   /_\\  \n" +
                    " | (__  | (_) | | .` |   | |    / _ \\ \n" +
                    "  \\___|  \\___/  |_|\\_|   |_|   /_/ \\_\\\n" +
                    "                                      \n");
            System.out.println("   ___    ___    ___   ___   ___   _  _   _____   ___ \n" +
                    "  / __|  / _ \\  | _ \\ | _ \\ | __| | \\| | |_   _| | __|\n" +
                    " | (__  | (_) | | / / | / / | _|  | .` |   | |   | _| \n" +
                    "  \\___|  \\___/  |_|_\\ |_|_\\ |___| |_|\\_|   |_|   |___|\n" +
                    "                                                      ");
            setSaldo(50);
        } else if (getTipoConta().equals("cp") || getTipoConta().equals("CP")){
            System.out.println("   ___    ___    _  _   _____     _   \n" +
                    "  / __|  / _ \\  | \\| | |_   _|   /_\\  \n" +
                    " | (__  | (_) | | .` |   | |    / _ \\ \n" +
                    "  \\___|  \\___/  |_|\\_|   |_|   /_/ \\_\\\n" +
                    "                                      \n");
            System.out.println("  ___    ___    _   _   ___     _     _  _    ___     _   \n" +
                    " | _ \\  / _ \\  | | | | | _ \\   /_\\   | \\| |  / __|   /_\\  \n" +
                    " |  _/ | (_) | | |_| | |  _/  / _ \\  | .` | | (__   / _ \\ \n" +
                    " |_|    \\___/   \\___/  |_|   /_/ \\_\\ |_|\\_|  \\___| /_/ \\_\\\n" +
                    "                                                          ");
            setSaldo(150);
        } else {
            System.out.println("Entrada invalida.\n");
        }
        return saldo;
    }

    public void fecharConta(){
        if (getSaldo()== 0 && this.status){
            System.out.println("Conta fechada.");
            this.status = false;
        } else {
            System.out.println("\nEsta conta não pode ser fechada pelo seguinte motivo: \n" +
                    "Existe dinheiro na conta ou ela já está fechada.\n");
        }
    }

    public float sacar(float saque){
        float res = 0;
        if (this.status){
            if (saque <= getSaldo()){
                setSaldo(getSaldo() - saque);
                info(saque);
            } else {
                System.out.println("Valor de saque superior ao saldo disponivel.");
            }
            res = getSaldo();
        } else {
            System.out.println("A conta esta fechada.");
        }
        return res;
    }

    public void depositar(float valorDeposito){
        if (this.status){
            setSaldo(getSaldo() + valorDeposito);
            info();
        } else {
            System.out.println("A conta está fechada.");
        }
    }

    public void pagarMensal(){
        if (getTipoConta().equals("CC") || getTipoConta().equals("cc")){
            setSaldo(getSaldo() - 12);
        } else {
            setSaldo(getSaldo() - 20);
        }
    }

    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipoConta() {
        return tipoConta;
    }

    public void setTipoConta(String tipoConta) {
        this.tipoConta = tipoConta;
    }

    public String getDono() {
        return dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}