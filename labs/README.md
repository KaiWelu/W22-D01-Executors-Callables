**Lab: Understanding ExecutorService and Thread Pools in Java**

### **Objective:**
In this lab, students will learn how to use `ExecutorService`, create and manage thread pools, and work with `Callable` and `Future` to handle concurrent tasks in Java.

---
### **Part 1: Using FixedThreadPool**
#### **Task 1: Implement a FixedThreadPool with Runnable Tasks**
1. Create a class `WorkerTask` that implements `Runnable`.
2. The `run()` method should print the thread name and simulate a task by sleeping for 500 milliseconds.
3. In the `main()` method, create an `ExecutorService` with a **fixed thread pool of size 3**.
4. Submit **7 tasks** to the executor.
5. Shutdown the executor properly.

**Example Output:**
```
Task 1 executed by Thread-1
Task 2 executed by Thread-2
Task 3 executed by Thread-3
Task 4 executed by Thread-1
Task 5 executed by Thread-2
Task 6 executed by Thread-3
Task 7 executed by Thread-1
```
---
### **Part 2: Using Callable and Future**
#### **Task 2: Implement a Callable Task That Returns a Value**
1. Create a class `SquareCalculator` that implements `Callable<Integer>`.
2. The `call()` method should compute and return the **square** of a given number.
3. In `main()`, create an `ExecutorService` with **a fixed thread pool of 2**.
4. Submit **three callable tasks** with numbers of your choice.
5. Retrieve the results using `Future<Integer>` and print them.
6. Shutdown the executor.

**Example Output:**
```
Square of 4: 16
Square of 7: 49
Square of 3: 9
```
---
### **Part 3: Using invokeAll() and invokeAny()**
#### **Task 3: Execute Multiple Tasks and Retrieve Results**
1. Create three `Callable` tasks that return different messages after a random delay.
2. Use `invokeAll()` to execute all tasks and retrieve their results.
3. Use `invokeAny()` to return the first completed task.

**Example Output:**
```
Task 2 completed
Task 1 completed
Task 3 completed
First completed result: Task 2 completed
```

---
### **Bonus Challenge:**
#### **Task 4: Implement a Timeout Mechanism**
Modify Task 2 so that if a computation takes longer than **2 seconds**, a `TimeoutException` should be thrown.
