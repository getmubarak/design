---

## name: organizing-algorithm-code

description: How we structure object-oriented algorithm code so it stays readable, testable, and changeable. Use when writing, reviewing, or refactoring algorithm code — creating functions, classes, Stages, Modules, or Pipelines, or deciding where code belongs.

# Organizing Algorithm Code

How we structure object-oriented algorithm code so it stays readable, testable, and changeable. This guide is intended for anyone joining the codebase.

## Architecture

Function → Class → Stage → Module → Pipeline

A Stage is the primary unit of algorithmic organization. A Stage contains a small, cohesive group of classes that performs one part of an algorithm.

```
module_name/
│
├── dto/                       # Shared by all Algorithms
├── utils/                     # Shared by all Algorithms
├── rules/                     # All Rule classes
├── constants.py               # Module-level constants
│
└── algorithm_name/
    │
    ├── dto/                   # Algorithm-level
    ├── utils/                 # Algorithm-level
    ├── constants.py           # Algorithm-level constants
    ├── algorithm_name_pipeline.py    # <algorithm_name>_pipeline.py — the flow
    │
    ├── stage_1_name/          # Stage
    │   ├── __init__.py
    │   ├── dto/               # Stage-level
    │   ├── utils/             # Stage-level
    │   ├── constants.py       # Stage-level constants
    │   ├── stage_1_name_pipeline.py   # <stage_name>_pipeline.py — the flow
    │   ├── step_1_name.py
    │   ├── step_2_name.py
    │   └── step_3_name.py
    │
    ├── stage_2_name/          # Stage
    │   ├── __init__.py
    │   ├── dto/
    │   ├── utils/
    │   ├── constants.py
    │   ├── stage_2_name_pipeline.py
    │   └── step_1_name.py
    │
    └── stage_3_name/          # Stage
        ├── dto/
        ├── utils/
        ├── constants.py
        ├── stage_3_name_pipeline.py
        └── step_1_name.py
```



## 1. Writing a Function

Functions are the smallest unit of algorithmic behavior. Keep them small enough to understand, test, and change independently.

### Keep cyclomatic complexity under 10

A decision point includes an `if`, loop, case, catch, or logical `&&` / `||` condition. As complexity increases, the number of execution paths increases. Past 10, the function becomes harder to reason about and test comprehensively.

### Don't nest more than 3 levels deep

Prefer early returns over deeply nested conditionals.

### Prefer 3 parameters or fewer

Long parameter lists make functions harder to understand and make it easier to accidentally swap arguments. If several parameters naturally belong together, create a class with named fields instead.

### Return one conceptual result

A function should return one conceptual result. Avoid anonymous tuples:

```python
return price, tax
```

Prefer a named result:

```python
return PriceBreakdown(
    price=price,
    tax=tax
)
```

Named results make the contract explicit and prevent callers from having to remember the meaning or position of tuple elements.

### Functions belong to a class

All algorithmic behavior should be organized using objects.

### No nested functions



### No magic values

Don't embed unexplained numbers or strings directly in algorithm code.

### Don't hard-code  rules inside functions

 rules should not be embedded directly inside algorithm functions.

Bad:

```python
if customer.age >= 18 and customer.country == "US":
    approve()
```

Prefer putting the  rule in a dedicated Rule method/ class:

```python
if AdultUSCustomerRule().matches(customer):
    approve()
```

Rule method/classes make rules explicit, reusable, testable, and easier to change without modifying the algorithm flow.

## 2. Organizing Functions

A function either describes the flow or does the work. A flow function describes what happens. A work function performs the actual calculation or operation. A function should not mix the two.  

Algorithm code becomes difficult to maintain when one function both steers the algorithm and performs the calculations. Keep those responsibilities separate. 

Read a flow-level function out loud. It should sound like a plain-language summary of the algorithm.

## 3. Classes

Classes group closely related behavior and state.

### Keep classes small

- At most 5 public methods.
- At most 15 methods total

These are guidelines, not mathematical laws. If a class exceeds them, review its cohesion and responsibilities.

The goal is not to minimize the number of methods. The goal is to keep each class cohesive and understandable.  
  
Utility and Factory classes can have all methods public.

### Don't use inheritance to share implementation

Prefer composition over inheritance. If two classes need the same behavior, extract that behavior into a cohesive object that they can both use. Avoid creating a parent class solely to hold shared methods. Inheritance should represent a genuine is-a relationship, not simply a code-reuse mechanism.

### Avoid mixing static methods and class methods in a class with instance methods

Prefer not to mix instance and static methods in the same class. A class should primarily represent one kind of abstraction: either stateful behavior operating on an instance, or stateless utility behavior.

### Classes belong to a Stage

A Stage is a cohesive group of classes that performs one part of an algorithm.

```
Stage
│
├── Class
├── Class
├── Class
└── Class
```

A Stage should normally contain:

- less than 8 classes
- Review the design when it grows beyond 10 classes

The numbers are guidelines. Cohesion and clear responsibility matter more than the exact count.

### One file per class

Dont keep multiple classes with logic in one files. 

### Class name should match the file name



## 4. Stage Boundaries

A Stage is the primary boundary for organizing algorithm code.

### One class is the way in

Each Stage has one public entry point.

```
Stage
│
└── Public Entry Class
     │
     ├── Internal Class
     ├── Internal Class
     └── Internal Class
```

Only the entry class should be accessible from outside the Stage. The remaining classes are implementation details of the Stage.

### Stages are wired together from outside

A Stage should not know what runs before or after it. The Module or Pipeline is responsible for connecting Stages.

This allows Stages to be:

- reordered
- reused
- tested independently
- replaced without modifying their internal implementation



### Keep configuration separate from the algorithm

Thresholds, weights, rates, limits, and other runtime tunable values should not be in algorithm code.

Database, Environmental variables, Config Files, Cloud Storage should be in Service layer and passed as dto to algorithm module.