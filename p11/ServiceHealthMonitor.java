// restart library
public class ServiceRestarter {
    public void restart() {
        System.out.println("restarting service...");
    }
}

// monitoring library
public class ServiceHealthMonitor {
    double cpuUsage;

    public void onMetricChanged(double newCpuUsage) {
        cpuUsage = newCpuUsage;
        if (isCritical()) {
            ServiceRestarter restarter = new ServiceRestarter(); // ❌ wrong
            restarter.restart();
        }
    }

    public boolean isCritical() {
        if (cpuUsage > 90 && memoryUsage > 85)
            return true;
        else
            return false;
    }
}
