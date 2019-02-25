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
  - Red-black balanced tree :red_circle::black_circle: <img align="center" height="50" src="https://cdn-images-1.medium.com/max/1600/1*84jyh_SAj6keE5yKgqYDYQ.gif">
- Outputting the time consumption :stopwatch: for each data structure
<br/>

### Starting the program :checkered_flag:
- Clone the project through `git clone https://github.com/davi7725/Algorithms-Assignment2.git` or just download it as a ZIP file
- Open the project into an IDE that supports   <img src="https://waffleio-direct-uploads-production.s3.amazonaws.com/uploads/5b631124103d580013dcf6a4/125516c66e82c728ace21e0d46b9c6ca73929be4a5e8a9429b4de29b2e54267e240dad2c4f89e226b8577a060a3012f316074107baae9b37b4f67e2fd00958a9c3674d71946818a4ead31ab907b826d94685b7b4dc4894be3c77e599935d7c4f5b4cd6a2047ff5db59c24af742eb4c50a1133462e477327c40941a6761.png" height="50">    applications
- Change file path in [Main.java](https://github.com/davi7725/Algorithms_Assignment1/blob/9fdd4a3a62e0165d0f6c28384cf797044385c813/src/main/java/com/cphbusiness/basicalgorithms/Main.java#L31) to the path of your [dataset](https://raw.githubusercontent.com/datsoftlyngby/soft2019spring-algorithms/master/Weeklies/Week_05/Assignment_01/Shakespeare_Complete_Works.txt)
- Start the application by running the *Main* file

_NB❗️ you can download the Shakespeare's works from the hyperlink attached to the word **dataset**_

⚠️ _Be aware that it will take some time to load the full dataset, therefore coffee_ ☕️ _or tea_ 🍵 _break is advisable._
<br/>

____
> Sources:
TreePrinter.java - provided by [MightyPork](https://gist.github.com/MightyPork/3a5b184e8c569d46d58a)
___
> #### Assignment made by:   
`David Alves 👨🏻‍💻 ` :octocat: [Github](https://github.com/davi7725) <br />
`Elitsa Marinovska 👩🏻‍💻 ` :octocat: [Github](https://github.com/elit0451) <br />
> Attending "Algorithms and Data Structures" course of Software Development bachelor's degree
