public class Pythagorean {
    public double calculateHypotenuse(int legA, int legB) {
        double resultOfLegA = Math.sqrt(legA);
        double resultOfLegB = Math.sqrt(legB);

        double finalResult = resultOfLegA + resultOfLegB;
        return finalResult;
    }
}
