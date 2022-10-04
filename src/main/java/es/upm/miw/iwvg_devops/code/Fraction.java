package es.upm.miw.iwvg_devops.code;

/**
 * Conceptos: Las fracciones propias son aquellas cuyo numerador es menor que el denominador
 * <p>
 * Las fracciones impropias son aquellas cuyo numerador es mayor que el denominador
 * <p>
 * Dos fracciones son equivalentes cuando el producto de extremos (numerador de la primera por denominador de la segunda) es igual al
 * producto de medios (denominador de la primera por el numerador de la segunda)
 * <p>
 * Las fracciones irreducibles son aquellas que no se pueden simplificar, esto sucede cuando el numerador y el denominador son primos entre
 * sí
 * <p>
 * Reducir varias fracciones a común denominador consiste en convertirlas en otras equivalentes que tengan el mismo denominador
 * <p>
 * Comparar fracciones
 * <p>
 * Suma fracciones: En primer lugar se reducen los denominadores a común denominador, y se suman o se restan los numeradores de las
 * fracciones equivalentes obtenidas
 * <p>
 * Multiplicación: La multiplicación de dos fracciones es otra fracción que tiene: Por numerador el producto de los numeradores. Por
 * denominador el producto de los denominadores.
 * <p>
 * La división de dos fracciones es otra fracción que tiene: Por numerador el producto de los extremos. Por denominador el producto de los
 * medios. Invertir fraccion
 */
public class Fraction {

    private int numerator;

    private int denominator;

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public Fraction() {
        this(1, 1);
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public double decimal() {
        return (double) numerator / denominator;
    }

    public boolean isProper(Fraction fraction) {
        return fraction.getNumerator() < fraction.getDenominator();
    }

    public boolean isImproper(Fraction fraction) {
        return fraction.getNumerator() > fraction.getDenominator();
    }

    public boolean isEquivalent(Fraction that) {
        return this.reduce().equals(that.reduce());
    }

    public Fraction add(Fraction f) {
        int a = numerator;
        int b = denominator;
        int c = f.getNumerator();
        int d = f.getDenominator();
        int num = ((a * d) + (b * c));
        int den = (b * d);

        return new Fraction(num, den).reduce();
    }

    public Fraction multiply(Fraction f) {
        int a = numerator;
        int b = denominator;
        int c = f.getNumerator();
        int d = f.getDenominator();
        int num = a * c;
        int den = b * d;

        return new Fraction(num, den).reduce();
    }

    public Fraction divide(Fraction f) {
        int a = numerator;
        int b = denominator;
        int c = f.getNumerator();
        int d = f.getDenominator();
        int num = a * d;
        int den = b * c;

        return new Fraction(num, den).reduce();
    }

    public Fraction subtraction(Fraction f) {
        int a = numerator;
        int b = denominator;
        int c = f.getNumerator();
        int d = f.getDenominator();
        int num = ((a * d) - (b * c));
        int den = (b * d);

        return new Fraction(num, den).reduce();
    }

    private Fraction reduce() {
        int u = numerator;
        int v = denominator;
        int temp;

        u = Math.abs(u);
        while (v != 0) {
            temp = u % v;
            u = v;
            v = temp;
        }
        return new Fraction(numerator / u, denominator / u);
    }


    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Fraction)) {
            return false;
        }
        Fraction that = (Fraction) obj;
        return (this.numerator == that.getNumerator()
                && this.denominator == that.getDenominator());
    }
}