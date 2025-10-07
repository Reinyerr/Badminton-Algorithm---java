# 🏸 Badminton Court Algorithm

**Author:** Rainier Jorge Jorda  
**Language:** Java (Prototype) → *Planned: JavaScript + HTML Web Version*


## 📘 Overview
The **Badminton Court Algorithm** is designed to distribute `n` players across `y` badminton courts for **singles (1v1)** or **doubles (2v2)** matches.  
It ensures that players face **unique opponents** before repeating matchups — creating fair and varied games for everyone.

Originally implemented in **Java** to test the algorithm’s logic, the goal is to later convert it into a **web-based tool** using **JavaScript + HTML** for public use.


## ⚙️ Features
- ✅ Automatic court and player assignment  
- 🔁 Unique matchup generation before reset  
- 🧩 Supports singles and doubles  
- 👥 Handles odd numbers of players (some may rest each round)  
- 🏟️ Manages unfilled courts gracefully  
- 💡 Clear and readable output showing each round’s matchups

## 🎥 Video Showcase


https://github.com/user-attachments/assets/8527a3d5-43f6-4efa-921c-4cc06d6c5c08



## 🗂️ Repository Structure
├── Court.java # Court object (match type, team lists, fill check)

├── Player.java # Player object (tracks opponents and teammates)

├── Main.java # Core algorithm: rounds, assignments, display

└── README.md


---

## 🚀 Getting Started

### Prerequisites
- Java 8+ installed on your system.

### Run the program
```bash
# 1. Clone the repository
git clone https://github.com/Reinyerr/Badminton-Algorithm---java.git
cd Badminton-Algorithm---java

# 2. Compile all Java files
javac *.java

# 3. Run the program
java Main

```

## 🧠 Algorithm Logic
Initialization

Each player (1..n) starts with:

A list of opponents they haven’t faced

A list of teammates they haven’t partnered with

Round Generation

Courts are filled based on availability.

Singles → pick 2 players who haven’t faced each other.

Doubles → pick 4 players ensuring unique team compositions.

If there are leftover players, some may rest.

Display all matchups for the round.

``` bash
Round 1:
Court 1 (Singles): Player 1 vs Player 2
Court 2 (Doubles): Team (3,4) vs Team (5,6)
Court 3: Empty
----------------------
Round 2:
Court 1 (Singles): Player 3 vs Player 6
Court 2 (Doubles): Team (1,5) vs Team (2,4)
Court 3: Empty
----------------------
```

## 🌐 Future Development

The next phase of this project will involve:

🔄 Porting algorithm logic to JavaScript

💻 Building an interactive web interface

🧮 Allowing dynamic input of players and courts

📊 Displaying results visually with court and player layouts


## 🪪 License

This project is open source — feel free to use and modify.
You can add a license (e.g., MIT License) here once finalized.

## 💬 Contact

Rainier Jorge Jorda

📧 r1jorda@torontomu.ca

🌐 https://github.com/Reinyerr

🔗 https://www.linkedin.com/in/rainier-jorge-jorda/
