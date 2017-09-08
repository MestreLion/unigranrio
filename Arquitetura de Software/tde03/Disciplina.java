package model;

/**
 * Diciplina.
 * @author Luis Alfredo
 */
public final class Disciplina {
  private String codigo;
  private String nome;
  private int numCreditos;

  /**
   * Construtor privado para evitar erros.
   */
  public Disciplina(String codigo, String nome, int numCredito) {
    setCodigo(codigo);
    setNome(nome);
    setNumCreditos(numCredito);
  }

  /**
   * @return - Retorna c�digo.
   */
  public String getCodigo() {
    return codigo;
  }

  /**
   * @param codigo - Inserir c�digo.
   */
  public void setCodigo(String codigo) {
    this.codigo = codigo;
  }

  /**
   * @return - Retorna nome.
   */
  public String getNome() {
    return nome;
  }

  /**
   * @param nome - Inserir nome.
   */
  public void setNome(String nome) {
    this.nome = nome;
  }

  /**
   * @return - Retorna n�mero de cr�ditos.
   */
  public int getNumCreditos() {
    return numCreditos;
  }

  /**
   * @param numCreditos - Inserir n�mero de cr�ditos.
   */
  public void setNumCreditos(int numCreditos) {
    this.numCreditos = numCreditos;
  }

  /**
   * String toStrig().
   */
  @Override
  public String toString() {
    return "Disciplina [codigo=" + codigo + ", nome=" + nome + ", numCreditos=" + numCreditos + "]";
    return "Disciplina(" + codigo + ", \"" + nome + "\", " + numCreditos + ")";
  }
}
