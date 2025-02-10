# BlackJack Game

## Objective

The objective of the game is to beat the dealer.

The player wins if:

- The player has a score of 21 or less and the dealer has a score greater than 21.
- The player has a score greater than the dealer and less than or equal to 21.
- The player has a score of 21 with the first two cards and the dealer does not.

## Design and Implementation

### Core objects

#### Card

Represents a playing card. It has a rank and a suit. The card should have `rank`
and a `suit`. The `rank` and `suit` could be implemented as a `Sting` and
`Number` or as `ENUM`s or as a combination of both.

The `suit` could be one of: `HEARTS`, `DIAMONDS`, `CLUBS`, `SPADES`.
The `rank` is an integer from 1 to 13. The `ACE` has `rank` of 1.

#### Deck

Represents a deck of cards. It has a collection of cards. It can have next
functionality:

- initialize - form a starting deck of cards (think of opening a real new deck
  of cards)
- shuffle - shuffle the deck of cards
- deal - deal a card from the deck (take a card from the top of the deck)
- etc.

But always keep in mind that even though a class is the representation of the
real world deck it is still a Java class instance, so some methods like `reset`
is not required as you can just create a new instance of the `Deck` class.

#### Hand

Represents a hand of cards. It has a collection of cards, so should have next
functionality:

- add - add a card to the hand
- remove - remove a card from the hand
- clear - remove all cards from the hand

#### Player

Represents a player, so should have the player name and a hand of cards. The
player could be a human or a computer AI.

For human player, it should provide the player with resources to make decisions
and take players input.

For computer AI player, it should run an AI algorith to make a decision based on
the current state of the game.

### Game engine

In general the game engine should have the following functionality:

- player management - managing the players
- game mechanics - the game rules and logic
- game state - the current state of the game
- game flow - the game flow, start, turn, end, etc.

#### BlackJack

The BlackJack class is a game engine representing the specific BlackJack game.
On top of the generic game engine, it should have the following functionality:

- rules
- turn order
- winning conditions
- scoring system don't forget that ACE has a special mechanics (e.g. 2-10 are
  worth their face value, face cards are worth 10, and aces are worth 1 or 11)
- map card `rank` and `suit` to card value

## Development Steps advised

Phase 1: Core objects

- Create the core objects: `Card`, `Deck`, `Hand`
- Create the `Player` class but do not implement the human or AI player just yet

Phase 2: Simple game mechanics

- Create the `BlackJack` class and implement the game mechanics:
    - Start the game: instantiating the `Deck`, setting up players.
    - Deal initial set of cards face up and skip the blackjack check for now.
- Implement the game loop:
    - Player turn: player presented with hand state and makes a decision to hit or
      stand.
    - Iterate over all players.

Phase 3: Scoring and winning conditions

- Implement the scoring system - given a hand of cards calculate the score.
- Implement the winning conditions - given the score of the player.
- Implement the BlackJack check - if a player has a score of 21 with the first
  two cards, the player wins.

Phase 4: AI player

- Implement the AI player. Simple strategy is to hit if the score is less than
  16 and stand otherwise.
- Add the Dealer AI player to the game.

Phase 5: Polishing

- Make sure Dealer hand has one card face down.
- Make Text UI user friendly and consistent.
- Implement card's `suit` and `rank` as `ENUM`s.

## Some design advice

### Single Responsibility Principle

Try to design all classes and functions to carry a single responsibility. It
makes the code much easier to write understand and maintain.

For example, a real world card object could be represented/modelled by a `Card`
class. A card typically has a `rank` and a `suit`.

The `Card` class should only be responsible for representing a card.
It should not be responsible for:

- game it is being used in
- game value and/or role of the card
- the deck it is in
- the hand it is in
- is it face up or face down

### Encapsulation

Encapsulation is the bundling of data with the methods. It allows to hide the
internal state of an object and logic complexity.

For example, a `Deck` class could be responsible for initializing the deck of
cards, shuffling the deck, dealing a card, etc. 
