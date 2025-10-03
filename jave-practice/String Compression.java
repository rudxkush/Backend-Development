public String compressString(String input) {
    if (input == null || input.length() <= 1) return input;
    
    StringBuilder compressed = new StringBuilder();
    int count = 1;
    
    for (int i = 1; i < input.length(); i++) {
        if (input.charAt(i) == input.charAt(i - 1)) {
            count++;
        } else {
            compressed.append(input.charAt(i - 1)).append(count);
            count = 1;
        }
    }
    
    // Handle last character sequence
    compressed.append(input.charAt(input.length() - 1)).append(count);
    
    return compressed.length() < input.length() ? compressed.toString() : input;
}
