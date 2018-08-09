# Scala Parser Demo

Test processing is a common task in computing. Very often we need to extract complex patterns from logs,
usually by utilizing regular expressions. In some cases, however, we require more flexibility. In particular,
when the text patterns we are concerned with also underlie strict syntactic rules, a *parser* might fit our 
needs better, since it can handle a much wider range of expressions. In addition, it allows us to develop a 
domain-specific language (commonly abbreviated as *DSL*) that fits a lot better with the problem at hand. The 
aim of this tutorial is to show you how to do that with Scala's parser combinator library. We are basically 
going to develop our own programming language. How cool is that?

#### Why Scala

Although not the most popular language at the moment, Scala is commonly used in the Big Data field, which is 
exactly where such functionality is needed. It is also an extremely expressive language, allowing us to utilize 
both functional and object-oriented programming styles, and customize almost anything we might think of (especially 
recursive algorithms). This allows developing domain-specific languages and parsers in a particularly easy way. For our 
purpose, we are going to use the *Parser Combinators* library, which also lives on GitHub: 

[Parser Combinators Github Project](https://github.com/scala/scala-parser-combinators)

The ideas we are developing in this tutorial are obviously not specific to Scala, so the parsing logic can also be done 
in any programming language, albeit with different libraries (or not :) ). For instance, for a small project I was 
having, I did a quick prototype in Python and then implemented the actual parser in C++. In fact, knowing how to make 
a parser also brings you some high-level understanding of what the actual programming language compilers and 
interpreters are doing. 
 
## Custom Parser Use Cases

A parser basically reads some sort of text expressions - "code" - and tries to execute the instructions in that code 
during its run time. The most common use case seems to be when some non-trivial configuration logic is used to configure
a complex application (think of java properties files vs web server configuration files). The minute you have some kind 
of dynamic parameter (e.g. confVar = 7+ 10^2 ), you start crossing into parser land. To illustrate this, let's take a 
look at two examples:
 
### Example 1: Simple Arithmetic Expressions

Probably the easiest way to introduce the topic of parsing is with the simple example of fixed arithmetic expressions
like these:
```
- (1 + 0.23) / 3.31
(1.23 + 3.12) * (8 - 3)
(22.2 / 2) * 0.5
```
In this case we can clearly extract and convert the numerical expressions to integers or floats, but we don't know how 
to calculate the results using pre-defined functions, because the user of the program might define a new expression like 
`(2.2 + 1.3) / (0.73 - 1.2)`, which we can not predict in advance. What we do know, however, are the *rules* how to do 
these calculations. From these rules we can derive a *syntax* which we can utilize to create a parser that is capable
of handling any syntactically correct expressions based on the rules that we have stipulated with the user.

### Example 2: Variable Arithmetic Expressions

Let's say you have some kind of data at hand and you would like to calculate a number of different expressions with that 
data. Your data is held in *Data Table* and then you have a list of expressions that you need to evaluate. The expressions 
are defined in text form (strings), but now you need to substitute the data in the variables for each expression, instead
of just evaluating it "on the spot", like in example 1.

##### Data Table:
|var a|var b|var c|
|:---:|:---:|:---:|
|1.00|-9.20|2.72|
|0.01|1.37|4.00|
|-0.21|-7.20|3.14|

##### Expressions
```
a + b - c
a * (b + c)
b ^ 2 * (a - b)
(a + b) / c
log(a) - log(b) + exp(c)
```

### Example 3: Complex Configuration Logic
The final example is courtesy of the [Enear blog post](http://enear.github.io/2016/03/31/parser-combinators/) on parser 
combinators and illustrates an even more complex configuration use case:
```
read input name, country
switch:
  country == "PT" ->
    call service "A"
    exit
  otherwise ->
    call service "B"
    switch:
      name == "unknown" ->
        exit
      otherwise ->
        call service "C"
        exit
```
Here already start to recognize common programming constructs and even function calls. It starts getting closer to a 
full blown programming language!

## To Parse or Not to Parse

### Advantages
### Disadvantages

## Parsing Mechanics


## Enter Scala Parser Combinators


## Tokenizer
## Lexer

## Parser


## Evaluation


