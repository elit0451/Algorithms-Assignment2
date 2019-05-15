# Simple data structures and searching for <br/> 𝒮ℋ𝒜𝒦ℰ𝒮𝒫ℰ𝒜ℛℰ  's work :fountain_pen:

The following Java program provides different implementation of Symbol tables, which saves distinct words from Shakespeare's work as **keys** :old_key: and their number of occurances as **values**. 🧮 

<br/>

_Let's take an example_ :eyes:: <br/>
_` "to be or not to be, that is the question"`_

| **Word** | <span>to</span> | be | or | not | that | is | the |question |
| :--- |:---:|:---: | :---:| :---:|:---: | :---:|:---: |:---: |
|**Occurances**|2|2|1|1|1|1|1| 1|

<br/>

## Features
- Read Shakespeare's work from a text file. :scroll:
  - Process the text to find how many times a word appears on the text.
- Symbol table implementations:
  - Linked list-based
  - Array-based
  - Using Linear probing hashing strategy
  - Red-black balanced tree :red_circle::black_circle: <img align="center" height="50" src="./images/algorithm.gif">
- Outputting the time consumption :stopwatch: for each data structure
<br/>

### Starting the program :checkered_flag:
- Clone the project through `git clone https://github.com/davi7725/Algorithms-Assignment2.git` or just download it as a ZIP file
- Open the project into an IDE that supports   <img src="./images/java.png" height="50">    applications
- Change file path in [Program.java](https://github.com/davi7725/Algorithms-Assignment2/blob/48cf61c56a878fb55a8ca54584a8c07fbab2a7fe/src/assignment2/algorithms/Program.java#L27) to the path of your [dataset](https://raw.githubusercontent.com/datsoftlyngby/soft2019spring-algorithms/master/Weeklies/Week_05/Assignment_01/Shakespeare_Complete_Works.txt)
- Start the application by running the *Main* file

_NB❗️ you can download the Shakespeare's works from the hyperlink attached to the word **dataset**_ ⬆️

⚠️ _Be aware that it will take some time to load the full dataset, therefore coffee_ ☕️ _or tea_ 🍵 _break is advisable._
<br/>

_The Red-Black tree algorithm is commented out due to the fact that it doesn't work well with big arrays (e.g. an array populated with words from the file), BUT you can try it out with a smaller array that you create._

____
> Sources:
TreePrinter.java - provided by [MightyPork](https://gist.github.com/MightyPork/3a5b184e8c569d46d58a)
___
> #### Assignment made by:   
`David Alves 👨🏻‍💻 ` :octocat: [Github](https://github.com/davi7725) <br />
`Elitsa Marinovska 👩🏻‍💻 ` :octocat: [Github](https://github.com/elit0451) <br />
> Attending "Algorithms and Data Structures" course of Software Development bachelor's degree
