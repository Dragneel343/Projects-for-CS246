#Hangman Game with a predetermined word bank that is choosen from at random
#letter over and over will win the game

import random

#word bank where the words are choosen from
wordBank = ["apple","burrow","cat","dairy","easter","ferris wheel","ghost",
"habanero","illustration","jabberwocky","keystone","lemon","medusa","nitrate",
"opposite","peasant","quetzal","rogue","serpent","taffy","ultimatum","vacuum",
"welsh","xylophone","yacht","zoology"]

random.shuffle(wordBank)

answer = list(wordBank[0])

#empty list called display
display = []

#adds the variable answer to display
display.extend(answer)

#iterates through the list 'display'
#replaces each index in the list with '_'
for i in range (len(display)):
    display[i] = "_"

#places a space between each '_'
print (' '.join(display))
print()

#counter stops the game once all letters have been guessed
count = 0

#keeps asking the user until all letters are guessed
while count < len(answer):
    guess = input ("Please guess a letter: ")
    guess = guess.lower()
    print (count)

    #iterates through the letters in answer
    for i in range(len(answer)):
        #if the guessed letter matches an letter in the answer
        if answer[i] == guess :
            #replaces the index of that guess with the actual letter
            display[i] = guess
            count = count + 1

    #print out the new string with guessed letters in it
    print (' '.join(display))
    print()
print ("Well done, you guessed the word!")