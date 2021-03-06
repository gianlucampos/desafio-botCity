package dev.botcity.recrutamento_problems.problem1;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import dev.botcity.recrutamento_problems.problem2.Problem2;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 1. Carregar o arquivo cte.xml localizado na pasta ./res/. 2. Criar um objeto
 * Cte (Conhecimento de Transporte). 3. Preencher os campos, sabendo os
 * seguintes caminhos na estrutura XML:
 *
 * - serie:   <cteProc><CTe><infCte><ide><serie>
 * - chave:   <cteProc><CTe><infCte Id=>
 * - emissao: <cteProc><CTe><infCte><ide><dhEmi>
 * - valor:   <cteProc><CTe><infCte><vPrest><vTPrest>
 *
 */
public class Problem1 {

    /**
     * Implementar metodo abaixo
     */
    private Cte loadCteFromXML(File file) {
        try {
            ObjectMapper mapper = new XmlMapper();
            JsonNode root = mapper.readTree(file);
            Cte cte = new Cte();
            cte.setSerie(root.findValue("serie").asInt());
            cte.setChave(root.findValue("Id").asText());
            cte.setEmissao(root.findValue("dhEmi").asText());
            cte.setValor(root.findValue("vTPrest").asDouble());
            return cte;
        } catch (Exception ex) {
            Logger.getLogger(Problem2.class.getName()).log(Level.SEVERE, "Falha ao processar xml!", ex);
        }
        return null;
    }

    /**
     * NÃO ALTERAR MÉTODO EVAL
     */
    private void eval() {
        Cte cte = loadCteFromXML(new File("./res/cte.xml"));

        boolean failed = false;
        if (cte != null && cte.getSerie() != null && cte.getSerie() == 4) {
            System.out.println("[OK] campo \"serie\" com valor correto");
        } else {
            System.out.println("[FAIL] Campo \"serie\" com valor incorreto. Valor esperado: 4");
            failed = true;
        }

        if (cte != null && cte.getChave() != null && cte.getChave().equals("CTe99999704012799900349570040000165560001225662")) {
            System.out.println("[OK] campo \"chave\" com valor correto");
        } else {
            System.out.println("[FAIL] Campo \"chave\" com valor incorreto. Valor esperado: CTe99999704012799900349570040000165560001225662");
            failed = true;
        }

        if (cte != null && cte.getEmissao() != null && cte.getEmissao().equals("2011-07-05T14:42:29")) {
            System.out.println("[OK] campo \"emissao\" com valor correto");
        } else {
            System.out.println("[FAIL] Campo \"emissao\" com valor incorreto. Valor esperado: 2011-07-05T14:42:29");
            failed = true;
        }

        if (cte != null && cte.getValor() != null && cte.getValor() == 50.13) {
            System.out.println("[OK] campo \"valor\" com valor correto");
        } else {
            System.out.println("[FAIL] Campo \"valor\" com valor incorreto. Valor esperado: 50.13");
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
        new Problem1().eval();
        System.exit(0);
    }

}
