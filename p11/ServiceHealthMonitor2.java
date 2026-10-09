// Contract Library
interface HealthMonitorListener{
 void OnHighCpuUtilization();
}

// restart library
public class ServiceRestarterImp implements  HealthMonitorListener{
    public void OnHighCpuUtilization() {
        System.out.println("restarting service...");
    }
}

// monitoring library
public class ServiceHealthMonitor {
    HealthMonitorListener healthMonitorListener;
    double cpuUsage;
    public ServiceHealthMonitor(HealthMonitorListener healthMonitorListener){
        this.healthMonitorListener = healthMonitorListener;
    }
    public void onMetricChanged(double newCpuUsage) {
        cpuUsage = newCpuUsage;
        if (isCritical()) {
            healthMonitorListener.OnHighCpuUtilization();
        }
    }

    public boolean isCritical() {
        if (cpuUsage > 90 && memoryUsage > 85)
            return true;
        else
            return false;
    }
}


//client
ServiceRestarterImp restarter = new ServiceRestarterImp();
ServiceHealthMonitor monitor = new ServiceHealthMonitor(restarter);
...

