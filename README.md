# DELI-cious Sandwich Shop

A Java console application for ordering custom sandwiches, drinks, and chips from a virtual deli shop. The application provides an interactive menu system allowing customers to build their perfect sandwich with various customization options.

## Features

### Order Management
- **Customer Registration**: Create customer profiles with unique IDs
- **Order Tracking**: Each order is timestamped and assigned a unique order number
- **Receipt Generation**: Automatic receipt creation with detailed order breakdown

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
4.   <img width="459" alt="Screenshot 2025-05-30 at 8 28 33 AM" src="https://github.com/user-attachments/assets/ef7a588a-7a14-404a-8b8f-586ab18f47ed" />
5.   <img width="459" alt="Screenshot 2025-05-30 at 8 28 56 AM" src="https://github.com/user-attachments/assets/f7318a89-495d-4502-86ef-88dcf32a693e" />
6. **Build Order**: Add sandwiches, drinks, and chips as desired
7. <img width="459" alt="Screenshot 2025-05-30 at 8 29 20 AM" src="https://github.com/user-attachments/assets/8d8b3b1e-111a-4233-a78d-37621a9dbca9" />
8. **Customize Sandwiches**: Choose size, bread, toppings, and modifications
9.  <img width="459" alt="Screenshot 2025-05-30 at 8 29 46 AM" src="https://github.com/user-attachments/assets/97ac6593-1eb3-4d72-ab11-86655f85e5a9" />
    <img width="459" alt="Screenshot 2025-05-30 at 8 30 08 AM" src="https://github.com/user-attachments/assets/0c6a287b-a5db-4986-b48e-b3f045175d82" />
    <img width="459" alt="Screenshot 2025-05-30 at 8 30 34 AM" src="https://github.com/user-attachments/assets/900a4a3c-411a-4a00-9abd-464383e76c63" />
    <img width="459" alt="Screenshot 2025-05-30 at 9 28 51 AM" src="https://github.com/user-attachments/assets/06c4eff1-be83-4d79-8d61-329cd236c99a" />
    <img width="459" alt="Screenshot 2025-05-30 at 9 29 14 AM" src="https://github.com/user-attachments/assets/fa1502f8-4df9-4dbc-a22f-56bfb9b1a78f" />
    <img width="459" alt="Screenshot 2025-05-30 at 9 35 00 AM" src="https://github.com/user-attachments/assets/ce26104b-e515-464a-9158-db00c8b3c9f0" />
    <img width="459" alt="Screenshot 2025-05-30 at 9 35 31 AM" src="https://github.com/user-attachments/assets/47493fe2-4c74-44db-88e0-e9db3d406bb4" />
    <img width="459" alt="Screenshot 2025-05-30 at 9 36 04 AM" src="https://github.com/user-attachments/assets/5d610fe7-ebf5-4b41-9d73-a84e0edfac9d" />
    <img width="459" alt="Screenshot 2025-05-30 at 9 36 34 AM" src="https://github.com/user-attachments/assets/0e02c6da-8d1f-4920-979c-6e184dc18384" />
    <img width="459" alt="Screenshot 2025-05-30 at 9 36 54 AM" src="https://github.com/user-attachments/assets/4dc90067-ded2-44f6-a364-8df303de1579" />
    <img width="459" alt="Screenshot 2025-05-30 at 9 37 50 AM" src="https://github.com/user-attachments/assets/f9d59d96-ae1a-4565-b456-e5803463ae7c" />
10. **Checkout**: Review order details and complete purchase
    <img width="459" alt="Screenshot 2025-05-30 at 8 33 36 AM" src="https://github.com/user-attachments/assets/7aa0fcc8-2cbe-4526-a86c-cacd2864660b" />
12. **Receipt**: Receive printed receipt and saved file copy
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
