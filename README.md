🏛️ Java Design Patterns Lab

A comprehensive collection of software design patterns implemented in Java with practical examples and interactive demonstrations. This project serves as a hands-on learning resource for understanding design patterns through clean, maintainable code that follows SOLID principles and best practices.

## 🔧 Implemented Patterns

### Observer Pattern
**Location:** `src/ObserverPattern/`

**Concept:** The Observer pattern defines a one-to-many dependency between objects, where when one object (the subject) changes state, all its dependents (observers) are automatically notified and updated. This pattern is essential for building event-driven systems and maintaining loose coupling between objects.

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

**Real-World Use Case:** YouTube notification system where subscribers get notified about new video uploads or live streams. The channel (subject) maintains a list of subscribers (observers) and notifies them when events occur.

**Key Methods:**
- `subscribe(Observer observer)`: Add a new subscriber to the channel
- `unsubscribe(Observer observer)`: Remove a subscriber from notifications
- `notifyObservers()`: Notify all current subscribers about state changes
- `uploadVideo()`: Trigger new video upload notification
- `startLive()`: Trigger live stream start notification
- `update(State state)`: Observer method to handle incoming notifications

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

**Real-World Use Case:** E-commerce payment processing system where customers can choose from multiple payment options. The system processes payments differently based on the selected method while maintaining a consistent interface.

**Key Methods:**
- `collectPaymentDetails()`: Gather payment-specific information from user
- `pay(double amount)`: Execute the payment transaction
- `checkOut(double amount, PaymentStrategy strategy)`: Process payment using selected strategy
- `createStrategy(PaymentType type)`: Factory method to create appropriate strategy

**Pattern Benefits:**
- **Open/Closed Principle:** Open for extension (new strategies), closed for modification
- **Single Responsibility:** Each strategy handles one specific payment method
- **Dependency Inversion:** High-level modules depend on abstractions, not concrete implementations
- **Runtime Flexibility:** Algorithms can be swapped without changing client code
