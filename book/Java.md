# Java

## Basics

- object reference is int32(32-bit JVM) or long64(64-bit system)

**SOLID**

* Single Responsibility principle
* Open/Closed principle  
  Open for extension, closed for modification.  
  You should be able to add new functionality without changing existing code.
* Liskov substitution principle  
  Subtypes must behave like their parent types.
* Interface segregation principle  
  Clients should not be forced to depend on interfaces they do not use.
* Dependency inversion principle  
  High-level modules should not depend on low-level modules. Both should depend on abstractions.  
  Depend on interfaces, not concrete implementations.

**OOP**

* Encapsulation
* Inheritance  
  Promotes code reuse.
* Polymorphism  
  Objects can take many forms; the same interface can be implemented differently.
* Abstraction  
  Hiding complex implementation details and showing only the necessary features.  
  Focus on **what** an object does, not **how**.  
  Example: A Vehicle interface with a move() method

Polymorhism vs Inheritance:   
But polymorphism is a **behavior**, while inheritance is a **mechanism**. Inheritance is a relationship.

### Types of References in Java

Java provides **four types of references**, each with different behavior in relation to **Garbage Collection (GC)**:

| Reference Type | Class                               | GC Behavior                                                 | Use Case                                   |
|----------------|-------------------------------------|-------------------------------------------------------------|--------------------------------------------|
| **Strong**     | Ordinary reference                  | Not collected while reachable                               | Normal object usage                        |
| **Soft**       | `java.lang.ref.SoftReference<T>`    | Collected **only when memory is low**                       | Memory-sensitive caches                    |
| **Weak**       | `java.lang.ref.WeakReference<T>`    | Collected **next GC cycle**, even if memory is fine         | Caches, canonical maps, `WeakHashMap`      |
| **Phantom**    | `java.lang.ref.PhantomReference<T>` | Collected **after finalization**, must use `ReferenceQueue` | Advanced cleanup, direct memory management |

## JMM

### Happens-before

If **A happens-before B**, then:

1. All effects (writes, memory changes) of A are visible to B.
2. A must **appear to execute before** B — from the perspective of all threads.

**Happens-before** is a _guarantee of ordering and visibility_. It doesn’t necessarily mean "executed earlier" — it’s
about what can be **observed**.

#### Common Happens-Before Relationships

| Relationship                 | Explanation                                                                                                               |
|------------------------------|---------------------------------------------------------------------------------------------------------------------------|
| **Program order rule**       | In a single thread, actions appear in the order written.                                                                  |
| **Monitor lock rule**        | Unlocking a monitor (e.g., `synchronized`) happens-before a subsequent lock on the same monitor.                          |
| **Volatile rule**            | A write to a `volatile` variable happens-before a subsequent read of that variable.                                       |
| **Thread start rule**        | A call to `Thread.start()` happens-before any action in the started thread.                                               |
| **Thread termination rule**  | All actions in a thread happen-before another thread detects its termination via `Thread.join()` or `isAlive() == false`. |
| **Executor submission rule** | Submitting a task to an executor happens-before the task starts executing.                                                |

### Safe Publication

**Safe publication** is the guarantee that an object is **fully constructed** and **visible to all threads** after it's
shared. In Java, it's part of ensuring correct visibility and ordering under the Java Memory Model (JMM).

❗ Why It's Important  
If you publish an object unsafely, other threads might:

* See a **partially constructed** object (some fields still default).
* Read **stale values** due to instruction reordering or caching.

| Method                                   | Description                                                                                                                         |
|------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------|
| **Immutable objects**                    | No state can change after construction — inherently safe.                                                                           |
| **`final` fields + proper construction** | Java guarantees visibility of `final` fields if object is constructed safely (without leaking `this` or any field in constructor ). |
| **`volatile` field**                     | Writing the reference to a `volatile` field makes the object safely published.                                                      |
| **`synchronized` block**                 | Synchronization on any shared lock ensures visibility.                                                                              |
| **Thread-safe containers**               | Adding an object to a `ConcurrentHashMap`, `BlockingQueue`, etc. ensures safe publication.                                          |
| **Static initializers**                  | JVM guarantees safe publication of class static fields.                                                                             |

### Piggybacking

Piggybacking is when you attach (or piggyback) additional information onto a shared variable to:

* Avoid extra synchronization
* Combine multiple actions into one atomic update   
  It's a trick to encode more than one logical piece of state into a single atomic reference or value.

