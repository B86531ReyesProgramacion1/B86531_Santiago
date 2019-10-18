import java.util.Random;



public class Experience{ 
    double exp;
    public double exp() {
     Random stats = new Random();
    int expe = stats.nextInt(3);
      if (expe == 0) {
          exp = 0.0;
    }
    if (expe == 1) {
        exp = 0.25;
    }
    if (expe == 2) {
        exp = 0.50;
    }
    return this.exp;
  }
}