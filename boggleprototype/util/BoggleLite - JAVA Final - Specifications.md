2025-03-2611:43

Status: WIP

Tags: #Game_Project 

# Definite Features

- Squares style zen gameplay
	- Randomly scramble letters on the board
		- Limit quantities of letters
	- Word are a minimum length of 3
	- Boggle scoring system * 100
	- You drag the cursor across a word as long as the letters are connected in some direction
	- The game ends when a timer runs out
    - The same word cannot be created twice
- Score tracking and score system
- Word database access (SQLite? HyperSQL?)
	- Filtering out slurs from the DB so they can't be made
- Words that have been successfully made are tracked
- Words are verified/matched against the DB
- Custom assets (letter icons, background, probably from Itch.io, cute, colorful)
- Tests
- Title screen
- CI/CD -> pre-commit hook to run Maven tests and build

## References