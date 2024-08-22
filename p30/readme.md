### 1. Context
The exercise requires you to develop an alert execution engine that executes alerts at the specified interval checks and sends notifications if alerts fire. 

### 2. Functional requirements
- Create and delete alerts. Retrieve a list of alerts created by the user. View the execution history for any given alert.
- The system should support both one-time execution and recurring style.
- When that data meets the alerting policy condition, Monitoring creates an incident and sends the notifications.

One alert execution cycle involves:
- Making an API call (query) to query the value of the metric
- Comparing the return value against Critical thresholds
- Determining the state of the alert
- Make a Notify API call if the alert is in CRITICAL state

### Reference
- https://www.linkedin.com/pulse/notification-system-design-rajiv-srivastava 
- https://medium.com/@mayilb77/design-a-distributed-job-scheduler-for-millions-of-tasks-in-daily-operations-4132dc6d645f
