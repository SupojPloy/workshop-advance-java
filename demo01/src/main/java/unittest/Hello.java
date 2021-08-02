package unittest;

public class Hello {
    public String hi(String name) {
        return "Hello, " + name;
    }

    UserDB userDB;

    public String workWithDb(int id) {
        return userDB.getNameById(id);
    }
}

class UserDB { //connect to DB
    public String getNameById(int id) {
        throw new RuntimeException("TODO");
    }
}
