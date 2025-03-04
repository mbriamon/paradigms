#!/usr/bin/env python3.5

import random

class Wordle:
    def __init__(self, words_file, answer_file):
        self.words_file = words_file
        self.answer_file = answer_file
        self.chosen_word = ""   #the word to guess
        self.good_letters = set()
        self.bad_letters = set()
        self.correct_letters = [""] * 5 #array with 5 elements for correct positions
        self.max_attempts = 6
        self.attempts = 0

    def load_words(self):
        with open(self.words_file, "r") as file:
            self.words = [line.strip().lower() for line in file]
    
    def pick_random_word(self):
        self.chosen_word = random.choice(self.words)
        with open(self.answer_file, "w") as file:
            file.write(self.chosen_word)

    def is_valid_word(self, word):
        return len(word) == 5 and word.lower() in self.words

    def evaluate_guess(self, guess):
        guess = guess.lower()
        for i, letter in enumerate(guess):
            #print(f"Debug: Comparing guess [{i}]='{letter}' with chosen_word[{i}]='{self.chosen_word[i]}'")        
    
            if letter in self.chosen_word:
                self.good_letters.add(letter)
            else:
                self.bad_letters.add(letter)
            if self.chosen_word[i] == letter:
                self.correct_letters[i] = letter

    def play(self):
        print("Welcome to Wordle!")
        self.load_words()
        self.pick_random_word()
    
        while self.attempts < self.max_attempts:
            #print(f"Debug: attempt {self.attempts + 1}")
            guess = input("Enter a 5-letter word: ").strip()
            if not self.is_valid_word(guess):
                print("Invalid word. Please try again.")
                continue
        
            #print(f"Debug: Valid guess received -> {guess}")
            self.attempts += 1
            self.evaluate_guess(guess)

            if guess.lower() == self.chosen_word:
                print(f"Congratulations, you correctly identified the word after {self.attempts} attempts!")
                return 

            print(f"Good Letters: {sorted(self.good_letters)}")
            print(f"Bad Letters: {sorted(self.bad_letters)}")
            print(f"Correct Letters: {self.correct_letters}")

        print(f"The answer is {self.chosen_word}. You did not correctly guess it within 6 tries.")


if __name__ == "__main__":
    wordle = Wordle("words.txt", "answer.txt")
    wordle.play()
