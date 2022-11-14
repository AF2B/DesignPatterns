// Factory Method Design Pattern in Java Language

interface Button {
  void render();
  void onClick();
}

class HTMLButton implements Button {
  public void render() {
    System.out.println("HTML Button");
  }

  public void onClick() {
    System.out.println("HTML Button Clicked");
  }
}

class WindowsButton implements Button {
  public void render() {
    System.out.println("Windows Button");
  }

  public void onClick() {
    System.out.println("Windows Button Clicked");
  }
}

interface Dialog {
  Button createButton();
}

class HTMLDialog implements Dialog {
  public Button createButton() {
    return new HTMLButton();
  }
}

class WindowsDialog implements Dialog {
  public Button createButton() {
    return new WindowsButton();
  }
}

class Configure {
  public static Dialog getDialog(String type) {
    if (type.equals("Windows")) {
      return new WindowsDialog();
    } else if (type.equals("HTML")) {
      return new HTMLDialog();
    } else {
      throw new IllegalArgumentException("Unknown type");
    }
  }
}

public class FactoryMethod {
  public static void main(String[] args) {
    Dialog dialog = Configure.getDialog("Windows");
    Button button = dialog.createButton();
    button.render();
    button.onClick();
  }
}
