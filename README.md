# UW-Madison-CS300-Program1

Introduction

We are going to implement a shopping cart that represents a collection of market items. This cart will be represented by an array. In this application, we assume the following:
The cart stores a collection of items of type String (descriptions for market items),
Each market item is identified by an index (unique number)
The shopping cart may contain multiple occurrences of the same item,
Users can ask how many occurrences of a given item are in the shopping cart (may be 0 or more) Users can remove an item from the shopping cart,
Users can checkout the shopping cart (i.e. display number of items in the shopping cart together with total cost), Users can display the content of the shopping cart.
We note also that the market product catalog (set of products available for sale in the market) and the shopping cart (set of items selected by the user for purchase) are stored in two different places.
The following is a demo of your program. Note that the user’s input below is shown in green, and that the rest of the text below was printed out by the program.
============= Welcome to the Shopping Cart App =============
   COMMAND MENU:
    [P] print the market catalog
    [A <index>] add one occurrence of an item to the cart given its identifier
    [C] checkout
    [D] display the cart content
    [O <index>] number of occurrences of an item in the cart given its identifier
    [R <index>] remove one occurrence of an item from the cart given its identifier
    [Q]uit the application
ENTER COMMAND: p +++++++++++++++++++++++++++++++++++++++++++++ Item id Description Price +++++++++++++++++++++++++++++++++++++++++++++
0 Apple
1 Avocado
2 Banana
3 Beef
4 Blueberry
5 Broccoli
6 Butter
7 Carrot
8 Cereal
9 Cheese
10 Chicken
11 Chocolate
12 Cookie
13 Cucumber
14 Eggs
15 Grape
16 Ice Cream
17 Milk
18 Mushroom
19 Onion
20 Pepper
21 Pizza
22 Potato
23 Spinach
24 Tomato
+++++++++++++++++++++++++++++++++++++++++++++
$1.59 $0.59 $0.49 $3.79 $6.89 $1.79 $4.59 $1.19 $3.69 $3.49 $5.09 $3.19 $9.5 $0.79 $3.09 $2.29 $5.39 $2.09 $1.79 $0.79 $1.99 $11.5 $0.69 $3.09 $1.79
.ěl·bįșșǿp șǻ ỳl·ħģųǿřǿħť șǻ ěđǿč ňẅǿ řųǿỳ fǿ ỳťįl·įbǻđǻěř ěħť ẅěįvěř đňǻ řěđįșňǿč đl·ųǿħș ųǿỳ ,șřěđǻřģ ěșěħť mǿřf ķčǻbđěěf ěħť ģňįěěș řěťfǻ
ŇǾİŤČŲĐǾŘŤŇİ
ŇǾİȘȘİMBŲȘ
 COMMAND MENU:
 [P] print the market catalog
 [A <index>] add one occurrence of an item to the cart given its identifier
 [C] checkout
 [D] display the cart content
 [O <index>] number of occurrences of an item in the cart given its identifier
 [R <index>] remove one occurrence of an item from the cart given its identifier
 [Q]uit the application
ENTER COMMAND: a 0
COMMAND MENU:
 [P] print the market catalog
 [A <index>] add one occurrence of an item to the cart given its identifier
 [C] checkout
 [D] display the cart content
 [O <index>] number of occurrences of an item in the cart given its identifier
 [R <index>] remove one occurrence of an item from the cart given its identifier
 [Q]uit the application
ENTER COMMAND: a 24
COMMAND MENU:
 [P] print the market catalog
 [A <index>] add one occurrence of an item to the cart given its identifier
 [C] checkout
 [D] display the cart content
 [O <index>] number of occurrences of an item in the cart given its identifier
 [R <index>] remove one occurrence of an item from the cart given its identifier
 [Q]uit the application
ENTER COMMAND: a 0
COMMAND MENU:
 [P] print the market catalog
 [A <index>] add one occurrence of an item to the cart given its identifier
 [C] checkout
 [D] display the cart content
 [O <index>] number of occurrences of an item in the cart given its identifier
 [R <index>] remove one occurrence of an item from the cart given its identifier
 [Q]uit the application
ENTER COMMAND: A 17
COMMAND MENU:
 [P] print the market catalog
 [A <index>] add one occurrence of an item to the cart given its identifier
 [C] checkout
 [D] display the cart content
 [O <index>] number of occurrences of an item in the cart given its identifier
 [R <index>] remove one occurrence of an item from the cart given its identifier
 [Q]uit the application
ENTER COMMAND: d
Cart Content: Apple, Tomato, Apple, Milk,
COMMAND MENU:
 [P] print the market catalog
 [A <index>] add one occurrence of an item to the cart given its identifier
 [C] checkout
 [D] display the cart content
 [O <index>] number of occurrences of an item in the cart given its identifier
 [R <index>] remove one occurrence of an item from the cart given its identifier
 [Q]uit the application
ENTER COMMAND: O 0
The number of occurrences of Apple (id #0) is: 2
COMMAND MENU:
 [P] print the market catalog
 [A <index>] add one occurrence of an item to the cart given its identifier
 [C] checkout
 [D] display the cart content
 [O <index>] number of occurrences of an item in the cart given its identifier
 [R <index>] remove one occurrence of an item from the cart given its identifier
 [Q]uit the application
ENTER COMMAND: r 0
COMMAND MENU:
 [P] print the market catalog

[A <index>] add one occurrence of an item to the cart given its identifier
    [C] checkout
    [D] display the cart content
    [O <index>] number of occurrences of an item in the cart given its identifier
    [R <index>] remove one occurrence of an item from the cart given its identifier
    [Q]uit the application
ENTER COMMAND: D
Cart Content: Milk, Tomato, Apple,
   COMMAND MENU:
    [P] print the market catalog
    [A <index>] add one occurrence of an item to the cart given its identifier
    [C] checkout
    [D] display the cart content
    [O <index>] number of occurrences of an item in the cart given its identifier
    [R <index>] remove one occurrence of an item from the cart given its identifier
    [Q]uit the application
ENTER COMMAND: c
#items: 3 Subtotal: $5.47 Tax: $0.27 TOTAL: $5.74
   COMMAND MENU:
    [P] print the market catalog
    [A <index>] add one occurrence of an item to the cart given its identifier
    [C] checkout
    [D] display the cart content
    [O <index>] number of occurrences of an item in the cart given its identifier
    [R <index>] remove one occurrence of an item from the cart given its identifier
    [Q]uit the application
ENTER COMMAND: Q
============= Thank you for using this App!!!!! =============

