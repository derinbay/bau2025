public class UserPool {

    public static User validUser() {
        return new User("asddasdaasd@dasd.com", "1234qwe");
    }

    public static User invalidUser() {
        return new User("asddasdaasd@dasd.com", "1234dasjqwe");
    }
}
