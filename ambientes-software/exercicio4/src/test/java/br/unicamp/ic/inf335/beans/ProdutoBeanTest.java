package br.unicamp.ic.inf335.beans;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ProdutoBeanTest {
    private ProdutoBean produtoBean1 = new ProdutoBean("product001", "produto 1", "Lorem ipsum", 1500.00, "sp");
    private ProdutoBean produtoBean2 = new ProdutoBean("product002", "produto 2", "Lorem ipsum", 1800.00, "rj");
    
    @Test
    void compareTo() {
        Assertions.assertEquals(-1, produtoBean1.compareTo(produtoBean2));
    }
}