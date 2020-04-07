package Learn;


public class EnumLearn {
    public static void main(String[] args) {
        double earthWeight = Double.parseDouble("185");
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        for (Planet planet : Planet.values()) {
            System.out.printf("Weight on %s is %f%n",planet,planet.surfaceWeight(mass));
        }
    }
}