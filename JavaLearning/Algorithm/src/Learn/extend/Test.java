package Learn.extend;

/**
 * @author RiceFamily
 * @date 2020/5/29 14:35
 */
public  class Test {
    public static void main(String[] args) {
        Bird bird = new Bird("Raven","black");
        Animals animal = bird;
        Object obj = bird;
        System.out.println(animal.getClass());
        System.out.println(obj.getClass());
        Bird bird1 = (Bird) obj;
        System.out.println(bird1.getName());
        System.out.println(bird1.getClass());
        human h;

    }
}
