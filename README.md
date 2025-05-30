# DELI-cious Sandwich Shop

A Java console application for ordering custom sandwiches, drinks, and chips from a virtual deli shop. The application provides an interactive menu system allowing customers to build their perfect sandwich with various customization options.

## Features

### Order Management
- **Customer Registration**: Create customer profiles with unique IDs
- **Order Tracking**: Each order is timestamped and assigned a unique order number
- **Receipt Generation**: Automatic receipt creation with detailed order breakdown
- **Order History**: Track previous orders for each customer

### Sandwich Customization
- **Size Options**: Choose from 4-inch ($5.50), 8-inch ($7.00), or 12-inch ($8.50) sandwiches
- **Bread Types**: White, Wheat, Rye, or Wrap
- **Toasting Option**: Choose to toast your sandwich or not
- **Premium Toppings**:
  - **Meats**: Steak, Ham, Salami, Roast Beef, Chicken, Bacon (with extra portions available)
  - **Cheeses**: American, Provolone, Cheddar, Swiss (with extra portions available)
- **Regular Toppings**: Lettuce, Peppers, Onions, Tomatoes, Jalapeños, Cucumbers, Pickles, Guacamole, Mushrooms
- **Sauces**: Mayo, Ranch, Thousand Island, Vinaigrette

### Signature Sandwiches
Pre-designed sandwich combinations for quick ordering:
1. **BLT**: 8-inch white bread (toasted) with bacon, cheddar cheese, lettuce, tomatoes, and ranch
2. **Garden Wrap**: 4-inch wrap with chicken, swiss cheese, lettuce, tomatoes, cucumbers, guacamole, and ranch
3. **The Steak House**: 12-inch white bread (toasted) with steak, cheddar cheese, mushrooms, onions, and vinaigrette

### Additional Items
- **Drinks**: Small ($2.00), Medium ($2.50), Large ($3.00) in various flavors including Sprite, Dr. Pepper, Mt. Dew, Orange Fanta, Lemonade, Hi-C, and Water
- **Chips**: $1.50 per bag with options like BBQ, Salt & Vinegar, Sour Cream & Cheddar, Flamin' Hot Cheetos, Nacho Cheese Doritos, and Lay's Potato Chips

### Pricing System
Dynamic pricing based on sandwich size and toppings:
- **Base Sandwich Price**: Varies by size (4", 8", 12")
- **Meat Pricing**: 4" ($1.00 + $0.50 extra), 8" ($2.00 + $1.00 extra), 12" ($3.00 + $1.50 extra)
- **Cheese Pricing**: 4" ($0.75 + $0.30 extra), 8" ($1.50 + $0.60 extra), 12" ($2.25 + $0.90 extra)
- **Regular Toppings**: Free of charge

## Technical Architecture

### Design Patterns
- **Builder Pattern**: Implemented through the `Sandwich.Builder` class for flexible sandwich construction
- **Strategy Pattern**: Used via the `Priceable` interface for different pricing calculations
- **Inheritance**: Topping hierarchy with specialized pricing for different topping types

### Key Classes
- **App**: Main entry point and scanner management
- **HomeScreen**: Welcome screen and initial navigation
- **OrderScreen**: Main ordering interface
- **AddSandwichScreen**: Sandwich building and customization
- **Customer**: Customer information and order history
- **Order**: Order management and item collection
- **Sandwich**: Sandwich representation with builder pattern
- **Checkout**: Order finalization and receipt generation

### File Management
- **Receipt Storage**: Orders are automatically saved as text files in `src/main/receipts/`
- **File Naming**: Receipts use timestamp format `YYYYMMDD-HHMMSS.txt`
- **Order Details**: Complete order breakdown including customer info, items, and pricing

## Usage

1. **Start Application**: Run the main App class
2. **Place Order**: Choose to place an order from the welcome screen
3. **Enter Name**: Provide customer name for order tracking
4. **Build Order**: Add sandwiches, drinks, and chips as desired
5. **Customize Sandwiches**: Choose size, bread, toppings, and modifications
6. **Checkout**: Review order details and complete purchase
7. **Receipt**: Receive printed receipt and saved file copy

## Interesting Implementation Details

### Sandwich Builder Pattern
One of the most interesting aspects of this project is the implementation of the Builder pattern for sandwich construction. Initially, I attempted to use an empty constructor for the Sandwich class and add components as the user made selections. However, this approach proved problematic because it required the sandwich object to be in an incomplete state during construction.

The Builder pattern solved this elegantly by:
- Allowing step-by-step construction without exposing incomplete objects
- Providing flexibility for optional components (toppings, sauces)
- Enabling modification of selections before final construction
- Maintaining immutability of the final Sandwich object

This pattern is particularly effective for complex objects like sandwiches where customers can make numerous optional selections in any order.

### Pricing Architecture
The application uses a consistent `Priceable` interface across all purchasable items, enabling polymorphic price calculations. Each item type implements its own pricing logic:
- Size-based pricing for sandwiches and drinks
- Extra portion calculations for premium toppings
- Flat pricing for chips and regular toppings

## Future Enhancements

- **GUI Interface**: Replace console interface with graphical user interface
- **Database Integration**: Store customer and order data persistently
- **Online Ordering**: Web-based ordering system
