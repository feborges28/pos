package br.unicamp.ic.inf335.beans;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

class AnuncianteBeanTest {
    public static ArrayList<URL> fotos = new ArrayList<>();

    private final ArrayList<AnuncioBean> anuncios = new ArrayList<>();

    private final ProdutoBean produto1 = new ProdutoBean("product001", "produto 1", "Lorem ipsum", 1000.00, "sp");
    private final ProdutoBean produto2 = new ProdutoBean("product002", "produto 2", "Lorem ipsum", 1500.00, "sp");
    private final ProdutoBean produto3 = new ProdutoBean("product003", "produto 3", "Lorem ipsum", 2000.00, "sp");

    private final AnuncioBean anuncio1 = new AnuncioBean(produto1, fotos, 0.1);
    private final AnuncioBean anuncio2 = new AnuncioBean(produto2, fotos, 0.2);
    private final AnuncioBean anuncio3 = new AnuncioBean(produto3, fotos, 0.5);

    private final AnuncianteBean anunciante = new AnuncianteBean("Vendedor", "999.999.999-99", anuncios);

    @BeforeAll()
    public static void init() {
        try {
            fotos.add(new URL("https://unsplash.com/photos/PDX_a_82obo"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    void addAnuncio() {
        anunciante.addAnuncio(anuncio1);
        Assertions.assertEquals(1, anunciante.getAnuncios().size());
    }

    @Test
    void excecoesRemocaoAnuncio() {
        Assertions.assertAll("Remove itens da lista de anuncios",
                () -> {
                    anunciante.getAnuncios().clear();
                    Exception exception = Assertions.assertThrows(Exception.class, () ->
                            anunciante.removeAnuncio(0));
                            Assertions.assertEquals("Não existem items para remover na lista", exception.getMessage());
                },
                () -> {
                    anunciante.getAnuncios().clear();
                    Exception exception = Assertions.assertThrows(Exception.class, () ->
                            anunciante.removeAnuncio(-1));
                            Assertions.assertEquals("Índice inválido! O índice precisa ser maior ou igual a 0", exception.getMessage());
                },
                () -> {
                    anunciante.getAnuncios().clear();
                    anunciante.addAnuncio(anuncio1);
                    Exception exception = Assertions.assertThrows(Exception.class, () ->
                            anunciante.removeAnuncio(5));
                            Assertions.assertEquals("Índice inválido! O índice precisa ser menor que o tamanho da lista", exception.getMessage());
                });
    }

    @Test
    void removeAnuncio() {
        anunciante.getAnuncios().clear();
        anunciante.addAnuncio(anuncio1);
        anunciante.addAnuncio(anuncio2);
        try {
            anunciante.removeAnuncio(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(1, anunciante.getAnuncios().size());
    }

    @Test
    void valorMedioAnuncios() {
        anunciante.addAnuncio(anuncio1);
        anunciante.addAnuncio(anuncio2);
        anunciante.addAnuncio(anuncio3);

        Assertions.assertEquals(Double.valueOf(1033.33), anunciante.valorMedioAnuncios());
    }
}