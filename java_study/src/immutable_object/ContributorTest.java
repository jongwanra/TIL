package immutable_object;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class ContributorTest {
    public static void main(String[] args) {
        AtomicReference<Contribution> contribution = new AtomicReference<>(Contribution.valueOf(0));
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {

            executorService.execute(() -> {
                for (int j = 0; j < 10000; j++) {
                    Contribution donate = contribution.get().donate();
                    contribution.set(donate);
                }
                System.out.println(contribution.get().getTotal());
            });

        }

        executorService.shutdown();

        try {
            if (!executorService.awaitTermination(5, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            executorService.shutdownNow();
        }


    }
}
