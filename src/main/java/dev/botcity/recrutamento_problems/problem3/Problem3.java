package dev.botcity.recrutamento_problems.problem3;

/**
 * Problema:
 *
 * - a URL https://viacep.com.br/ws/{cep}/json/ retorna o endereço completo de
 * um dado cep. exemplo: https://viacep.com.br/ws/85855-750/json/
 *
 * - implementar um método, que dado um cep, faz um request para a URL e retorna
 * o objeto Address
 *
 */
public class Problem3 {

    /**
     * Implementar o método abaixo
     */
    private Address getAddressByCEP(String cep) {
        return null;
    }

    /**
     * NÃO ALTERAR MÉTODO EVAL
     */
    private void eval() {

        boolean failed = false;

        Address addr;

        // Avenida Paulista 1708, Bela Vista, São Paulo
        addr = getAddressByCEP("01310-918");

        if (addr != null
                && addr.getLogradouro().equals("Avenida Paulista 1708")
                && addr.getBairro().equals("Bela Vista")
                && addr.getLocalidade().equals("São Paulo")) {
            System.out.println("[OK] Endereço correto para CEP \"01310-918\", Avenida Paulista 1708, Bela Vista, São Paulo");
        } else {
            System.out.println("[FAIL] Endereço incorreto para o CEP \"01310-918\". Esperado: Avenida Paulista 1708, Bela Vista, São Paulo");
            failed = true;
        }

        // Parque Nacional do Iguaçu
        addr = getAddressByCEP("85855-750");

        if (addr != null
                && addr.getLogradouro().equals("Rodovia BR-469")
                && addr.getBairro().equals("Parque Nacional do Iguaçu")
                && addr.getLocalidade().equals("Foz do Iguaçu")) {
            System.out.println("[OK] Endereço correto para CEP \"85855-750\", Rodovia BR-469, Parque Nacional do Iguaçu, Foz do Iguaçu");
        } else {
            System.out.println("[FAIL] Endereço incorreto para o CEP \"01310-918\". Esperado: Rodovia BR-469, Parque Nacional do Iguaçu, Foz do Iguaçu");
            failed = true;
        }

        if (!failed) {
            System.out.println("PROBLEM SOLVED!");
        }

    }

    /**
     * NÃO ALTERAR MÉTODO MAIN
     */
    public static void main(String[] args) {
        new Problem3().eval();
        System.exit(0);
    }
}
