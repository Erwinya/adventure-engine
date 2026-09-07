# Adventure Engine

A Java console text adventure set in the world of **Aetheria**. Choose a hero, explore locations, gather rare artifacts, and seal the Void Lord before the realm falls.

## Features

- Four character classes: Warrior, Assassin, Mage, Healer
- Five locations: Safe House, Ghua Market, Shadow Forest, Dark Caverns, Void Realm Portal
- Three enemy types: Void Minion, Shadow Beast, Void Lord
- Weapons, armor, gold, rare item progression
- Health regeneration at the Safe House
- Save / load support
- Event logging, unit tests, and Maven packaging

## Requirements

- Java 17+
- Maven 3.6+

## Build and run

```bash
git clone https://github.com/Erwinya/adventure-engine.git
cd adventure-engine
mvn clean package
java -jar target/text-adventure-1.0-SNAPSHOT.jar
```

Windows PowerShell:

```powershell
.\mvnw.cmd clean package
java -jar target\text-adventure-1.0-SNAPSHOT.jar
```

## Tests

```bash
mvn test
```

```powershell
.\mvnw.cmd test
```

## Project structure

```text
src/main/java/com/halukkilincer/adventure/
├── characters/   # Heroes and enemies
├── combat/       # Combat strategies
├── engine/       # Game loop and manager
├── interfaces/   # Combat and loot contracts
├── items/        # Inventory and loot
├── launcher/     # Main entry point
├── map/          # Locations
├── ui/           # Console UI
└── utils/        # Save, logging, location helpers
```

## How to play

1. Rest and heal at the Safe House
2. Buy gear at Ghua Market
3. Collect the Forest Scroll in Shadow Forest
4. Collect the Ancient Stone in Dark Caverns
5. Face the Void Lord at the Void Realm Portal

## Related project

Sister console RPG with a different cyberpunk storyline: [realm-quest](https://github.com/Erwinya/realm-quest)

## License

MIT — see [LICENSE](LICENSE).
