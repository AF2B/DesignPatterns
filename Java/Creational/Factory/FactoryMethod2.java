// factory method pattern loja de carros
interface Car {
  void info(String mark, String model, String color);
  void detailedInfo(String power, String engine, String transmission, String price);
}

class Ford implements Car {
  public void info(String mark, String model, String color) {
    System.out.printf("Marca: " + mark,
                       "Modelo: " + model, 
                       "Cor: " + color);
  }

  public void detailedInfo(String power, String engine, String transmission, String price) {
    System.out.printf("Potência: " + power,
                       "Motor: " + engine, 
                       "Câmbio: " + transmission, 
                       "Preço: " + price);
  }
}

class Hyundai implements Car {
  public void info(String mark, String model, String color) {
    System.out.printf("Marca: " + mark,
                       "Modelo: " + model, 
                       "Cor: " + color);
  }

  public void detailedInfo(String power, String engine, String transmission, String price) {
    System.out.printf("Potência: " + power,
                       "Motor: " + engine, 
                       "Câmbio: " + transmission, 
                       "Preço: " + price);
  }
}

class Chevrolet implements Car {
  public void info(String mark, String model, String color) {
    System.out.printf("Marca: " + mark,
                       "Modelo: " + model, 
                       "Cor: " + color);
  }

  public void detailedInfo(String power, String engine, String transmission, String price) {
    System.out.printf("Potência: " + power,
                       "Motor: " + engine, 
                       "Câmbio: " + transmission, 
                       "Preço: " + price);
  }
}

class CarFactory {
  public static Car getCar(String type) {
    if (type.equals("Ford")) {
      return new Ford();
    } else if (type.equals("Hyundai")) {
      return new Hyundai();
    } else if (type.equals("Chevrolet")) {
      return new Chevrolet();
    } else {
      throw new IllegalArgumentException("Unknown type");
    }
  }
}

class CarShop {
  public static void main(String[] args) {
    Car car = CarFactory.getCar("Ford");

    System.out.println("");
    System.out.println(car.getClass().getName());
    System.out.println("");
    
    car.info("Ford", "Mustang", "Vermelho");
    car.detailedInfo("500 cv", "V8", "Manual", "R$ 300.000,00");
  }
}
