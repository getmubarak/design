import java.util.List;

class NetworkPacket {
    private double sizeKb;
    public double getSizeKb() { return sizeKb; }
}

public class VirtualTrafficRouter {

    public enum DelayType {
        FIXED,
        LINEAR_BACKOFF,
        JITTER_THRESHOLD
    }

    private DelayType delayType;

    // FIXED delay constants
    private static final double FIXED_RATE = 0.05; // 5% processing tax per KB
    private static final double FIXED_MIN_THRESHOLD = 1000; // minimum package size to trigger delay

    // LINEAR_BACKOFF delay constants
    private static final double BACKOFF_SCALE = 0.025;
    private static final double BASE_HANDSHAKE_FEE = 500; // base network handshake overhead in ms

    // JITTER_THRESHOLD delay constants
    private static final double TRAFFIC_BURST_THRESHOLD = 5000;
    private static final double JITTER_RATE_BELOW_BURST = 0.3;
    private static final double JITTER_RATE_ABOVE_BURST = 0.4;

    private List<NetworkPacket> packetQueue;

    public void setDelayType(DelayType delayType) {
        this.delayType = delayType;
    }

    // Helper condition equivalent to isKSTApplicable
    boolean isFixedDelayApplicable(double totalSize) {
        return totalSize > FIXED_MIN_THRESHOLD;
    }

    // Helper condition equivalent to isBelowGSTThreshold
    boolean isBelowBurstThreshold(double totalSize) {
        return totalSize < TRAFFIC_BURST_THRESHOLD;
    }

    // THE SMELLY METHOD: Contains the entire strategy switch matrix
    public double calculateTotalLatencyMs() {
        double currentDelay = getQueuePayloadSize();

        switch (delayType) {
            case FIXED:
                if (isFixedDelayApplicable(currentDelay)) {
                    currentDelay += currentDelay * FIXED_RATE;
                }
                break;

            case LINEAR_BACKOFF:
                currentDelay += currentDelay * BACKOFF_SCALE + BASE_HANDSHAKE_FEE;
                break;

            case JITTER_THRESHOLD:
                if (isBelowBurstThreshold(currentDelay)) {
                    currentDelay += (currentDelay - TRAFFIC_BURST_THRESHOLD) * JITTER_RATE_BELOW_BURST;
                } else {
                    currentDelay += (currentDelay - TRAFFIC_BURST_THRESHOLD) * JITTER_RATE_ABOVE_BURST;
                }
                break;
        }

        return currentDelay;
    }

    // Aggregates sub-elements, equivalent to getSubtotal()
    double getQueuePayloadSize() {
        double totalSize = 0;
        for (NetworkPacket packet : packetQueue) {
            totalSize += packet.getSizeKb();
        }
        return totalSize;
    }
}
