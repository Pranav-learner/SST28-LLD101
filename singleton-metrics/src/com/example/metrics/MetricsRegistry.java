package com.example.metrics;

import java.io.Serial;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Global metrics registry using eager/lazy Holder Singleton pattern.
 */
public class MetricsRegistry implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    // To prevent reflection attacks
    private static boolean isInitialized = false;

    private final Map<String, Long> counters = new HashMap<>();

    //  Make it a proper lazy, thread-safe singleton and private constructor
    //  Block reflection-based multiple construction
    private MetricsRegistry() {
        if (isInitialized) {
            throw new IllegalStateException("Singleton already initialized. Use getInstance().");
        }
        isInitialized = true;
    }

    // Thread-safe Lazy Initialization using Initialization-on-demand holder idiom
    private static class RegistryHolder {
        private static final MetricsRegistry INSTANCE = new MetricsRegistry();
    }

    public static MetricsRegistry getInstance() {
        return RegistryHolder.INSTANCE;
    }

    public synchronized void setCount(String key, long value) {
        counters.put(key, value);
    }

    public synchronized void increment(String key) {
        counters.put(key, getCount(key) + 1);
    }

    public synchronized long getCount(String key) {
        return counters.getOrDefault(key, 0L);
    }

    public synchronized Map<String, Long> getAll() {
        return Collections.unmodifiableMap(new HashMap<>(counters));
    }

    // Preserve singleton on serialization 
    @Serial
    protected Object readResolve() {
        return getInstance();
    }
}
