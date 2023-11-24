package utils;

public enum Responses {
        SUCCESSFULLY_REMOVED("successfully removed"),
        SUCCESSFULLY_INSTALLED("successfully installed"),
        ALREADY_INSTALLED("is already installed"),
        ALREADY_REMOVED("is not installed"),
        IN_USE("is still needed");
    
        private final String text;
    
        Responses(final String text) {
            this.text = text;
        }
    
        public String toString(){
            return text;
        }
    
    
}
