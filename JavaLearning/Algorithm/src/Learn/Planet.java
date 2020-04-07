package Learn;

public enum Planet {
    MERCURY(3.202E+23, 2439E6),
    VENUS(4.202E+23, 2439E6),
    EARTH(5.202E+23, 2439E6),
    MARS(6.202E+23, 2439E6),
    JUPITER(7.202E+23, 2439E6),
    SATURN(8.202E+23, 2439E6),
    URANUS(9.202E+23, 2439E6),
    NEPTUNE(10.202E+23, 2439E6);

    private final double mass;  //枚举类型不可变 所以 final
    private final double radius;
    private final double surfaceGravity;

    private static final double G = 6.67300E-11;

    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
        surfaceGravity = G * mass / (radius * radius);
    }

    public double mass() {
        return mass;
    }

    public double radius() {
        return radius;
    }

    public double surfaceGravity() {
        return surfaceGravity;
    }

    public double surfaceWeight(double mass) {
        return mass * surfaceGravity; // F = ma
    }

}