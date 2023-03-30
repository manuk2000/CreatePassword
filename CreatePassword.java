import java.util.regex.Pattern;

public class CreatePassword {

    public static void main(String[] args) {
        System.out.println(foo(100, 3));
    }

    static String foo(int c, int protectionLevel) {
        if (c < 8 || (!(protectionLevel == 1 || protectionLevel == 2 || protectionLevel == 3))) {
            return null;
        }
        String pattern = switch (protectionLevel) {
            case 1 -> "^[a-z0-9]$";
            case 2 -> "^[a-zA-Z0-9]$";
            case 3 -> "^[a-zA-Z0-9!@#$%^&*]$";
            default -> "^[a-zA-Z0-9!@#$%^&*]$";
        };

        StringBuilder res = new StringBuilder(c);
        int tmp;
        for (int i = 0; i < c; i++) {
            while (true) {
                tmp = (int) (Math.random() * 130);
                if (Pattern.matches(pattern, String.valueOf((char) tmp))) {
                    res.append((char) tmp);
                    break;
                }
            }
        }
        return new String(res);
    }
}
