
1. The author should also be able to define a State Machine using API’s provided by the FSM framework
2. The author should be able to define a State Machine using a declarative language like XML or HTML or JSON 
3. State machine can have many entry states, based on the initial event the State Machine will be in one of the many possible initial states. State machine can have many end states
4. Not all event cause state transition, some events only execute logic and remain in the same state
5. The author should be able to execute a action when a event occurs
6. Each event will carry data related to the event. e.g. for bug opened event, id, priority, desc, .. etc
7. Should be able to execute a action when State Machine enters a state or exit a state
8. The author should be able to add custom actions 
9. Should be able to add additional capabilities/features to State machine like tracking, persistence
10. Forks are used to split an incoming transition into concurrent multiple transitions leading to different target states. Joins are used to merge concurrent multiple transitions into a single transition leading to a single target. 
11. The persistence capability should guarantee reliability in case of process/system restarts 
12. All events Raised on a workflow instance and the transitions are tracked in the workflow history
13. An Exception is raised when a event Raised does not have a transition in the given state. The Exception is also Tracked in the history of the workflow instance.
14. Should support multiple versions  of  the state machine
15. When a event is fired on a State Machine, the Transition from one state to another could be also have additional rules to decide the destination state.  e.g.. only if Order.amount > 300
16. The rules used to decide the destination state should also be author-able in declarative language or API
17. Author should be able to suspend or cancel a running workflow
18. Author should be able to set a timeout for a workflow
19. Author should be able to add additional transitions or states to a running workflow.
20. Should be able to start one or more sub workflow when a workflow reaches a specific state or  a specific end state or times out.
21. Should be able to wait for one or more sub workflow to reach a specific state and then resume execution of the Main workflow
22. StateMachine contain sensitive information that is not intended to be shared with everyone in the process.  System should allow you to customize what each user can see and edit.