```java
record TaskState(Task task, int version) {
}

AtomicReference<TaskState> state = new AtomicReference<>(new TaskState(null, 0));

// Atomic update: replace only if both match
state.

compareAndSet(
    new TaskState(oldTask, oldVersion),
    new

TaskState(newTask, oldVersion +1)
);
```

This way:

* You update both `task` and `version` in one atomic step.
* You can implement optimistic locking (using the version).
* No need for a separate lock just to track changes.

### Optimistic locking

**Optimistic locking** is a concurrency control strategy where you assume **conflicts are rare**, so you proceed without
locking — but **verify** at commit time whether your assumption was correct.

It's widely used in multithreaded programming, databases (e.g., JPA/Hibernate), and lock-free algorithms.

```java
AtomicReference<Integer> balance = new AtomicReference<>(100);

void withdraw(int amount) {
    while (true) {
        int current = balance.get();
        int newBalance = current - amount;
        if (balance.compareAndSet(current, newBalance)) {
            break; // success!
        }
        // else: another thread changed the balance — retry
    }
}
```

#### Compare with Pessimistic Locking

| Feature                           | Optimistic                       | Pessimistic              |
|-----------------------------------|----------------------------------|--------------------------|
| Lock-free                         | ✅                                | ❌                        |
| Blocking                          | ❌                                | ✅                        |
| Performance under low contention  | 🟢 Very good                     | 🟡 Acceptable            |
| Performance under high contention | 🔴 Retry-heavy                   | 🟢 Consistent            |
| Risk                              | Lost updates if check is skipped | Deadlocks if not careful |

## GC

### Heap

| Region                                   | Description                                                                              |
|------------------------------------------|------------------------------------------------------------------------------------------|
| **Eden**                                 | Where most new objects are first allocated.                                              |
| **Survivor 0 (S0)**                      | One of the survivor spaces for copying during GC.                                        |
| **Survivor 1 (S1)**                      | The other survivor space. S0 and S1 alternate roles after each Minor GC.                 |
| **Old Generation (Tenured)**             | Long-lived objects                                                                       |
| **(Optional) Humongous / Large Objects** | Very large objects may bypass Young Gen and go directly to Old Gen (especially in G1 GC) |

### Not in the Heap

| Area                         | Description                                                          |
|------------------------------|----------------------------------------------------------------------|
| **Metaspace** (Java 8+)      | Stores class metadata (replaces PermGen)                             |
| **Code Cache**               | JIT-compiled native code                                             |
| **Thread Stacks**            | Each thread has its own call stack (not GC-managed)                  |
| **Direct / Off-heap Memory** | Manually allocated native memory (e.g., `ByteBuffer.allocateDirect`) |
| **Native Heap (C heap)**     | Used by the JVM itself or JNI libraries                              |

#### What Qualifies as “Humongous”?

In G1 GC, the heap is divided into fixed-size regions (e.g., 1–32 MB each, typically 1–4 MB by default). An object is
considered humongous if:  
**Object size ≥ 50% of a region size**  
That means:

* If region size = 4 MB
* Then object ≥ 2 MB → it's a humongous object

```java
byte[] bigArray = new byte[3_000_000]; // ~2.86 MB

// If region size = 1 MB → Humongous
// If region size = 4 MB → Not humongous
```

How G1 Handles Humongous Objects

* Humongous objects skip the Young Generation.
* They are **allocated directly into contiguous regions in Old Gen.**
* They may occupy **multiple whole regions.**
* Each region is **fully dedicated**, even if only partially used → wasteful.

