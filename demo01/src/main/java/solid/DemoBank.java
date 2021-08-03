package solid;

public class DemoBank {
    public static void main(String[] args) {

        LocalBank localBank = new LocalBank();
        localBank.transferMoney(1000);

        InterBank interBank = new InterBank();
        interBank.transferMoney(2000);
    }
}

class LocalBank {
    public void transferMoney(int money) {
        System.out.println("Transfer money in Thailand only");
    }
}

class InterBank extends LocalBank {
    public void transferMoney(int money) {
        System.out.println("Transfer money (International)");
    }
}

