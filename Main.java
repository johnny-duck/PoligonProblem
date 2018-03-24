import java.io.*;

public class Main {
    public static void main(String[] args) {
        Point punct1= new Point(0d,0d);
        Poligon poligon = new Poligon();
        Point punct2 = new Point(1d,0.d);
        Point punct3 = new Point(0d,1d);
        poligon.addPoint(punct1);
        poligon.addPoint(punct2);
        poligon.addPoint(punct3);
        System.out.println("size: " + poligon.points.size());
        try {
            System.out.println("Parameter: " + poligon.getPermiter());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Area: " + poligon.getArea());
        System.out.println();
        //serializable
        File file = new File("C:/scanner/poligon.txt");
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(poligon);
        } catch (Exception e){
            e.printStackTrace();
        }
        try(FileInputStream fileInputStream = new FileInputStream(file);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            objectInputStream.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("AFTER:");
        System.out.println("size: " + poligon.points.size());
        try {
            System.out.println("Parameter: " + poligon.getPermiter());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Area: " + poligon.getArea());
        System.out.println();
    }
}
