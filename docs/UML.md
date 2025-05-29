```mermaid
classDiagram
    %% Interfaces
    class ICombat {
        <<interface>>
        +attack() int
        +takeDamage(int) void
        +isAlive() boolean
        +getHealth() int
        +heal(int) void
    }

    class ILootable {
        <<interface>>
        +dropLoot() String
        +getGoldReward() int
    }

    class ICombatStrategy {
        <<interface>>
        +executeCombat(AbstractCharacter, Enemy) boolean
        +getStrategyName() String
    }

    %% Abstract Classes
    class AbstractCharacter {
        <<abstract>>
        #String name
        #int damage
        #int health
        #int maxHealth
        #int defense
        #Inventory inventory
        +AbstractCharacter(String, int, int, int)
        +attack() int
        +takeDamage(int) void
        +isAlive() boolean
        +getHealth() int
        +heal(int) void
        +abstract getDescription() String
        +abstract getCharacterType() String
        +getDamage() int
        +getDefense() int
        +getInventory() Inventory
    }

    class Location {
        <<abstract>>
        #AbstractCharacter player
        #String name
        #String locationEmoji
        +Location(AbstractCharacter, String, String)
        +abstract getLocation() boolean
    }

    class NormalLoc {
        <<abstract>>
        +NormalLoc(AbstractCharacter, String, String)
        +getLocation() boolean
    }

    class BattleLoc {
        <<abstract>>
        #Enemy enemy
        #String reward
        #int maxEnemyCount
        #Scanner scanner
        #Random random
        #ICombatStrategy combatStrategy
        #CombatUI combatUI
        +BattleLoc(AbstractCharacter, String, String, Enemy, String, int)
        +getLocation() boolean
        #handleCombat(int) boolean
        #earnReward() void
        #generateEnemyCount() int
    }

    %% Combat Related Classes
    class BasicCombatStrategy {
        +executeCombat(AbstractCharacter, Enemy) boolean
        +getStrategyName() String
    }

    class CombatResult {
        -boolean victory
        -int damageDealt
        -int damageTaken
        -int goldEarned
        -String itemDropped
        +CombatResult(boolean, int, int, int, String)
        +isVictory() boolean
        +getDamageDealt() int
        +getDamageTaken() int
        +getGoldEarned() int
        +getItemDropped() String
    }

    class CombatUI {
        +displayEnemyEncounter(int, String) void
        +askForFight(Scanner) boolean
        +askForAction(Scanner) boolean
        +displayDeath() void
        +displayRetreat() void
        +displayVictory(String) void
        +displayStats(AbstractCharacter, Enemy) void
        +displayCombatResult(CombatResult) void
        +displayGoldReward(int) void
        +displayItemDrop(String) void
        +displayReward(String) void
    }

    %% Concrete Classes
    class Enemy {
        -String name
        -int damage
        -int health
        -int maxHealth
        -int gold
        -int originalHealth
        +Enemy(String, int, int, int)
        +dropLoot() String
        +resetHealth() void
    }

    class VoidMinion {
        +VoidMinion()
    }

    class ShadowBeast {
        +ShadowBeast()
    }

    class VoidLord {
        +VoidLord()
    }

    class Inventory {
        -boolean dungeonKey
        -boolean forestScroll
        -boolean ancientStone
        -int money
        -List~String~ rareItems
        -boolean hasWeapon
        -boolean hasArmor
        -int weaponDamage
        -int armorDefense
        +addRareItem(String) void
    }

    class SafeHouse {
        +SafeHouse(AbstractCharacter)
        +getLocation() boolean
    }

    class ToolStore {
        +ToolStore(AbstractCharacter)
        +getLocation() boolean
    }

    class GameManager {
        -AbstractCharacter player
        -Location currentLocation
        -boolean gameRunning
        +setPlayer(AbstractCharacter) void
        +getPlayer() AbstractCharacter
        +isGameRunning() boolean
        +setGameRunning(boolean) void
    }

    class GameLogger {
        <<utility>>
        +log(String) void
        +logBattle(String, String, int, int) void
        +logPurchase(String, String, int) void
        +logError(String, Throwable) void
    }

    class GameSaveManager {
        <<utility>>
        +saveGame(AbstractCharacter) void
        +loadGame(AbstractCharacter) void
        +saveExists() boolean
    }

    class GameConstants {
        <<utility>>
        +INITIAL_MONEY: int
        +IRON_SWORD_DAMAGE: int
        +STEEL_SWORD_DAMAGE: int
        +MITHRIL_SWORD_DAMAGE: int
        +LIGHT_ARMOR_DEFENSE: int
        +MEDIUM_ARMOR_DEFENSE: int
        +HEAVY_ARMOR_DEFENSE: int
    }

    %% Relationships
    ICombat <|.. AbstractCharacter
    ICombat <|.. Enemy
    ILootable <|.. Enemy
    ICombatStrategy <|.. BasicCombatStrategy
    AbstractCharacter *-- Inventory
    Location <|-- NormalLoc
    Location <|-- BattleLoc
    NormalLoc <|-- SafeHouse
    NormalLoc <|-- ToolStore
    Enemy <|-- VoidMinion
    Enemy <|-- ShadowBeast
    Enemy <|-- VoidLord
    GameManager *-- AbstractCharacter
    GameManager *-- Location
    BattleLoc *-- Enemy
    BattleLoc *-- ICombatStrategy
    BattleLoc *-- CombatUI
    BasicCombatStrategy ..> GameLogger
    CombatUI ..> CombatResult
} 