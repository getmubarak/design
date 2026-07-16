// Contract Library
interface ServiceRestarter{
 void restart();
}

// restart library
public class ServiceRestarterImp implements  ServiceRestarter{
    public void restart() {
        System.out.println("restarting service...");
    }
}

// monitoring library
public class ServiceHealthMonitor {
    ServiceRestarter restarter;
    double cpuUsage;
    public ServiceHealthMonitor(ServiceRestarter serviceRestarter){
        restarter = serviceRestarter;
    }
    public void onMetricChanged(double newCpuUsage) {
        cpuUsage = newCpuUsage;
        if (isCritical()) {
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


//client
ServiceRestarterImp restarter = new ServiceRestarterImp();
ServiceHealthMonitor monitor = new ServiceHealthMonitor(restarter);
...

