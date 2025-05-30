```mermaid
classDiagram
    class App {
        +Scanner scanner$
        +main(String[] args)$
    }

    class HomeScreen {
        +displayHomeScreen(Scanner scanner)
        +askIfOrdering(Scanner scanner) int
    }

    class OrderScreen {
        -String[] drinkSizes
        -String[] drinkFlavors
        -String[] chipList
        -Order order
        +displayOrderScreen()
        +askForChips(Scanner scanner)
        +askForDrink(Scanner scanner)
        +askForName(Scanner scanner) String
        +addToOrder(Scanner scanner) int
    }

    class AddSandwichScreen {
        -String[] breadTypes
        -String[] meatTypes
        -String[] cheeseTypes
        -String[] regularToppings
        -String[] sauces
        -double price
        -int sandwichSize$
        -List~Topping~ toppings
        -Sandwich.Builder sandwichBuilder
        +displayAndBuildSandwich() Sandwich
        +askForModifications(Scanner scanner)
        +removeToppings(Scanner scanner)
        +askForSignatureSandwich(Scanner scanner)
        +askIfToasted(Scanner scanner)
        +askForSauce(Scanner scanner)
        +askForRegularTopping(Scanner scanner)
        +askForCheese(Scanner scanner)
        +askForMeat(Scanner scanner)
        +askForSize(Scanner scanner)$ int
        +askForBread(Scanner scanner) int
    }

    class Customer {
        -String name
        -int customerId
        -List~Order~ previousOrders
        +Customer(String name)
        +getName() String
        +getCustomerId() int
        +getPreviousOrders() List~Order~
        +addToPreviousOrders(Order order)
    }

    class Order {
        -int orderNumber
        -double total
        -List~Sandwich~ sandwiches
        -List~Drink~ drinks
        -List~Chips~ chipList
        -LocalDateTime orderDateTime
        +Order()
        +getOrderNumber() int
        +getSandwiches() List~Sandwich~
        +getDrinks() List~Drink~
        +getChipList() List~Chips~
        +addSandwich(Sandwich sandwich)
        +addDrink(Drink drink)
        +addChips(Chips chips)
        +getOrderDateTime() LocalDateTime
        +calculatePrice() double
    }

    class Checkout {
        -double price
        -Order order
        -Customer customer
        -LocalDateTime orderDateTime
        -List~Sandwich~ sandwiches
        -List~Drink~ drinks
        -List~Chips~ chipList
        +Checkout(Order order, Customer customer)
        +displayOrderDetails()
        +writeOrderToFile(Order order)
    }

    class Sandwich {
        -Bread bread
        -List~Topping~ toppings
        -List~Topping~ sauces
        -boolean isToasted
        -int sandwichSize
        -double price
        +Sandwich(Bread bread, List~Topping~ toppings, List~Topping~ sauces, boolean isToasted, int sandwichSize)
        +getBread() Bread
        +getToppings() List~Topping~
        +getSauces() List~Topping~
        +isToasted() boolean
        +getSandwichSize() int
        +calculatePrice() double
        +toString() String
    }

    class SandwichBuilder {
        <<inner class>>
        -Bread bread
        -List~Topping~ toppings
        -List~Topping~ sauces
        -boolean isToasted
        -int sandwichSize
        +setBread(Bread bread)
        +setToasted(boolean toasted)
        +setSandwichSize(int sandwichSize)
        +addSauce(Topping sauce)
        +addTopping(Topping topping)
        +removeTopping(Topping topping)
        +getToppings() List~Topping~
        +getSauces() List~Topping~
        +build() Sandwich
    }

    class Bread {
        -String breadType
        -double price
        -int sandwichSize
        +Bread(String breadType, int sandwichSize)
        +getBreadType() String
        +getSandwichSize() int
        +getPrice() double
        +calculatePrice() double
    }

    class Topping {
        <<abstract>>
        #boolean isExtra
        #int sandwichSize
        #String toppingName
        #double price
        +Topping(boolean isExtra, int sandwichSize, String toppingName)
        +isExtra() boolean
        +setExtra(boolean extra)
        +getSandwichSize() int
        +getToppingName() String
        +calculatePrice() double*
    }

    class Meat {
        -double price
        +Meat(boolean isExtra, int sandwichSize, String toppingName)
        +calculatePrice() double
    }

    class Cheese {
        -double price
        +Cheese(boolean isExtra, int sandwichSize, String toppingName)
        +calculatePrice() double
    }

    class RegularTopping {
        +RegularTopping(boolean isExtra, int sandwichSize, String toppingName)
        +calculatePrice() double
    }

    class Drink {
        -String drinkSize
        -String flavor
        -double price
        +Drink(String drinkSize, String flavor)
        +getDrinkSize() String
        +getFlavor() String
        +calculatePrice() double
    }

    class Chips {
        -String flavor
        -double price
        +Chips(String flavor)
        +getFlavor() String
        +calculatePrice() double
    }

    class Priceable {
        <<interface>>
        +calculatePrice() double
    }

    %% Inheritance relationships
    Topping <|-- Meat
    Topping <|-- Cheese
    Topping <|-- RegularTopping
    
    %% Interface implementations
    Priceable <|.. Order
    Priceable <|.. Sandwich
    Priceable <|.. Bread
    Priceable <|.. Topping
    Priceable <|.. Drink
    Priceable <|.. Chips
