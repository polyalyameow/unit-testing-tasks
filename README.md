
### Övning 1: Testa en Kalkylator

**Beskrivning**: Skapa och testa en enkel kalkylator som utför grundläggande matematiska operationer.

1. **Implementera `Calculator`-klassen** som har följande metoder:
    - `int add(int a, int b)`
    - `int subtract(int a, int b)`
    - `int multiply(int a, int b)`
    - `int divide(int a, int b)` - den här metoden ska kasta en `ArithmeticException` om `b` är 0.

2. **Skriv enhetstester** för att testa dessa metoder med JUnit. Testa olika fall, inklusive:
    - Positiva tal, negativa tal och noll.
    - `divide`-metoden ska också testas för att säkerställa att en `ArithmeticException` kastas när `b` är 0.

---

### Övning 2: Mockning med BankAccountService

**Beskrivning**: Skapa ett testschema för att kontrollera interaktionen mellan `BankAccountService` och `TransactionRepository` för att hantera kontosaldon.

1. **Implementera `BankAccountService`** med följande metoder:
    - `deposit(double amount)`: Lägger till ett belopp till kontosaldot.
    - `withdraw(double amount)`: Drar ett belopp från kontosaldot om det finns tillräckligt med pengar, annars kastar en `IllegalArgumentException`.
    - `getBalance()`: Returnerar det aktuella kontosaldot.

2. **Mocka `TransactionRepository`** med hjälp av Mockito och:
    - Skapa tester för att verifiera att `withdraw` kastar ett undantag när det inte finns tillräckligt med pengar.
    - Kontrollera att `deposit` och `withdraw` anropar metoderna i `TransactionRepository` korrekt.

---

### Övning 3: Testa en Enkel Shoppingkorg

**Beskrivning**: Skapa och testa en klass för att hantera en enkel shoppingkorg.

1. **Implementera `ShoppingCart`-klassen** med följande funktionalitet:
    - `void addItem(Item item, int quantity)`: Lägger till en viss mängd av en `Item`.
    - `void removeItem(Item item)`: Tar bort en specifik `Item` från korgen.
    - `BigDecimal getTotalPrice()`: Beräknar totalpriset för alla objekt i korgen.

2. **Skriv enhetstester** för:
    - Att lägga till och ta bort objekt och kontrollera korgens storlek efter varje operation.
    - Att verifiera att `getTotalPrice()` returnerar rätt resultat, även när korgen är tom.

---

### Övning 4: Testa en Användarhanteringsapplikation

**Beskrivning**: Skapa och testa en tjänst för att hantera användare i ett system.

1. **Implementera `UserService`** som hanterar följande metoder:
    - `void createUser(User user)`: Lägger till en användare om den inte redan finns.
    - `User getUserById(Long id)`: Hämtar en användare baserat på deras ID.
    - `void deleteUser(Long id)`: Tar bort en användare baserat på deras ID.

2. **Skapa mockade versioner av `UserRepository`** och skriv tester för:
    - `createUser()` ska kontrollera om användaren redan finns. Om så är fallet ska en `IllegalStateException` kastas.
    - `getUserById()` ska returnera en användare om ID:t finns, och returnera `null` eller kasta en `NoSuchElementException` om den inte finns.
    - `deleteUser()` ska verifiera att anropet sker när ett specifikt ID skickas in.

---