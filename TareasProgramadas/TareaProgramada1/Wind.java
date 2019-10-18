import java.util.Random;



public class Wind{
    double wind;
    public double wind() {
     Random stat = new Random();
    int viento = stat.nextInt(3);
     if (viento == 0) {
          wind = 0.0;
    }
    if (viento == 1) {
        wind = 0.25;
    }
    if (viento == 2) {
        wind = 0.50;
    }
    return this.wind;
  }
}