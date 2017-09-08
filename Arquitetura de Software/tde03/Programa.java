package control;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import model.Disciplina;

public class Programa {
    static Scanner teclado = new Scanner(System.in);
    static Disciplina disciplina;
    static List<Disciplina> listaDisciplina = new ArrayList<Disciplina>();
    static Pattern pattern;
    static Boolean valida;

    /**
     * Construtor Protegido
     */
    private Programa() {
        // TODO Auto-generated constructor stub
    }

    public static void main(String[] args) {
        int resposta = -1;
        while (resposta != 0) {
            menuPrincipal();
            int resPrincipal = teclado.nextInt();
            System.out.println("================");
            if (resPrincipal == 0) {
                resposta = 0;
                System.out.println("Fim.");
            } else {
                menuSecundario(resPrincipal);
            }
        }
    }

    public static void menuPrincipal() {
        System.out.println("1 - Cadastrar Diciplina.");
        System.out.println("2 - Listar Diciplina(s).");
        System.out.println("0 - Finalizar.");
    }

    public static void menuSecundario(int menu) {
        if (menu == 1) {
            try {
                String codigo = validaCodigo();
                String nome = validaNome();
                int numCredito = validaNumCreditos();
                disciplina = new Disciplina(codigo, nome, numCredito);
                listaDisciplina.add(disciplina);

            }
            catch (Exception e) {
                System.err.println(e.getMessage());
            }
        } else if (menu == 2) {
            listarDiciplinas();
        }

    }

    public static void listarDiciplinas() {
        System.out.println("Listando as Diciplinas");
        System.out.println("================");
        for (Disciplina d : listaDisciplina) {
            System.out.println("Código: " + d.getCodigo());
            System.out.println("Nome: " + d.getNome());
            System.out.println("Número Créditos: " + Integer.toString(d.getNumCreditos()));
            System.out.println("----------------");
        }
    }

    /**
     * @param codigo
     *            - Validação do código.
     * @return - Retorno para resposta.
     */
    public static String validaCodigo() {
        valida = false;
        String codigo;
        System.out.println("Digite o código:");
        do {
            codigo = teclado.next();
            pattern = Pattern.compile("^[A-Z]{3,3}+[0-9]{3,3}$");
            if (pattern.matcher(codigo).matches()) {
                valida = true;
            }
            else {
                System.err.println("Digite um código valido. \n"
                        + " Deve conter exatamente 6 digitos. \n"
                        + " As três primeiras Tem que ser maiusculas e tem que ser Caracteres[A-Z]. \n"
                        + " Os três ultimos tem que ser números[0-9].");
            }
        } while (valida == false);
        return codigo;
    }

    /**
     * @param nome
     *            - Validação do nome.
     * @return - Retorno para resposta.
     */
    public static String validaNome() {
        valida = false;
        String nome;
        System.out.println("Digite o nome:");
        do {
            nome = teclado.next();
            if (nome.length() > 1) {
                valida = true;
            } else {
                System.err.println("Digite um nome valido! \n"
                        + " Tem que conter pelo menos 2 caracteres");
            }
        } while (valida == false);
        return nome;
    }

    /**
     * @param numCreditos
     *            - Validação do numCredito.
     * @return - Retorno para resposta.
     */
    public static int validaNumCreditos() {
        valida = false;
        int numCredito;
        System.out.println("Digite o número de créditos: ");
        do {
            numCredito = teclado.nextInt();
            if (numCredito > 2 && numCredito < 6) {
                valida = true;
            } else {
                System.err.println("Digite um número de crédito valido. \n"
                        + " Que seja entre 2 e 6:");
            }
        } while (valida == false);
        return numCredito;
    }
}
