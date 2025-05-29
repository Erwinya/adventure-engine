# Text-Based Adventure Game

This project is a text-based adventure game developed in Java. Players can choose different characters, fight enemies, collect items, and try to save the world of Aetheria.

## Features

- 4 different character classes (Warrior, Assassin, Mage, Healer)
- 5 different locations (Safe House, Ghua Market, Shadow Forest, Dark Caverns, Void Realm Portal)
- 3 different enemy types (Void Minion, Shadow Beast, Void Lord)
- Weapon and armor system
- Money system
- Rare item collection system
- Health regeneration system
- Game save/load system
- Detailed event logging
- SOLID principles implementation
- Clean Code practices

## Requirements

- Java 17 or higher
- Maven 3.6 or higher

## Installation

1. Clone the project:
```bash
git clone https://github.com/yourusername/Simple-Text-Based-Adventure-Engine.git
```

2. Navigate to the project directory:
```bash
cd Simple-Text-Based-Adventure-Engine
```

3. Build the project with Maven:
```bash
mvn clean package
```

4. Run the game:
```bash
java -jar target/text-adventure-1.0-SNAPSHOT.jar
```

## Development

### Project Structure
```
src/
├── main/
│   ├── java/
│   │   └── com/halukkilincer/adventure/
│   │       ├── characters/    # Character classes
│   │       ├── combat/        # Combat system
│   │       ├── engine/        # Game engine
│   │       ├── interfaces/    # Game interfaces
│   │       ├── items/         # Item system
│   │       ├── launcher/      # Game entry point
│   │       ├── map/          # Game locations
│   │       ├── ui/           # User interface
│   │       └── utils/        # Utility classes
│   └── resources/
│       └── logback.xml       # Logging configuration
├── test/
│   └── java/                # Unit tests
└── pom.xml                  # Maven configuration
```

### Design Patterns Used
- Strategy Pattern (Combat System)
- Factory Pattern (Character Creation)
- Singleton Pattern (Game Manager)
- Observer Pattern (Event System)

### SOLID Principles Implementation
- Single Responsibility Principle: Each class has one specific responsibility
- Open/Closed Principle: New character types and combat strategies can be added without modifying existing code
- Liskov Substitution Principle: Character subtypes can be used in place of AbstractCharacter
- Interface Segregation: Specific interfaces (ICombat, ILootable) for different behaviors
- Dependency Inversion: High-level modules depend on abstractions

## Game Controls

- Use numbers 1-4 to navigate menus
- Use S, A, B, H keys for character selection
- During combat:
  - Press V to attack
  - Press K to run away

## Game Tips

1. You can regenerate your health at the Safe House when starting the game
2. Buy weapons and armor from the Ghua Market
3. Collect the Forest Scroll from the Shadow Forest
4. Obtain the Ancient Stone from the Dark Caverns
5. Finally, fight the Void Lord at the Void Realm Portal

## Contributing

1. Fork this repository
2. Create a new branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push your branch (`git push origin feature/amazing-feature`)
5. Create a Pull Request

## Testing

Run the tests using Maven:
```bash
mvn test
```

## Logging

Game events are logged to both console and `game.log` file. The logging level can be configured in `src/main/resources/logback.xml`.

## License

This project is licensed under the MIT License. See the `LICENSE` file for more information.
