

# 🚗 Parking System – Low Level Design

## Overview
This project implements a **Parking Lot Management System** using **Java + Spring Boot + JPA**.  
The system manages vehicle entry, slot allocation, ticket generation, and exit payment.

The design follows **clean architecture principles** and uses common **object-oriented design patterns**.

---

# 🏗️ System Architecture

Client (Postman / Frontend)
        │
        ▼
Controller Layer
        │
        ▼
Service Layer
        │
        ▼
Repository Layer
        │
        ▼
Database (PostgreSQL / H2)

---

# 📁 Project Structure

com.parkingsystem.parking
│
├── controller
│       ParkingController.java
│
├── service
│       ParkingService.java
│       impl
│           ParkingServiceImpl.java
│
├── repository
│       ParkingSlotRepository.java
│       TicketRepository.java
│
├── model
│       Vehicle.java
│       ParkingSlot.java
│       ParkingFloor.java
│       Ticket.java
│       VehicleType.java
│
├── dto
│       ParkingRequest.java
│       ParkingResponse.java
│
├── exception
│       ParkingFullException.java
│       GlobalExceptionHandler.java
│
├── utils
│       EndPoints.java
│
└── ParkingApplication.java

---

# 📊 UML Class Diagram

                    +----------------------+
                    |      ParkingLot      |   <<Singleton>>
                    +----------------------+
                    | floors : List        |
                    +----------------------+
                    | parkVehicle()        |
                    | exitVehicle()        |
                    +----------+-----------+
                               |
                               ▼
                    +----------------------+
                    |    ParkingFloor      |
                    +----------------------+
                    | floorNumber          |
                    | slots : List         |
                    +----------+-----------+
                               |
                               ▼
                    +----------------------+
                    |     ParkingSlot      |
                    +----------------------+
                    | id                   |
                    | vehicleType          |
                    | occupied             |
                    | vehicleNumber        |
                    +----------------------+
                    | assignVehicle()      |
                    | removeVehicle()      |
                    +----------------------+

            +---------------------+
            |       Vehicle       |
            +---------------------+
            | vehicleNumber       |
            | vehicleType         |
            +---------------------+

            +---------------------+
            |       Ticket        |
            +---------------------+
            | ticketId            |
            | entryTime           |
            | exitTime            |
            | slotId              |
            | price               |
            +---------------------+

            +---------------------+
            |       Payment       |
            +---------------------+
            | calculateFee()      |
            +---------------------+

---

# 🚘 Core Entities

## Vehicle

```java
public class Vehicle {

    private String vehicleNumber;
    private VehicleType vehicleType;

}
```

---

## VehicleType

```java
public enum VehicleType {

    BIKE,
    CAR,
    TRUCK

}
```

---

## ParkingSlot

```java
public class ParkingSlot {

    private Long id;

    private VehicleType vehicleType;

    private boolean occupied;

    private String vehicleNumber;

    public void assignVehicle(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
        this.occupied = true;
    }

    public void removeVehicle() {
        this.vehicleNumber = null;
        this.occupied = false;
    }
}
```

---

## ParkingFloor

```java
public class ParkingFloor {

    private int floorNumber;

    private List<ParkingSlot> slots;

}
```

---

## Ticket

```java
public class Ticket {

    private Long ticketId;

    private String vehicleNumber;

    private Long slotId;

    private LocalDateTime entryTime;

    private LocalDateTime exitTime;

    private double price;

}
```

---

# 🎯 Design Patterns Used

## 1️⃣ Singleton Pattern

Ensures only **one parking lot instance exists**.

```java
public class ParkingLot {

    private static ParkingLot instance;

    private List<ParkingFloor> floors;

    private ParkingLot() {}

    public static ParkingLot getInstance() {

        if(instance == null) {
            instance = new ParkingLot();
        }

        return instance;
    }
}
```

---

## 2️⃣ Strategy Pattern

Used for **slot allocation logic**.

```java
public interface SlotAllocationStrategy {

    ParkingSlot findSlot(List<ParkingSlot> slots);

}
```

Example Strategy:

```java
public class NearestSlotStrategy implements SlotAllocationStrategy {

    @Override
    public ParkingSlot findSlot(List<ParkingSlot> slots) {

        return slots.stream()
                .filter(slot -> !slot.isOccupied())
                .findFirst()
                .orElseThrow();
    }
}
```

---

## 3️⃣ Factory Pattern

```java
public class VehicleFactory {

    public static Vehicle createVehicle(String number,
                                        VehicleType type) {

        Vehicle vehicle = new Vehicle();

        vehicle.setVehicleNumber(number);
        vehicle.setVehicleType(type);

        return vehicle;
    }
}
```

---

# 🚗 Parking Flow

Vehicle enters

Driver arrives  
POST /parking/park  
Controller  
ParkingService  
SlotAllocationStrategy  
Assign slot  
Generate ticket  

---

Vehicle exits

Driver exits  
POST /parking/exit  
Controller  
Fetch ticket  
Calculate fee  
Free slot  

---

# 💰 Parking Fee Calculation

``` java
long hours = Duration
        .between(entryTime, exitTime)
        .toHours();

price = hours * 10;
```

Example:

4 hours parked  
price = 4 × 10 = 40

---

# 🧠 System Flow

Client  
Controller  
Service  
Strategy  
Repository  
Database  

---

# ⭐ Possible Improvements

Future enhancements:

- Multiple parking lots
- Dynamic pricing
- Redis caching for slots
- QR code tickets
- Kafka event streaming
- Admin dashboard
- Reservation system