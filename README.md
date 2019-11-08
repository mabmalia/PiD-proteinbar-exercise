# PiD Exercise 2 - XML

## Description

Imagine that you have a supply of protein bars and you want to present these bars to potential customers to make it easier for them to reach their nutritional goals. Some of them might be interested in eating as much protein as they can (bodybuilders, I guess) and some of them might be interested in eating carbohydrates as well and so on. Your job is to make an application that will assist the customers in choosing the right product. At your disposal you have the information about the protein bars represented in an XML file bars.xml .

## Task

Write Java code with the following functionalities (text interface program as the IP project):

Extract the information from the XML file into a data structure of your choice.
After that give the user the ability to choose from the following options:
1. Show the name of all bars.
2. Sort bars based on highest protein content.
3. Sort bars based on highest fat content.
4. Filter bars which has less than "some number from the user" fiber and sort them from highest to lowest.
5. Find all protein bars with more than X protein reviewed by Y (X and Y should be entered from the user).

## Open question

Imagine that you have a very large database, think millions of protein bars. How do you think that the memory will behave with the database if you save it in a data structure ? Are there any problems? If yes, then how do we fix it? What is the best sort algorithm to be used here and what is its time complexity. Motivate!