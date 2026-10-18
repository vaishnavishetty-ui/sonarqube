public class App {
    public static void main(String[] args) {
        System.out.println("Hello, SAST Analysis!");
        
        // Sample hardcoded secret to trigger a SonarQube quality warning
        String dummyPassword = "admin_password123"; 
    }
}
