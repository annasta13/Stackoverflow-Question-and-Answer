package com.explore.stackoverflow.worker;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleOwner;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ListenableWorker;
import androidx.work.OneTimeWorkRequest;
import androidx.work.Operation;
import androidx.work.PeriodicWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.annotation.Nonnull;

public class PollingWorker extends Worker {

    private final static String DELAY_KEY = "initialDelayDuration";
    private final static String TAG_POLLING_WORK_KEY = "background_polling_tag";
    private final static int DEFAULT_DELAY = 20000;

    public PollingWorker(
            @Nonnull Context ctx,
            @Nonnull WorkerParameters params) {
        super(ctx, params);
        //WorkManager.getInstance(ctx).getWorkInfosByTag("Test Worker"));
    }

    @NonNull
    public ListenableWorker.Result doWork() {
        try {
            Log.d("TEST", "sending work");
            return ListenableWorker.Result.success();
        } catch (Throwable throwable) {
            Log.e("TEST", "Error applying blur", throwable);
            return ListenableWorker.Result.failure();
        }

    }

    public static void startPollingWorker(
            final long interval,
            Context ctx,
            final @Nullable String pollingWorkerTag,
            @NotNull LifecycleOwner lifecycleScope) {
        Log.d("TEST", "interval:" + interval);
        Log.d("TEST", "pollingWorkerTag:" + pollingWorkerTag);

        PeriodicWorkRequest pollingWorkerRequest =
                new PeriodicWorkRequest.Builder(PollingWorker.class, interval, TimeUnit.SECONDS)
                        .addTag(pollingWorkerTag)
                        .build();
        UUID workerId = pollingWorkerRequest.getId();

        OneTimeWorkRequest oneTimeWorkRequest =
                new OneTimeWorkRequest.Builder(PollingWorker.class)
                        .addTag("test tag")
                        .build();

        Log.d("TEST", "workerId set:" + workerId);
        Operation operationResult = WorkManager.getInstance(ctx).enqueueUniquePeriodicWork(pollingWorkerTag, ExistingPeriodicWorkPolicy.KEEP, pollingWorkerRequest);
//        Operation operationResult = WorkManager.getInstance(ctx).enqueue(oneTimeWorkRequest);
      /*  WorkManager.getInstance(ctx).getWorkInfoByIdLiveData(workerId).observe(lifecycleScope, workInfo -> {
            Log.d("TEST", "worker listened:" + workInfo.getState());
        });*/
            /*if (workInfo.getState() == WorkInfo.State.SUCCEEDED) {
                Toast.makeText(ctx, "Success", Toast.LENGTH_SHORT).show();
            } else {
                Log.d("TEST", "worker listened: Failure");
                Toast.makeText(ctx, "Failure", Toast.LENGTH_SHORT).show();
            }*/
        ;
        //operationResult.getState();
        //Log.d("TEST", "operation result:" + operationResult.getState().observeForever(););
        Log.d("TEST", "operation result:" + operationResult.getResult().isDone());
        Log.d("TEST", "operation result:" + operationResult.getResult().isCancelled());
    }
}