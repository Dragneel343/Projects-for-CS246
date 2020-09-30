from random import randint

#create a list of play options
t = ["Rock", "Paper", "Scissors"]

#assign a random play to the computer
computer = t[randint(0,2)]

#Create a player name
player_name = input("Hello, What's your name?\n")

#set player to False
player = False
play_again = "Yes"

while player == False and play_again == "Yes":
#set player to True
    player = input("Rock, Paper, Scissors?\n")
    if player == computer:
        print("It's a Tie!")
    elif player == "Rock":
        if computer == "Paper":
            print(player_name, "You lose!\n", computer, "covers", player)
        else:
            print(player_name, "You win!\n", player, "smashes", computer)
    elif player == "Paper":
        if computer == "Scissors":
            print(player_name, "You lose!\n", computer, "cut", player)
        else:
            print(player_name, "You win!\n", player, "covers", computer)
    elif player == "Scissors":
        if computer == "Rock":
            print(player_name, "You lose!\n", computer, "smashes", player)
        else:
            print(player_name, "You win!\n", player, "cut", computer)
    else:
        print("That's not a valid play", player_name,". Check your spelling!")
    #the player is asked to play again if Yes, the play_again is set to Yes and player is set to False.
    #if No, then play_again is set to No and the game ends.
    play_again = input("Play Again? Yes/No\n")
    player = False
    computer = t[randint(0,2)]