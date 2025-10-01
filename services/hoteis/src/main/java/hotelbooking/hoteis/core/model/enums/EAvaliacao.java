package hotelbooking.hoteis.core.model.enums;

public enum EAvaliacao {
    N1(1),
    N2(2),
    N3(3),
    N4(4),
    N5(5);

    private final int valor;

    // O construtor de um enum deve ser privado
    private EAvaliacao(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return this.valor;
    }

    // Método opcional para buscar um enum pelo valor numérico
    public static EAvaliacao fromValor(int valor) {
        for (EAvaliacao avaliacao : EAvaliacao.values()) {
            if (avaliacao.getValor() == valor) {
                return avaliacao;
            }
        }
        throw new IllegalArgumentException("Valor de avaliação inválido: " + valor);
    }
}