| GC Type                                         | How It Works                                                                                                                      | Minor GC                                    | Major/Full GC                                      | Pros                                     | Cons                                              |
|-------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------|---------------------------------------------|----------------------------------------------------|------------------------------------------|---------------------------------------------------|
| **Serial GC** (`-XX:+UseSerialGC`)              | Uses **one thread** for all GC tasks. Very simple. Best for small apps.                                                           | Stop-the-world (STW), single-threaded       | Stop-the-world, single-threaded                    | Low overhead, predictable                | Long pauses, not scalable                         |
| **Parallel GC** (`-XX:+UseParallelGC`)          | Uses **multiple threads** to speed up GC, especially in Minor GC.                                                                 | Parallel, stop-the-world                    | Parallel, stop-the-world                           | High throughput                          | Long pause times, even for Old Gen                |
| **G1 GC** (default in Java 9+) (`-XX:+UseG1GC`) | Divides heap into regions. Does incremental **copying collection**. Prioritizes areas with the most garbage ("Garbage First").    | Parallel, stop-the-world, young-region only | Mostly concurrent marking + stop-the-world cleanup | Balanced, tunable pause times            | Overhead from region tracking, more tuning needed |
| **ZGC** (`-XX:+UseZGC`)                         | Designed for **very low pause times**. Fully concurrent GC using colored pointers and barriers. Handles **multi-terabyte** heaps. | Mostly concurrent, extremely low-pause      | Concurrent marking & relocation, <10ms pause       | Pause times are independent of heap size | Still evolving, not great for small heaps         |
| **Shenandoah** (`-XX:+UseShenandoahGC`)         | Similar to ZGC but developed by Red Hat. Also uses barriers for concurrent compaction.                                            | Mostly concurrent, low-pause                | Fully concurrent, compacting                       | Predictable low latency                  | Higher CPU use, less throughput                   |
| **Epsilon GC** (`-XX:+UseEpsilonGC`)            | No-op GC — **no collection at all**. For testing, benchmarking                                                                    | No GC                                       | No GC                                              | Benchmarking realism                     | Will crash when memory runs out                   |
| **CMS** *(deprecated)*                          | Concurrent Mark-Sweep — Old Gen is collected concurrently to reduce pauses                                                        | Stop-the-world, parallel                    | Concurrent mark + sweep + short STW remark         | Low-pause GC before G1 existed           | Fragmentation, legacy, removed since Java 14      |

| Term         | Meaning                                                                                         |
|--------------|-------------------------------------------------------------------------------------------------|
| **Minor GC** | Collects **Young Generation** (Eden + Survivor). Frequent but fast.                             |
| **Major GC** | Collects **Old Generation** (Tenured). Can be stop-the-world or concurrent.                     |
| **Full GC**  | Collects **entire heap** (Young + Old + Metaspace). Usually **stop-the-world**, most expensive. |

```
-Xms1g // initial heap size
-Xmx2g // max heap siz
-Xss2m // stack size
-Xmn512m // sets size of Young Generation
-XX:NewRatio=3 // Old:Young = 3:1
-XX:SurvivorRatio=8 // Eden:Survivor = 8:1:1
```

## 1. Collection<E> (interface)

![collections_tree.png](img/collections_tree.png)

- **Key methods**:
    - `add(E e)`
    - `remove(Object o)`
    - `contains(Object o)`
    - `size()`
    - `clear()`
    - `iterator()`

### Sequenced Collection

- `SequencedCollection<E> reversed()`
- `void addFirst(E e)`
- `void addLast(E e)`
- `E getFirst()` can throw `NoSuchElementException`
- `E getLast()` can throw `NoSuchElementException`
- `E removeFirst()` can throw `NoSuchElementException`
- `E removeLast()` can throw `NoSuchElementException`

### List<E> (ordered, allows duplicates)

