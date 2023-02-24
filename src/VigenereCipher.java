public class VigenereCipher {
    private String alphabet;
    private String key;
    public VigenereCipher(String key) {
        alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        this.key = key.toLowerCase();
    }
    public String getKey(){
        return key;}
    public String getAlphabet(){
        return alphabet;}
    public String encode(String input){
        StringBuilder output = new StringBuilder();
        for(int i = 0; i < input.length(); i++){
            char shift = key.charAt(i % key.length());
            boolean inAlphabet = false;
            for(int j = 0; j < 52; j++) if (alphabet.charAt(j) == input.charAt(i)) inAlphabet = true;
            if(!inAlphabet){
                output.append(input.charAt(i));
                continue;
            }
            int shifted = input.charAt(i) + shift - 'a';
            if (shifted > 'z') {
                char newChar = (char) shifted;
                while (newChar > 'z') newChar -= 26;
                output.append(newChar);
            }
            else output.append((char) shifted);
        }
        return output.toString();
    }

    public String decode(String input){
        StringBuilder output = new StringBuilder();
        for(int i = 0; i < input.length(); i++){
            boolean inAlphabet = false;
            char shift = key.charAt(i % key.length());
            for(int j = 0; j < 52; j++){
                if (alphabet.charAt(j) == input.charAt(i)) inAlphabet = true;
            }
            if(!inAlphabet){
                output.append(input.charAt(i));
                continue;
            }
            int shifted = input.charAt(i) - shift + 'a';
            if (shifted < 'a') {
                char newChar = (char) shifted;
                while (newChar < 'a') newChar += 26;
                output.append(newChar);
            }
            else output.append((char) shifted);
        }
        return output.toString();
    }
}