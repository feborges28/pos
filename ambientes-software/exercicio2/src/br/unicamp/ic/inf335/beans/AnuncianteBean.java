/**
 * 
 */
package br.unicamp.ic.inf335.beans;

import java.util.ArrayList;

/**
 * @author bonacin
 * Classe que representa um anunciante, com respectivos dados e anuncios associados
 */
public class AnuncianteBean {
	/**
	 * Nome do anunciante
	 */
	private String nome;
	/**
	 * CFP do anuncioante
	 */
	private String CPF;
	/**
	 * Lista de anuncios de um anunciante
	 */
	private ArrayList<AnuncioBean> anuncios;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public ArrayList<AnuncioBean> getAnuncios() {
		return anuncios;
	}
	public void setAnuncios(ArrayList<AnuncioBean> anuncios) {
		this.anuncios = anuncios;
	}
	
	/**
	 * Construtor deafult
	 */
	public AnuncianteBean() {
		nome = new String();
		CPF = new String();
		anuncios = new ArrayList<AnuncioBean>();
	}
	
	
	/**
	 * Construtor com parametros
	 * @param nome
	 * @param cPF
	 * @param anuncios
	 */
	public AnuncianteBean(String nome, String cPF, ArrayList<AnuncioBean> anuncios) {
		super();
		this.nome = nome;
		CPF = cPF;
		this.anuncios = anuncios;
	}
	

	/**
	 * Inclui novo anuncio na lista de anuncios de um anunciante
	 * @param nAnuncio Anuncio a ser incluido
	 */
	public void addAnuncio (AnuncioBean nAnuncio) {
		anuncios.add(nAnuncio);	
	}
	
	/**
	 * Inclui novo anuncio na lista de anuncios de um anunciante
	 * @param nAnuncio Anuncio a ser incluido
	 */
	public void removeAnuncio (int i) throws Exception {
		try {
			anuncios.remove(i);
		} catch (Exception e) {
			if(i < 0) {
				throw new Exception("Índice inválido! O índice precisa ser maior ou igual a 0");
			}

			if (this.anuncios.size() > 0 && i > this.anuncios.size() - 1){
				throw new Exception("Índice inválido! O índice precisa ser menor que o tamanho da lista");
			}

			if(this.anuncios.size() == 0){
				throw new Exception("Não existem items para remover na lista");
			}
		}
	}
	
	/**
	 * Calcula o valor medio de anuncios de um anuciante
	 * @return valor medio dos anuncios 
	 */
	public Double valorMedioAnuncios() {
		Double soma = 0.0;
		for (AnuncioBean an:anuncios) {
			soma += an.getValor();
		}
		double v = Math.floor((soma / anuncios.size()) * 100) / 100;
		return v;
	}

}
