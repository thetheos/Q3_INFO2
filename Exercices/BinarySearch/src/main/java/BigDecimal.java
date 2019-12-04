public class BigDecimal {
    /*
     * parse exponent
     */
    public static long parseExp(char[] in, int offset, int len){
        long exp = 0;
        offset++;
        char c = in[offset];
        len--;
        boolean negexp = (c == '-');
        // optional sign
        // S'il y a un signe, on le supprime. En deplacant l'offset et en diminuant la taille
        if (negexp || c == '+') {
            offset++;
            c = in[offset];
            len--;
        }
        if (len <= 0) // no exponent digits
            throw new NumberFormatException();
        // skip leading zeros in the exponent
        // Character.digit(c, 10) convertis le caractère en digit base 10)
        while (len > 10 && (c=='0' || (Character.digit(c, 10) == 0))) {
            offset++;
            c = in[offset];
            len--;
        }
        if (len > 10) // too many nonzero exponent digits
            throw new NumberFormatException();
        // c now holds first digit of exponent
        for (;; len--) {
            int v;
            if (c >= '0' && c <= '9') {
                v = c - '0'; // Cette ligne de sert pas à grand chose
            } else {
                v = Character.digit(c, 10);
                if (v < 0) // not a digit Cas où ce n'est pas un digit
                    throw new NumberFormatException();
            }
            exp = exp * 10 + v;
            if (len == 1)
                break; // that was final character
            offset++;
            c = in[offset];
        }
        if (negexp) // apply sign
            exp = -exp;
        return exp;
    }
}