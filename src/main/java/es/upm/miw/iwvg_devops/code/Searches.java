package es.upm.miw.iwvg_devops.code;

import java.util.stream.Stream;

public class Searches {

    public Stream<String> findUserFamilyNameByUserNameDistinct(String userName) {
        return new UsersDatabase().findAll()
                .filter(user -> userName.equals(user.getName()))
                .map(User::getFamilyName)
                .distinct();
    }

    //.peek(x -> LogManager.getLogger(this.getClass()).info("before: " + x))
    public Stream<Integer> findFractionNumeratorByUserFamilyName(String userFamilyName) {
        return new UsersDatabase().findAll()
                .filter(user -> userFamilyName.equals(user.getFamilyName()))
                .flatMap(user -> user.getFractions().stream()
                        .filter(i -> null != i)
                )
                .map(Fraction::getNumerator);
    }

    public Stream<String> findUserFamilyNameByFractionDenominator(int fractionDenominator) {
        return new UsersDatabase().findAll()
                .filter(user -> user.getFractions().stream()
                        .anyMatch(fraction -> fractionDenominator == fraction.getDenominator()))
                .map(User::getFamilyName);
    }

    public Stream<String> findUserFamilyNameInitialByAnyProperFraction() {
        return Stream.empty();
    }

    public Stream<String> findUserIdByAnyProperFraction() {
        return Stream.empty();
    }

    public Fraction findFractionMultiplicationByUserFamilyName(String userFamilyName) {
        Fraction newFraction = new Fraction();
        new UsersDatabase().findAll()
                .filter(user -> userFamilyName.equals(user.getFamilyName()))
                .map(User::getFractions)
                .findAny()
                .get()
                .forEach((Fraction fraction) -> {
                    fraction = newFraction.multiply(fraction);
                    newFraction.setNumerator(fraction.getNumerator());
                    newFraction.setDenominator(fraction.getDenominator());
                });
        return newFraction;
    }


    public Fraction findFirstFractionDivisionByUserId(String id) {
        return null;
    }

    public Double findFirstDecimalFractionByUserName(String name) {
        return null;
    }

    public Stream<String> findUserIdByAllProperFraction() {
        return Stream.empty();
    }

    public Stream<Double> findDecimalImproperFractionByUserName(String name) {
        return Stream.empty();
    }

    public Fraction findFirstProperFractionByUserId(String id) {
        return null;
    }

    public Stream<String> findUserFamilyNameByImproperFraction() {
        return Stream.empty();
    }

    public Fraction findHighestFraction() {
        return null;
    }

    public Stream<String> findUserNameByAnyImproperFraction() {
        return Stream.empty();
    }

    public Stream<Double> findDecimalFractionByUserName(String name) {
        return Stream.empty();
    }


    public Stream<Double> findDecimalFractionByNegativeSignFraction() {



        return Stream.empty();
    }

    public Fraction findFractionAdditionByUserId(String id) {
        return null;
    }

    public Fraction findFirstFractionSubtractionByUserName(String name) {
        return null;
    }


    public Fraction findFractionSubtractionByUserName(String name) {




        return null;
    }

}