- Implementations:
    - `ArrayList`
        - grow on demand x1.5
        - initial cap=10 but lazily allocates in first `add`(for custom cap allocates instantly).
        - doesn't trim automatically, use list.trimToSize()
    - `LinkedList` implements [Deque](#dequee-double-ended-queue)
    - `Vector` (old, slower than ArrayList because of synch, increases x2)
    - `Stack` (extends Vector, so better to use ArrayDeque)
- **Key methods** (in addition to Collection):
    - `get(int index)`
    - `set(int index, E element)`
    - `add(int index, E element)`
    - `remove(int index)`
    - `indexOf(Object o)`
    - `subList(int fromIndexInc, int toIndexExc)`

### Set<E> (no duplicates)

- Implementations:
    - `HashSet` use HashMap with constant value
    - `LinkedHashSet extends HashSet<E> implements SequencedSet<E>` uses LinkedHashMap
    - `TreeSet`
- **Key methods**: Same as `Collection`, but no positional access

### SortedSet<E> → NavigableSet<E> (ordered set)

- Implementation:
    - `TreeSet`
- **Key methods**:
    - `first()`, `last()`
    - `headSet(E toElement)`, `tailSet(E fromElement)`
    - `subSet(E from, E to)`
    - `lower(E e)`, `higher(E e)`
    - `ceiling(E e)`, `floor(E e)`
    - `pollFirst()`, `pollLast()`

### Queue<E> (FIFO)

- Implementations:
    - `LinkedList`, `PriorityQueue`, `ArrayDeque`
- **Key methods**:
    - `offer(E e)`
    - `poll()`
    - `peek()`

### Deque<E> (double-ended queue)

- Implementations:
    - `ArrayDeque`, `LinkedList`
- **Key methods**:
    - `addFirst(E e)`, `addLast(E e)`
    - `removeFirst()`, `removeLast()`
    - `peekFirst()`, `peekLast()` returns `null` instead of Exception comparing to `getFirst()`
    - `offerFirst(E e)`, `offerLast(E e)` works as `addFirst()` but returns `boolean` instead of Exception
    - `pollFirst()`, `pollLast()` get and remove or null

---

## 2. Map<K, V> (not part of Collection)

- Implementations:
    - `SequencedMap` interface, `reversed()`, `firstEntry()`, `pollFirstEntry()`, `putFirst(K k, V v)`,
      `sequencedKeySet()`
    - `HashMap`
    - `LinkedHashMap` extends HashMap, each entry has link to prev and next entry.
    - `TreeMap`
    - `Hashtable`
    - `ConcurrentHashMap`

### LinkedHashMap vs TreeMap

| Feature                        | LinkedHashMap                                | TreeMap                                       |
|--------------------------------|----------------------------------------------|-----------------------------------------------|
| **Ordering**                   | Insertion order (or access order if enabled) | Sorted by keys (natural or via Comparator)    |
| **Underlying structure**       | Hash table + Doubly linked list              | Red-black tree                                |
| **Time complexity (get/put)**  | O(1) average case                            | O(log n)                                      |
| **Key requirements**           | `equals()` and `hashCode()`                  | `Comparable` or `Comparator`                  |
| **Null keys**                  | ✅ Allows one `null` key                      | ❌ Not allowed                                 |
| **Iteration order**            | Insertion or access order                    | Sorted key order                              |
| **Navigation methods**         | ❌ Not supported                              | ✅ `firstKey()`, `lastKey()`, `subMap()`, etc. |
| **LRU cache support**          | ✅ Yes (`accessOrder = true`)                 | ❌ No                                          |
| **Range queries**              | ❌ Not supported                              | ✅ Fully supported                             |
| **Performance for large data** | Faster random access, less overhead          | Better for sorted/range-based access          |
| **Thread safety**              | ❌ Not thread-safe                            | ❌ Not thread-safe                             |

### SortedMap<K, V> → NavigableMap<K, V>

- Implementation:
    - `TreeMap`
- **Key methods** (in addition to Map):
    - `firstKey()`, `lastKey()`
    - `subMap(K from, K to)`
    - `headMap(K toKey)`, `tailMap(K fromKey)`
    - `lowerEntry(K key)`, `higherEntry(K key)`
    - `floorEntry(K key)`, `ceilingEntry(K key)`
    - `pollFirstEntry()`, `pollLastEntry()`

---

## 3. Special Collections (Selected)

- `EnumSet` – efficient enum-based Set
- `EnumMap` – efficient enum-based Map
- `WeakHashMap` – keys are garbage-collectible
- `IdentityHashMap` – uses reference equality (==)
- `ConcurrentHashMap` – thread-safe map
- `CopyOnWriteArrayList`, `CopyOnWriteArraySet` – thread-safe snapshot collections

---

## Generics

- `List<? super Integer> list` - add `Integer`, read `Object`
- `List<?> list` - read only
- type erasure in runtime

### Variance Comparison: Java Arrays, Java Generics, Kotlin

**Covariant** = List<? extends Animal> = List<Dog> → safe **read**, can't write   
**Contravariant** = List<? super Dog> → safe **write**, read returns Object   
**Invariant** = List<String> != List<Object> — different types

| Structure             | Covariant (allows subtype)? | Contravariant? | Notes                                                         |
|-----------------------|-----------------------------|----------------|---------------------------------------------------------------|
| `Java arrays (T[])`   | ✅ Yes                       | ❌ No           | **Unsafe!** Arrays are covariant but not type-safe at runtime |
| `List<T>` (Java)      | ❌ No                        | ❌ No           | Invariant — `List<Object>` ≠ `List<String>`                   |
| `List<? extends T>`   | ✅ Yes (read-only)           | ❌ No           | Covariant — can read, but can't safely add                    |
| `List<? super T>`     | ❌ No                        | ✅ Yes (write)  | Contravariant — can add `T`, but can't read as `T`            |
| `Kotlin: Array<T>`    | ❌ No                        | ❌ No           | Invariant, like `List<T>` in Java                             |
| `Kotlin: List<out T>` | ✅ Yes                       | ❌ No           | Covariant (like `? extends`), read-only                       |
| `Kotlin: List<in T>`  | ❌ No                        | ✅ Yes          | Contravariant (like `? super`), usually for consumers         |


