# wk9_ProjectWeek_Mario-s_INTELLIJ
Native application developed in Java according to OOP design principles.

Self-examination:

- ArrayLists lend themselves to messy code and are harder test. There is another repo on this account that uses HashMaps for the same exercise.
- The classes Bar and Kitchen were meant to be used as implementations of Storable. However, and this was the main take away from this project, the use interfaces should only be applicable for objects with similar composition i.e. if my logic is dependent on accessing a certain property inside all objects - those objects need to have a comparable structure. Hence, both the storable and sellable interfaces were not fully implemented.

Mario's Italian Restaurant

Mario is opening a new restaurant in Edinburgh and needs your help getting it organised.

MVP

The restaurant should have a name and budget
Patrons can come and eat at the restaurant. They will be added to a table when they come in to eat.
Patrons can order from a menu. It should consist of dishes that have prices and ingredients.
Mario wants to be able to calculate the total price for each table and add it to the budget of the restaurant when the patron pay.
After paying, patrons are removed from the table to make room for the next ones.

Extensions

Patrons can split up the bill and pay individually
Dishes can be customised for dietary needs
Add a kitchen that gets ingredients delivered and has a pantry to keep them.
Ingredients are removed when dishes are ordered (hint: customised dishes use different ingredients)
When the kitchen runs out of an ingredient, all dishes using that ingredient have to be removed from the menu
And/or anything else that you can think of...
