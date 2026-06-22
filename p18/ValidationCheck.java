class Service {
    List<ValidationCheck> checks;
    // DB restart requires: 
    // DiskSpaceCheck, PortAvailableCheck, ReplicationLagCheck
}

class ValidationCheck {
    List<Service> services;
    // DiskSpaceCheck is required by: 
    // DB, Cache, MessageQueue
}

When restarting a service, you need: "run all validation checks for this service before proceeding"
When a validation check fails, you need: "which services are now blocked from restarting?" — to log and halt the entire dependent chain

