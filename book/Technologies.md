
## Kafka

- A **Broker** is a Kafka node; brokers form a **cluster**.
- By default, `num.partitions=1`, meaning each topic has a **single partition**.
- Partitions are usually **sharded (distributed) across brokers** to enable scaling.
- By default, `replication.factor=1`, so **no replication between brokers**.
- A **Producer** writes to multiple partitions. The partition is selected by:
    - **Hashing the key** (if provided),
    - Or **round-robin** when the key is null.
- A **Consumer** can consume from multiple partitions.
- Each partition is assigned to **only one consumer** within a **consumer group**.  
  Therefore, it is recommended to have `#partitions >= #consumers`.
- Consumers should **commit offsets** to mark their progress.
- Important consumer config parameters affecting stability:
    - `max.poll.interval.ms = 5 minutes` (default) — max time between `poll()` calls before consumer is considered dead and triggers rebalance.
    - `session.timeout.ms = 10 seconds` (default) — timeout for consumer heartbeats.
    - `heartbeat.interval.ms = 3 seconds` (default) — interval between heartbeat sends.
- **Rebalancing** can change partition assignments among consumers but does **not move data**.
- **Durability** is ensured by writing logs to disk and replicating partitions.
- Default message delivery guarantee is **at-least-once**.
- **MirrorMaker 2.0 (MM2)** is a Kafka tool for replicating data across clusters.
- `exactly-once` = `enable.idempotence=true` + `acks=all`

---

### Kafka and the CAP Theorem

- Kafka is primarily a **CP system** (Consistency + Partition tolerance) but can be configured toward **AP** (Availability + Partition tolerance).
- **Partition tolerance** refers to tolerance of network partitions between brokers, not clusters.  
  Brokers can be located in different data centers (DCs), but it’s recommended to keep separate clusters per DC and synchronize them using MirrorMaker 2.0.
- **In-Sync Replicas (ISR)** are replicas that are fully caught up with the leader. Only ISR members can be elected as leaders.
- Key configuration settings to balance consistency and availability:
    - `acks` — producer setting for number of replica acknowledgments required. Default is `acks=1`.  
      Setting `acks=all` means waiting for acknowledgments from all ISR replicas.
    - `min.insync.replicas` — minimum number of ISR replicas required to acknowledge a write for it to be considered successful.
    - `replication.factor` — number of replicas per partition.

---

## DB Queue

```sql
CREATE TABLE task_queue (
    id SERIAL PRIMARY KEY,
    payload JSONB NOT NULL,
    status TEXT NOT NULL DEFAULT 'new',
    created_at TIMESTAMP DEFAULT now(),
    updated_at TIMESTAMP
);

UPDATE task_queue
SET status = 'processing', updated_at = now()
WHERE id = (
    SELECT id FROM task_queue
    WHERE status = 'new'
    ORDER BY created_at
    FOR UPDATE SKIP LOCKED
    LIMIT 1
)
RETURNING *;
```

Isolation level: **Read Committed** enough.
Semantic: **at-most-once**. Need some watchdog to make it **at-least-once**.

## Ignite

SQL ORDER BY loads all data to memory.
