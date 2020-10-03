# Work_Manager_Project


WorkManager is an API that makes it easy to schedule deferrable, asynchronous tasks that are expected to run even if the app exits or the device restarts.

The WorkManager API is a suitable and recommended replacement for all previous Android background scheduling APIs, including FirebaseJobDispatcher, GcmNetworkManager, and Job Scheduler.

WorkManager incorporates the features of its predecessors in a modern, consistent API that works back to API level 14 while also being conscious of battery life.



WorkManager is one of the Android Architecture Components and part of Android Jetpack, a new and opinionated take on how to build modern Android applications.

WorkManager is an Android library that runs deferrable background work when the work’s constraints are satisfied.
WorkManager is intended for tasks that require a guarantee that the system will run them even if the app exits.
WorkManager provides a battery-friendly API that encapsulates years of evolution of Android’s background behavior restrictions. This is critical for Android applications that need to execute background tasks!

To summarize, WorkManager offers the following benefits:

Handles compatibility with different OS versions
Follows system health best practices
Supports asynchronous one-off and periodic tasks
Supports chained tasks with input/output
Lets you set constraints on when the task runs
Guarantees task execution, even if the app or device restarts.

Android WorkManager can be a perfect background processing library to use when your task –

1. Does not need to run at a specific time

2. Can be deferred to be executed

3. Is guaranteed to run even after the app is killed or device is restarted

4. Has to meet constraints like battery supply or network availability before execution


Work is defined using the Worker class. The doWork() method is run synchronously on a background thread provided by WorkManager.


Before writing the actual codes first we should understand the WorkManager classes.

Worker: The main class where we will put the work that needs to be done.

WorkRequest: It defines an individual task, like it will define which worker class should execute the task.

WorkManager: The class used to enqueue the work requests.

WorkInfo: The class contains information about the works. For each WorkRequest we can get a LiveData using WorkManager. The LiveData holds the WorkInfo and by observing it we can determine the Work Informations.


public class AmodWorker extends Worker {
    public static final String NOTIFICATION_CHANNEL_ID = "10001";
    public AmodWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
      createNotification("I am amod","finished");
        return  Result.success();
    }
