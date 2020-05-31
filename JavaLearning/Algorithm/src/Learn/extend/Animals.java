package Learn.extend;

/**
 * @author RiceFamily
 * @date 2020/5/29 14:34
 */
public class Animals {
    String name;
    String color;

    public Animals() {
    }

    public Animals(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
