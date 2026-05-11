🏛️ Java Design Patterns Lab

A comprehensive collection of software design patterns implemented in Java with practical examples and interactive demonstrations. This project serves as a hands-on learning resource for understanding design patterns through clean, maintainable code that follows SOLID principles and best practices.

## 🔧 Implemented Patterns

### Observer Pattern
**Location:** `src/ObserverPattern/`


**Key Components:**
- `Observer` Interface: Defines the contract for objects that want to receive notifications
- `Subject` Interface: Defines methods for attaching, detaching, and notifying observers
- `State` Enum: Represents different types of events (New_video_uploaded, Live_Started)
- `YoutubeChannel` Class: Concrete subject that maintains a list of subscribers and notifies them of events
- `Subscriber` Class: Concrete observer that receives and processes notifications

**Implementation Details:**
- **State-Aware Notifications:** Observers receive specific state information, allowing them to react differently to various events
- **Dynamic Subscription:** Observers can subscribe and unsubscribe at runtime
- **Type-Safe Events:** Using enum for states ensures compile-time safety and prevents invalid event types
- **Clean Separation:** Clear separation between subject logic and observer behavior

### Observer Pattern UML
```
┌─────────────────┐           ┌──────────────────┐
│    <<interface>>│           │   <<interface>>  │
│    Observer     │           │    Subject      │
├─────────────────┤           ├──────────────────┤
│ +update(state)  │           │ +subscribe(obs)  │
└─────────┬───────┘           │ +unsubscribe(obs)│
          │                   │ +notifyObservers│
          │                   └─────────┬────────┘
          │                            │
          ▼                            ▼
┌─────────────────┐           ┌──────────────────┐
│   Subscriber    │           │ YoutubeChannel   │
├─────────────────┤           ├──────────────────┤
│ -name: String   │           │ -subscribers: List│
│ -date: String   │           │ -state: State    │
│ +update(state)  │           │ -name: String    │
│ +getName()      │           │ +subscribe(obs)  │
│ +setName()      │           │ +unsubscribe(obs)│
└─────────────────┘           │ +notifyObservers│
                              │ +uploadVideo()   │
                              │ +startLive()     │
                              └─────────┬────────┘
                                        │
                                        ▼
                              ┌─────────────────┐
                              │ <<enumeration>> │
                              │      State      │
                              ├─────────────────┤
                              │ New_video_upld  │
                              │ Live_Started    │
                              └─────────────────┘
```

### Observer Pattern Flow
```
┌─────────┐    subscribe()     ┌─────────────┐    add subscriber    ┌─────────────┐
│ Main    │────────────────────►│YoutubeChannel│─────────────────────►│ Subscribers │
└─────────┘                    └─────────────┘                      │  List       │
        │                              │                            └─────────────┘
        │                              │
        ▼                              ▼
┌─────────┐    uploadVideo()    ┌─────────────┐    notifyObservers()    ┌─────────────┐
│ Main    │────────────────────►│YoutubeChannel│───────────────────────►│ Subscribers │
└─────────┘                    └─────────────┘                        └─────────────┘
        │                              │                                        │
        ▼                              ▼                                        ▼
┌─────────┐    unsubscribe()    ┌─────────────┐    remove subscriber   ┌─────────────┐
│ Main    │────────────────────►│YoutubeChannel│─────────────────────►│ Subscribers │
└─────────┘                    └─────────────┘                      │  List       │
                                      │                            └─────────────┘
                                      ▼
                              ┌─────────────┐    update(state)    ┌─────────────┐
                              │ State = New │◄─────────────────────│ Subscriber  │
                              │ Video       │                      │ Notification │
                              └─────────────┘                      └─────────────┘
```

### Strategy Pattern
**Location:** `src/strategyPattern/`

**Concept:** The Strategy pattern defines a family of algorithms, encapsulates each one, and makes them interchangeable. This pattern lets the algorithm vary independently from clients that use it, promoting code reusability and flexibility. It's particularly useful when you have multiple ways to accomplish a task and want to switch between them easily.

**Key Components:**
- `PaymentStrategy` Interface: Defines the contract for payment algorithms
- `PaymentService` Class: Context that uses different payment strategies
- `PaymentFactory` Class: Factory for creating appropriate strategy instances
- `PaymentType` Enum: Defines available payment methods (PAYPAL, CREDIT_CARD, CASH)
- Concrete Strategies: `PaymentByCreditCard`, `PaymentWithPaypal`, `PaymentByCashOnDelivery`

**Implementation Details:**
- **Factory Integration:** Uses Factory pattern to create appropriate strategy instances based on user input
- **Interactive Demo:** Menu-driven interface allowing users to select payment methods
- **Encapsulated Algorithms:** Each payment method encapsulates its specific payment logic
- **Runtime Flexibility:** Strategies can be selected at runtime based on user preferences
- **Extensibility:** New payment methods can be added without modifying existing code

### Strategy Pattern UML
```
┌─────────────────┐           ┌──────────────────┐
│ <<interface>>   │           │ PaymentService   │
│ PaymentStrategy │◄──────────┤                  │
├─────────────────┤           ├──────────────────┤
│ +collectDetails│           │ +checkOut(amount,│
│ +pay(amount)   │           │   strategy)      │
└─────────┬───────┘           └──────────────────┘
          ▲
          │
          │
┌─────────┴───────┬─────────────┬─────────────────┐
│                 │             │                 │
▼                 ▼             ▼                 ▼
┌─────────────┐ ┌─────────────┐ ┌─────────────┐ ┌─────────────┐
│PaymentByCC  │ │PaymentWith  │ │PaymentByCash│ │  Main       │
├─────────────┤ │Paypal       │ ├─────────────┤ ├─────────────┤
│+collectDet  │ │+collectDet  │ │+collectDet  │ │+main()      │
│+pay(amount) │ │+pay(amount) │ │+pay(amount) │ │             │
└─────────────┘ └─────────────┘ └─────────────┘ └─────────────┘

┌─────────────────┐           ┌─────────────────┐
│PaymentFactory   │◄──────────│ <<enumeration>> │
│                 │           │  PaymentType    │
├─────────────────┤           ├─────────────────┤
│+createStrategy  │           │ PAYPAL          │
│  (type)         │           │ CREDIT_CARD     │
└─────────────────┘           │ CASH            │
                              └─────────────────┘

```

### Strategy Pattern Flow
```
┌─────────┐    select payment    ┌─────────────┐    create strategy    ┌─────────────┐
│ Main    │─────────────────────►│PaymentFactory│◄─────────────────────│PaymentType  │
└─────────┘                    └─────────────┘                      └─────────────┘
        │                                │
        ▼                                ▼
┌─────────────┐    checkout()    ┌─────────────┐    pay(amount)    ┌─────────────┐
│PaymentService│─────────────────►│PaymentStrategy│──────────────────►│Transaction  │
└─────────────┘                  └─────────────┘                  └─────────────┘
```

