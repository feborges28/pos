package br.unicamp.ic.inf335.beans;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import java.util.ArrayList;
import java.net.MalformedURLException;
import java.net.URL;

class AnuncioBeanTest {
    public static ArrayList<URL> fotos = new ArrayList<>();

    @BeforeAll()
    public static void init() {
        try {
            fotos.add(new URL("https://unsplash.com/photos/PDX_a_82obo"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private ProdutoBean produto = new ProdutoBean("product001", "produto 1", "Lorem ipsum", 1500.00, "sp");
    private AnuncioBean anuncio = new AnuncioBean(produto, fotos, 0.2);

    @Test
    @DisplayName("O método getValor deve retornar o valor do produto menos o percentual de desconto")
    void getDesconto() {
        assertEquals(1200.00, anuncio.getValor());
    }

    @Test
    @DisplayName("O valor de desconto não pode exceder 100% do valor do produto")
    void descontoMáximo() {
        Exception exception = assertThrows(Exception.class, () -> anuncio.setDesconto(1.1));
        assertEquals("Desconto inválido!", exception.getMessage());
    }

    @Test
    @DisplayName("O valor de desconto não pode ser inferior a 0")
    void descontoMinimo() {
        Exception exception = assertThrows(Exception.class, () -> anuncio.setDesconto(-0.1));
        assertEquals("Desconto inválido!", exception.getMessage());
    }
}