package CompletableFutureExample;

import java.util.concurrent.CompletableFuture;

public class ChainingFutures {
    public static void main(String[] args) {
        CompletableFuture
                .supplyAsync(ChainingFutures::getDefaultAdminEmail)
                .thenCompose(
                        email -> CompletableFuture.supplyAsync(() -> "Please Contact admin at" + email + "for queries"))
                .thenAccept(System.out::println);
    }

    static String getDefaultAdminName() {
        return Admin.name;
    }

    static String getDefaultAdminEmail() {
        return Admin.email;
    }

    static class Admin {
        private final static String name = "Ram";
        private final static String email = "ram@gmail.com";
    }

}
