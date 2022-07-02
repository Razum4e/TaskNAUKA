package FlipString;

public class Main {
    public static void main(String[] args) {
        String text = "text";
        char[] charArray = text.toCharArray();
        System.out.println("До: " + text);
        System.out.println("На 90 градусов:");
        for (char character : charArray)
            System.out.println(character);
        System.out.println("На 180 градусов fori:");
        for (int i = charArray.length - 1; i >= 0; i--)
            System.out.print(charArray[i]);
        System.out.println();
        System.out.println("На 180 градусов StringBuilder: " +
                "\n" + new StringBuilder(text).reverse());
        System.out.println("На 270 градусов:");
        for (int i = charArray.length - 1; i >= 0; i--)
            System.out.println(charArray[i]);
    }
}
